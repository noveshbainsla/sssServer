package com.smartsystem.sss.registrations.repository;

import com.smartsystem.sss.registrations.VO.StudentSearchContextVO;
import com.smartsystem.sss.registrations.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    public Student save(Student student);
    public Optional<Student> findById(Long id);

    public List<Student> searchStudent(StudentSearchContextVO studentSearchContextVO);
}
