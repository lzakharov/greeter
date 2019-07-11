package ru.lzakharov.examples.greeter

import scala.concurrent.Future

/** The greeting service implementation. */
final class GreeterService extends GreeterGrpc.Greeter {
  /** Sends a greeting. */
  override def sayHello(request: HelloRequest): Future[HelloReply] = {
    Future.successful(HelloReply(s"Hello, ${request.name}!"))
  }
}
