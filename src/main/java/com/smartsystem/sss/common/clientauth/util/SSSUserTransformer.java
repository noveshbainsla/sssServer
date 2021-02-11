package com.smartsystem.sss.common.clientauth.util;

import com.smartsystem.sss.common.clientauth.entity.SSSUser;
import com.smartsystem.sss.common.clientauth.mo.SSSUserMO;
import org.springframework.stereotype.Component;

@Component
public class SSSUserTransformer {
    public SSSUser toDomain(SSSUserMO sssUserMO){
        SSSUser sssUser = new SSSUser();
        sssUser.setId(sssUserMO.getId());
        sssUser.setTenantId(sssUserMO.getTenantId());
        sssUser.setPassword(sssUserMO.getPassword());
        sssUser.setUserName(sssUserMO.getUserName());
        sssUser.setTenantName(sssUserMO.getTenantName());

        return  sssUser;
    }

    public SSSUserMO toMo(SSSUser sssUser){
        SSSUserMO sssUserMO = new SSSUserMO();
        sssUserMO.setId(sssUser.getId());
        sssUserMO.setTenantId(sssUser.getTenantId());
        sssUserMO.setUserName(sssUser.getUserName());
        sssUserMO.setPassword(sssUser.getPassword());
        sssUserMO.setTenantName(sssUser.getTenantName());

        return sssUserMO;
    }
}
