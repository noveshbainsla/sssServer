package com.smartsystem.sss.registrations.repository;

import com.smartsystem.sss.registrations.VO.ClassSearchContextVO;
import com.smartsystem.sss.registrations.entity.SSSClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class ClassDaoImpl implements ClassDao {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ClassRepository classRepository;

    @Override
    public void save(SSSClass sssClass) {
        classRepository.save(sssClass);
    }

    @Override
    public List<SSSClass> findAllByClassName(SSSClass sssClass) {
        Query query = em.createNamedQuery("SSSClass.findClassByName");
        query.setParameter("className",sssClass.getClassName().toUpperCase());
        query.setParameter("tenantId",sssClass.getTenantId());
        return query.getResultList();
    }

    @Override
    public Optional<SSSClass> findById(SSSClass sssClass) {
        return classRepository.findById(sssClass.getId());
    }

    @Override
    public List<SSSClass> findAllByTenant(ClassSearchContextVO classSearchContextVO) {
        Query query = em.createNamedQuery("SSSClass.findAllClasses");
        query.setParameter("tenantId",classSearchContextVO.getTenantId());
        return query.getResultList();
    }

    @Override
    public void delete(SSSClass sssClass) {
    	classRepository.deleteById(sssClass.getId());
    }
}
