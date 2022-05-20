package com.rohithmsr.app.simplestudentrest.Controller;

import com.rohithmsr.app.simplestudentrest.Models.Student;
import com.rohithmsr.app.simplestudentrest.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/students")
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    @GetMapping(value = "/students/{id}")
    public Student getStudentById(@PathVariable long id){
        return studentRepo.findById(id).get();
    }

    @PostMapping(value = "/students")
    public String saveStudent(@RequestBody Student student){
        studentRepo.save(student);
        return "Saved to the database successfully!";
    }

    @PutMapping(value = "/students/{id}")
    public String updateStudent(@PathVariable long id, @RequestBody Student student){
        Student newStudent = studentRepo.findById(id).get();
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setDepartment(student.getDepartment());
        newStudent.setSemester(student.getSemester());
        studentRepo.save(newStudent);
        return "Updated the details for the student id = " + id;
    }

    @DeleteMapping(value = "/students/{id}")
    public String deleteStudent(@PathVariable long id){
        Student deleteStudent = studentRepo.findById(id).get();
        studentRepo.delete(deleteStudent);
        return "Delete user with the id = " + id;
    }
}
