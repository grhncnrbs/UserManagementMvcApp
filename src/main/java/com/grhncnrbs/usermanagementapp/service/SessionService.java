package com.grhncnrbs.usermanagementapp.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class SessionService {

    public void removeMessageFromSession() {
        try {
            HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
            session.removeAttribute("msg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
