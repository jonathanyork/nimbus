name := "nimbus"

version := "0.1"

scalaVersion := "2.11.8"

// Main
libraryDependencies  ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.6",
  "ch.qos.logback" %  "logback-classic" % "1.1.7",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",
  "org.scalanlp" %% "breeze" % "0.12",
  "org.scalanlp" %% "breeze-natives" % "0.12"
  
)

// Test
libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "com.storm-enroute" %% "scalameter" % "0.8.2"
)

// Debug
libraryDependencies ++= Seq(
  "com.lihaoyi" % "ammonite" % "0.8.2" % "test" cross CrossVersion.full
)

initialCommands in (Test, console) := """ammonite.Main().run()"""

resolvers += "Sonatype OSS Snapshots" at
  "https://oss.sonatype.org/content/repositories/releases" 

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

parallelExecution in Test := false
