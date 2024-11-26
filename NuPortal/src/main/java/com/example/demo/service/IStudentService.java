package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * @author Simpson Alfred
 */

public interface IStudentService {
    Student addStudent(Student student);
    List<Student> getStudents();
    Student updateStudent(Student student, Long id);
    Student getStudentById(Long id);
    void deleteStudent(Long id);

    Optional<Student> authenticate(String email, String password);
}
