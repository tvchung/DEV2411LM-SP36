package com.devmaster.lesson03.controller;

import com.devmaster.lesson03.entity.Student;
import com.devmaster.lesson03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * Lấy danh sách sinh viên
     */
    @GetMapping("/student-list")
    public List<Student> getAllStudent(){
        return studentService.getStudents();
    }

    /***
     * Lấy thông tin sinh viên theo id
     * @param: id
     */
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable String id){
        Long idStudent = Long.parseLong(id);
        return studentService.getStudent(idStudent);
    }
    /**
     * Thêm mơới 1 sinh viên
     */
    @PostMapping("/student-add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    /***
     * Sửa thông tin sinh viên
     *
     */
    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student){
        Long idStudent = Long.parseLong(id);
        return studentService.updateStudent(idStudent, student);
    }

    /**
     * Xóa 1 sinh viên
     */
    @DeleteMapping("/student/{id}")
    public boolean deleteStudent(@PathVariable String id){
        long idStudent = Long.parseLong(id);
        return studentService.deleteStudent(idStudent);
    }
}
