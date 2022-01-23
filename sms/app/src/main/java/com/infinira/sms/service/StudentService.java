package com.infinira.sms.service;

import java.util.List;

import com.infinira.sms.model.Student;
import com.infinira.sms.dao.StudentDAO;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    public int createStudent(Student student) {
        return StudentDAO.create(student);
    }
    
    public Student getStudentById(int studentId) {
        return StudentDAO.getById(studentId);     
    }
    
    public Student getStudentByAadharNo(String aadharNo) {
        return StudentDAO.getByAadharNo(aadharNo);
    }
    
    public List<Student> getStudentByName(String firstName, String lastName) {
        return StudentDAO.getByName(firstName, lastName);
    }
    
    public List<Student> getAllStudents() {
        return StudentDAO.getAll();
    }
    
    public int updateStudentById(int studentId, Student student) {
        return StudentDAO.update(studentId, student);
    }
    
    public int deleteStudentById(int studentId) {
        return StudentDAO.deleteById(studentId);
    }
    
    public int deleteStudentByAadharNo(String aadharNo) {
        return StudentDAO.deleteByAadharNo(aadharNo);
    }
}