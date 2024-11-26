package com.example.demo.service;

import com.example.demo.model.Instructor;
import com.example.demo.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorService implements IInstructorService {
    private final InstructorRepository instructorRepository;

    @Override
    public List<Instructor> getInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor, Long id) {
        Optional<Instructor> existingInstructor = instructorRepository.findById(id);
        if (existingInstructor.isPresent()) {
            Instructor updatedInstructor = existingInstructor.get();
            updatedInstructor.setName(instructor.getName());
            updatedInstructor.setSpecialization(instructor.getSpecialization());
            return instructorRepository.save(updatedInstructor);
        } else {
            return null; // Indicate failure to update because instructor not found
        }
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id).orElse(null); // Return null if instructor not found
    }

    @Override
    public boolean deleteInstructor(Long id) {
        if (instructorRepository.existsById(id)) {
            instructorRepository.deleteById(id);
            return true; // Indicate successful deletion
        } else {
            return false; // Indicate failure to delete because instructor not found
        }
    }
}
