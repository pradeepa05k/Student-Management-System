// package com.infinira.sms.test;

// import com.infinira.sms.model.Student;

// import java.sql.Date;
// import java.util.List;
// import java.math.BigDecimal;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.Order;
// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.TestMethodOrder;
// import org.junit.jupiter.api.TestInstance;
// import org.junit.jupiter.api.TestInstance.Lifecycle;
// import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

// import reactor.core.publisher.Mono;
// import reactor.core.publisher.Flux;

// import org.springframework.web.reactive.function.client.WebClient;
// import org.springframework.http.MediaType;

// @TestMethodOrder(OrderAnnotation.class)
// @TestInstance(Lifecycle.PER_CLASS)
// public class StudentWebClientTest {
    // private WebClient webClient;
    // private Student student;
    
    // private static int studentId;
    // private static String baseUrl;
    
    // public StudentWebClientTest() {
        // webClient = WebClient.create();
    // }    
    
    // @BeforeAll
    // public void beforeAll() {
        // baseUrl = "http://localhost:8080/students/";        
    // }    
    
    // @Order(1)
    // @Test 
    // public void create() {
        // int id = webClient.post()
            // .uri(baseUrl)
            // .contentType(MediaType.APPLICATION_JSON)
            // .body(Mono.just(getStudentDetails()), Student.class)
            // .retrieve()
            // .bodyToMono(Integer.class)
            // .block();
            
        // studentId = id;
    // }
          
    // @Order(2)
    // @Test
    // public void getById() {
        // Student student = webClient.get()
            // .uri(baseUrl + studentId)
            // .retrieve()
            // .bodyToMono(Student.class)
            // .block();
    // }
    
    // @Disabled
    // @Order(3)
    // @Test
    // public void getByAadharNo() {
        // Student stud = webClient.post()
            // .uri(baseUrl + AADHAR_NO_URL)
            // .contentType(MediaType.APPLICATION_JSON)
            // .body(Mono.just(getStudentDetails()), Student.class)
            // .retrieve()
            // .bodyToMono(Student.class)
            // .block();            
    // }
    
    // @Disabled
    // @Order(4)
    // @Test
    // public void getByName() {        
        // List<Student> student = webClient.post()
            // .uri(baseUrl + GET_BY_NAME_URL)
            // .contentType(MediaType.APPLICATION_JSON)
            // .body(Mono.just(getStudentDetails()), Student.class)
            // .retrieve()
            // .bodyToFlux(Student.class)
            // .collectList()
            // .block();
    // }
    
    // @Order(5)
    // @Test
    // public void update() {
        // int id = webClient.put()
            // .uri(baseUrl + studentId)
            // .contentType(MediaType.APPLICATION_JSON)
            // .body(Mono.just(getStudentDetails()), Student.class)
            // .retrieve()
            // .bodyToMono(Integer.class)
            // .block();
    // }
    
    // @Order(6)
    // @Test
    // public void getAll() {
        // List<Student> student = webClient.get()
            // .uri(baseUrl)
            // .retrieve()
            // .bodyToFlux(Student.class)
            // .collectList()
            // .block();        
    // }
        
    // @Order(7)
    // @Test
    // public void deleteById(){ 
        // int count = webClient.delete()
            // .uri(baseUrl + studentId)
            // .retrieve()
            // .bodyToMono(Integer.class)
            // .block();
    // }
    
    // @Order(8)
    // @Disabled
    // @Test
    // public void deleteByAadharNo(){ 
        // int count = webClient.delete()
            // .uri(baseUrl + student.getAadharNo())
            // .retrieve()
            // .bodyToMono(Integer.class)
            // .block();        
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
    
    // private static final String GET_BY_NAME_URL = "/name";
    // private static final String AADHAR_NO_URL = "/aadharNo";
// }