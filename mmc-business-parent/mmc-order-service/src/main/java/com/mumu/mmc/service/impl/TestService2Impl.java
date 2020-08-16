package com.mumu.mmc.service.impl;

import com.mumu.mmc.service.TestService2;
import com.mumu.mmc.web.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.concurrent.Future;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/7/21
 */
@Service
public class TestService2Impl implements TestService2 {
    @Autowired
    private RestTemplate restTemplate;

    @Async
    @Override
    public Future<TestController.UserInfo> invokeBaidu() {
        System.out.println("调用百度接口线程：" + Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        // 调用百度
        TestController.UserInfo result = restTemplate.getForObject("http://localhost:36000/test/baidu", TestController.UserInfo.class, new HashMap<>(16));
        System.out.println("调用百度耗时：" + (System.currentTimeMillis() - start) / 1000);
        return new AsyncResult<>(result);
    }

    @Async
    @Override
    public Future<TestController.UserInfo> invokeWeixin() {
        System.out.println("调用微信接口线程：" + Thread.currentThread().getName());
        long start2 = System.currentTimeMillis();
        // 调用微信
        TestController.UserInfo result2 = restTemplate.getForObject("http://localhost:9587/test/weixin", TestController.UserInfo.class, new HashMap<>(16));
        System.out.println("调用微信耗时：" + (System.currentTimeMillis() - start2) / 1000);
        return new AsyncResult<>(result2);
    }
}
