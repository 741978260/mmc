package com.mumu.mmc.web;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @PostMapping("/getOrderCounts")
    public int getOrderCounts(@RequestParam("userId") String userId) {
        final Random random = new Random();
        int counts = random.nextInt() * 10;
        log.info("用户{}订单笔数：{}", userId, counts);
        return counts;
    }
}
