package com.infinira.sms.dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.infinira.sms.util.Util;
import com.infinira.sms.model.Student;
import com.infinira.sms.util.DBService;
import com.infinira.sms.model.StudentEnum;
import com.infinira.sms.util.SMSException;

public class StudentDAO { 
    // Create student
    public static int create(Student student){
        validateStudent(STUDENT, student);
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;        
        try {
            conn = DBService.getInstance().getConnection(); 
            boolean aadharExist = isAadharExist(student.getAadharNo());
    
            if (!aadharExist) {              
                throw Util.prepareException("SMS-00009", null, student.getFirstName(), student.getLastName());
            }
            
            pstmt = conn.prepareStatement(CREATE_STUDENT, Statement.RETURN_GENERATED_KEYS); 
            int ix = setStudentDetails(pstmt, student);
            
            int result = pstmt.executeUpdate(); 
            rs = pstmt.getGeneratedKeys();                
            if (rs.next() == false) {
                throw Util.prepareException("SMS-00002", null, student.getFirstName(), student.getLastName());
            }                
            
            int StudentId = rs.getInt(STUDENT_ID);
            return StudentId;
        } catch (SMSException ex) {
            throw ex;
        } catch (Throwable th) {
            throw Util.prepareException("SMS-00002", th, student.getFirstName(), student.getLastName());
        } finally {
            DBService.getInstance().closeResource(rs, pstmt, conn);
        }
    }  
    
    // Get Student information by Id
    public static Student getById(int studentId) {
        validateStudentId(STUDENT_ID, studentId);
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;        
        try {
            conn = DBService.getInstance().getConnection();
            pstmt = conn.prepareStatement(GET_STUDENT_BY_ID);
            pstmt.setInt(1, studentId);
            
            rs = pstmt.executeQuery();
            if (rs.next() ==  false) {
                throw Util.prepareException("SMS-00003", null, studentId);
            }
            return getStudentDetails(rs);
        } catch (SMSException ex) {
            throw ex;
        } catch (Throwable th) {
            throw Util.prepareException("SMS-00004", th, studentId);
        } finally {
            DBService.getInstance().closeResource(rs, pstmt, conn);
        }
    }
        
    // Get Student information by Aadhar Number    
    public static Student getByAadharNo(String aadharNo) {
        validateAadharNo(AADHAR_NO, aadharNo);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;    
        
        try {
            conn = DBService.getInstance().getConnection();
            pstmt = conn.prepareStatement(GET_STUDENT_BY_AADHAR_NUMBER);
            pstmt.setString(1, aadharNo);
            
            rs = pstmt.executeQuery();
            
            if (rs.next() == false) {
                throw Util.prepareException("SMS-00005", null, aadharNo);
            }
            return getStudentDetails(rs);
        } catch (SMSException ex) {
            throw ex;
        } catch (Throwable th) {
            throw Util.prepareException("SMS-00006", th, aadharNo);
        } finally {
            DBService.getInstance().closeResource(rs, pstmt, conn);
        }
    }
    
    // Get Student information by firstName and lastName
    public static List<Student> getByName(String firstName, String lastName) {
        validateName(FIRST_NAME, firstName);
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;              
        try {
            conn = DBService.getInstance().getConnection();
            
            if(lastName != null && lastName.trim().length() > 0) {
                pstmt = conn.prepareStatement(GET_STUDENT_BY_NAME);
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                
                rs = pstmt.executeQuery(); 
                if (rs.next() == false) {
                    throw Util.prepareException("SMS-00007", null, firstName, lastName);
                }
            }
            
            pstmt = conn.prepareStatement(GET_STUDENT_BY_FIRST_NAME);
            pstmt.setString(1, firstName);
            
            rs = pstmt.executeQuery(); 
            if (rs.next() == false) {
                throw Util.prepareException("SMS-00008", null, firstName);
            }
            
            List<Student> studentList = new ArrayList<Student>();
            do { 
                studentList.add(getStudentDetails(rs));
            } while (rs.next());

            return studentList;            
        } catch (SMSException ex) {
            throw ex;
        } catch (Throwable th) {
            throw Util.prepareException("SMS-00009", th, firstName, lastName);
        } finally {
            DBService.getInstance().closeResource(rs, pstmt, conn);
        }
    } 
        
