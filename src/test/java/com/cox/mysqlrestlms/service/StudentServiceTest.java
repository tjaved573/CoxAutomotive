package com.cox.mysqlrestlms.service;

import com.cox.mysqlrestlms.model.Student;
import com.cox.mysqlrestlms.repository.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepo testRepo;

    @InjectMocks
    StudentService serviceTest;

    Student student1;
    Student student2;

    @BeforeEach
    void setUp() {
        student1 = new Student(12,"random", "randomtesting@yahoo.com");
        student2 = new Student(13,"taimoor", "taimoor@yahoo.com");
    }

    @Test
    void getAllStudents() {
        List<Student> testList = new ArrayList<>();
        testList.add(student1);
        testList.add(student2);
        given(testRepo.findAll()).willReturn(testList);
        Optional<List<Student>> allStudents = serviceTest.getAllStudents();
        assertThat(allStudents.isPresent()).isTrue();
        assertThat(allStudents.get()).hasSize(2);
    }

    @Test
    void createStudent() {

        // Test1: Create student already existing in database
        // Test2:  Create Valid user
        // Test3: Create user with missing param name
        // Test4: Create user with missing param email

    }

    @Test
    void findStudentById() {

        // Test1: Find student with valid id
        // Test2: Find student not existing in db
    }

    @Test
    void isStudentExists() {
        // Test 1: Find Student with Valid ID
        // Test 2: Find student with invalid ID

    }

    @Test
    void deleteStudent() {
        // Test 1: Delete Student with Valid ID
        // Test 2: Delete student with invalid ID
    }
}