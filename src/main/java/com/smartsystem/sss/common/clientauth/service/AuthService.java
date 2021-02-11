package com.smartsystem.sss.common.clientauth.service;

import com.smartsystem.sss.common.Response;
import com.smartsystem.sss.common.clientauth.mo.SSSTenantMO;
import com.smartsystem.sss.common.clientauth.mo.SSSUserMO;

public interface AuthService {
    public void createTenant(SSSTenantMO sssTenantMO, Response response);
    public void createUser(SSSUserMO sssUserMO, Response response);

    public void login(SSSUserMO sssUserMO, Response response);
}
