package com.smartsystem.sss.registrations.util;

import com.smartsystem.sss.registrations.VO.SSSClassVO;
import com.smartsystem.sss.registrations.entity.SSSClass;
import org.springframework.stereotype.Component;

@Component
public class SSSClassTransformer {
    //from a to b
    public SSSClass toDomain(SSSClassVO sssClassVO){
        if(sssClassVO==null){
            return null;
        }
        SSSClass sssClass = new SSSClass();
        sssClass.setId(sssClassVO.getId());
        sssClass.setClassName(sssClassVO.getClassName());
        sssClass.setClassYear(sssClassVO.getClassYear());
        sssClass.setIncharge(sssClassVO.getIncharge());
        sssClass.setTenantId(sssClassVO.getTenantId());
        sssClass.setStrength(sssClassVO.getStrength());

        return sssClass;
    }

    public SSSClassVO toVo(SSSClass sssClass){
        if(sssClass==null){
            return null;
        }
        SSSClassVO sssClassVO = new SSSClassVO();
        sssClassVO.setClassName(sssClass.getClassName());
        sssClassVO.setClassYear(sssClass.getClassYear());
        sssClassVO.setId(sssClass.getId());
        sssClassVO.setIncharge(sssClass.getIncharge());
        sssClassVO.setTenantId(sssClass.getTenantId());
        sssClassVO.setStrength(sssClass.getStrength());

        return sssClassVO;
    }
}
