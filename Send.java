public class Send {

    private static final String EXCHANGE_NAME="test_exchange_direct";

    public static void main (String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");

        String msg="hello qiaohong";

        String routingKey="error";
        channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());

        System.out.println("Send: "+msg);

        channel.close();
        connection.close();


    }

}
