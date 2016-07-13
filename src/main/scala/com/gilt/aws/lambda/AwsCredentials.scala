package com.gilt.aws.lambda

import com.amazonaws._, auth._, profile._

private[lambda] object AwsCredentials {
  lazy val provider: AWSCredentialsProvider =
    new AWSCredentialsProviderChain(
      new EnvironmentVariableCredentialsProvider,
      new SystemPropertiesCredentialsProvider,
      new ProfileCredentialsProvider,
      new InstanceProfileCredentialsProvider
    ) {

    override def getCredentials: AWSCredentials = {
      try return super.getCredentials
      catch { case ace: AmazonClientException => }
      println("No credentials available; falling back to anonymous access")
      null
    }
  }
}
