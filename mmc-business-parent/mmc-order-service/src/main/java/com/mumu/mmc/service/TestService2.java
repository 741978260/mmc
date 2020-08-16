package com.mumu.mmc.service;

import com.mumu.mmc.web.TestController;

import java.util.concurrent.Future;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/7/21
 */
public interface TestService2 {
    Future<TestController.UserInfo> invokeBaidu();

    Future<TestController.UserInfo> invokeWeixin();
}
