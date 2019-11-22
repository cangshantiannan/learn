package com.wyl.socket.client;

import jdk.nashorn.internal.objects.NativeError;

import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        NettyClient nettyClient = new NettyClient();
        nettyClient.start(new InetSocketAddress("127.0.0.1", 8090));
    }
}
