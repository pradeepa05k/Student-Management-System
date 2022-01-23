package com.infinira.sms.model;

import java.sql.Date;
import java.lang.Integer;
import java.math.BigDecimal;

import java.text.MessageFormat;

public class Student {
    private Integer studentId;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dob;
    private String emailId;
    private String mobileNo;
    private Date doa;
    private String identificationMark;
    private String aadharNo;
    private String bloodGroup;
    private String nationality;
    private String fatherName;
    private String fatherOccupation;
    private String fatherMobileNo;
    private String motherName;
    private String motherOccupation;
    private String motherMobileNo;
    private BigDecimal annualIncome;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country; 
    private String pinCode;
        
    public Student() {}    
    
    public Student(Integer studentId) {
        validateInput(STUDENT_ID, studentId);
        this.studentId = studentId;
    }
    
    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        validateInput(STUDENT_ID, studentId);
        this.studentId = studentId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        validateInput(FIRST_NAME, firstName, MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        validateInput(LAST_NAME, lastName, MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        validateInput(GENDER, gender);
        this.gender = gender;
    }
    
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        validateInput(DOB, dob);
        this.dob = dob;
    }
    
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        validateInput(EMAIL_ID, emailId, MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);
        this.emailId = emailId;
    }
    
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        validateInput(MOBILE_NO, mobileNo, MIN_MOBILE_NO_AND_PINCODE_LENGTH, MAX_MOBILE_NO_AND_PINCODE_LENGTH);
        this.mobileNo = mobileNo;
    }
    
    public Date getDoa() {
        return doa;
    }
    public void setDoa(Date doa) {
        validateInput(DOA, doa);
        this.doa = doa;
    }
           
    public String getIdentificationMark() {
        return identificationMark;
    }
    public void setIdentificationMark(String identificationMark) {
        validateInput(IDENTIFICATION_MARK, identificationMark);
        this.identificationMark = identificationMark;
    }
    
    public String getAadharNo() {
        return aadharNo;
    }
    public void setAadharNo(String aadharNo) {
        validateInput(AADHAR_NO, aadharNo);
        this.aadharNo = aadharNo;
    }
    
    public String getBloodGroup(){
        return bloodGroup;
    }   
    public void setBloodGroup(String bloodGroup){
        validateInput(BLOOD_GROUP, bloodGroup);
        this.bloodGroup = bloodGroup;
    }

    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        validateInput(NATIONALITY, nationality);
        this.nationality = nationality;
    }
    
    public String getFatherName() {
        return fatherName;
    }
    public void setFatherName(String fatherName) {
        validateInput(FATHER_NAME, fatherName, MIN_NAME_LENGTH, MAX_FULLNAME_LENGTH);
        this.fatherName = fatherName;
    }
    
    public String getFatherOccupation() {
        return fatherOccupation;
    }
    public void setFatherOccupation(String fatherOccupation) {
        validateInput(FATHER_OCCUPATION, fatherOccupation);
        this.fatherOccupation = fatherOccupation;
    }
    
    public String getFatherMobileNo() {
        return fatherMobileNo;
    }
    public void setFatherMobileNo(String fatherMobileNo) {
        validateInput(FATHER_MOBILE_NO, fatherMobileNo, MIN_MOBILE_NO_AND_PINCODE_LENGTH, MAX_MOBILE_NO_AND_PINCODE_LENGTH);
        this.fatherMobileNo = fatherMobileNo;
    }
    
    public String getMotherName() {
        return motherName;
    }
    public void setMotherName(String motherName) {
        validateInput(MOTHER_NAME, motherName, MIN_NAME_LENGTH, MAX_FULLNAME_LENGTH);
        this.motherName = motherName;
    }
    
    public String getMotherOccupation() {
        return motherOccupation;
    }
    public void setMotherOccupation(String motherOccupation) {
        validateInput(MOTHER_OCCUPATION, motherOccupation);
        this.motherOccupation = motherOccupation;
    }
    
    public String getMotherMobileNo() {
        return motherMobileNo;
    }
    public void setMotherMobileNo(String motherMobileNo) {
        validateInput(MOTHER_MOBILE_NO, motherMobileNo, MIN_MOBILE_NO_AND_PINCODE_LENGTH, MAX_MOBILE_NO_AND_PINCODE_LENGTH);
        this.motherMobileNo = motherMobileNo;
    }
    
    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }
    public void setAnnualIncome(BigDecimal annualIncome) {
        validateInput(ANNUAL_INCOME, annualIncome);
        this.annualIncome = annualIncome;
    }
    
    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        validateInput(ADDRESS_LINE_1, addressLine1);
        this.addressLine1 = addressLine1;
    }
    
    public String getAddressLine2() {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        validateInput(CITY, city);
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    public void setState(String state) {
        validateInput(STATE, state);
        this.state = state;
    }
    
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        validateInput(COUNTRY, country);
        this.country = country;
    }
    
    public String getPinCode() {
        return pinCode;
    }
    public void setPinCode(String pinCode) {
        validateInput(PINCODE, pinCode, MIN_MOBILE_NO_AND_PINCODE_LENGTH, MAX_MOBILE_NO_AND_PINCODE_LENGTH);
        this.pinCode = pinCode;
    }  
          
    public static void validateInput(String paramName, Object paramValue, int... args) {
        if (paramValue == null) {
            errorMessage(MSG_001, paramName);
        }

        if (paramValue instanceof String value) {
            if (value.trim().length() <= 0) {
                errorMessage(MSG_002, paramName);
            }
            if(args.length == 1) {
                if(value.length() != AADHAR_NO_LENGTH) {
                    errorMessage(MSG_004, paramName, AADHAR_NO_LENGTH);
                }
            }
            if(args.length == 2) {
                if((value.length() < args[0]) || (value.length() > args[1])) {
                    errorMessage(MSG_005, paramName, args[0], args[1]);
                }
            }
        } else if (paramValue instanceof Integer value) {
            if (value <= 0) {
                errorMessage(MSG_003, paramName, paramValue);
            }
        }
    }
    
    public static void errorMessage(String key, Object... args) {
        throw new RuntimeException(MessageFormat.format(key, args));
    }
        
    private static final String MSG_001 = "{0} is null";
    private static final String MSG_002 = "{0} is empty";
    private static final String MSG_003 = "Invalid {0} value as {1}";
    private static final String MSG_004 = "The length of {0} should be {1}";
    private static final String MSG_005 = "The Minimum and Maximum length of {0} should be {1} and {2}";
    
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 35;
    private static final int MAX_FULLNAME_LENGTH = 70;
    private static final int MIN_EMAIL_LENGTH = 10;
    private static final int MAX_EMAIL_LENGTH = 320;
    private static final int MIN_MOBILE_NO_AND_PINCODE_LENGTH = 6;
    private static final int MAX_MOBILE_NO_AND_PINCODE_LENGTH = 15;
    private static final int AADHAR_NO_LENGTH = 12;
        
    private static final String STUDENT_ID  = "Student Id";
    private static final String FIRST_NAME = "First Name";
    private static final String LAST_NAME = "Last Name";
    private static final String GENDER = "Gender";
    private static final String DOB = "Date of birth";
    private static final String EMAIL_ID = "Email Id";
    private static final String MOBILE_NO = "Mobile Number";
    private static final String DOA = "Date Of Admission";
    private static final String IDENTIFICATION_MARK = "Identification Mark";
    private static final String AADHAR_NO = "Aadhar Number";
    private static final String BLOOD_GROUP = "Blood Group";
    private static final String NATIONALITY = "Nationality";
    private static final String FATHER_NAME = "Father's Name";
    private static final String FATHER_OCCUPATION = "Father's Occupation";
    private static final String FATHER_MOBILE_NO = "Father's Mobile Number";
    private static final String MOTHER_NAME = "Mother's Name";
    private static final String MOTHER_OCCUPATION = "Mother's Occupation";
    private static final String MOTHER_MOBILE_NO = "Mother's Mobile Number";
    private static final String ANNUAL_INCOME = "Annual Income";
    private static final String ADDRESS_LINE_1 = "Address Line-1";
    private static final String ADDRESS_LINE_2 = "Address Line-2";
    private static final String CITY = "City";
    private static final String STATE = "State";
    private static final String COUNTRY = "Country";
    private static final String PINCODE = "Pin Code";
}   