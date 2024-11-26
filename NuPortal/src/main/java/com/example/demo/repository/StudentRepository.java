package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Simpson Alfred
 */

public interface StudentRepository extends JpaRepository<Student, Long>
{
    Optional<Student> findByEmail(String email);
    Optional<Student> findByEmailAndPassword(String email, String password);
}
