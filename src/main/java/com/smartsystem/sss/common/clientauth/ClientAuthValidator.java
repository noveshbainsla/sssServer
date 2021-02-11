package com.smartsystem.sss.common.clientauth;

import com.smartsystem.sss.common.GlobalConstants;
import com.smartsystem.sss.common.GlobalMethods;
import com.smartsystem.sss.common.ValidationMessage;
import com.smartsystem.sss.common.clientauth.entity.SSSTenant;
import com.smartsystem.sss.common.clientauth.entity.SSSUser;
import com.smartsystem.sss.common.clientauth.repository.SSSTenantDao;
import com.smartsystem.sss.common.clientauth.repository.SSSUserDao;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientAuthValidator {
    @Autowired
    SSSTenantDao sssTenantDao;

    @Autowired
    SSSUserDao sssUserDao;

    public List<ValidationMessage> validateTenantCreation(SSSTenant sssTenant) {
        List<ValidationMessage> validationMessages = new ArrayList<>();
        if(GlobalMethods.isNullEmptyString(sssTenant.getTenantName())){
            validationMessages.add(new ValidationMessage(ClientAuthConstants.TENANT_NAME_NULL));
        }
        return validationMessages;
    }

    public List<ValidationMessage> validateUserCreation(SSSUser sssUser) {
        List<ValidationMessage> validationMessages = new ArrayList<>();
        if(GlobalMethods.isNullEmptyString(sssUser.getUserName()))
            validationMessages.add(new ValidationMessage(ClientAuthConstants.USER_NAME_INVALID));
        if(GlobalMethods.isNullEmptyString(sssUser.getPassword()))
            validationMessages.add(new ValidationMessage(ClientAuthConstants.INVALID_PASSWORD));
        if(sssUser.getTenantId()==null)
            validationMessages.add(new ValidationMessage(ClientAuthConstants.Invalid_Tenant));

        validateTenantRelation(sssUser,validationMessages);
        validateDuplicateUser(sssUser, validationMessages);

        return validationMessages;
    }

    private void validateDuplicateUser(SSSUser sssUser, List<ValidationMessage> validationMessages) {
        if(!GlobalMethods.isNullEmptyString(sssUser.getUserName())){
            if(!sssUserDao.findByUserName(sssUser).isEmpty()){
                validationMessages.add(new ValidationMessage(ClientAuthConstants.USERNAME_EXISTS));
            }
        }
    }

    public void validateTenantRelation(SSSUser sssUser, List<ValidationMessage> validationMessages) {
        if(sssUser.getTenantId()!=null){
            SSSTenant sssTenant = new SSSTenant();
            sssTenant.setId(sssUser.getTenantId());
            if(!sssTenantDao.findById(sssTenant).isPresent()){
                validationMessages.add(new ValidationMessage(ClientAuthConstants.Invalid_Tenant));
            }
        } else {
            validationMessages.add(new ValidationMessage(ClientAuthConstants.Invalid_Tenant));
        }
    }

}
