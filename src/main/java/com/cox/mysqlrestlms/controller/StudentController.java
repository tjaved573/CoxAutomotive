package com.cox.mysqlrestlms.controller;

import com.cox.mysqlrestlms.model.Student;
import com.cox.mysqlrestlms.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/students")
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        Optional<List<Student>> allStudents = studentService.getAllStudents();
        return allStudents.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        Optional<Student> currentStudent = studentService.getStudentById(id);
        return currentStudent.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @DeleteMapping(value="/{id}")
    public void deleteStudentIfExists(@PathVariable Integer id){
        log.info(String.valueOf(id));
        if(studentService.isStudentExists(id)){
            studentService.deleteStudent(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found");
        }
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student currStudent = studentService.createStudent(student);
        return ResponseEntity.ok(currStudent);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @Valid @RequestBody Student student){
        if(studentService.isStudentExists(id)){
            studentService.updateStudent(id, student);
            return ResponseEntity.ok(student);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
