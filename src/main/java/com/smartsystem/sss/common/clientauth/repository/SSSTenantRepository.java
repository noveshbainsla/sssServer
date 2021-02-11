package com.smartsystem.sss.common.clientauth.repository;

import com.smartsystem.sss.common.clientauth.entity.SSSTenant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSSTenantRepository extends CrudRepository<SSSTenant,Long> {
}
