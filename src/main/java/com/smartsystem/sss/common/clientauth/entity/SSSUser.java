package com.smartsystem.sss.common.clientauth.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "SSS_USER")
@DynamicInsert
@DynamicUpdate
@NamedQueries({
     @NamedQuery(name = "SSSUser.findByUserName",query = "select sssUser from SSSUser sssUser where sssUser.userName = :userName")
})
public class SSSUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName="id_sequence", allocationSize = 1)
    @Column
    private Long id;

    @Column(name = "TENANT_ID")
    private Long tenantId;

    @Column(name = "TENANT_NAME")
    private String tenantName;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PASS_WORD")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantName() {
		return tenantName;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
