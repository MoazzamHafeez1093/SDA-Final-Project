package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        if (courseAlreadyExists(course.getName())) {
            return null; // Indicate failure to add because course already exists
        }
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            Course updatedCourse = existingCourse.get();
            updatedCourse.setName(course.getName());
            updatedCourse.setDescription(course.getDescription());
            return courseRepository.save(updatedCourse);
        } else {
            return null; // Indicate failure to update because course not found
        }
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null); // Return null if course not found
    }

    @Override
    public void deleteCourse(Long id)
    {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        }

    }

    private boolean courseAlreadyExists(String name) {
        return courseRepository.findByName(name).isPresent();
    }
}
