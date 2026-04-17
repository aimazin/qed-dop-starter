val scala3Version = "3.4.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "qed-dop-starter",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,

    // Core dependencies for Web 5.0 and Functional Streams
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.10.0",
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.scalameta" %% "munit-scalacheck" % "0.7.29" % Test,
      "org.scalacheck" %% "scalacheck" % "1.17.0" % Test
    )
  )