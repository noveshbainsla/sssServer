package com.smartsystem.sss.common.clientauth.repository;

import com.smartsystem.sss.common.clientauth.entity.SSSTenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class SSSTenantDaoImpl implements SSSTenantDao {
    @Autowired
    SSSTenantRepository sssTenantRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(SSSTenant sssTenant) {
        sssTenantRepository.save(sssTenant);
    }

    @Override
    public Optional<SSSTenant> findById(SSSTenant sssTenant) {
       return sssTenantRepository.findById(sssTenant.getId());
    }

    @Override
    public List<SSSTenant> findAllTenant() {
       return (List<SSSTenant>) sssTenantRepository.findAll();
    }
}
