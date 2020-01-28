package com.coding.guys

import cats.effect.{ExitCode, IO, IOApp}
import com.typesafe.config.ConfigFactory

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends IOApp {

  val app = new Application(ConfigValues(ConfigFactory.load("app.conf")))

  override def run(args: List[String]): IO[ExitCode] =
    app.recordDbParsing().map(_ => ExitCode.Success)

}
