scalaVersion := "3.0.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "animation-fx",
    version := "0.1.0",
    Compile / unmanagedSourceDirectories += baseDirectory.value / "libs/trivalibs/src/main",
    Test / unmanagedSourceDirectories += baseDirectory.value / "libs/trivalibs/src/test",
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.26" % Test,
    testFrameworks += new TestFramework("munit.Framework"),
    // Add dependency on ScalaFX library
    libraryDependencies += "org.scalafx" %% "scalafx" % "16.0.0-R24",

    // Determine OS version of JavaFX binaries
    libraryDependencies ++= javaFXModules
      .map(m => "org.openjfx" % s"javafx-$m" % "16" classifier osName),
    mainClass := Some("hello.ScalaFXHelloWorld"),
    // Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
    fork := true
  )

// ScalaFX setup
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux")   => "linux"
  case n if n.startsWith("Mac")     => "mac"
  case n if n.startsWith("Windows") => "win"
  case _                            => throw new Exception("Unknown platform!")
}

// Add dependency on JavaFX libraries, OS dependent
lazy val javaFXModules =
  Seq(
    "base",
    "controls",
//    "fxml",
    "graphics",
    "media"
//    "swing",
//    "web"
  )
