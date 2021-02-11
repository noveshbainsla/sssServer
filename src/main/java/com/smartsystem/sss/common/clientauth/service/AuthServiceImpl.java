package com.smartsystem.sss.common.clientauth.service;

import com.smartsystem.sss.common.BusinessException;
import com.smartsystem.sss.common.Response;
import com.smartsystem.sss.common.clientauth.businessobject.ClientAuthBusinessObject;
import com.smartsystem.sss.common.clientauth.entity.SSSUser;
import com.smartsystem.sss.common.clientauth.mo.SSSTenantMO;
import com.smartsystem.sss.common.clientauth.mo.SSSUserMO;
import com.smartsystem.sss.common.clientauth.util.SSSTenantTransformer;
import com.smartsystem.sss.common.clientauth.util.SSSUserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private ClientAuthBusinessObject clientAuthBusinessObject;

    @Autowired
    private SSSTenantTransformer sssTenantTransformer;

    @Autowired
    private SSSUserTransformer sssUserTransformer;

    @Override
    public void createTenant(SSSTenantMO sssTenantMO, Response response) {
        try{
            clientAuthBusinessObject.createTenant(sssTenantTransformer.toDomain(sssTenantMO));
            response.setSuccess(true);
        } catch (BusinessException be) {
            response.setSuccess(false);
            response.setValidationMessages(be.getValidationMessages());
            response.setMessage(be.getMessage());
            be.printStackTrace();
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void createUser(SSSUserMO sssUserMO, Response response) {
        try{
            clientAuthBusinessObject.createUser(sssUserTransformer.toDomain(sssUserMO));
            response.setSuccess(true);
        } catch (BusinessException be) {
            response.setSuccess(false);
            response.setValidationMessages(be.getValidationMessages());
            response.setMessage(be.getMessage());
            be.printStackTrace();
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void login(SSSUserMO sssUserMO, Response response) {
        try{
            SSSUser sssUser = clientAuthBusinessObject.loginUser(sssUserTransformer.toDomain(sssUserMO));
            response.setSuccess(true);
            response.setResponseObjects(Collections.singletonList(sssUserTransformer.toMo(sssUser)));
        } catch (BusinessException be) {
            response.setSuccess(false);
            response.setValidationMessages(be.getValidationMessages());
            response.setMessage(be.getMessage());
            be.printStackTrace();
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            e.printStackTrace();
        }
    }
}
