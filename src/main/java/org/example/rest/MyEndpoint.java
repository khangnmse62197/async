package org.example.rest;

import lombok.extern.slf4j.Slf4j;
import org.example.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class MyEndpoint {

    @Autowired
    private MyService myService;

    @GetMapping("/test/async")
    public ResponseEntity<String> testasync() {
        log.info(myService.doSomeLongJob());
        return ResponseEntity.ok("HelloWorld");
    }
}
