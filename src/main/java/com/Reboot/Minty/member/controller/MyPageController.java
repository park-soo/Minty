package com.Reboot.Minty.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {
    @GetMapping(value = "mypage")
    public String mypage()  {
        return "member/myPage";
    }
}
