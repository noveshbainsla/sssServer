package com.smartsystem.sss.common.clientauth.mo;

public class SSSTenantMO {
    private Long id;
    private String tenantName;
    private String registrationPrefix;
    private Long registrationCounter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getRegistrationPrefix() {
        return registrationPrefix;
    }

    public void setRegistrationPrefix(String registrationPrefix) {
        this.registrationPrefix = registrationPrefix;
    }

    public Long getRegistrationCounter() {
        return registrationCounter;
    }

    public void setRegistrationCounter(Long registrationCounter) {
        this.registrationCounter = registrationCounter;
    }
}
