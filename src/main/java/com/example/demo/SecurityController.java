package com.example.demo;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class SecurityController {


    public SecurityController() {
        super();
    }
    //autherious before get into the url
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(final Principal principal) {
       String username= principal.getName();
//       System.out.println("username:"+username);
       return  username;
    }
}