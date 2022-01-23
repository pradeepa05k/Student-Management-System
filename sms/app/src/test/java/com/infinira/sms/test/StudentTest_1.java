package com.infinira.sms.test;

import com.infinira.sms.model.Student;

import java.util.Map;
import java.util.HashMap;

import java.sql.Date;
import java.math.BigDecimal;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class StudentTest_1 {
    private Student student;
    
    @BeforeAll
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/students";
    }    
    
    @Test 
    @Order(1)
	@DisplayName("Create Student")
    @Tag("create")
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
    
    @Order(2)
    @DisplayName("Get By ID")
    @ParameterizedTest(name = "Get By Student ID - {0}")
	@ValueSource(ints = {1, 3})
    @Tag("get")
    public void getById(int studentId){
        when().
            get(URL + studentId).
        then().
            assertThat().statusCode(200);
    }    
    
    @Test
    @Order(3)
    @DisplayName("Update by Student ID")
    @Tag("update")
    public void update() {
        given().
            contentType(ContentType.JSON).
            body(getStudentDetails()).
        when().
            put(URL + student.getStudentId()).
        then().
            assertThat().statusCode(200);
    }
    
    @Test
    @Order(4)
    @DisplayName("Get By Student Aadhar Number")
    @Tag("get")
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
    @Order(5)
    @DisplayName("Get By Student Name")
    @Tag("get")
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
    @Order(6)
    @DisplayName("Get All Student")
    @Tag("get")
    public void getAll(){        
        when().
            get(URL).
        then().
            assertThat().statusCode(200);
    }
    
    @Test
    @Order(7)
    @DisplayName("Delete By Student ID")
    @Tag("delete")
    public void deleteById(){ 
        when().
            delete(URL + student.getStudentId()).
        then().
            statusCode(200);
    }
    
    @Disabled("Disabled because this student is already deleted")
    @Test
    @Order(8)
    @DisplayName("Delete By Student Aadhar Number")
    @Tag("delete")
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
        
    private static final String URL = "/";
    private static final String GET_BY_NAME_URL = "/name";
    private static final String AADHAR_NO_URL = "/aadharNo";
    private static final String AADHAR_NO = "aadharNo";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
}