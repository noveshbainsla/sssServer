package com.smartsystem.sss.registrations.bussinessObject;

import com.smartsystem.sss.common.BusinessException;
import com.smartsystem.sss.common.GlobalConstants;
import com.smartsystem.sss.common.ValidationMessage;
import com.smartsystem.sss.common.clientauth.entity.SSSTenant;
import com.smartsystem.sss.common.clientauth.repository.SSSTenantDao;
import com.smartsystem.sss.registrations.constants.RegistrationConstants;
import com.smartsystem.sss.registrations.RegistrationValidator;
import com.smartsystem.sss.registrations.VO.ClassSearchContextVO;
import com.smartsystem.sss.registrations.VO.StudentSearchContextVO;
import com.smartsystem.sss.registrations.entity.SSSClass;
import com.smartsystem.sss.registrations.entity.Student;
import com.smartsystem.sss.registrations.repository.ClassDao;
import com.smartsystem.sss.registrations.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Component
public class RegistrationBusinessObjectImpl implements RegistrationBusinessObject {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ClassDao classDao;

    @Autowired
    private SSSTenantDao sssTenantDao;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private RegistrationValidator registrationValidator;

    @Override
    @Transactional
    public void createClass(SSSClass sssClass) throws Exception {
        if(!registrationValidator.validateClassCreation(sssClass).isEmpty()){
            BusinessException be = new BusinessException(RegistrationConstants.BUSINESS_EXCEPTION);
            be.setValidationMessages(registrationValidator.validateClassCreation(sssClass));
            throw be;
        }

        sssClass.setStrength(0L);
    	classDao.save(sssClass);
    }

    @Override
    public void updateClass(SSSClass sssClass) throws Exception {
        if(!registrationValidator.validateClassUpdation(sssClass).isEmpty()){
            BusinessException be = new BusinessException(RegistrationConstants.BUSINESS_EXCEPTION);
            be.setValidationMessages(registrationValidator.validateClassUpdation(sssClass));
            throw be;
        }
        classDao.save(sssClass);
    }

    @Override
    public List<SSSClass> getClasses(ClassSearchContextVO classSearchContextVO) {
        return classDao.findAllByTenant(classSearchContextVO);
    }

    @Override
    @Transactional
    public Student createStudent(Student student) throws Exception{
        List<ValidationMessage> validationMessages = registrationValidator.validateStudentCreationUpdation(student);
        if(!validationMessages.isEmpty()){
            BusinessException be = new BusinessException(GlobalConstants.BUSINESS_EXCEPTION);
            be.setValidationMessages(validationMessages);
            throw be;
        }

        generateApplicationNumber(student);
        generateRollNumber(student); //logic needs to be written
        student = studentDao.save(student);
        updateStrengthOfAffectedClasses(student,null);
        return student;
    }

    private void generateRollNumber(Student student) {
    }

    private void generateApplicationNumber(Student student) {
        SSSTenant sssTenant = new SSSTenant();
        sssTenant.setId(student.getTenantId());
        sssTenant = sssTenantDao.findById(sssTenant).get();
        String appNo = sssTenant.getRegistrationPrefix() +  (sssTenant.getRegistrationCounter()==null ? 0 : sssTenant.getRegistrationCounter()+1);
        student.setApplicationNumber(appNo);
        student.setRollNumber(appNo); //to be removed after generateRollNumber login is created
        sssTenant.setRegistrationCounter(sssTenant.getRegistrationCounter()==null ? 0 : sssTenant.getRegistrationCounter()+1);
        sssTenantDao.save(sssTenant);
    }

    @Override
    public Student updateStudent(Student student) throws Exception{
        List<ValidationMessage> validationMessages = registrationValidator.validateStudentCreationUpdation(student);
        if(!validationMessages.isEmpty()){
            BusinessException be = new BusinessException(GlobalConstants.BUSINESS_EXCEPTION);
            be.setValidationMessages(validationMessages);
            throw be;
        }

        Long previousClassId = studentDao.findById(student.getId()).get().getClassId();
        student = studentDao.save(student);
        updateStrengthOfAffectedClasses(student,previousClassId);
        return student;
    }

    private void updateStrengthOfAffectedClasses(Student student,Long previousClassId) {
        SSSClass sssClass = new SSSClass();
        sssClass.setId(student.getClassId());
        sssClass=classDao.findById(sssClass).get();
        sssClass.setStrength(sssClass.getStrength()==null ? 0L : sssClass.getStrength()+1);
        classDao.save(sssClass);

        if(previousClassId!=null) {
            SSSClass previousClass = new SSSClass();
            previousClass.setId(previousClassId);
            previousClass = classDao.findById(previousClass).get();
            previousClass.setStrength(previousClass.getStrength() - 1);
            classDao.save(previousClass);
        }
    }

    @Override
    public void deleteClass(SSSClass sssClass) throws Exception {
        if(!registrationValidator.validateDeleteClass(sssClass).isEmpty()){
            BusinessException be = new BusinessException(RegistrationConstants.BUSINESS_EXCEPTION);
            be.setValidationMessages(registrationValidator.validateDeleteClass(sssClass));
            throw be;
        }

        classDao.delete(sssClass);
    }

    @Override
    public SSSClass getClassById(Long classId) {
        SSSClass sssClass = new SSSClass();
        sssClass.setId(classId);
        Optional<SSSClass> sssClassOptional = classDao.findById(sssClass);
        sssClass = sssClassOptional.get();
        StudentSearchContextVO studentSearchContextVO = new StudentSearchContextVO();
        studentSearchContextVO.setTenantId(sssClass.getTenantId());
        studentSearchContextVO.setClassId(classId);
        sssClass.setStudents(studentDao.searchStudent(studentSearchContextVO));
        return sssClassOptional.orElse(null);
    }

    @Override
    public List<Student> searchStudent(StudentSearchContextVO studentSearchContextVO) {
        return studentDao.searchStudent(studentSearchContextVO);
    }

}
