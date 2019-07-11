package ru.lzakharov.examples.greeter

import com.typesafe.config.ConfigFactory
import io.grpc.ServerBuilder

object Main extends App {
  val settings = Settings(ConfigFactory.load())
  val ec = concurrent.ExecutionContext.global

  val server = GreeterServer(
    ServerBuilder
      .forPort(settings.port)
      .addService(GreeterGrpc.bindService(new GreeterService, ec))
      .build()
  )

  server.start()
  server.blockUntilShutdown()
}
