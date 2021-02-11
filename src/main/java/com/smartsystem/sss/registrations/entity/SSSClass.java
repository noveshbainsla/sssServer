package com.smartsystem.sss.registrations.entity;

import com.smartsystem.sss.common.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SSS_CLASS")
@DynamicInsert
@DynamicUpdate
@NamedQueries({
        @NamedQuery(name = "SSSClass.findClassByName",query = "select sssClass from SSSClass sssClass where sssClass.className = :className and sssClass.tenantId = :tenantId"),
        @NamedQuery(name = "SSSClass.findAllClasses",query = "select sssClass from SSSClass sssClass where sssClass.tenantId = :tenantId")
})
public class SSSClass extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName="id_sequence", allocationSize = 1)
    @Column
    private Long id;

    @Column(name = "CLASS_NAME")
    private String className;

    @Column(name = "CLASS_YEAR")
    private Long classYear;

    @Column(name = "INCHARGE")
    private String incharge;

    @Column(name = "STRENGTH")
    private Long strength;

    @Transient
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

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
    	this.className = className==null ? null : className.toUpperCase();
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
