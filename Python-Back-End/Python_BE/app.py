# app.py
from flask import Flask, request, jsonify 
import joblib
import pandas as pd
from flask_cors import CORS 


#cros
app = Flask(__name__)
CORS(app) 
CORS(app, origins=["http://localhost:4200"])

#.csv files
patients = pd.read_csv('Testing_Set__30__.csv')
conditions = pd.read_csv('conditions.csv')

# Load diseases for consistent feature input
disease_list = [
        "Chronic sinusitis (disorder)",
    "Viral sinusitis (disorder)",
    "Acute viral pharyngitis (disorder)",
    "Acute bronchitis (disorder)",
    "Streptococcal sore throat (disorder)",
    "Laceration of foot",
    "Acute bacterial sinusitis (disorder)",
    "Sprain of wrist",
    "Otitis media",
    "Body mass index 30+ - obesity (finding)",
    "Cystitis",
    "Fracture of forearm",
    "Impacted molars",
    "Normal pregnancy",
    "Sinusitis (disorder)",
    "Anemia (disorder)",
    "Miscarriage in first trimester",
    "Fetus with unknown complication",
    "Prediabetes",
    "Hypertension",
    "Escherichia coli urinary tract infection",
    "Whiplash injury to neck",
    "Atrial Fibrillation",
    "Sprain of ankle",
    "Laceration of forearm",
    "Malignant neoplasm of breast (disorder)",
    "Laceration of thigh",
    "Osteoarthritis of knee",
    "Preeclampsia",
    "Perennial allergic rhinitis with seasonal variation",
    "Fracture of clavicle",
    "Childhood asthma",
    "Facial laceration",
    "Acute allergic reaction",
    "Concussion with no loss of consciousness",
    "Recurrent urinary tract infection",
    "Hyperlipidemia",
    "Osteoarthritis of hip",
    "Coronary Heart Disease",
    "Polyp of colon",
    "Tubal pregnancy",
    "Blighted ovum",
    "Stroke",
    "Fracture of the vertebral column with spinal cord injury",
    "Atopic dermatitis",
    "Seasonal allergic rhinitis",
    "Cardiac Arrest",
    "History of cardiac arrest (situation)",
    "Fracture of ankle",
    "Second degree burn",
    "Fracture subluxation of wrist",
    "Diabetes",
    "Hypertriglyceridemia (disorder)",
    "Metabolic syndrome X (disorder)",
    "Fracture of rib",
    "Antepartum eclampsia",
    "Chronic pain",
    "Chronic intractable migraine without aura",
    "Drug overdose",
    "Osteoporosis (disorder)",
    "Idiopathic atrophic hypothyroidism",
    "Seizure disorder",
    "History of single seizure (situation)",
    "Perennial allergic rhinitis",
    "Epilepsy",
    "Myocardial Infarction",
    "History of myocardial infarction (situation)",
    "Body mass index 40+ - severely obese (finding)",
    "Hyperglycemia (disorder)",
    "Neuropathy due to type 2 diabetes mellitus (disorder)",
    "Diabetic retinopathy associated with type II diabetes mellitus (disorder)",
    "Nonproliferative diabetic retinopathy due to type 2 diabetes mellitus (disorder)",
    "Chronic kidney disease stage 1 (disorder)",
    "Diabetic renal disease (disorder)",
    "Localized primary osteoarthritis of the hand",
    "Neoplasm of prostate",
    "Carcinoma in situ of prostate (disorder)",
    "Laceration of hand",
    "Injury of tendon of the rotator cuff of shoulder",
    "Pulmonary emphysema (disorder)",
    "Appendicitis",
    "History of appendectomy",
    "Major depression disorder",
    "Alcoholism",
    "Burn injury(morphologic abnormality)",
    "Rupture of patellar tendon",
    "Concussion with loss of consciousness",
    "Child attention deficit disorder",
    "Injury of medial collateral ligament of knee",
    "Recurrent rectal polyp",
    "Contact dermatitis",
    "Familial Alzheimer's disease of early onset (disorder)",
    "Chronic kidney disease stage 2 (disorder)",
    "Microalbuminuria due to type 2 diabetes mellitus (disorder)",
    "Bleeding from anus",
    "Protracted diarrhea",
    "Malignant tumor of colon",
    "First degree burn",
    "Suspected lung cancer (situation)",
    "Non-small cell lung cancer (disorder)",
    "Non-small cell carcinoma of lung  TNM stage 1 (disorder)",
    "Chronic congestive heart failure (disorder)",
    "Chronic obstructive bronchitis (disorder)",
    "Tear of meniscus of knee",
    "Fracture of vertebral column without spinal cord injury",
    "Smokes tobacco daily",
    "Gout",
    "Rupture of appendix",
    "Alzheimer's disease (disorder)",
    "Pneumonia",
    "Opioid abuse (disorder)",
    "Concussion injury of brain",
    "Metastasis from malignant tumor of prostate (disorder)",
    "Closed fracture of hip",
    "Rheumatoid arthritis",
    "Overlapping malignant neoplasm of colon",
    "Macular edema and retinopathy due to type 2 diabetes mellitus (disorder)",
    "Pathological fracture due to osteoporosis (disorder)",
    "Brain damage - traumatic",
    "Secondary malignant neoplasm of colon",
    "Bullet wound",
    "Proliferative diabetic retinopathy due to type II diabetes mellitus (disorder)",
    "Injury of anterior cruciate ligament",
    "Pyelonephritis",
    "Primary fibromyalgia syndrome",
    "Primary malignant neoplasm of colon",
    "Small cell carcinoma of lung (disorder)",
    "Primary small cell malignant neoplasm of lung  TNM stage 1 (disorder)",
    "Major depression single episode"
]

