package rabbitmq_demo.revcmassage;

import com.rabbitmq.client.*;

import java.io.IOException;

public class MassageRevc {
    /**
     * 从消息队列中取消息
     * @param conn
     * @param queueName 队列名称
     * @throws Exception
     */
    public void revcMassages(Connection conn, String queueName) throws Exception{
        //创建通道
        Channel channel = conn.createChannel();
        //声明队列
        channel.queueDeclare(queueName, false, false, false, null);

        /*  lambda函数式编程 实现DeliverCallback接口
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        实现CancelCallback接口
        CancelCallback cancelCallbac = (s)->{ };
        */



        /**
         * 实现DeliverCallback接口
         * 获取消息队列里面的信息在此完成
         */
        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String s, Delivery delivery) throws IOException {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("MQMessage:"+message);
            }
        };

        /**
         * 实现cancelCallback接口
         */
        CancelCallback cancelCallback = new CancelCallback() {
            @Override
            public void handle(String s) throws IOException {

            }
        };

       channel.basicConsume(queueName, true, deliverCallback, cancelCallback);
       channel.close();
    }
}
