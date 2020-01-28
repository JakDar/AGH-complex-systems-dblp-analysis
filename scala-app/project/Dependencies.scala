object Dependencies {

  import sbt._

  val CodeheroesCommonsVersion = "0.101"
  val ScalaTestVersion = "3.0.8"
  val ScalaMockVersion = "4.4.0"
  val SimulacrumVersion = "0.19.0"
  val TypesafeConfigVersion = "1.3.4"

  private val miscDependencies = Seq(
    "io.codeheroes" %% "commons-core" % CodeheroesCommonsVersion,
    "com.github.mpilquist" %% "simulacrum" % SimulacrumVersion,
    "com.typesafe" % "config" % TypesafeConfigVersion,
    "neo4j-contrib" % "neo4j-spark-connector" % "2.1.0-M4",
    //    "org.neo4j"            % "neo4j-ogm-core"        % "3.1.10",
    //    "org.neo4j"            % "neo4j-ogm-bolt-driver" % "3.1.10"

    "org.neo4j.driver" % "neo4j-java-driver" % "1.7.2"


  )

  private val testDependencies = Seq(
    "org.scalatest" %% "scalatest" % ScalaTestVersion % Test,
    "org.scalamock" %% "scalamock" % ScalaMockVersion % Test
  )

  val all: Seq[ModuleID] = Seq(
    testDependencies,
    miscDependencies
  ).flatten

  val additionalResolvers: Seq[Resolver] = Seq(
    Resolver.jcenterRepo,
    Resolver.mavenCentral,
    Resolver.bintrayRepo("codeheroes", "maven"),
    "Typesafe Repo" at "https://repo.typesafe.com/typesafe/releases/",
    "Spark Packages Repo" at "https://dl.bintray.com/spark-packages/maven"
  )

}
