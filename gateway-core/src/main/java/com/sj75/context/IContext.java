package com.sj75.context;

import com.sj75.common.rule.Rule;
import io.netty.channel.ChannelHandlerContext;

import java.util.function.Consumer;

/**
 * 核心上下文接口
 *
 * @author hujiabin
 * @date 2023/8/27 21:23
 * @since 1.0
 */
public interface IContext {
    // 声明声明周期状态

    /**
     * 一个请求正在执行的状态
     */
    int RUNNING = 0;

    /**
     * 标志请求结束，写会响应，返回结果
     */
    int WRITTEN = 1;

    /**
     * 响应成功，设置该标识
     */
    int COMPLETED = 2;

    /**
     * 整个网关请求完毕。彻底结束
     */
    int TERMINATED = -1;

    /**
     * 设置上下文状态为正常运行状态
     */
    void running();

    /**
     * 设置上下文状态标记写会状态
     */
    void written();

    /**
     * 设置上下文状态写回成功
     */
    void completed();

    /**
     * 标记网关结束
     */
    void terminated();

    // 判断网关运行状态

    /**
     * 是否运行
     *
     * @return true/false
     */
    boolean isRunning();

    /**
     * 是否已经标记写回
     *
     * @return true/false
     */
    boolean isWritten();

    /**
     * 是否标记写回成功
     *
     * @return true/false
     */
    boolean isCompleted();

    /**
     * 是否结束
     *
     * @return true/false
     */
    boolean isTerminated();

    /**
     * 获取请求协议
     *
     * @return 请求协议
     */
    String getProtocol();

    /**
     * 获取请求规则
     *
     * @return rule
     */
    Rule getRule();

    /**
     * 获取请求对象
     *
     * @return 请求对象
     */
    Object getRequest();

    /**
     * 获取响应对象
     *
     * @return 响应对象
     */
    Object getResponse();

    /**
     * 获取异常信息
     *
     * @return throwable
     */
    Throwable getThrowable();

    /**
     * 获取上下文请求参数
     *
     * @param key 参数的key
     * @return 参数
     */
    Object getAttribute(String key);

    /**
     * 设置请求规则
     */
    void setRule();

    /**
     * 设置请求返回结果
     */
    void setResponse();

    /**
     * 设置请求异常信息
     *
     * @param throwable 异常
     */
    void setThrowable(Throwable throwable);

    /**
     * 设置上下文参数
     *
     * @param key    上下文参数的key
     * @param object 参数value
     * @return object
     */
    Object setAttribute(String key, Object object);

    /**
     * 获取netty上下文
     *
     * @return netty上下文
     */
    ChannelHandlerContext getNettyCtx();

    /**
     * 是否保持长连接
     *
     * @return true/false
     */
    boolean isKeepAlive();

    /**
     * 释放资源
     */
    void releaseRequest();

    /**
     * 设置回调函数
     *
     * @param consumer 执行的回调函数
     */
    void setCompleted(Consumer<IContext> consumer);

    /**
     * 调用回调函数
     */
    void invokeCompletedCallBack();
}
