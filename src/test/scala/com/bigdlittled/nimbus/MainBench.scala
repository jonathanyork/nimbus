package com.bigdlittled.nimbus

import org.scalameter.api._
import breeze.linalg._

class MainBench extends Bench.OfflineRegressionReport {
  val sizes = Gen.range("size")(300000, 1500000, 300000)

  val ranges = for {
    size <- sizes
  } yield DenseVector.fill(size, 1)

  performance of "DenseVector" in {
    measure method "reduce" in {
      using(ranges) in {
        r => r.reduce(_ + _)
      }
    }
  }
}