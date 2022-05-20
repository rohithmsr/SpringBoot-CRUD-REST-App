package com.rohithmsr.app.simplestudentrest.Repo;

import com.rohithmsr.app.simplestudentrest.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
