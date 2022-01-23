package com.infinira.sms.test;

import com.infinira.sms.model.Student;

import java.sql.Date;
import java.math.BigDecimal;

import java.util.Map;
import java.util.HashMap;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@TestInstance(Lifecycle.PER_CLASS)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class StudentTest_2 {
    private Student student;
    
    @BeforeAll
    public void beforeAll(TestInfo testInfo) {
        System.out.println("Started Test class - " + testInfo.getTestClass());        
        setUp();
    }    
    
    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        System.out.println("Started Test method - " + testInfo.getDisplayName());
    }
    
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/students";        
    }    
    
    @Test 
	@DisplayName("Create Student")
    public void create() {
        int studentId = given().
            contentType(ContentType.JSON).
            body(getStudentDetails()).
        when().
            post(URL).
        then()
            .assertThat().statusCode(200)
            .extract().as(Integer.class);
            
        student.setStudentId(studentId);
    }
    
    @Order(1)
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Get_Student_Test {
        
        @DisplayName("Get By ID")
        @ParameterizedTest(name = "Get By Student ID - {0}")
        @ValueSource(ints = {1, 3})
        public void getById(int studentId){
            when().
                get(URL + studentId).
            then().
                assertThat().statusCode(200);
        }    
        
        @RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
        @DisplayName("Get By Student Aadhar Number")
        public void getByAadharNo(){
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put(AADHAR_NO, student.getAadharNo());

            given().
                contentType(ContentType.JSON).
                body(requestBody).
            when().
                get(AADHAR_NO_URL).
            then().
                assertThat().statusCode(200);
        }
        
        @Test
        @EnabledOnOs(OS.WINDOWS) 
        @DisplayName("Get By Student Name")
        public void getByName(){
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put(FIRST_NAME, student.getFirstName());
            requestBody.put(LAST_NAME, student.getLastName());

            given().
                contentType(ContentType.JSON).
                body(requestBody).
            when().
                get(GET_BY_NAME_URL).
            then().
                assertThat().statusCode(200);            
        }
        
        @Test
        @DisplayName("Get All Student")
        public void getAll(){        
            when().
                get(URL).
            then().
                assertThat().statusCode(200);
        }
    }
    
    @Test
    @DisplayName("Update by Student ID")
    @Timeout(value = 3000, unit = TimeUnit.MILLISECONDS)
    public void update() {
        given().
            contentType(ContentType.JSON).
            body(getStudentDetails()).
        when().
            put(URL + student.getStudentId()).
        then().
            assertThat().statusCode(200);
    }
    
    @Order(2)
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Delete_Student_Test {            
        @Test
        @DisplayName("Delete By Student ID")
        public void deleteById(){ 
            when().
                delete(URL + student.getStudentId()).
            then().
                statusCode(200);
        }
        
        @Disabled("Disabled because this student is already deleted")
        @Test
        @DisplayName("Delete By Student Aadhar Number")
        public void deleteByAadharNo(){
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put(AADHAR_NO, student.getAadharNo());    

            given().
                contentType(ContentType.JSON).
                body(requestBody).
            when().
                delete(AADHAR_NO_URL).
            then().
                assertThat().statusCode(200);
        }    
    }
    
    
    private Student getStudentDetails(){
        if ( student != null ) {
            return student;
        }

        student = new Student();
        student.setStudentId(2);
        student.setFirstName("Rest");
        student.setLastName("Assured");
        student.setGender("f");
        student.setDob(Date.valueOf("2000-07-15"));
        student.setEmailId("rest@gmail.com");
        student.setMobileNo("1234567890");
        student.setDoa(Date.valueOf("2018-09-08"));
        student.setIdentificationMark("A scar in right hand");
        student.setAadharNo("963852741123");
        student.setBloodGroup("o+");
        student.setNationality("indian");
        student.setFatherName("test");
        student.setFatherOccupation("businessman");
        student.setFatherMobileNo("7899528874");
        student.setMotherName("test");
        student.setMotherOccupation("employee");
        student.setMotherMobileNo("2244668879");
        student.setAnnualIncome(BigDecimal.valueOf(Double.valueOf("3000000.0")));
        student.setAddressLine1("12 test colony");
        student.setAddressLine2("");
        student.setCity("trichy");
        student.setState("tamilnadu");
        student.setCountry("india");
        student.setPinCode("123450");
        
        return student;
    }
    
    @AfterEach
    public void afterEach(TestInfo testInfo) {
        System.out.println("Completed Test method - " + testInfo.getDisplayName());
    }
    
    @AfterAll
    public void afterAll(TestInfo testInfo) {
        System.out.println("Completed Test class - " + testInfo.getTestClass());
    }
        
    private static final String URL = "/";
    private static final String GET_BY_NAME_URL = "/name";
    private static final String AADHAR_NO_URL = "/aadharNo";
    private static final String AADHAR_NO = "aadharNo";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
}