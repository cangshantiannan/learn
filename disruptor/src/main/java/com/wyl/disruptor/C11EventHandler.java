package com.wyl.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class C11EventHandler implements EventHandler<LongEvent>, WorkHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        long number = event.getNumber();
        number += 10;
        //获取所有连接依次发送信息
        // TODO
        System.out.println(System.currentTimeMillis() + ": c1-1 even consumer finished.number=" + number);
    }

    @Override
    public void onEvent(LongEvent event) throws Exception {
        long number = event.getNumber();
        number += 10;
        System.out.println(System.currentTimeMillis() + ": c1-1 work consumer finished.number=" + number);
    }
}