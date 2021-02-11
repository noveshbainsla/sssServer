package com.smartsystem.sss.registrations.service;

import com.smartsystem.sss.common.Response;
import com.smartsystem.sss.registrations.VO.ClassSearchContextVO;
import com.smartsystem.sss.registrations.VO.SSSClassVO;
import com.smartsystem.sss.registrations.VO.StudentSearchContextVO;
import com.smartsystem.sss.registrations.VO.StudentVO;

import java.util.List;

public interface RegistrationService {
    public void createClass(SSSClassVO sssClassVO, Response response);
    public void updateClass(SSSClassVO sssClassVO, Response response);
    public void getClasses(ClassSearchContextVO classSearchContextVO,Response response);

    public void createStudent(StudentVO studentVO, Response response);
    public void updateStudent(StudentVO studentVO, Response response);
    public void getStudents(StudentSearchContextVO studentSearchContextVO, Response response);

    public void deleteClass(Long id, Response response);

    public void findSSSClass(Long classId, Response response);

    public void searchStudent(StudentSearchContextVO studentSearchContextVO, Response response);
}
