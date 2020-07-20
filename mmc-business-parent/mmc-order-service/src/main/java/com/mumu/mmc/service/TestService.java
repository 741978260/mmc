package com.mumu.mmc.service;

import com.mumu.mmc.web.TestController;

import java.util.concurrent.CompletableFuture;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/7/20
 */
public interface TestService {
    CompletableFuture<TestController.UserInfo> invokeBaidu();
    CompletableFuture<TestController.UserInfo> invokeWeixin();
}
