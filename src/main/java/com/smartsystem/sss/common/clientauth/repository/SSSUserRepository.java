package com.smartsystem.sss.common.clientauth.repository;

import com.smartsystem.sss.common.clientauth.entity.SSSUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSSUserRepository extends CrudRepository<SSSUser,Long> {
}
