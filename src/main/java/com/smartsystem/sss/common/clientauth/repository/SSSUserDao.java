package com.smartsystem.sss.common.clientauth.repository;

import com.smartsystem.sss.common.clientauth.entity.SSSUser;

import java.util.List;
import java.util.Optional;

public interface SSSUserDao {
    public void save(SSSUser sssUser);
    public Optional<SSSUser> findById(SSSUser sssUser);
    public List<SSSUser> findAll();

    public List findByUserName(SSSUser sssUser);
}
