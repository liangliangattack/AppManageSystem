package com.liang.listener;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import java.sql.DriverManager;
import java.sql.SQLException;

/**

 - Created by liangliangattack on 2018/2/27.
 */
//解决数据库register之后无法unregister的问题
public class WebAppContextListener  extends ContextLoaderListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("webService stop");

        try {
            while (DriverManager.getDrivers().hasMoreElements()) {
                DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
            }
            System.out.println("jdbc Driver close");
            AbandonedConnectionCleanupThread.checkedShutdown();
            System.out.println("clean thread success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {

//        Const.WEB_APP_CONTEXT = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());

    }
}