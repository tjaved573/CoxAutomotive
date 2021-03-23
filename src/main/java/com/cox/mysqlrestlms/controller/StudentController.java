package com.cox.mysqlrestlms.controller;

import com.cox.mysqlrestlms.model.Student;
import com.cox.mysqlrestlms.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @RequestMapping(value = "/api/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents(){

        List<Student> students = new ArrayList<Student>();
        studentRepo.findAll().forEach(students::add);

        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/students", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        try {
            Student currStudent = studentRepo
                    .save(new Student(student.getStudentId(), student.getStudentName(), student.getStudentEmail()));
            return new ResponseEntity<>(currStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/api/students/{studentID}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@PathVariable int studentID, @Valid @RequestBody Student student) {
        Optional<Student> currStudentPresent = studentRepo.findById(studentID);
        if(currStudentPresent.isPresent()){
            Student s = currStudentPresent.get();
            s.setStudentName(student.getStudentName());
            s.setStudentEmail(student.getStudentEmail());
            return new ResponseEntity<>(studentRepo.save(s), HttpStatus.OK);
        }
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value="/api/students/{studentID}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable int studentID) {
        Optional<Student> currStudentPresent = studentRepo.findById(studentID);
        if(currStudentPresent.isPresent()){
            studentRepo.delete(currStudentPresent.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }

}
