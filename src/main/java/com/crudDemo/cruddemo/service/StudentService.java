package com.crudDemo.cruddemo.service;

import com.crudDemo.cruddemo.dao.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> dindByLastName(String lastName);

    void update(Student s);

    void delete(Integer id);

    int deleteAll();
}
