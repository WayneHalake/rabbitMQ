package rabbitmq_demo.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class UtilConnection {
    /**
     * 连接rabbitmq服务器
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        Connection connection = null;
        ConnectionFactory factory = new ConnectionFactory();
        //设置访问服务器地址
        factory.setHost("localhost");
        //设置访问服务器端口号
        factory.setPort(5672);
        //设置访问服务器的virtualHost
        factory.setVirtualHost("chxieHost");
        //设置访问服务器的用户名
        factory.setUsername("chxie");
        //设置访问服务器的密码
        factory.setPassword("123456");

        connection = factory.newConnection();
        return connection;
    }
}
