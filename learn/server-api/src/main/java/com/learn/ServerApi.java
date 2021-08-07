package com.learn;

import com.learn.req.ServRequest;
import com.learn.rsp.ServResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/server")
public interface ServerApi {

    @PostMapping("/login")
    public ServResponse login(@RequestBody ServRequest request);

}
