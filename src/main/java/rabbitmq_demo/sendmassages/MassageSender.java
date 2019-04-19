package rabbitmq_demo.sendmassages;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class MassageSender {

    /**
     * 向消息队列中发布消息
     * @param conn
     * @param queueName 队列名称
     * @throws Exception
     */
    public void sendMassages(Connection conn, String queueName) throws Exception{
        //创建连接通道
        Channel channel = conn.createChannel();
        //声明队列
        channel.queueDeclare(queueName, false, false, false, null);
        //发布消息
        channel.basicPublish("",queueName,null,"firstMassage".getBytes());
        System.out.println("发布消息");
        //关闭通道
        channel.close();
    }
}
