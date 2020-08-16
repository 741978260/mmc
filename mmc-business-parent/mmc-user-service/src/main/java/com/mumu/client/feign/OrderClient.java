package com.mumu.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author Created by Mumu
 * @Date on 2020/8/16
 */
@FeignClient("mmc-order-service")
public interface OrderClient {
    @PostMapping("/order/getOrderCounts")
    int getOrderCounts(@RequestParam("userId") String userId);
}
