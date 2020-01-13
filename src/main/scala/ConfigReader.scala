import com.typesafe.config.{Config, ConfigFactory}

object ConfigReader {
  private val config: Config = ConfigFactory.load()

  val RabbitMQHost: String = config.getString("rabbitmq.host")
  val RabbitMQTopic: String = config.getString("rabbitmq.queue")
  val RabbitMQExchange: String = config.getString("rabbitmq.exchange")
}
