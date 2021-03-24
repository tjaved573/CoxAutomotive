package com.cox.mysqlrestlms.controller;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cox.mysqlrestlms.model.Student;
import com.cox.mysqlrestlms.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest(controllers = StudentController.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    Student student1;
    Student student2;

    @BeforeEach
    void setUp() {
        student1 = new Student(12,"asdfasf", "Sdfsaf@yahoo.com");
        student2 = new Student(13,"taimoor", "taimoor@yahoo.com");
    }

    @Test
    void getAllStudents() throws Exception {
        List<Student> finalList = new ArrayList<>();
        finalList.add(student1);
        finalList.add(student2);
        given(studentService.getAllStudents()).willReturn(java.util.Optional.of(finalList));
        mockMvc.perform(get("/api/students")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAllStudentsError() throws Exception {
        given(studentService.getAllStudents()).willReturn(java.util.Optional.empty());
        mockMvc.perform(get("/api/students")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getStudentById() {
    }

    @Test
    void deleteStudentIfExists() {
    }

    @Test
    void createStudent() {
    }
}