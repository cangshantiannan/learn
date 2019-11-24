/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import lombok.val;

/**
 * @ClassName: HttpServiceInitialize
 * @Function:
 * @Date: 2019/11/23 19:53
 * @author wyl
 * @version V1.0
 */
public class HttpServiceInitialize extends ChannelInitializer<SocketChannel> {

    /**
     * @Description 初始化
     * @param socketChannel
     * @return void
     * @Date 2019/11/23 19:58
     * @Author wangyl
     * @Version  V1.0
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        /**
         *Http处理器
         */
        pipeline.addLast("httpServerCodec",new HttpServerCodec());
        pipeline.addLast("httpServiceHandler",new HttpServiceHandler());
    }
}
