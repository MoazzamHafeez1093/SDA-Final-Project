package com.example.demo.service;

import com.example.demo.model.Course;

import java.util.List;

public interface ICourseService {
    Course addCourse(Course course);
    List<Course> getCourses();
    Course updateCourse(Course course, Long id);
    Course getCourseById(Long id);
    void deleteCourse(Long id);
}
