name := "ProgLab6"

version := "0.1"

scalaVersion := "2.13.4"

val AkkaVersion = "2.5.23"
val AkkaHttpVersion = "10.1.8"
libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
)