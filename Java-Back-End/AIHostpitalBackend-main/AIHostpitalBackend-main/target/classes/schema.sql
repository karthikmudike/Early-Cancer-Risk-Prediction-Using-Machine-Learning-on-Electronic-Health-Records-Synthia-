CREATE TABLE TODO (
    id INT PRIMARY KEY,
    username VARCHAR(255),
    is_done BOOLEAN,
    target_date TIMESTAMP
);


CREATE TABLE PATIENT_RECORD (
    Patient_Id BIGINT PRIMARY KEY,
    Patient_Name VARCHAR(255),
    Patient_Age INT,
    Patient_Gender VARCHAR(10),
    Patient_Address VARCHAR(255) ,
    Patient_City VARCHAR(100),
    Patient_Zip_Code BIGINT ,
    PatientDOB DATE ,
    Patient_Phone_Number VARCHAR(20) ,
    Patient_Email VARCHAR(255) ,
    is_Been_Here VARCHAR(10) 
);

CREATE TABLE Medical_History (
    Record_Id BIGINT AUTO_INCREMENT PRIMARY KEY,
    Patient_Id BIGINT NOT NULL,
    Record VARCHAR(255),
    FOREIGN KEY (Patient_Id) REFERENCES Patient_Record(Patient_Id)
);


CREATE TABLE Doctors (
    Doctor_Id BIGINT PRIMARY KEY,
    Doctor_Last_Name VARCHAR(10),
    Doctor_First_Name VARCHAR(10),
   Gender VARCHAR(10),
   Phone_Number VARCHAR(20),
   Email VARCHAR(40),
   Department VARCHAR(20)
);


CREATE TABLE Bill_Payment (
    Bill_Id BIGINT PRIMARY KEY,
    Description VARCHAR(255),
    Price BIGINT,
    Patient_Id BIGINT NOT NULL,
    FOREIGN KEY (Patient_Id) REFERENCES Patient_Record(Patient_Id)
);


CREATE TABLE Appointment (
    Appointment_Id BIGINT PRIMARY KEY, 
    Patient_Id BIGINT,     
    Reason VARCHAR(255),
    Appointment_Date DATE,
    Appointment_Slot VARCHAR(50),
    FOREIGN KEY (Patient_Id) REFERENCES Patient_Record(Patient_Id)
);


CREATE TABLE customer_service (
     customerlname VARCHAR(255),
     customer_name VARCHAR(255) ,
      email VARCHAR(255),
      message VARCHAR(255) ,
    phone_number VARCHAR(225),
     customer_id BIGINT PRIMARY KEY
);


