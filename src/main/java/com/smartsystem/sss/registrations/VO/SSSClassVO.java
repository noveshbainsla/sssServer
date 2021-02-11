package com.smartsystem.sss.registrations.VO;

import com.smartsystem.sss.common.BaseEntityVO;
import com.smartsystem.sss.common.Response;

import java.io.Serializable;

public class SSSClassVO extends BaseEntityVO {
    private Long id;
    private String className;
    private Long classYear;
    private String incharge;
    private Long strength;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getClassYear() {
        return classYear;
    }

    public void setClassYear(Long classYear) {
        this.classYear = classYear;
    }

    public String getIncharge() {
        return incharge;
    }

    public void setIncharge(String incharge) {
        this.incharge = incharge;
    }

    public Long getStrength() {
        return strength;
    }

    public void setStrength(Long strength) {
        this.strength = strength;
    }
}
