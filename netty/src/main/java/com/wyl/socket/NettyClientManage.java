package com.wyl.socket;

import io.netty.channel.Channel;

import java.util.HashMap;
/**
 * @ClassName: NettyClientManage
 * @Function:  多客户端管理
 * @Date:      2019/11/23 0:34
 * @author     wangyl
 * @version    V1.0
 */ 
public class NettyClientManage {
    static private HashMap<String, Channel> NettyClienMap = new HashMap<>();

    /**
     * @Description 添加一个已启动的客户端
     * @param name
     * @param channel
     * @return void
     * @Date 2019/11/22 17:17
     * @Author wangyl
     * @Version V1.0
     */
    static public void add(String name, Channel channel) {
        NettyClienMap.put(name, channel);
    }

    /**
     * @Description 获取相应对应的客户端
     * @param name
     * @return io.netty.channel.ChannelFuture
     * @Date 2019/11/22 17:18
     * @Author wangyl
     * @Version V1.0
     */
    static public Channel getChannelByName(String name) throws Exception {
        if (NettyClienMap.containsKey(name)) {
            return NettyClienMap.get(name);
        }
        throw new Exception("不存在");
    }
}