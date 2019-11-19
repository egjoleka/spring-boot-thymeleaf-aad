package com.hellokoding.springboot.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.Map;

@Controller
public class HelloController {
    @GetMapping({"/", "/hello"})
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name,
                        HttpServletRequest httpServletRequest) {

        String ID_TOKEN = "X-MS-TOKEN-AAD-ID-TOKEN";
        model.addAttribute("id_token", httpServletRequest.getHeader(ID_TOKEN));
        String ACCESS_TOKEN = "X-MS-TOKEN-AAD-ACCESS-TOKEN";
        model.addAttribute("access_token", httpServletRequest.getHeader(ACCESS_TOKEN));
        String EXPIRATION = "X-MS-TOKEN-AAD-EXPIRES-ON";
        model.addAttribute("expiration", httpServletRequest.getHeader(EXPIRATION));
        String REFRESH_TOKEN = "X-MS-TOKEN-AAD-REFRESH-TOKEN";
        model.addAttribute("refresh_token", httpServletRequest.getHeader(REFRESH_TOKEN));
        model.addAttribute("path", httpServletRequest.getPathInfo());
        Principal userPrincipal = httpServletRequest.getUserPrincipal();
        if (userPrincipal != null) {
            model.addAttribute("principal name", userPrincipal.getName());
        }
        model.addAttribute("principal", userPrincipal);
        model.addAttribute("getAuthType", httpServletRequest.getAuthType());
        model.addAttribute("getContextPath", httpServletRequest.getContextPath());
        model.addAttribute("getCookies", httpServletRequest.getCookies());
        model.addAttribute("getRemoteUser", httpServletRequest.getRemoteUser());
        model.addAttribute("getRequestedSessionId", httpServletRequest.getRequestedSessionId());
        model.addAttribute("getSession", httpServletRequest.getSession().getAttributeNames());
        model.addAttribute("getTrailerFields", httpServletRequest.getTrailerFields());
        return "hello";
    }
}
