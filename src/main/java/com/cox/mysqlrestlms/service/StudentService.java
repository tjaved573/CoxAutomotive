package com.cox.mysqlrestlms.service;

import com.cox.mysqlrestlms.model.Student;
import com.cox.mysqlrestlms.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Optional<List<Student>> getAllStudents(){
        return Optional.of(studentRepo.findAll());
    }

    public Student createStudent(Student student){
        return studentRepo.save(student);
    }

    public Optional<Student> getStudentById(int id){
        return studentRepo.findById(id);
    }

    public boolean isStudentExists(int id){
        return studentRepo.existsById(id);
    }

    public void deleteStudent(int id){
        if(isStudentExists(id)){
            studentRepo.deleteById(id);
        }
    }

    public void updateStudent(int id, Student student){
        if(isStudentExists(id)){
            studentRepo.save(student);
        }
    }
}
