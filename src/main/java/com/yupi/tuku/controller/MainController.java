package com.yupi.tuku.controller;

import com.yupi.tuku.common.BaseResponse;
import com.yupi.tuku.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    /**
     * 健康检查
     * @return
     */
    @GetMapping("/health")
    public BaseResponse<String> health(){
        return ResultUtils.success("OK");
    }
}
