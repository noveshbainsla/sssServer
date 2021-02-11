package com.smartsystem.sss.registrations.service;

import com.smartsystem.sss.common.BusinessException;
import com.smartsystem.sss.common.Response;
import com.smartsystem.sss.registrations.VO.ClassSearchContextVO;
import com.smartsystem.sss.registrations.VO.SSSClassVO;
import com.smartsystem.sss.registrations.VO.StudentSearchContextVO;
import com.smartsystem.sss.registrations.VO.StudentVO;
import com.smartsystem.sss.registrations.bussinessObject.RegistrationBusinessObject;
import com.smartsystem.sss.registrations.entity.SSSClass;
import com.smartsystem.sss.registrations.entity.Student;
import com.smartsystem.sss.registrations.util.SSSClassTransformer;
import com.smartsystem.sss.registrations.util.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    private RegistrationBusinessObject registrationBusinessObject;

    @Autowired
    private SSSClassTransformer sssClassMapper;

    @Autowired
    private StudentTransformer studentMapper;

    @Override
    public void createClass(SSSClassVO sssClassVO, Response response) {
        try {
            SSSClass sssClass = sssClassMapper.toDomain(sssClassVO);
            registrationBusinessObject.createClass(sssClass);
            sssClassVO = sssClassMapper.toVo(sssClass);
            response.setSuccess(true);
            response.setResponseObjects(Collections.singletonList(sssClassVO));
        } catch (BusinessException e){
            response.setSuccess(false);
            response.setValidationMessages(e.getValidationMessages());
        } catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void updateClass(SSSClassVO sssClassVO, Response response) {
        try{
            SSSClass sssClass = sssClassMapper.toDomain(sssClassVO);
            registrationBusinessObject.updateClass(sssClass);
            response.setSuccess(true);
            response.setResponseObjects(Collections.singletonList(sssClassMapper.toVo(sssClass)));
        } catch (BusinessException e){
            response.setSuccess(false);
            response.setValidationMessages(e.getValidationMessages());
        } catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void getClasses(ClassSearchContextVO classSearchContextVO,Response response) {
        try {
            List<SSSClass> sssClasses = registrationBusinessObject.getClasses(classSearchContextVO);
            List<SSSClassVO> sssClassVOS = new ArrayList<>();
            for (SSSClass sssClass : sssClasses) {
                sssClassVOS.add(sssClassMapper.toVo(sssClass));
            }
            response.setSuccess(true);
            response.setResponseObjects(Collections.singletonList(sssClassVOS));
        } catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
    }

    @Override
    public void createStudent(StudentVO studentVO, Response response) {
        try{
            Student student = registrationBusinessObject.createStudent(studentMapper.toDomain(studentVO));
            studentVO = studentMapper.toVo(student);
            response.setSuccess(true);
            response.setResponseObjects(Collections.singletonList(studentVO));
        } catch (BusinessException be) {
            be.printStackTrace();
            response.setSuccess(false);
            response.setValidationMessages(be.getValidationMessages());
        } catch (Exception e){
            e.printStackTrace();
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
    }

    @Override
    public void updateStudent(StudentVO studentVO, Response response) {
        try {
            Student student = studentMapper.toDomain(studentVO);
            student = registrationBusinessObject.updateStudent(student);
            response.setSuccess(true);
            response.setResponseObjects(Collections.singletonList(studentMapper.toVo(student)));
        } catch (BusinessException be) {
            be.printStackTrace();
            response.setSuccess(false);
            response.setValidationMessages(be.getValidationMessages());
        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
    }

    @Override
    public void getStudents(StudentSearchContextVO studentSearchContextVO, Response response) {
        try {
            List<Student> students = new ArrayList<>();
            students = registrationBusinessObject.searchStudent(studentSearchContextVO);
            response.setSuccess(true);
            List<StudentVO> studentVOS =new ArrayList<>();
            for(Student student: students){
                studentVOS.add(studentMapper.toVo(student));
            }
            response.setResponseObjects(Collections.singletonList(studentVOS));
        }catch (Exception e){
            e.printStackTrace();
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteClass(Long id, Response response) {
        try{
            SSSClass sssClass = new SSSClass();
            sssClass.setId(id);
            registrationBusinessObject.deleteClass(sssClass);
            response.setSuccess(true);
        } catch (BusinessException e){
            response.setSuccess(false);
            response.setValidationMessages(e.getValidationMessages());
        } catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void findSSSClass(Long classId, Response response) {
        try {
            SSSClass sssClass = registrationBusinessObject.getClassById(classId);
            response.setSuccess(true);
            response.setResponseObjects(Collections.singletonList(sssClassMapper.toVo(sssClass)));
        } catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
    }

    @Override
    public void searchStudent(StudentSearchContextVO studentSearchContextVO, Response response) {
        try{
            List<Student> students = new ArrayList<>();
            students.addAll(registrationBusinessObject.searchStudent(studentSearchContextVO));
            response.setSuccess(true);
            response.setResponseObjects(Collections.singletonList(students));
        }catch (Exception e){
            e.printStackTrace();
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
    }
}
