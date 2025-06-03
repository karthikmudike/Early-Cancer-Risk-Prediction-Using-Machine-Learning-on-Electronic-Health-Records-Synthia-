insert into TODO (id,username,is_done, target_date) values (100,'karthik',false,CURRENT_TIMESTAMP);

insert into TODO (id,username,is_done, target_date) values (101,'Deepak',false,CURRENT_TIMESTAMP);

insert into TODO (id,username,is_done, target_date) values (102,'Ramesh',false,CURRENT_TIMESTAMP);


INSERT INTO PATIENT_RECORD
(Patient_Id, Patient_Name, Patient_Age, Patient_Gender, Patient_Address, Patient_City, Patient_Zip_Code, PatientDOB, Patient_Phone_Number, Patient_Email, is_Been_Here)
VALUES
(1, 'John Doe', 45, 'Male', '123 Elm Street', 'New York', 10001, '1978-03-15', '123-456-7890', 'john.doe@example.com', 'Yes'),
(2, 'Jane Smith', 32, 'Female', '456 Oak Avenue', 'Los Angeles', 90001, '1991-06-20', '987-654-3210', 'jane.smith@example.com', 'No'),
(3, 'Sam Wilson', 28, 'Male', '789 Pine Lane', 'Chicago', 60601, '1995-02-14', '112-233-4455', 'sam.wilson@example.com', 'Yes');



-- Insert records for the patient
INSERT INTO Medical_History (Patient_Id, Record) VALUES (1, 'No allergies');
INSERT INTO Medical_History (Patient_Id, Record) VALUES (1, 'Diagnosed with flu in 2020');
INSERT INTO Medical_History (Patient_Id, Record) VALUES (1, 'Vaccinated for COVID-19');

-- Insert records for Patient 2
INSERT INTO Medical_History (Patient_Id, Record) VALUES (2, 'Allergic to penicillin');
INSERT INTO Medical_History (Patient_Id, Record) VALUES (2, 'Underwent appendectomy in 2015');
INSERT INTO Medical_History (Patient_Id, Record) VALUES (2, 'Diagnosed with asthma in 2010');

-- Insert records for Patient 3
INSERT INTO Medical_History (Patient_Id, Record) VALUES (3, 'No known allergies');
INSERT INTO Medical_History (Patient_Id, Record) VALUES (3, 'Completed annual physical check-up in 2023');
INSERT INTO Medical_History (Patient_Id, Record) VALUES (3, 'Blood pressure controlled with medication');


-- Insert data for Doctor 1
INSERT INTO Doctors (Doctor_Id, Doctor_Last_Name, Doctor_First_Name, Gender, Phone_Number, Email, Department)
VALUES (1, 'Smith', 'John', 'Male', '123-456-7890', 'john.smith@example.com', 'Cardiology');

-- Insert data for Doctor 2
INSERT INTO Doctors (Doctor_Id, Doctor_Last_Name, Doctor_First_Name, Gender, Phone_Number, Email, Department)
VALUES (2, 'Taylor', 'Emily', 'Female', '987-654-3210', 'emily.taylor@example.com', 'Neurology');

-- Insert data for Doctor 3
INSERT INTO Doctors (Doctor_Id, Doctor_Last_Name, Doctor_First_Name, Gender, Phone_Number, Email, Department)
VALUES (3, 'Brown', 'Michael', 'Male', '555-666-7777', 'michael.brown@example.com', 'Pediatrics');


-- Inserting multiple bills for each patient into Bill_Payment
INSERT INTO Bill_Payment (Bill_Id, Description, Price, Patient_Id)
VALUES 
-- Bills for Patient 1
(101, 'Consultation Fee', 500, 1),
(102, 'Blood Test', 800, 1),
(103, 'X-Ray', 1200, 1),
(104, 'MRI Scan', 3000, 1),

-- Bills for Patient 2
(105, 'Vaccination', 1500, 2),
(106, 'CT Scan', 4000, 2),
(107, 'Follow-Up Consultation', 600, 2),
(108, 'Physiotherapy', 2500, 2),

-- Bills for Patient 3
(109, 'Surgery Fee', 25000, 3),
(110, 'Post-Surgery Medication', 2000, 3),
(111, 'Room Charges', 5000, 3),
(112, 'Diet Consultation', 700, 3);


-- Inserting records for Patient_Id 1
INSERT INTO Appointment (Appointment_Id, Patient_Id, Reason, Appointment_Date, Appointment_Slot) 
VALUES 
(0, 1, 'Regular Checkup', '2024-01-15', 'Morning'),
(1, 1, 'Regular Checkup', '2024-01-15', 'Morning'),
(2, 1, 'Follow-up Visit', '2024-02-01', 'Afternoon'),
(3, 1, 'Blood Test', '2024-02-10', 'Evening');

-- Inserting records for Patient_Id 2
INSERT INTO Appointment (Appointment_Id, Patient_Id, Reason, Appointment_Date, Appointment_Slot) 
VALUES 
(4, 2, 'Annual Physical', '2024-01-20', 'Morning'),
(5, 2, 'Consultation', '2024-01-25', 'Afternoon'),
(6, 2, 'X-Ray', '2024-02-05', 'Evening');

-- Inserting records for Patient_Id 3
INSERT INTO Appointment (Appointment_Id, Patient_Id, Reason, Appointment_Date, Appointment_Slot) 
VALUES 
(7, 3, 'Skin Allergy Check', '2024-01-18', 'Morning'),
(8, 3, 'Diabetes Monitoring', '2024-02-02', 'Afternoon'),
(9, 3, 'Heart Checkup', '2024-02-12', 'Evening');

INSERT INTO customer_service (Customer_Id, Customer_Name, CustomerLName, Message, Phone_Number, Email) 
VALUES 
(1, 'John', 'Doe', 'Inquiry about product availability', '123-456-7890', 'john.doe@example.com');
