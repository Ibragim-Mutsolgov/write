package com.example.write.controller;

import com.example.write.KafkaSend;
import com.example.write.model.Data;
import com.example.write.model.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/write/data")
public class WriteController {

    private KafkaSend kafkaSend;

    @PostMapping
    public Result saveData(@RequestBody Data string, HttpServletRequest request) {
        log.info("IP: " + request.getRemoteAddr());
        if(kafkaSend.send(string.getString())){
            return new Result("ok");
        }
        return new Result("error");
    }
}
