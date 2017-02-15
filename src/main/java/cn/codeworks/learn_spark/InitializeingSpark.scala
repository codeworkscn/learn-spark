
package cn.codeworks.learn_spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object InitializeingSpark {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MyApp").setMaster("spark://localhost:6066")
    new SparkContext(conf)
  }

}