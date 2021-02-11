package com.smartsystem.sss.common.clientauth.repository;

import com.smartsystem.sss.common.clientauth.entity.SSSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class SSSUserDaoImpl implements SSSUserDao {
    @Autowired
    SSSUserRepository sssUserRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(SSSUser sssUser) {
        sssUserRepository.save(sssUser);
    }

    @Override
    public Optional<SSSUser> findById(SSSUser sssUser) {
        return sssUserRepository.findById(sssUser.getId());
    }

    @Override
    public List<SSSUser> findAll() {
        return (List<SSSUser>) sssUserRepository.findAll();
    }

    @Override
    public List findByUserName(SSSUser sssUser) {
        Query query = entityManager.createNamedQuery("SSSUser.findByUserName");
        query.setParameter("userName",sssUser.getUserName());
        return query.getResultList();
    }
}
