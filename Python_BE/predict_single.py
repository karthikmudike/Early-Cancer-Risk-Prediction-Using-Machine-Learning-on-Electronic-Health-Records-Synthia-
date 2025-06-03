import joblib
import pandas as pd

# Load model
model = joblib.load('cancer_model.pkl')

# List of diseases to include
diseases_to_include = [
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
    "cancer",
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

def predict_cancer_risk(age, is_male, diseases):
    # Create a feature vector for the patient
    features = [age, is_male]
    
    # Add disease features: 1 if the patient has the disease, else 0
    for disease in diseases_to_include:
        features.append(1 if disease in diseases else 0)
    
    # Create the input dataframe for prediction
    input_data = pd.DataFrame([features], columns=['AGE', 'IS_MALE'] + diseases_to_include)
    
    # Make prediction
    risk_percent = model.predict_proba(input_data)[0][1] * 100
    print(f"\n🔍 Predicted Cancer Risk: {risk_percent:.2f}%")

# Input
print("\n--- Predict Cancer Risk for New Patient ---")
age_input = int(input("Enter age: "))
gender_input = input("Enter gender (M/F): ").strip().upper()
is_male_input = 1 if gender_input == 'M' else 0

# Input disease conditions (user provides a comma-separated list of diseases)
disease_input = input("Enter patient's diseases (comma-separated): ").strip().split(", ")

predict_cancer_risk(age_input, is_male_input, disease_input)