#-----------------------------------------------------------------

# Load the saved linear regression model
model = joblib.load('cancer_risk_model.pkl')

@app.route('/predict-all', methods=['GET'])
def predict_all():
    # Load fresh testing data
    patients_df = pd.read_csv('Testing_Set__30__.csv')
    conditions_df = pd.read_csv('conditions.csv')

    # Prepare demographic features
    patients_df['BIRTHDATE'] = pd.to_datetime(patients_df['BIRTHDATE'], errors='coerce')
    patients_df['AGE'] = 2025 - patients_df['BIRTHDATE'].dt.year
    patients_df['GENDER'] = patients_df['GENDER'].fillna('U')

    # Aggregate all condition descriptions per patient
    condition_summary = conditions_df.groupby('PATIENT')['DESCRIPTION'].apply(lambda x: ' '.join(x)).reset_index()
    condition_summary.columns = ['Id', 'MEDICAL_HISTORY']

    # Merge condition descriptions into patient records
    patients_df = pd.merge(patients_df, condition_summary, on='Id', how='left')
    patients_df['MEDICAL_HISTORY'] = patients_df['MEDICAL_HISTORY'].fillna('')

    # Prepare features
    input_features = patients_df[['AGE', 'GENDER', 'MEDICAL_HISTORY']]

    # Predict cancer risk % using the model
    predictions = model.predict(input_features) * 100
    patients_df['CANCER_RISK_PERCENT'] = predictions.clip(0, 100)

    # Prepare list of all diseases per patient (list format)
    patient_diseases = conditions_df.groupby('PATIENT')['DESCRIPTION'].apply(list).reset_index()
    patient_diseases.columns = ['Id', 'DISEASES']

    # Merge diseases list with patients
    patients_df = pd.merge(patients_df, patient_diseases, on='Id', how='left')

    result = patients_df[['Id', 'CITY', 'RACE', 'ZIP','STATE', 'COUNTY','BIRTHPLACE','ETHNICITY','BIRTHDATE','FIRST', 'LAST', 'AGE', 'GENDER', 'CANCER_RISK_PERCENT', 'DISEASES']]

    # Clean NaN or non-list values in 'DISEASES'
    def clean_data(data):
        for row in data:
            if not isinstance(row.get('DISEASES'), list):
                row['DISEASES'] = []
        return data

    # Convert to records and clean
    records = result.to_dict(orient='records')
    cleaned_records = clean_data(records)

    # Send JSON response
    return jsonify(cleaned_records)

#------------------------------------------------------------------

@app.route('/karthik')
def home():
    return jsonify({"Hello" : "cancer_risk_percent"})

#-------------------------------------------------------------------

@app.route('/all-patients', methods=['GET'])
def all_patients():
    # Reload fresh data (optional - in case CSVs are updated)
    patients_df = pd.read_csv('Testing_Set__30__.csv')

    # Return all patient data as JSON
    patients_data = patients_df.to_dict(orient='records')
    return jsonify(patients_data)
#--------------------------------------------------------------------------

if __name__ == '__main__':
    app.run(debug=True)