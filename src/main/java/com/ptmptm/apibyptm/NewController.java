package com.ptmptm.apibyptm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewController {

    @ResponseBody
    @GetMapping("/details")
    public String details() {
        return "details";
    }
}
