package com.mumu.web;

import com.mumu.client.feign.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/8/16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private OrderClient orderClient;

    @PostMapping("/getOrderCounts")
    public void getOrderCounts(@RequestParam("userId") String userId) {
        final int orderCounts = orderClient.getOrderCounts(userId);
        System.out.println("订单笔数：" + orderCounts);
    }
}
