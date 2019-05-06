package com.liang.interceptor;

import com.liang.pojo.DevUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 方法耗时统计
 */
public class MethodTimeInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodTimeInterceptor.class);

    //前置功能
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        DevUser devUser = (DevUser) session.getAttribute("devUser");
        if(devUser != null) {

            LOGGER.warn(request.getRequestURI() + "======================请求到达==========================");
            LOGGER.warn("======================当前用户============================："+devUser.getDevName());

            //开始时间
            long start = System.currentTimeMillis();
            request.setAttribute("start", start);
        }
        else {
            //请登陆
            LOGGER.warn("======================请登陆！！！！！！！！！！！！！，没有权限=========================");

            return false;
        }
        //返回true才会找下一个拦截器
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        //又开始才会有结束
        if(request.getAttribute("start") != null) {
            //结束时间
            long end = System.currentTimeMillis();

            long spendTime = end - (long) request.getAttribute("start");

            if (spendTime >= 1000) {
                LOGGER.warn("方法耗时严重 请及时处理！时间：" + spendTime + "毫秒");
            } else {
                LOGGER.warn("方法耗时：" + spendTime + "毫秒");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
