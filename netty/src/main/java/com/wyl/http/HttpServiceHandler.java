/**
 * @Author wangyl
 * @E-mail wangyl@dsgdata.com
 **/
package com.wyl.http;

import com.wyl.socket.client.NettyClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: HttpServiceHandler
 * @Function: Http请求处理方法
 * @Date: 2019/11/23 19:52
 * @author wyl
 * @version V1.0
 */
public class HttpServiceHandler extends SimpleChannelInboundHandler<HttpObject> {
    private static Logger log = LoggerFactory.getLogger(HttpServiceHandler.class);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        if (httpObject instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) httpObject;
            log.info("url is [{}]",httpRequest.uri());
            log.info("method is [{}]",httpRequest.method().name());
            /**
             *返回数据
             */
            ByteBuf context = Unpooled.copiedBuffer("hellow", CharsetUtil.UTF_8);

            /**
             *相应对象
             */
            FullHttpResponse request = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, context);
            request.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain").set(HttpHeaderNames.CONTENT_LENGTH, context.readableBytes());
            /**
             *返回客户端
             */
            channelHandlerContext.writeAndFlush(request);
        }
    }
}
