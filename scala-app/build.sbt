enablePlugins(SbtNativePackager)
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
addCompilerPlugin(
  "org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full
)

version := "0.0"
lazy val `dblp` = (project in file("."))
  .settings(
    organization := "com.coding.guys",
    name := "dblp",
    scalaVersion := "2.12.10",
    resolvers ++= Dependencies.additionalResolvers,
    libraryDependencies ++= Dependencies.all,
    scalacOptions ++= CompilerOps.scalacOptions,
    parallelExecution in Test := false
  )
  .settings(
    dockerBaseImage := "java:openjdk-8",
    daemonUser in Docker := "root",
    // dockerRepository := Some(""),
    dockerExposedPorts := Seq(8080)
  )
