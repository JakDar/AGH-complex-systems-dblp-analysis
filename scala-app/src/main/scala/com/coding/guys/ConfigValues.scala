package com.coding.guys

import com.coding.guys.ConfigValues._
import com.typesafe.config.Config
case class ConfigValues(
    app: ApplicationConfig,
    raw: Config
)

object ConfigValues {

  def apply(config: Config): ConfigValues = new ConfigValues(
    ApplicationConfig(
      bindHost = config.getString("bind-host"),
      bindPort = config.getInt("bind-port"),
      appLogLevel = config.getString("log-level.app"),
      rootLogLevel = config.getString("log-level.root")
    ),
    config
  )

  
  case class ApplicationConfig(
      bindHost: String,
      bindPort: Int,
      appLogLevel: String,
      rootLogLevel: String
  )
}
