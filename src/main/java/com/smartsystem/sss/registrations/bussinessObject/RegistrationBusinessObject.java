package com.smartsystem.sss.registrations.bussinessObject;

import com.smartsystem.sss.registrations.VO.ClassSearchContextVO;
import com.smartsystem.sss.registrations.VO.StudentSearchContextVO;
import com.smartsystem.sss.registrations.entity.SSSClass;
import com.smartsystem.sss.registrations.entity.Student;

import java.util.Collection;
import java.util.List;

public interface RegistrationBusinessObject {
    public void createClass(SSSClass sssClass) throws Exception;
    public void updateClass(SSSClass sssClass) throws Exception;
    public List<SSSClass> getClasses(ClassSearchContextVO classSearchContextVO);

    public Student createStudent(Student student) throws Exception;
    public Student updateStudent(Student student) throws Exception;

    public void deleteClass(SSSClass sssClass) throws Exception;

    public SSSClass getClassById(Long classId);

    public List<Student> searchStudent(StudentSearchContextVO studentSearchContextVO);
}
