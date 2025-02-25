package com.devmaster.lesson03.service;

import com.devmaster.lesson03.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Service class: StudentService
 * <p>Lớp dịch vụ thực hiện các chức năng thao tác với List Object Student</p>
 * @author Chung Trịnh
 * @version 1.0
 */
@Service
public class StudentService {
    // mock data
    List<Student> students = new ArrayList<Student>();
    public StudentService() {
        students.addAll(
                Arrays.asList(
                    new Student(1L, "Devmaster Academy",20,"None","Số 25 Phố Vũ Ngọc Phan","0978611889","chungtrinhj@gmail.com"),
                    new Student(2L,"Chung Chuung",45, "Nam","Vũ Ngoc Phan","0123123123","chung@gmail.com")
                )
        );
    }
    // Lấy toàn bộ danh sách sinh viên
    public List<Student> getStudents() {
        return students;
    }
    // Lấy sinh viên theo id
    public Student getStudent(Long id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    // Thêm mơí sinh viên
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }
    // Cập nhật thông tin sinh viên
    public Student updateStudent(Long id, Student student) {
        Student check = getStudent(id);
        if(check == null) {
            return null;
        }
        students.forEach(item->{
            if(item.getId() == id) {
                item.setName(student.getName());
                item.setAddress(student.getAddress());
                item.setEmail(student.getEmail());
                item.setPhone(student.getPhone());
                item.setAge(student.getAge());
                item.setGender(student.getGender());
            }
        });
        return student;
    }

    // Xóa thông tin sinh viene
    public boolean deleteStudent(Long id) {
        Student student = getStudent(id);
        return students.remove(student);
    }
}
