package com.cox.mysqlrestlms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cox.mysqlrestlms.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
