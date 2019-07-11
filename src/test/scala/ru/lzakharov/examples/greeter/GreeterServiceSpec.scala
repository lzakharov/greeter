package ru.lzakharov.examples.greeter

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.concurrent.ScalaFutures

class GreeterServiceSpec extends FlatSpec with Matchers with ScalaFutures {
  "A greeter service" should "greet by name specified in request" in {
    val service = new GreeterService

    whenReady(service.sayHello(HelloRequest("John Doe"))) { result =>
      result should be(HelloReply("Hello, John Doe!"))
    }
  }
}
