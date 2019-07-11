package ru.lzakharov.examples.greeter

import com.typesafe.scalalogging.Logger
import io.grpc.Server

/** A greeter gRPC server.
  *
  * @param server server for listening and serving gRPC requests.
  */
final class GreeterServer(val server: Server) {
  private val logger = Logger[GreeterServer]

  /** Starts a greeter gRPC server. */
  def start(): Unit = {
    server.start()
    logger.info("Started the greeter gRPC server.")
  }

  /** Stops a greeter gRPC server. */
  def stop(): Unit = {
    server.shutdown()
    logger.info("Stopped the greeter gRPC server.")
  }

  /** Awaits termination on the main thread. */
  def blockUntilShutdown(): Unit = {
    logger.info("Waiting for the greeter gRPC server to become terminated...")
    server.awaitTermination()
    logger.info("Terminated the greeter gRPC server.")
  }
}

/** Greeter gRPC server factory. */
object GreeterServer {
  def apply(server: Server): GreeterServer = new GreeterServer(server)
}
