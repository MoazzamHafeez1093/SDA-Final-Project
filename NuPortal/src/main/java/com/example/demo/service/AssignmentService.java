package com.example.demo.service;

import com.example.demo.model.Assignment;
import com.example.demo.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService implements IAssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public List<Assignment> getAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment addAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment updateAssignment(Assignment assignment, Long id) {
        Optional<Assignment> existingAssignment = assignmentRepository.findById(id);
        if (existingAssignment.isPresent()) {
            Assignment updatedAssignment = existingAssignment.get();
            updatedAssignment.setName(assignment.getName());
            updatedAssignment.setGoogleDriveLink(assignment.getGoogleDriveLink());
            return assignmentRepository.save(updatedAssignment);
        } else {
            return null; // Indicate failure to update because assignment not found
        }
    }

    @Override
    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id).orElse(null); // Return null if assignment not found
    }

    @Override
    public void deleteAssignment(Long id) {
        if (assignmentRepository.existsById(id)) {
            assignmentRepository.deleteById(id);
        }
    }
}
