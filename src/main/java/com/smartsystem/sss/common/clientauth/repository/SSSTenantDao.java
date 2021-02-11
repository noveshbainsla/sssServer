package com.smartsystem.sss.common.clientauth.repository;

import com.smartsystem.sss.common.clientauth.entity.SSSTenant;

import java.util.List;
import java.util.Optional;

public interface SSSTenantDao {
    public void save(SSSTenant sssTenant);
    public Optional<SSSTenant> findById(SSSTenant sssTenant);
    public List<SSSTenant> findAllTenant();
}