    //List All students Information
    public static List<Student> getAll() {           
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = DBService.getInstance().getConnection();
            pstmt = conn.prepareStatement(GET_ALL_STUDENTS);
            rs = pstmt.executeQuery();
            
            if (rs.next() == false) {
                throw Util.prepareException("SMS-00010", null);
            }
            List<Student> studentList = new ArrayList<Student>();
            do { 
                studentList.add(getStudentDetails(rs));
            } while (rs.next());

            return studentList;
        } catch (SMSException ex) {
            throw ex;
        } catch (Throwable th) {
            throw Util.prepareException("SMS-00010", th);
        } finally {
            DBService.getInstance().closeResource(rs, pstmt, conn);
        }
    }
    
    // Update Student By Id
    public static int update(int studentId, Student student) {
        validateStudentId(STUDENT_ID, studentId);
        validateStudent(STUDENT, student);
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBService.getInstance().getConnection();  
            pstmt = conn.prepareStatement(UPDATE_STUDENT_BY_ID);
            
            int ix = setStudentDetails(pstmt, student);            
            pstmt.setInt(ix, studentId);            
            
            int count = pstmt.executeUpdate();
            
            if (count <= 0) {
                throw Util.prepareException("SMS-00011", null, studentId);
            }
            return count;
        } catch (SMSException ex) {
            throw ex;
        } catch (Throwable th) {
            throw Util.prepareException("SMS-00012", th, studentId);
        } finally {
            DBService.getInstance().closeResource(null, pstmt, conn);
        }
    }   
    
        
    // Delete Student By Id
    public static int deleteById(int studentId) {
        validateStudentId(STUDENT_ID, studentId);

        Connection conn = null;
        PreparedStatement pstmt = null;        
        try {
            conn = DBService.getInstance().getConnection();
            pstmt = conn.prepareStatement(DELETE_STUDENT_BY_ID);
            pstmt.setInt(1, studentId);
            
            int count = pstmt.executeUpdate();
            
            if (count <= 0) {
                throw Util.prepareException("SMS-00013", null, studentId);
            }
            return count;
        } catch (SMSException ex) {
            throw ex;
        } catch (Throwable th) {
            throw Util.prepareException("SMS-00014", th, studentId);
        } finally {
            DBService.getInstance().closeResource(null, pstmt, conn);
        }
    }
    
    // Delete Student By Aadhar Number
    public static int deleteByAadharNo(String aadharNo) {  
        validateAadharNo(AADHAR_NO, aadharNo);
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBService.getInstance().getConnection();
            pstmt = conn.prepareStatement(DELETE_STUDENT_BY_AADHAR_NUMBER);
            pstmt.setString(1, aadharNo);
            
            int count = pstmt.executeUpdate();
            
            if (count <= 0) {
                throw Util.prepareException("SMS-00015", null, aadharNo);
            }            
            return count;
        } catch (SMSException ex) {
            throw ex;
        } catch (Throwable th) {
            throw Util.prepareException("SMS-00016", th, aadharNo);
        } finally {
            DBService.getInstance().closeResource(null, pstmt, conn);
        }
    }
    
    public static boolean isAadharExist(String aadharNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = DBService.getInstance().getConnection();
            pstmt = conn.prepareStatement(IS_AADHAR_EXIST);
            pstmt.setString(1, aadharNo);       
            
            rs = pstmt.executeQuery();
            
            if (rs.next()){
                int aadharExist = rs.getInt(1);
                if(aadharExist == 1) {
                    throw Util.prepareException("SMS-00017", null, aadharNo);                    
                }
            } 
        } catch (SMSException ex) {
            throw ex;
        } catch (Throwable th) {
            throw Util.prepareException("SMS-00018", th, aadharNo);
        } finally {
            DBService.getInstance().closeResource(rs, pstmt, conn);
        }
        return true;
    }

    
    // To get student details
    private static Student getStudentDetails(ResultSet rs) throws SQLException{
        Student student = new Student();
        student.setStudentId(rs.getInt(STUDENT_ID)); 
        student.setFirstName(rs.getString(FIRST_NAME));
        student.setLastName(rs.getString(LAST_NAME));
        student.setGender(StudentEnum.GenderType.getGenderByString(rs.getString(GENDER)));
        student.setDob(rs.getDate(DOB));
        student.setEmailId(rs.getString(EMAIL_ID));
        
        student.setMobileNo(rs.getString(MOBILE_NO));
        student.setDoa(rs.getDate(DOA));
        student.setIdentificationMark(rs.getString(IDENTIFICATION_MARK));
        student.setAadharNo(rs.getString(AADHAR_NO));
        student.setBloodGroup(StudentEnum.BloodGroupType.getBloodGroupByValue(rs.getString(BLOOD_GROUP)));
        
        student.setNationality(rs.getString(NATIONALITY));
        student.setFatherName(rs.getString(FATHER_NAME));
        student.setFatherOccupation(rs.getString(FATHER_OCCUPATION));
        student.setFatherMobileNo(rs.getString(FATHER_MOBILE_NO));
        student.setMotherName(rs.getString(MOTHER_NAME));
        
        student.setMotherOccupation(rs.getString(MOTHER_OCCUPATION));
        student.setMotherMobileNo(rs.getString(MOTHER_MOBILE_NO));
        student.setAnnualIncome(rs.getBigDecimal(ANNUAL_INCOME));
        student.setAddressLine1(rs.getString(ADDRESS_LINE_1));
        student.setAddressLine2(rs.getString(ADDRESS_LINE_2));
        
        student.setCity(rs.getString(CITY));
        student.setState(rs.getString(STATE));
        student.setCountry(rs.getString(COUNTRY));
        student.setPinCode(rs.getString(PIN_CODE));           

        return student;
    }
    
    // To prepare Student Details
    private static int setStudentDetails(PreparedStatement pstmt, Student student) throws SQLException {
        int ix = 1;
        pstmt.setString(ix++, student.getFirstName());
        pstmt.setString(ix++, student.getLastName());
        pstmt.setString(ix++, StudentEnum.GenderType.getGenderByValue(student.getGender()));
        pstmt.setDate(ix++, student.getDob());
        pstmt.setString(ix++, student.getEmailId());
        pstmt.setString(ix++, student.getMobileNo());
        pstmt.setDate(ix++, student.getDoa());
        pstmt.setString(ix++, student.getIdentificationMark());
        pstmt.setString(ix++, student.getAadharNo());
        pstmt.setString(ix++, StudentEnum.BloodGroupType.getBloodGroupByValue(student.getBloodGroup()));
        pstmt.setString(ix++, student.getNationality());
        pstmt.setString(ix++, student.getFatherName());
        pstmt.setString(ix++, student.getFatherOccupation());
        pstmt.setString(ix++, student.getFatherMobileNo());
        pstmt.setString(ix++, student.getMotherName());
        pstmt.setString(ix++, student.getMotherOccupation());
        pstmt.setString(ix++, student.getMotherMobileNo());
        pstmt.setBigDecimal(ix++, student.getAnnualIncome());
        pstmt.setString(ix++, student.getAddressLine1());
        pstmt.setString(ix++, student.getAddressLine2());
        pstmt.setString(ix++, student.getCity());
        pstmt.setString(ix++, student.getState());
        pstmt.setString(ix++, student.getCountry());
        pstmt.setString(ix++, student.getPinCode());
        
        return ix;   
    }
    
    public static void validateStudent(String paramName, Student student) {
        if(student == null) {
            throw Util.prepareException("SMS-00001", null, paramName);
        }
    }
    public static void validateStudentId(String paramName, int studentId) {
        if(studentId <= 0) {
            throw Util.prepareException("SMS-00019", null, paramName, studentId);
        }
    }
    public static void validateAadharNo(String paramName, String aadharNo) {
        if(aadharNo == null) {
            throw Util.prepareException("SMS-00001", null, paramName);
        } else if(aadharNo.trim().length() != 12) {
            throw Util.prepareException("SMS-00021", null, aadharNo);
        }
    }
    public static void validateName(String paramName, String firstName) {
        if(firstName == null) {
            throw Util.prepareException("SMS-00001", null, paramName);
        } else if(firstName.trim().length() <= 0) {
            throw Util.prepareException("SMS-00020", null, paramName);
        }
    }
    
    private static final String COLUMN_NAMES = """
        student_id, 
        first_name, 
        last_name, 
        gender, 
        dob, 
        email_id, 
        mobile_no, 
        date_of_admission, 
        identification_mark, 
        aadhar_no, 
        blood_group, 
        nationality, 
        father_name, 
        father_occupation, 
        father_mobileNo, 
        mother_name, 
        mother_occupation, 
        mother_mobileNo, 
        annual_income, 
        address_line_1, 
        address_line_2, 
        city, 
        state, 
        country, 
        pin_code
        """;  
        
    private static final String GET_STUDENT_BY_ID = """
        SELECT %s
        FROM student 
        WHERE student_id = ? """.formatted(COLUMN_NAMES);
        
    private static final String GET_STUDENT_BY_AADHAR_NUMBER = """
        SELECT %s
        FROM student 
        WHERE aadhar_no = ? """.formatted(COLUMN_NAMES);
    
    private static final String GET_STUDENT_BY_NAME = """
        SELECT %s
        FROM student 
        WHERE first_name = ? AND last_name = ? """.formatted(COLUMN_NAMES);
        
    private static final String GET_STUDENT_BY_FIRST_NAME = """
        SELECT %s
        FROM student 
        WHERE first_name = ? """.formatted(COLUMN_NAMES);
    
    private static final String GET_ALL_STUDENTS = """
        SELECT %s
        FROM student """.formatted(COLUMN_NAMES);
        
    private static final String CREATE_STUDENT = """
        INSERT INTO student( %s ) 
        values(default,?,?,?::gender_type,?,?,?,?,?,?,?::blood_group_type,?,?,?,?,?,?,?,?,?,?,?,?,?,?) """.formatted(COLUMN_NAMES);
    
    private static final String UPDATE_STUDENT_BY_ID = """
        UPDATE student 
        SET 
            first_name = ?, 
            last_name = ?, 
            gender = ?::gender_type, 
            dob = ?, 
            email_id = ?, 
            mobile_no = ?, 
            date_of_admission = ?, 
            identification_mark = ?, 
            aadhar_no = ?, 
            blood_group = ?::blood_group_type, 
            nationality = ?, 
            father_name = ?, 
            father_occupation = ?, 
            father_mobileNo = ?, 
            mother_name = ?, 
            mother_occupation = ?, 
            mother_mobileNo = ?, 
            annual_income = ?, 
            address_line_1 = ?, 
            address_line_2 = ?, 
            city = ?, 
            state = ?, 
            country = ?, 
            pin_code = ?  
        WHERE student_id = ? 
        """;
    
    private static final String DELETE_STUDENT_BY_ID = """
        DELETE FROM student 
        WHERE student_id = ? 
        """;
    
    private static final String DELETE_STUDENT_BY_AADHAR_NUMBER = """
        DELETE FROM student 
        WHERE aadhar_no = ? 
        """;
      
    private static final String IS_AADHAR_EXIST = """
        SELECT 
        CASE 
            WHEN EXISTS (SELECT 1  FROM   student  WHERE  aadhar_no = ?) THEN 1 
            ELSE -1 
        END 
        """;  
         
    private static final String STUDENT  = "Student";
    private static final String STUDENT_ID  = "student_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String GENDER = "gender";
    private static final String DOB = "dob";
    private static final String EMAIL_ID = "email_id";
    private static final String MOBILE_NO = "mobile_no";
    private static final String DOA = "date_of_admission";
    private static final String IDENTIFICATION_MARK = "identification_mark";
    private static final String AADHAR_NO = "aadhar_no";
    private static final String BLOOD_GROUP = "blood_group";
    private static final String NATIONALITY = "nationality";
    private static final String FATHER_NAME = "father_name";
    private static final String FATHER_OCCUPATION = "father_occupation";
    private static final String FATHER_MOBILE_NO = "father_mobileno";  
    private static final String MOTHER_NAME = "mother_name";
    private static final String MOTHER_OCCUPATION = "mother_occupation";
    private static final String MOTHER_MOBILE_NO = "mother_mobileno";
    private static final String ANNUAL_INCOME = "annual_income";
    private static final String ADDRESS_LINE_1 = "address_line_1";
    private static final String ADDRESS_LINE_2 = "address_line_2";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String COUNTRY = "country";
    private static final String PIN_CODE = "pin_code";   
}
