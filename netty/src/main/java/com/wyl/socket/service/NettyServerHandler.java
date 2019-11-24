package com.wyl.socket.service;

import com.wyl.socket.NettyClientManage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServerHandler extends SimpleChannelInboundHandler<Object> {
    private static Logger log = LoggerFactory.getLogger(NettyServerHandler.class);

    /**
     *保存所有连接服务端的客户端信息
     */
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 客户端连接会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("上线了[{}]", ctx.channel().remoteAddress().toString());
    }

    /**
     * 客户端发消息会触发
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        //群发消息
        channelGroup.forEach(channel -> {
            //不是自己 就发送消息
            if (channel != ctx.channel()) {
                channel.writeAndFlush(ctx.channel().remoteAddress().toString() + "发送消息为[" + msg + "]");
            }
        });
    }

    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 连接被创建
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info("已上线[{}]", channel.remoteAddress());
        channelGroup.writeAndFlush("已上线[" + channel.remoteAddress() + "]");
        channelGroup.add(channel);
    }

    /**
     * 连接被移除
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //channelGroup.remove(channel); 不需要写 会自动调用
        channel.writeAndFlush("已下线[" + channel.remoteAddress() + "]");
        log.info("已下线[{}]", channel.remoteAddress());
    }

    /**
     *下线
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        log.info("已下线[{}]", ctx.channel().remoteAddress());
    }

    /**
     * 空闲时候触发
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            switch (idleStateEvent.state()) {
                /**
                 *都空闲
                 */
                case ALL_IDLE:
                    break;
                /**
                 *读空闲
                 */
                case READER_IDLE:
                    break;
                /**
                 *写空闲
                 */
                case WRITER_IDLE:
                    break;
            }

        }
    }
}