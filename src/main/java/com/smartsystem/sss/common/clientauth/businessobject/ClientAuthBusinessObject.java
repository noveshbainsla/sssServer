package com.smartsystem.sss.common.clientauth.businessobject;

import com.smartsystem.sss.common.clientauth.entity.SSSTenant;
import com.smartsystem.sss.common.clientauth.entity.SSSUser;

public interface ClientAuthBusinessObject {
    public void createTenant(SSSTenant sssTenant) throws Exception;
    public void createUser(SSSUser sssUser) throws Exception;
    public SSSUser loginUser(SSSUser sssUser) throws Exception;
}
