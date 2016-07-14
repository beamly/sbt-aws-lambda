name := "sbt-aws-lambda"

organization := "com.beamly"

sbtPlugin := true

version in ThisBuild := "1.0.1-SNAPSHOT"

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.3")

val awsSdkVersion = "1.10.77"

libraryDependencies ++= Seq(
  "com.amazonaws"  % "aws-java-sdk-iam"    % awsSdkVersion,
  "com.amazonaws"  % "aws-java-sdk-lambda" % awsSdkVersion,
  "com.amazonaws"  % "aws-java-sdk-s3"     % awsSdkVersion
)

javaVersionPrefix in javaVersionCheck := Some("1.7")
