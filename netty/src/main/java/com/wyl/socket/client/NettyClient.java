package com.wyl.socket.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

/**
 * @ClassName: NettyClient
 * @Function: nettySocket 客户端测试
 * @Date: 2019/11/22 16:49
 * @author wangyl
 * @version V1.0
 */
public class NettyClient {

    private static Logger log = LoggerFactory.getLogger(NettyClient.class);

    public void start(InetSocketAddress socketAddress) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap().group(group)
                //该参数的作用就是禁止使用Nagle算法，使用于小数据即时传输
                .option(ChannelOption.TCP_NODELAY, true).channel(NioSocketChannel.class).handler(new NettyClientInitializer());
        try {
            ChannelFuture future = bootstrap.connect(socketAddress).sync();
            log.info("客户端成功....");
            // 等待连接被关闭
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String content = reader.readLine();
                if (content != "") {
                    if ("q".equals(content)) {
                        System.exit(1);
                    }
                    future.channel().writeAndFlush(content);
                }
            }
    }
        catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        finally {
            group.shutdownGracefully();
        }
    }
}