package com.smartsystem.sss.common.clientauth.businessobject;

import com.smartsystem.sss.common.BusinessException;
import com.smartsystem.sss.common.GlobalConstants;
import com.smartsystem.sss.common.GlobalMethods;
import com.smartsystem.sss.common.ValidationMessage;
import com.smartsystem.sss.common.clientauth.ClientAuthConstants;
import com.smartsystem.sss.common.clientauth.ClientAuthValidator;
import com.smartsystem.sss.common.clientauth.entity.SSSTenant;
import com.smartsystem.sss.common.clientauth.entity.SSSUser;
import com.smartsystem.sss.common.clientauth.repository.SSSTenantDao;
import com.smartsystem.sss.common.clientauth.repository.SSSUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientAuthBusinessObjectImpl implements ClientAuthBusinessObject {
    @Autowired
    private SSSUserDao sssUserDao;

    @Autowired
    private SSSTenantDao sssTenantDao;

    @Autowired
    private ClientAuthValidator clientAuthValidator;

    @Override
    public void createTenant(SSSTenant sssTenant) throws Exception{
        if(!clientAuthValidator.validateTenantCreation(sssTenant).isEmpty()){
            BusinessException be = new BusinessException(GlobalConstants.BUSINESS_EXCEPTION);
            be.setValidationMessages(clientAuthValidator.validateTenantCreation(sssTenant));
            throw be;
        }
        sssTenantDao.save(sssTenant);
    }

    @Override
    public void createUser(SSSUser sssUser) throws Exception{
        if(!clientAuthValidator.validateUserCreation(sssUser).isEmpty()){
            BusinessException be = new BusinessException(GlobalConstants.BUSINESS_EXCEPTION);
            be.setValidationMessages(clientAuthValidator.validateUserCreation(sssUser));
            throw be;
        }
        SSSTenant sssTenant = new SSSTenant();
        sssTenant.setId(sssUser.getTenantId());
        sssUser.setTenantName(sssTenantDao.findById(sssTenant).get().getTenantName());
        sssUserDao.save(sssUser);
    }

    @Override
    public SSSUser loginUser(SSSUser sssUser) throws Exception{
        BusinessException be = new BusinessException(GlobalConstants.BUSINESS_EXCEPTION);
        List<ValidationMessage> validationMessages = new ArrayList<>();
        if(GlobalMethods.isNullEmptyString(sssUser.getUserName()) || GlobalMethods.isNullEmptyString(sssUser.getPassword())){
            validationMessages.add(new ValidationMessage(ClientAuthConstants.INVALID_CREDENTIALS));
            be.setValidationMessages(validationMessages);
            throw be;
        }

        String password = sssUser.getPassword();

        List<SSSUser> sssUsers = sssUserDao.findByUserName(sssUser);
        if(sssUsers!=null && !sssUsers.isEmpty()) {
        	sssUser = sssUsers.get(0);
        }else {
        	validationMessages.add(new ValidationMessage(ClientAuthConstants.INVALID_CREDENTIALS));
            be.setValidationMessages(validationMessages);
            throw be;
        }

        if(!sssUser.getPassword().equals(password)){
            validationMessages.add(new ValidationMessage(ClientAuthConstants.INVALID_CREDENTIALS));
            be.setValidationMessages(validationMessages);
            throw be;
        }

        clientAuthValidator.validateTenantRelation(sssUser,validationMessages);
        if(!validationMessages.isEmpty()){
            be.setValidationMessages(validationMessages);
            throw be;
        }

        return sssUser;
    }
}
