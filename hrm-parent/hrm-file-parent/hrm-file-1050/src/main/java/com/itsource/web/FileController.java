package com.itsource.web;

import com.itsource.hrm.util.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ooss")
@RestController
public class FileController {
    @PostMapping("/upload")
    AjaxResult fiileUpload() {
        return null;
    }
}
