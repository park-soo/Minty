package com.Reboot.Minty;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(HttpServletRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("userEmail"));
        if (authentication != null) {
            System.out.println(authentication.getPrincipal());

        }
        return "home";
    }





    @RequestMapping("/map")
    public String getMap(){
        return "map/map";
    }
}
