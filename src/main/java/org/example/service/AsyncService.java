package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncService {
    @Async
    public CompletableFuture<String> runMyJob() {
        log.info("Running on thread: {}", Thread.currentThread().getName());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String value = UUID.randomUUID().toString();
        return CompletableFuture.completedFuture(value);
    }
}
