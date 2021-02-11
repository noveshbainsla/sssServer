package com.smartsystem.sss.registrations.VO;

import com.smartsystem.sss.common.BaseEntityVO;
import com.smartsystem.sss.common.Response;
import com.smartsystem.sss.registrations.util.StudentTransformer;

import java.util.Date;

public class StudentVO extends BaseEntityVO {
    private Long id;
    private Long classId;
    private String studentName;
    private String rollNumber;
    private String className;
    private String primaryGuardian;
    private String secondaryGuardian;
    private Long contactNo;
    private Long age;
    private String dateOfBirth;
    private Long regStatus;
    private String category;
    private String applicationNumber;

    private String admissionWithdrawlNumber;
    private String studentRegistrationNumber;
    private String primaryGuardianOccupation;
    private String secondaryGuardianOccupation;
    private String dateOfAdmission;
    private String gender;
    private boolean conveyance;
    private String routeNumber;
    private String previousSchoolName;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
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

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getConveyance() {
        return conveyance;
    }

    public void setConveyance(boolean conveyance) {
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
