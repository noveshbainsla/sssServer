package com.smartsystem.sss.registrations.repository;

import com.smartsystem.sss.registrations.VO.ClassSearchContextVO;
import com.smartsystem.sss.registrations.entity.SSSClass;

import java.util.List;
import java.util.Optional;

public interface ClassDao {
    public void save(SSSClass sssClass);
    public List<SSSClass> findAllByClassName(SSSClass sssClass);
    public Optional<SSSClass> findById(SSSClass sssClass);
    public List<SSSClass> findAllByTenant(ClassSearchContextVO classSearchContextVO);

    public void delete(SSSClass sssClass);
}
