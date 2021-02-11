package com.smartsystem.sss.common.clientauth;

import com.smartsystem.sss.common.Response;
import com.smartsystem.sss.common.clientauth.mo.SSSTenantMO;
import com.smartsystem.sss.common.clientauth.mo.SSSUserMO;
import com.smartsystem.sss.common.clientauth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public Response registerUser(@RequestBody SSSUserMO sssUserMO){
        Response response = new Response();
        authService.createUser(sssUserMO,response);

        return response;
    }

    @RequestMapping(value = "/registerTenant", method = RequestMethod.POST)
    public Response registerTenant(@RequestBody SSSTenantMO sssTenantMO){
        Response response = new Response();
        authService.createTenant(sssTenantMO,response);

        return response;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestBody SSSUserMO sssUserMO){
        Response response = new Response();
        authService.login(sssUserMO,response);

        return response;
    }
}
