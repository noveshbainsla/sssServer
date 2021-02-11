package com.smartsystem.sss.registrations;

import com.smartsystem.sss.common.Response;
import com.smartsystem.sss.registrations.VO.ClassSearchContextVO;
import com.smartsystem.sss.registrations.VO.SSSClassVO;
import com.smartsystem.sss.registrations.VO.StudentSearchContextVO;
import com.smartsystem.sss.registrations.VO.StudentVO;
import com.smartsystem.sss.registrations.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/createClass", method = RequestMethod.POST )
    public Response createClass(@RequestBody SSSClassVO sssClassVO, @RequestHeader HttpHeaders headers){
        Response response = new Response();
        registrationService.createClass(sssClassVO,response);
        return response;
    }

    @RequestMapping(value = "/getClasses", method = RequestMethod.GET)
    public Response getClasses(@RequestHeader("header") HttpHeaders headers){
    	Response response = new Response();
    	Long tenantId = Long.valueOf(headers.get("tenantId").get(0));
    	registrationService.getClasses(new ClassSearchContextVO(tenantId),response);
        return response;
    }

    @RequestMapping(value = "/updateClass")
    public Response updateClass(@RequestBody SSSClassVO sssClassVO){
        Response response = new Response();
        registrationService.updateClass(sssClassVO,response);
        return response;
    }
    
    @RequestMapping(value = "/deleteClass/{id}")
    public Response deleteClass(@PathVariable("id") Long id){
        Response response = new Response();
        registrationService.deleteClass(id,response);
        return response;
    }

    @RequestMapping(value = "/getClass/{classId}", method = RequestMethod.GET)
    public Response getClass(@PathVariable("classId") Long classId){
        Response response = new Response();
        registrationService.findSSSClass(classId,response);
        return response;

    }

    @RequestMapping(value = "/registerstudent")
    public Response registerStudent(@RequestBody StudentVO studentVO,@RequestHeader HttpHeaders headers){
        Response response = new Response();
        studentVO.setTenantId(Long.valueOf(headers.get("tenantId").get(0)));
        registrationService.createStudent(studentVO,response);
        return response;
    }

    @RequestMapping(value = "/updatestudent")
    public Response updateStudent(@RequestBody StudentVO studentVO,@RequestHeader HttpHeaders headers){
        Response response = new Response();
        studentVO.setTenantId(Long.valueOf(headers.get("tenantId").get(0)));
        registrationService.updateStudent(studentVO,response);
        return response;
    }

    @RequestMapping(value = "/getstudentsbyclass/{classId}")
    public Response getStudentsByClass(@PathVariable Long classId,@RequestHeader HttpHeaders headers){
        Response response = new Response();
        StudentSearchContextVO studentSearchContextVO = new StudentSearchContextVO();
        studentSearchContextVO.setClassId(classId);
        registrationService.getStudents(studentSearchContextVO,response);
        return response;
    }

    @RequestMapping(value = "/studentSearch")
    public Response studentSearch(@RequestBody StudentSearchContextVO studentSearchContextVO,@RequestHeader HttpHeaders headers){
        Response response = new Response();
        studentSearchContextVO.setTenantId(Long.valueOf(headers.get("tenantId").get(0)));
        registrationService.searchStudent(studentSearchContextVO,response);
        return response;
    }


}
