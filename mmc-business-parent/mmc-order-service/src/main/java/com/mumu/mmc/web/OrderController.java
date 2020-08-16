package com.mumu.mmc.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/8/16
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @PostMapping("/getOrderCounts")
    public int getOrderCounts(@RequestParam("userId") String userId) {
        final Random random = new Random();
        int counts = random.nextInt() * 10;
        System.out.println("用户" + userId + "订单笔数：" + counts);
        return counts;
    }
}
