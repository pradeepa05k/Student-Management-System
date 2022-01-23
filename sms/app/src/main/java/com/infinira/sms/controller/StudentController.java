package com.infinira.sms.controller;

import com.infinira.sms.model.Student;
import com.infinira.sms.service.StudentService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/students")
public class StudentController { 
   
    @Autowired
    StudentService studentService; 
    
    @PostMapping("/")
    public int createStudent(@RequestBody Student studentForm) { 
        return studentService.createStudent(studentForm);   
    }
        
    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) { 
        return studentService.getStudentById(studentId);
    }
    
    @GetMapping("/aadharNo")
    public Student getStudentByAadharNo(@RequestBody Student req) {
        return studentService.getStudentByAadharNo(req.getAadharNo());
    }
    
    @GetMapping("/name")
    public List<Student> getStudentByName(@RequestBody Student req) {
        List<Student> students = studentService.getStudentByName(req.getFirstName(), req.getLastName());            
        return students;
    }
    
    @GetMapping("/")
    public List<Student> getAllStudents() { 
        List<Student> students = studentService.getAllStudents();           
        return students;
    }
    
    @PutMapping("/{studentId}")
    public int updateStudentById(@PathVariable int studentId, @RequestBody Student studentForm) { 
        return studentService.updateStudentById(studentId, studentForm);  
    }
    
    @DeleteMapping("/{studentId}")
    public int deleteStudentById(@PathVariable int studentId) { 
        return studentService.deleteStudentById(studentId);            
    }
    
    @DeleteMapping("/aadharNo")
    public int deleteStudentByAadharNo(@RequestBody Student req) { 
        return studentService.deleteStudentByAadharNo(req.getAadharNo());  
    }      
}