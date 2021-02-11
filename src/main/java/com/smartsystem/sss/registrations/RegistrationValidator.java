package com.smartsystem.sss.registrations;

import com.smartsystem.sss.common.BusinessException;
import com.smartsystem.sss.common.GlobalConstants;
import com.smartsystem.sss.common.GlobalMethods;
import com.smartsystem.sss.common.ValidationMessage;
import com.smartsystem.sss.registrations.VO.ClassSearchContextVO;
import com.smartsystem.sss.registrations.VO.StudentSearchContextVO;
import com.smartsystem.sss.registrations.constants.RegistrationConstants;
import com.smartsystem.sss.registrations.entity.SSSClass;
import com.smartsystem.sss.registrations.entity.Student;
import com.smartsystem.sss.registrations.repository.ClassDao;
import com.smartsystem.sss.registrations.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RegistrationValidator {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ClassDao classDao;

    @Autowired
    StudentDao studentDao;

    public List<ValidationMessage> validateClassCreation(SSSClass sssClass) throws Exception {
        List<ValidationMessage> validationMessages = new ArrayList<>();
        if(sssClass.getId()!=null){
            if(classDao.findById(sssClass).isPresent())
                validationMessages.add(new ValidationMessage(RegistrationConstants.CLASS_ALREADY_EXISTS));
        }
        //duplicacy check
        if(sssClass.getClassName()!=null){
            if(!classDao.findAllByClassName(sssClass).isEmpty()){
                validationMessages.add(new ValidationMessage(RegistrationConstants.CLASS_ALREADY_EXISTS));
            }
        } else {
            validationMessages.add(new ValidationMessage(RegistrationConstants.CLASS_NAME_NULL));
        }
        
        validateNotNullableFields(sssClass,validationMessages);

        return validationMessages;
    }

    private void validateNotNullableFields(SSSClass sssClass, List<ValidationMessage> validationMessages) {
		if(sssClass.getTenantId()==null)
		    validationMessages.add(new ValidationMessage(RegistrationConstants.TENANT_ID_NULL));
		if(sssClass.getClassYear()==null)
		    validationMessages.add(new ValidationMessage(RegistrationConstants.CLASS_YEAR_NULL));
		if(sssClass.getIncharge()==null)
		    validationMessages.add(new ValidationMessage(RegistrationConstants.INCHARGE_NULL));
	}

	public List<ValidationMessage> validateClassUpdation(SSSClass sssClass) throws BusinessException {
        List<ValidationMessage> validationMessages = new ArrayList<>();
        //whether sssClass id is valid
        if(sssClass.getId()!=null){
            if(!classDao.findById(sssClass).isPresent()){
                validationMessages.add(new ValidationMessage(RegistrationConstants.CLASS_DOES_NOT_EXIST));
            }
        } else {
            validationMessages.add(new ValidationMessage(RegistrationConstants.CLASS_DOES_NOT_EXIST));
        }

        //whether className is unique
        if(sssClass.getClassName()!=null){
            List<SSSClass> sssClasses = classDao.findAllByClassName(sssClass);
            if(!sssClasses.isEmpty() && !sssClasses.get(0).getId().equals(sssClass.getId())){
                validationMessages.add(new ValidationMessage(RegistrationConstants.CLASS_ALREADY_EXISTS));
            }
        } else {
            validationMessages.add(new ValidationMessage(RegistrationConstants.CLASS_NAME_NULL));
        }
        
        validateNotNullableFields(sssClass, validationMessages);

        return validationMessages;
    }

    public List<ValidationMessage> validateDeleteClass(SSSClass sssClass) throws Exception {
        List<ValidationMessage> validationMessages = new ArrayList<>();
        if(sssClass.getId()!=null){
            if(classDao.findById(sssClass).isPresent()){
               sssClass = classDao.findById(sssClass).get();
            }else {
                validationMessages.add(new ValidationMessage(RegistrationConstants.CLASS_DOES_NOT_EXIST));
			}
        } else {
            validationMessages.add(new ValidationMessage(RegistrationConstants.ID_NULL));
        }

        return validationMessages;
    }

    public List<ValidationMessage> validateStudentCreationUpdation(Student student) {
        List<ValidationMessage> validationMessages = new ArrayList<>();

        if(student.getTenantId()==null){
            validationMessages.add(new ValidationMessage(GlobalConstants.TENANT_INVALID));
        }
        if(student.getId()!=null && !isValidAppNo(student)){
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_APPLICATION_NUMBER));
        }
        if(!isValidClass(student)){
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_CLASS));
        }
        if(GlobalMethods.isNullEmptyString(student.getStudentName())){
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_STUDENT_NAME));
        }
        if(GlobalMethods.isNullEmptyString(student.getCategory())){
            validationMessages.add(new ValidationMessage(RegistrationConstants.CATEGORY_INVALID));
        }
        if(GlobalMethods.isNullEmptyString(student.getPrimaryGuardian())){
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_PRIMARY_GUARDIAN));
        }
        if(student.getContactNo()==null) {
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_CONTACT_NO));
        }
        if(student.getDateOfBirth()==null){
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_DOB));
        }
        if(student.getRegStatus()==null){
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_REG_STATUS));
        }
        if(student.getId()!=null){
            Optional<Student> studentOptional = studentDao.findById(student.getId());
            if (!studentOptional.isPresent()) {
                validationMessages.add(new ValidationMessage(RegistrationConstants.STUDENT_NOT_REGISTERED));
            }else if(!studentOptional.get().getTenantId().equals(student.getTenantId())){
                validationMessages.add(new ValidationMessage(RegistrationConstants.STUDENT_NOT_REGISTERED));
            }
        }
        if(!validAdmissionWithdrawalNumber(student)){
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_ADMISSION_WITHDRAWAL_NUMBER));
        }
        if(GlobalMethods.isNullEmptyString(student.getPrimaryGuardianOccupation())){
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_PRIMARY_GUARDIAN_OCCUPATION));
        }
        if(GlobalMethods.isNullEmptyString(student.getGender())){
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_GENDER));
        }
        if(student.getConveyance()==1 && GlobalMethods.isNullEmptyString(student.getRouteNumber())){
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_ROUTE_NUMBER));
        }
        if(GlobalMethods.isNullEmptyString(student.getAddress())){
            validationMessages.add(new ValidationMessage(RegistrationConstants.INVALID_ADDRESS));
        }

        return validationMessages;
    }

    private boolean validAdmissionWithdrawalNumber(Student student) {
        if(GlobalMethods.isNullEmptyString(student.getAdmissionWithdrawlNumber())){
            return false;
        }

        StudentSearchContextVO studentSearchContextVO = new StudentSearchContextVO();
        studentSearchContextVO.setTenantId(student.getTenantId());
        studentSearchContextVO.setAdmissionWithdrawalNumber(student.getAdmissionWithdrawlNumber());
        List<Student> studentsWithAWN = studentDao.searchStudent(studentSearchContextVO);
        if(studentsWithAWN.isEmpty()){
            return true;
        }else{
            return studentsWithAWN.get(0).getId() == student.getId();
        }
    }

    private boolean isValidAppNo(Student student) {
        boolean isValid;
        if(student.getApplicationNumber()==null){
            isValid = false;
            return false;
        }
        Query query = entityManager.createNamedQuery("findStudentByApplicationNumber");
        query.setParameter("tenantId",student.getTenantId());
        query.setParameter("applicationNumber",student.getApplicationNumber());

        if(student.getId()==null){
            //create mode
            isValid = query.getResultList().isEmpty();
        }else{
            //update mode
            List<Student> students = query.getResultList();
            if(!students.isEmpty()){
                isValid = students.get(0).getId().equals(student.getId());
            }else {
                isValid = true;
            }
        }

        return isValid;
    }

    private boolean isValidClass(Student student) {
        if(student.getClassId()==null){
            return false;
        }
        SSSClass sssClass = new SSSClass();
        sssClass.setId(student.getClassId());

        List<SSSClass> allTenantClasses = classDao.findAllByTenant(new ClassSearchContextVO(student.getTenantId()));
        Optional<SSSClass> sssClassOptional = classDao.findById(sssClass);
        if(sssClassOptional.isPresent() && allTenantClasses.contains(sssClassOptional.get())){
            return true;
        }else {
            return false;
        }
    }
}
