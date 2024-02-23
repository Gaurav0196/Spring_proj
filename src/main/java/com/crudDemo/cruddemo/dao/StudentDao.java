package com.crudDemo.cruddemo.dao;

import com.crudDemo.cruddemo.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface StudentDao extends JpaRepository<Student, Integer> {


    Student findByFirstName(String name);

}
