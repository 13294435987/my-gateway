package com.sj75.context;

import com.sj75.common.rule.Rule;
import com.sj75.request.GatewayRequest;
import com.sj75.response.GatewayResponse;
import io.netty.channel.ChannelHandlerContext;

/**
 * 网关上下文对象
 *
 * @author hujiabin
 * @date 2023/8/28 23:24
 * @since 1.0
 */
public class GatewayContext extends BasicContext {

    /**
     * 请求
     */
    private GatewayRequest request;

    /**
     * 响应
     */
    private GatewayResponse response;


    /**
     * 规则
     */
    private Rule rule;

    public GatewayContext(String protocol, ChannelHandlerContext nettyCtx, boolean keepAlive) {
        super(protocol, nettyCtx, keepAlive);
    }
}
