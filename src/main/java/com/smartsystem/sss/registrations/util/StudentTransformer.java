package com.smartsystem.sss.registrations.util;

import com.smartsystem.sss.common.GlobalMethods;
import com.smartsystem.sss.registrations.VO.StudentVO;
import com.smartsystem.sss.registrations.entity.Student;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class StudentTransformer {
    public Student toDomain(StudentVO studentVO) throws Exception {
        if(studentVO==null){
            return null;
        }
        Student student = new Student();
        student.setClassId(studentVO.getClassId());
        student.setId(studentVO.getId());
        student.setStudentName(studentVO.getStudentName().toUpperCase());
        student.setContactNo(studentVO.getContactNo());
        student.setPrimaryGuardian(studentVO.getPrimaryGuardian().toUpperCase());
        student.setSecondaryGuardian(studentVO.getSecondaryGuardian());
        student.setDateOfBirth(GlobalMethods.stringToDate(studentVO.getDateOfBirth()));
        student.setRegStatus(studentVO.getRegStatus());
        student.setTenantId(studentVO.getTenantId());
        student.setRollNumber(studentVO.getRollNumber());
        student.setApplicationNumber(GlobalMethods.isNullEmptyString(studentVO.getApplicationNumber()) ? null : studentVO.getApplicationNumber().toUpperCase());
        student.setCategory(studentVO.getCategory());

        student.setAdmissionWithdrawlNumber(studentVO.getAdmissionWithdrawlNumber().toUpperCase());
        student.setStudentRegistrationNumber(studentVO.getStudentRegistrationNumber());
        student.setPrimaryGuardianOccupation(studentVO.getPrimaryGuardianOccupation().toUpperCase());
        student.setSecondaryGuardianOccupation(GlobalMethods.isNullEmptyString(studentVO.getSecondaryGuardianOccupation()) ? null : studentVO.getSecondaryGuardianOccupation().toUpperCase());
        student.setDateOfAdmission(GlobalMethods.isNullEmptyString(studentVO.getDateOfAdmission()) ? null : GlobalMethods.stringToDate(studentVO.getDateOfAdmission()));
        student.setGender(studentVO.getGender());
        student.setConveyance(studentVO.getConveyance() ? 1L : 0L);
        student.setRouteNumber(studentVO.getRouteNumber());
        student.setPreviousSchoolName(studentVO.getPreviousSchoolName());
        student.setAddress(studentVO.getAddress());

        return student;
    }

    public StudentVO toVo(Student student) throws ParseException {
        if(student==null){
            return null;
        }
        StudentVO studentVO = new StudentVO();
        studentVO.setClassId(student.getClassId());
        studentVO.setId(student.getId());
        studentVO.setStudentName(student.getStudentName());
        studentVO.setContactNo(student.getContactNo());
        studentVO.setPrimaryGuardian(student.getPrimaryGuardian());
        studentVO.setSecondaryGuardian(student.getSecondaryGuardian());
        studentVO.setDateOfBirth(GlobalMethods.dateToString(student.getDateOfBirth()));
        studentVO.setRegStatus(student.getRegStatus());
        studentVO.setTenantId(student.getTenantId());
        studentVO.setRollNumber(student.getRollNumber());
        studentVO.setApplicationNumber(student.getApplicationNumber());
        studentVO.setCategory(student.getCategory());

        studentVO.setAdmissionWithdrawlNumber(student.getAdmissionWithdrawlNumber().toUpperCase());
        studentVO.setStudentRegistrationNumber(student.getStudentRegistrationNumber());
        studentVO.setPrimaryGuardianOccupation(student.getPrimaryGuardianOccupation().toUpperCase());
        studentVO.setSecondaryGuardianOccupation(student.getSecondaryGuardianOccupation());
        studentVO.setDateOfAdmission(GlobalMethods.dateToString(student.getDateOfAdmission()));
        studentVO.setGender(student.getGender());
        studentVO.setConveyance(student.getConveyance() == 1);
        studentVO.setRouteNumber(student.getRouteNumber());
        studentVO.setPreviousSchoolName(student.getPreviousSchoolName());
        studentVO.setAddress(student.getAddress());
        return studentVO;
    }
}
