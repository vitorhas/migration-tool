package com.vitorhas.migration.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncServices {
    @Async
    public Future<String> process() throws InterruptedException {
        Thread.sleep(3000);
        String processInfo = String.format("Processing is done");
        return new AsyncResult<>(processInfo);
    }
}

