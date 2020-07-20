package com.mumu.mmc.service.impl;

import com.mumu.mmc.service.TestService;
import com.mumu.mmc.web.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/7/20
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private RestTemplate restTemplate;

    @Async
    @Override
    public CompletableFuture<TestController.UserInfo> invokeBaidu() {
        System.out.println("调用百度接口线程：" + Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        CompletableFuture<TestController.UserInfo> future = new CompletableFuture<TestController.UserInfo>() {
            @Override
            public TestController.UserInfo get() throws InterruptedException, ExecutionException {
                System.out.println("调用百度接口线程：" + Thread.currentThread().getName());
                // 调用百度
                TestController.UserInfo result = restTemplate.getForObject("http://localhost:36000/test/baidu", TestController.UserInfo.class, new HashMap<>(16));
                return result;
            }
        };
        System.out.println("调用百度耗时：" + (System.currentTimeMillis() - start) / 1000);
        return future;
    }

    @Async
    @Override
    public CompletableFuture<TestController.UserInfo> invokeWeixin() {
        System.out.println("调用微信接口线程：" + Thread.currentThread().getName());
        long start2 = System.currentTimeMillis();
        CompletableFuture<TestController.UserInfo> future = new CompletableFuture<TestController.UserInfo>() {
            @Override
            public TestController.UserInfo get() throws InterruptedException, ExecutionException {
                System.out.println("调用微信接口线程：" + Thread.currentThread().getName());
                // 调用微信
                TestController.UserInfo result2 = restTemplate.getForObject("http://localhost:9587/test/weixin", TestController.UserInfo.class, new HashMap<>(16));
                return result2;
            }
        };
        System.out.println("调用微信耗时：" + (System.currentTimeMillis() - start2) / 1000);
        return future;
    }
}
