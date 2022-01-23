// package com.infinira.sms.test;

// import com.infinira.sms.model.Student;

// import java.util.List;
// import java.util.ArrayList;

// import java.sql.Date;
// import java.math.BigDecimal;

// import org.testng.annotations.Test;
// import org.testng.annotations.Ignore;
// import org.testng.annotations.BeforeClass;

// import reactor.core.publisher.Mono;
// import reactor.core.publisher.Flux;

// import org.springframework.web.reactive.function.BodyInserters;
// import org.springframework.web.reactive.function.client.WebClient;
// import org.springframework.http.MediaType;

// public class StudentWebClientTestNG {    
    // private WebClient webClient;
    // private Student student;
    
    // private static String baseUrl; 

    // public StudentWebClientTestNG() {
        // webClient = WebClient.create();
    // } 
    
    // @BeforeClass 
    // public void beforeClass() {
        // baseUrl = "http://localhost:8080/students/";
    // }  
    
    // @Test (priority = 1)
    // public void create() {
        // int id = webClient.post()
            // .uri(baseUrl)
            // .contentType(MediaType.APPLICATION_JSON)
            // .body(Mono.just(getStudentDetails()), Student.class)
            // .retrieve()
            // .bodyToMono(Integer.class)
            // .block();
        
        // student.setStudentId(id);
    // }
    
    // @Test (priority = 2)
    // public void getById() {
        // Student stud = webClient.get()
            // .uri(baseUrl + student.getStudentId())
            // .retrieve()
            // .bodyToMono(Student.class)
            // .block();
    // }
    
    // @Ignore
    // @Test (priority = 3)
    // public void getByAadharNo() {
        // Student stud = webClient.post()
            // .uri(baseUrl + AADHAR_NO_URL)
            // .contentType(MediaType.APPLICATION_JSON)
            // .body(Mono.just(getStudentDetails()), Student.class)
            // .retrieve()
            // .bodyToMono(Student.class)
            // .block();            
    // }
    
    // @Ignore
    // @Test (priority = 4)
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
    
    // @Test (priority = 5)
    // public void update() {
        // int id = webClient.put()
            // .uri(baseUrl + student.getStudentId())
            // .contentType(MediaType.APPLICATION_JSON)
            // .body(Mono.just(getStudentDetails()), Student.class)
            // .retrieve()
            // .bodyToMono(Integer.class)
            // .block();
    // }
    
    // @Test (priority = 6)
    // public void getAll() {
        // List<Student> student = webClient.get()
            // .uri(baseUrl)
            // .retrieve()
            // .bodyToFlux(Student.class)
            // .collectList()
            // .block();        
    // }
        
    // @Test (priority = 7)
    // public void deleteById(){ 
        // int count = webClient.delete()
            // .uri(baseUrl + student.getStudentId())
            // .retrieve()
            // .bodyToMono(Integer.class)
            // .block();
    // }
    
    // @Ignore
    // @Test (priority = 8)
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