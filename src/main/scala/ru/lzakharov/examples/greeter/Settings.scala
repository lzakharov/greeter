package ru.lzakharov.examples.greeter

import com.typesafe.config.Config

/**
  * An application settings.
  *
  * @param port a gRPC server port
  */
final case class Settings(port: Int)

/** Application settings factory. */
object Settings {
  /**
    * Creates an application settings.
    *
    * @param config configuration read from the environment
    * @return a new application settings
    */
  def apply(config: Config): Settings = {
    val port = config.getInt("port")
    new Settings(port)
  }
}
