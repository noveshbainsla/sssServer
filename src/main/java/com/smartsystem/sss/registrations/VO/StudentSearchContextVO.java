package com.smartsystem.sss.registrations.VO;

public class StudentSearchContextVO {
    private Long tenantId;
    private String applicationNumber;
    private String rollNumber;
    private Long classId;
    private String studentName;
    private String primaryGuardian;
    private String admissionWithdrawalNumber;

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPrimaryGuardian() {
        return primaryGuardian;
    }

    public void setPrimaryGuardian(String primaryGuardian) {
        this.primaryGuardian = primaryGuardian;
    }

    public String getAdmissionWithdrawalNumber() {
        return admissionWithdrawalNumber;
    }

    public void setAdmissionWithdrawalNumber(String admissionWithdrawalNumber) {
        this.admissionWithdrawalNumber = admissionWithdrawalNumber;
    }
}
