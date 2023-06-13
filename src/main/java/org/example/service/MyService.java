package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MyService {
    @Autowired
    private AsyncService asyncService;

    public String doSomeLongJob() {
        List<CompletableFuture<String>> workers = new ArrayList<>();
        workers.add(asyncService.runMyJob());
        workers.add(asyncService.runMyJob());
        workers.add(asyncService.runMyJob());
        workers.add(asyncService.runMyJob());
        workers.add(asyncService.runMyJob());
        workers.add(asyncService.runMyJob());
        workers.add(asyncService.runMyJob());
        workers.add(asyncService.runMyJob());
        workers.add(asyncService.runMyJob());
        return workers.stream().map(CompletableFuture::join).collect(Collectors.joining(", "));
    }
}
