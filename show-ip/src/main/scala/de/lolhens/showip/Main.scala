package de.lolhens.showip

import cats.effect.ExitCode
import monix.eval.{Task, TaskApp}
import org.http4s.HttpRoutes
import org.http4s.dsl.task._
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder

object Main extends TaskApp {
  override def run(args: List[String]): Task[ExitCode] =
    for {
      _ <- serverTask("0.0.0.0", 8080)
    } yield
      ExitCode.Success

  def serverTask(host: String, port: Int): Task[Nothing] =
    BlazeServerBuilder[Task]
      .bindHttp(port, host)
      .withHttpApp(service.orNotFound)
      .resource
      .use(_ => Task.never)

  def service: HttpRoutes[Task] =
    HttpRoutes.of[Task] {
      case request@GET -> Root =>
        Ok("Your IP is: " + request.from.map(_.toString).getOrElse("-"))
    }
}
