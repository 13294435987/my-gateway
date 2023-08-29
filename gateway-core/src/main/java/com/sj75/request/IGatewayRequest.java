package com.sj75.request;

import org.asynchttpclient.Request;
import org.asynchttpclient.cookie.Cookie;

/**
 * 网络请求的Request接口
 *
 * @author hujiabin
 * @date 2023/8/29 20:47
 * @since 1.0
 */
public interface IGatewayRequest {

    /**
     * 添加我请求头信息
     *
     * @param name  name
     * @param value value
     */
    void addHeader(CharSequence name, String value);

    /**
     * 设置请求头信息
     *
     * @param name  name
     * @param value value
     */
    void setHeader(CharSequence name, String value);

    /**
     * 添加或者替换Cookie
     *
     * @param cookie cookie
     */
    void addOrReplaceCookie(Cookie cookie);

    /**
     * 设置超时时间
     *
     * @param requestTimeout 超时时间
     */
    void setRequestTimeout(int requestTimeout);

    /**
     * 修改域名
     *
     * @param modifyHost 域名
     */
    void setModifyHost(String modifyHost);

    /**
     * 设置路径
     *
     * @param modifyPath 路径
     */
    void setModifyPath(String modifyPath);

    /**
     * 获取路径
     *
     * @return 路径
     */
    String getModifyPath();

    /**
     * Get请求参数
     *
     * @param name  name
     * @param value value
     */
    void addQueryParam(String name, String value);

    /**
     * POST增加参数
     *
     * @param name  name
     * @param value value
     */
    void addFormParam(String name, String value);

    /**
     * 获取最终的请求路径
     *
     * @return 最终请求的url
     */
    String getFinalUrl();


    /**
     * 构建最终的请求对象
     *
     * @return request
     */
    Request build();
}
