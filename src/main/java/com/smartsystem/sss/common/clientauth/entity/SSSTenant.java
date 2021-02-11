package com.smartsystem.sss.common.clientauth.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "SSS_TENANT")
@DynamicInsert
@DynamicUpdate
public class SSSTenant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tenant_id_sequence")
    @SequenceGenerator(name = "tenant_id_sequence", sequenceName="tenant_id_sequence", allocationSize = 1)
    @Column
    private Long id;

    @Column(name = "TENANT_NAME")
    private String tenantName;

    @Column(name = "REGISTRATION_PREFIX")
    private String registrationPrefix;

    @Column(name = "REG_COUNT")
    private Long registrationCounter;

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
}
