package com.crudDemo.cruddemo.service.impl;

import com.crudDemo.cruddemo.dao.StudentDao;
import com.crudDemo.cruddemo.dao.entity.Student;
import com.crudDemo.cruddemo.service.StudentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentServiceImpl implements StudentService {


    private EntityManager entityManager;
    private StudentDao studentDao;



    @Autowired
    public StudentServiceImpl(EntityManager em,StudentDao sd){
        entityManager=em;
        studentDao=sd;
    }
    @Override
    @Transactional
    public void save(Student student) {
    entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
//        Student s=entityManager.find(Student.class,id);
Optional<Student> s=studentDao.findById(id);
        return s.orElse(null);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery=entityManager.createQuery("From Student order by lastName asc",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> dindByLastName(String lastName) {
        TypedQuery<Student> students=entityManager.createQuery("from Student where lastName=:theData",Student.class);
        students.setParameter("theData",lastName);
        return students.getResultList();
    }

    @Override
    @Transactional
    public void update(Student s) {
        entityManager.merge(s);


    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student s=entityManager.find(Student.class,id);
        entityManager.remove(s);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numsrowDelete=entityManager.createQuery("DELETE from Student").executeUpdate();
        return numsrowDelete;
    }
}
