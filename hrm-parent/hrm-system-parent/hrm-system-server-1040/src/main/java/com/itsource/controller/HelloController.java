package com.itsource.controller;

import com.itsource.domain.Systemdictionaryitem;
import com.itsource.hrm.util.AjaxResult;
import com.itsource.service.ISystemdictionaryitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @Autowired
    ISystemdictionaryitemService systemdictionaryitemService;

    @GetMapping("/success")
    String hello(){
        return "SUCCESS";
    }

    @GetMapping("/querySingle")
    AjaxResult querySingle() {
        Systemdictionaryitem res = systemdictionaryitemService.selectById(4);
        return AjaxResult.me().setResultObj(res);
    }
}
