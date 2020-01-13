import com.rabbitmq.client.{Connection, ConnectionFactory}

object RabbitMQConnection {

  private val connection: Option[Connection] = None;

  def getConnection: Connection = {
    connection match {
      case None =>
        val factory = new ConnectionFactory
        factory.setHost(ConfigReader.RabbitMQHost)
        factory.newConnection()
      case Some(_) => connection.get
    }
  }
}
