package com.smartsystem.sss.registrations.entity;

import com.smartsystem.sss.common.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="SSS_STUDENT")
@DynamicUpdate
@DynamicInsert
@NamedQueries({
        @NamedQuery(name = "findStudentByApplicationNumber",
                query = "select student from Student student where student.applicationNumber = :applicationNumber and student.tenantId = :tenantId"),
})
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName="id_sequence", allocationSize = 1)
    @Column
    private Long id;

    @Column(name = "ROLL_NUMBER",unique = true)
    private String rollNumber;

    @Column(name = "CLASS_ID")
    private Long classId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "PRIMARY_GUARDIAN")
    private String primaryGuardian;

    @Column(name = "SECONDARY_GUARDIAN")
    private String secondaryGuardian;

    @Column(name = "CONTACT_NO")
    private Long contactNo;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "REG_STATUS")
    private Long regStatus;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "APPLICATION_NUMBER")
    private String applicationNumber;

    @Column(name = "ADMISSION_WITHDRAWAL_NUMBER")
    private String admissionWithdrawlNumber;

    @Column(name = "STUDENT_REGISTRATION_NUMBER")
    private String studentRegistrationNumber;

    @Column(name = "PRIMARY_GUARDIAN_OCCUPATION")
    private String primaryGuardianOccupation;

    @Column(name = "SECONDARY_GUARDIAN_OCCUPATION")
    private String secondaryGuardianOccupation;

    @Column(name = "DATE_OF_ADMISSION")
    private Date dateOfAdmission;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "CONVEYANCE")
    private Long conveyance;

    @Column(name = "ROUTE_NUMBER")
    private String routeNumber;

    @Column(name = "PREVIOUS_SCHOOL_NAME")
    private String previousSchoolName;

    @Column(name = "ADDRESS")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName==null ? null : studentName.toUpperCase();
    }

    public String getPrimaryGuardian() {
        return primaryGuardian;
    }

    public void setPrimaryGuardian(String primaryGuardian) {
        this.primaryGuardian = primaryGuardian;
    }

    public String getSecondaryGuardian() {
        return secondaryGuardian;
    }

    public void setSecondaryGuardian(String secondaryGuardian) {
        this.secondaryGuardian = secondaryGuardian;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Long getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(Long regStatus) {
        this.regStatus = regStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getAdmissionWithdrawlNumber() {
        return admissionWithdrawlNumber;
    }

    public void setAdmissionWithdrawlNumber(String admissionWithdrawlNumber) {
        this.admissionWithdrawlNumber = admissionWithdrawlNumber;
    }

    public String getStudentRegistrationNumber() {
        return studentRegistrationNumber;
    }

    public void setStudentRegistrationNumber(String studentRegistrationNumber) {
        this.studentRegistrationNumber = studentRegistrationNumber;
    }

    public String getPrimaryGuardianOccupation() {
        return primaryGuardianOccupation;
    }

    public void setPrimaryGuardianOccupation(String primaryGuardianOccupation) {
        this.primaryGuardianOccupation = primaryGuardianOccupation;
    }

    public String getSecondaryGuardianOccupation() {
        return secondaryGuardianOccupation;
    }

    public void setSecondaryGuardianOccupation(String secondaryGuardianOccupation) {
        this.secondaryGuardianOccupation = secondaryGuardianOccupation;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getConveyance() {
        return conveyance;
    }

    public void setConveyance(Long conveyance) {
        this.conveyance = conveyance;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getPreviousSchoolName() {
        return previousSchoolName;
    }

    public void setPreviousSchoolName(String previousSchoolName) {
        this.previousSchoolName = previousSchoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
