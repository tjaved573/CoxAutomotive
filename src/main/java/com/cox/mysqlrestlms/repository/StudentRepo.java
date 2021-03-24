package com.cox.mysqlrestlms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cox.mysqlrestlms.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
