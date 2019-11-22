package com.wyl.socket.service;

import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
    }
}
