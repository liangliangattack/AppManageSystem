package com.liang.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 方法耗时统计
 */
public class MethodTimeInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodTimeInterceptor.class);

    //前置功能
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LOGGER.warn(request.getRequestURI()+"请求到达");

        //开始时间
        long start = System.currentTimeMillis();
        request.setAttribute("start",start);
        //返回true才会找下一个拦截器
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //结束时间
        long end = System.currentTimeMillis();

        long spendTime =end -  (long)request.getAttribute("start");

        if (spendTime >= 1000) {
            LOGGER.warn("方法耗时严重 请及时处理！时间："+spendTime+"毫秒");
        } else {
            LOGGER.warn("方法耗时："+spendTime+"毫秒");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
