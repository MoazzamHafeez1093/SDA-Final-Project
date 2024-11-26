package com.example.demo.service;

import com.example.demo.model.Assignment;

import java.util.List;

public interface IAssignmentService {
    List<Assignment> getAssignments();
    Assignment addAssignment(Assignment assignment);
    Assignment updateAssignment(Assignment assignment, Long id);
    Assignment getAssignmentById(Long id);
    void deleteAssignment(Long id);
}
