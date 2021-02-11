package com.smartsystem.sss.common.clientauth.util;

import com.smartsystem.sss.common.clientauth.entity.SSSTenant;
import com.smartsystem.sss.common.clientauth.mo.SSSTenantMO;
import org.springframework.stereotype.Component;

@Component
public class SSSTenantTransformer {
    public SSSTenant toDomain(SSSTenantMO sssTenantMO){
        SSSTenant sssTenant = new SSSTenant();
        sssTenant.setId(sssTenantMO.getId());
        sssTenant.setTenantName(sssTenantMO.getTenantName());
        sssTenant.setRegistrationPrefix(sssTenantMO.getRegistrationPrefix());
        sssTenant.setRegistrationCounter(sssTenantMO.getRegistrationCounter());

        return sssTenant;
    }

    public SSSTenantMO toMo(SSSTenant sssTenant){
        SSSTenantMO sssTenantMO = new SSSTenantMO();
        sssTenantMO.setId(sssTenant.getId());
        sssTenantMO.setTenantName(sssTenant.getTenantName());
        sssTenantMO.setRegistrationPrefix(sssTenant.getRegistrationPrefix());
        sssTenantMO.setRegistrationCounter(sssTenant.getRegistrationCounter());

        return sssTenantMO;
    }
}
