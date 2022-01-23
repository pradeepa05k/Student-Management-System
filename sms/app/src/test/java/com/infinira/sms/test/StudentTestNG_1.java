// package com.infinira.sms.test;

// import com.infinira.sms.model.Student;

// import java.sql.Date;
// import java.math.BigDecimal;

// import java.util.Map;
// import java.util.HashMap;

// import io.restassured.RestAssured;
// import io.restassured.http.ContentType;
// import static io.restassured.RestAssured.given;
// import static io.restassured.RestAssured.when;

// import org.testng.annotations.Test;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.Ignore;
// import org.testng.annotations.AfterClass;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.Parameters;

// public class StudentTestNG_1 {
    // private Student student;
    
    // @BeforeClass 
    // public void beforeClass() {
        // System.out.println("Started Test class" + this.getClass());        
        // setUp();
    // }    
    
    // @BeforeMethod
    // public void beforeMethod() {
        // System.out.println("Started Test method");
    // }
    
    // public void setUp() {
        // RestAssured.baseURI = "http://localhost";
		// RestAssured.port = 8080;
		// RestAssured.basePath = "/students";        
    // }    
    
    // @Test (priority = 1)
    // public void create() {
        // int studentId = given().
            // contentType(ContentType.JSON).
            // body(getStudentDetails()).
        // when().
            // post(URL).
        // then()
            // .assertThat().statusCode(200)
            // .extract().as(Integer.class);
            
        // student.setStudentId(studentId);
    // }
    
    // @Parameters({"studentId"})
    // @Test (priority = 2, dependsOnMethods = {"create"})
    // public void getById(int id){
        // when().
            // get(URL + id).
        // then().
            // assertThat().statusCode(200);
    // }    
    
    // @Test (priority = 3, timeOut = 3000)
    // public void update() {
        // given().
            // contentType(ContentType.JSON).
            // body(getStudentDetails()).
        // when().
            // put(URL + student.getStudentId()).
        // then().
            // assertThat().statusCode(200);
    // }
    
    // @Test (priority = 4)
    // public void getByAadharNo(){
        // Map<String, String> requestBody = new HashMap<>();
        // requestBody.put(AADHAR_NO, student.getAadharNo());

        // given().
            // contentType(ContentType.JSON).
            // body(requestBody).
        // when().
            // get(AADHAR_NO_URL).
        // then().
            // assertThat().statusCode(200);
    // }
    
    // @Test (priority = 5)
    // public void getByName(){
        // Map<String, String> requestBody = new HashMap<>();
        // requestBody.put(FIRST_NAME, student.getFirstName());
        // requestBody.put(LAST_NAME, student.getLastName());

        // given().
            // contentType(ContentType.JSON).
            // body(requestBody).
        // when().
            // get(GET_BY_NAME_URL).
        // then().
            // assertThat().statusCode(200);            
    // }
    
    // @Test (priority = 6)
    // public void getAll(){        
        // when().
            // get(URL).
        // then().
            // assertThat().statusCode(200);
    // }
    
    // @Test (priority = 7)
    // public void deleteById(){ 
        // when().
            // delete(URL + student.getStudentId()).
        // then().
            // statusCode(200);
    // }
    
    // @Test (priority = 8, enabled = false)
    // public void deleteByAadharNo(){
        // Map<String, String> requestBody = new HashMap<>();
        // requestBody.put(AADHAR_NO, student.getAadharNo());    

        // given().
            // contentType(ContentType.JSON).
            // body(requestBody).
        // when().
            // delete(AADHAR_NO_URL).
        // then().
            // assertThat().statusCode(200);
    // }    
    
    // private Student getStudentDetails(){
        // if ( student != null ) {
            // return student;
        // }

        // student = new Student();
        // student.setStudentId(2);
        // student.setFirstName("Rest");
        // student.setLastName("Assured");
        // student.setGender("f");
        // student.setDob(Date.valueOf("2000-07-15"));
        // student.setEmailId("rest@gmail.com");
        // student.setMobileNo("1234567890");
        // student.setDoa(Date.valueOf("2018-09-08"));
        // student.setIdentificationMark("A scar in right hand");
        // student.setAadharNo("963852741123");
        // student.setBloodGroup("o+");
        // student.setNationality("indian");
        // student.setFatherName("test");
        // student.setFatherOccupation("businessman");
        // student.setFatherMobileNo("7899528874");
        // student.setMotherName("test");
        // student.setMotherOccupation("employee");
        // student.setMotherMobileNo("2244668879");
        // student.setAnnualIncome(BigDecimal.valueOf(Double.valueOf("3000000.0")));
        // student.setAddressLine1("12 test colony");
        // student.setAddressLine2("");
        // student.setCity("trichy");
        // student.setState("tamilnadu");
        // student.setCountry("india");
        // student.setPinCode("123450");
        
        // return student;
    // }
    
    
    // @AfterMethod
    // public void afterMethod() {
        // System.out.println("Completed Test method");
    // }
    
    // @AfterClass
    // public void afterClass() {
        // System.out.println("Completed Test class" + this.getClass());
    // }
    
    // private static final String URL = "/";
    // private static final String GET_BY_NAME_URL = "/name";
    // private static final String AADHAR_NO_URL = "/aadharNo";
    // private static final String AADHAR_NO = "aadharNo";
    // private static final String FIRST_NAME = "firstName";
    // private static final String LAST_NAME = "lastName";
// }