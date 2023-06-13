package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsynConfig {
    @Bean
    public Executor mcmDocumentUploadExecutor(@Value("${async.poolSize:5}") Integer poolSize) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // Running parallel from the 2nd task, maximum ${poolSize} at the same time
        executor.setCorePoolSize(5);
//        executor.setQueueCapacity(0);
//        executor.setMaxPoolSize(2);
        executor.setThreadNamePrefix("Khang");
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
