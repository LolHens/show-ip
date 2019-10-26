inThisBuild(Seq(
  name := "show-ip",
  organization := "de.lolhens",

  scalaVersion := "2.13.1"
))

name := (ThisBuild / name).value

lazy val showIp = project.in(file("show-ip"))
  .settings(
    name := "show-ip",
    version := "0.0.0",

    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "io.monix" %% "monix" % "3.0.0",
      "io.circe" %% "circe-core" % "0.12.3",
      "io.circe" %% "circe-generic" % "0.12.3",
      "io.circe" %% "circe-parser" % "0.12.3",
      "org.http4s" %% "http4s-dsl" % "0.21.0-M5",
      "org.http4s" %% "http4s-blaze-server" % "0.21.0-M5",
      "org.http4s" %% "http4s-circe" % "0.21.0-M5",
      "org.http4s" %% "http4s-scalatags" % "0.21.0-M5",
      "com.lihaoyi" %% "scalatags" % "0.7.0"
    )
  )
