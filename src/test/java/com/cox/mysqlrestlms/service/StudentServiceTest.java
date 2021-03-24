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
        student1 = new Student(12,"asdfasf", "Sdfsaf@yahoo.com");
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
    }

    @Test
    void findStudentById() {
    }

    @Test
    void isStudentExists() {
    }

    @Test
    void deleteStudent() {
    }
}