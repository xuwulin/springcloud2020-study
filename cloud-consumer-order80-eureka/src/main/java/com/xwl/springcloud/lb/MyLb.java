package com.xwl.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xwl
 * @date 2020-03-13 22:38
 * @description 手写轮询算法
 */
@Component
public class MyLb implements LoadBalance {
    // 原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get(); // 首先得到当前值，第一次为0
            next = current >= 2147483647 ? 0 : current + 1; // 如果current值大于int的最大数2147483647，就置为0
        } while (!this.atomicInteger.compareAndSet(current, next)); // 自旋锁！！！CAS算法
        System.out.println("第几次访问，次数next为：" + next);
        return next;
    }

    // 负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标，每次服务重启动后rest接口计数从1开始
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
