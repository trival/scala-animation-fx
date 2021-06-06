scalaVersion := "3.0.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "animation-fx",
    version := "0.1.0",
    libraryDependencies += "com.lihaoyi" %% "utest" % "0.7.10" % "test",
    testFrameworks += new TestFramework("utest.runner.Framework"),
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
