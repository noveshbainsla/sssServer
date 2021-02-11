package com.smartsystem.sss.registrations.repository;

import com.smartsystem.sss.registrations.entity.SSSClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends CrudRepository<SSSClass,Long> {
}
