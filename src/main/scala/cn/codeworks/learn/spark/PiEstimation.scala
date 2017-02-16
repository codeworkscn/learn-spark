
package cn.codeworks.learn.spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object PiEstimation {

  def estimate(num_samples: Int) = {
    val conf = new SparkConf().setAppName("MyApp").setMaster("spark://10.64.40.103:7077")
    val sc = new SparkContext(conf)

    val count = sc.parallelize(1 to num_samples).map { i =>
      val x = Math.random()
      val y = Math.random()
      if (x * x + y * y < 1) 1 else 0
    }.reduce(_ + _)
    println("Pi is roughly " + 4.0 * count / num_samples)
    count
  }

  def main(args: Array[String]): Unit = {
    estimate(10000)
  }

}