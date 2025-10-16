package com.foodelthy.springmvcboot.student.repository;

import com.foodelthy.springmvcboot.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameOrderByIdDesc(String name); // Query DSL

    @Query("from Student s where s.name = :name") // Custom Query
    List<Student> find(@Param("name") String name);
}
