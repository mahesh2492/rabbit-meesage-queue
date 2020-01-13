import akka.AkkaVersion
import akka.actor.{Actor, ActorSystem}

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

object Producer extends App {

  lazy val system = ActorSystem("data-streamer")

  def writeData = {

    val connection = RabbitMQConnection.getConnection
    val channel = connection.createChannel()
    channel.queueDeclare(ConfigReader.RabbitMQTopic, false, false, false, null)
    val randomWords = List("confluent", "databricks", "lightbend", "datastax", "akka")

    system.scheduler.schedule(2 seconds, 1 seconds) {
      Random.shuffle(randomWords).foreach { word =>
        val message = word +  System.currentTimeMillis().toString
        channel.basicPublish("", ConfigReader.RabbitMQTopic, null, message.getBytes)
      }
    }
  }

  println("Writing data to topic!! ")
  writeData

}
