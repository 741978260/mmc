package com.mumu.mmc.web;

import com.mumu.mmc.service.TestService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/7/20
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test/getUserInfo")
    public UserInfo getUserInfo() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        UserInfo user = new UserInfo();
        // 调用百度
        CompletableFuture<UserInfo> future = testService.invokeBaidu();
        user.setBaiduId(future.get().getBaiduId());
        // 调用微信
        CompletableFuture<UserInfo> future2 = testService.invokeWeixin();
        user.setOpenId(future2.get().getOpenId());
        // 总耗时
        System.out.println("总耗时：" + (System.currentTimeMillis() - start) / 1000);
        return user;
    }


    public static class UserInfo {
        private String openId;
        private String baiduId;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getBaiduId() {
            return baiduId;
        }

        public void setBaiduId(String baiduId) {
            this.baiduId = baiduId;
        }
    }
}
