name := "rabbit-message-queue"

version := "0.1"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "com.rabbitmq" % "amqp-client" % "2.8.1",
  "com.typesafe" % "config" % "1.2.1",

  //akka
  "com.typesafe.akka" %% "akka-actor" % "2.5.12"
)