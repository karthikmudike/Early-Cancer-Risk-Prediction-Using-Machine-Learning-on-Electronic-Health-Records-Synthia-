import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.pipeline import Pipeline
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.compose import ColumnTransformer
from sklearn.preprocessing import StandardScaler, OneHotEncoder
from sklearn.metrics import mean_squared_error, r2_score
import numpy as np
import joblib

# Load CSVs
patients = pd.read_csv('patients.csv')
conditions = pd.read_csv('conditions.csv')

# Label cancer based on descriptions
cancer_keywords = ['cancer', 'malignant', 'carcinoma', 'sarcoma', 'lymphoma', 'leukemia']
cancer_conditions = conditions[conditions['DESCRIPTION'].str.contains('|'.join(cancer_keywords), case=False, na=False)]

# Label patients with cancer
patients['HAS_CANCER'] = patients['Id'].isin(cancer_conditions['PATIENT']).astype(int)

# Age & Gender
patients['BIRTHDATE'] = pd.to_datetime(patients['BIRTHDATE'])
patients['AGE'] = 2025 - patients['BIRTHDATE'].dt.year
patients['GENDER'] = patients['GENDER'].fillna('U')

# Aggregate condition descriptions per patient
condition_summary = conditions.groupby('PATIENT')['DESCRIPTION'].apply(lambda x: ' '.join(x)).reset_index()
condition_summary.columns = ['Id', 'MEDICAL_HISTORY']

# Merge
patients = patients.merge(condition_summary, on='Id', how='left')
patients['MEDICAL_HISTORY'] = patients['MEDICAL_HISTORY'].fillna('')

# Features and label
features = patients[['AGE', 'GENDER', 'MEDICAL_HISTORY']]
labels = patients['HAS_CANCER']

# Preprocessing pipeline
preprocessor = ColumnTransformer([
    ('gender', OneHotEncoder(handle_unknown='ignore'), ['GENDER']),
    ('text', CountVectorizer(max_features=500), 'MEDICAL_HISTORY'),
    ('age', StandardScaler(), ['AGE'])
])

# Linear Regression pipeline
model = Pipeline([
    ('preprocess', preprocessor),
    ('regressor', LinearRegression())
])

# Split
X_train, X_test, y_train, y_test = train_test_split(features, labels, test_size=0.3, stratify=labels, random_state=42)

# Train
model.fit(X_train, y_train)

# Predict
y_pred = model.predict(X_test)

# Evaluate
print("✅ Mean Squared Error:", mean_squared_error(y_test, y_pred))
print("✅ R² Score:", r2_score(y_test, y_pred))

# Cancer risk % for all
patients['CANCER_RISK_PERCENT'] = model.predict(features) * 100
patients['CANCER_RISK_PERCENT'] = patients['CANCER_RISK_PERCENT'].clip(0, 100)  # keep within 0–100

# Top 10 at-risk patients
top_10 = patients[['Id', 'FIRST', 'LAST', 'AGE', 'GENDER', 'CANCER_RISK_PERCENT']].sort_values(by='CANCER_RISK_PERCENT', ascending=False).head(10)

print("\n🔝 Top 10 Patients with Highest Cancer Risk:")
print(top_10)

# Save model
joblib.dump(model, 'cancer_risk_model.pkl')
