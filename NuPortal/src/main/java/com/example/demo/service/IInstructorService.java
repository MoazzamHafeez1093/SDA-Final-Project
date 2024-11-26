package com.example.demo.service;

import com.example.demo.model.Instructor;

import java.util.List;

public interface IInstructorService {
    Instructor addInstructor(Instructor instructor);
    List<Instructor> getInstructors();
    Instructor updateInstructor(Instructor instructor, Long id);
    Instructor getInstructorById(Long id);
    boolean deleteInstructor(Long id);
}
