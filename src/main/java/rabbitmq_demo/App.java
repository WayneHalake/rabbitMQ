package rabbitmq_demo;

import com.rabbitmq.client.Connection;
import rabbitmq_demo.revcmassage.MassageRevc;
import rabbitmq_demo.sendmassages.MassageSender;
import rabbitmq_demo.util.UtilConnection;

/**
 *
 */
public class App {
    public static void main( String[] args ) throws Exception{
        Connection connection = UtilConnection.getConnection();
        //向队列中发送消息
        new MassageSender().sendMassages(connection,"testQueue");

        //从队列中取消息
        new MassageRevc().revcMassages(connection, "testQueue");
        connection.close();
    }
}
