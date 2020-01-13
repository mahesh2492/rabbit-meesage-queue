import com.rabbitmq.client.QueueingConsumer

object Consumer extends App {

  def startConsuming: Unit = {
    val channel = RabbitMQConnection.getConnection.createChannel()
    val consumer = new QueueingConsumer(channel)
    channel.basicConsume(ConfigReader.RabbitMQTopic, true, consumer)

    while(true) {
      val delivery = consumer.nextDelivery()
      val message = new String(delivery.getBody)
      println("Message received from queue: " + message)
    }

  }

  println("Started Receiving messages:")
  startConsuming
}
