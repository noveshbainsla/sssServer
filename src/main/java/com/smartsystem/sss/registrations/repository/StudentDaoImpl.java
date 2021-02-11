package com.smartsystem.sss.registrations.repository;

import com.smartsystem.sss.common.GlobalMethods;
import com.smartsystem.sss.registrations.VO.StudentSearchContextVO;
import com.smartsystem.sss.registrations.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    StudentRepository studentRepository;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Student save(Student student) {
        if(student.getDateOfAdmission()==null){
            student.setDateOfAdmission(java.util.Calendar.getInstance().getTime());
        }
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> searchStudent(StudentSearchContextVO studentSearchContextVO) {

        StringBuilder query = new StringBuilder("from Student student where 1=1 ");
        Map<String,Object> parameterMap = new HashMap<>();

        if(studentSearchContextVO.getTenantId()!=null){
            query.append("and student.tenantId = :tenantId ");
            parameterMap.put("tenantId",studentSearchContextVO.getTenantId());
        }

        if (studentSearchContextVO.getClassId() != null) {
            query.append("and student.classId = :classId ");
            parameterMap.put("classId",studentSearchContextVO.getClassId());
        }

        if (!GlobalMethods.isNullEmptyString(studentSearchContextVO.getApplicationNumber())) {
            query.append("and student.applicationNumber = :applicationNumber ");
            parameterMap.put("applicationNumber",studentSearchContextVO.getApplicationNumber().toUpperCase());
        }

        if(!GlobalMethods.isNullEmptyString(studentSearchContextVO.getRollNumber())) {
            query.append("and student.rollNumber = :rollNumber ");
            parameterMap.put("rollNumber",studentSearchContextVO.getRollNumber().toUpperCase());
        }

        if(!GlobalMethods.isNullEmptyString(studentSearchContextVO.getStudentName())) {
            query.append("and student.studentName like :studentName ");
            parameterMap.put("studentName","%" + studentSearchContextVO.getStudentName().toUpperCase() + "%");
        }

        if (!GlobalMethods.isNullEmptyString(studentSearchContextVO.getPrimaryGuardian())) {
            query.append("and student.primaryGuardian like :primaryGuardian ");
            parameterMap.put("primaryGuardian","%"+studentSearchContextVO.getPrimaryGuardian().toUpperCase()+"%");
        }

        if (!GlobalMethods.isNullEmptyString(studentSearchContextVO.getAdmissionWithdrawalNumber())) {
            query.append("and student.admissionWithdrawlNumber = :admissionWithdrawlNumber ");
            parameterMap.put("admissionWithdrawlNumber",studentSearchContextVO.getAdmissionWithdrawalNumber());
        }

        query.append("order by id");
        String stringQuery = query.toString();
        Query dynamicQuery = entityManager.createQuery(stringQuery);
        for(Map.Entry<String,Object> entry : parameterMap.entrySet()){
            dynamicQuery.setParameter(entry.getKey(),entry.getValue());
        }

        return dynamicQuery.getResultList();
    }

}
