package com.antin.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Administrator on 2017/4/25.
  */
object WordCount {
  def main(args: Array[String]) {

    //System.setProperty("HADOOP_USER_NAME", "root")

    //创建SparkConf()并设置App名称
    val conf = new SparkConf().setAppName("WC")
      //.setJars(Array("F:\\CommonDevelop\\hadoop\\project\\spark\\scala\\target\\scala-1.0-SNAPSHOT.jar"))
      .setMaster("local")
    //.setMaster("local[2]")
    //.setMaster("spark://192.168.2.88:7077")

    //创建SparkContext，该对象是提交spark App的入口
    val sc = new SparkContext(conf)

    //使用sc创建RDD并执行相应的transformation和action
    sc.textFile("F:\\CommonDevelop\\hadoop\\testData\\words.txt") //hdfs://192.168.2.88:9000/input/test.log
      .flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _, 1)
      .sortBy(_._2, false)
      .saveAsTextFile("F:\\CommonDevelop\\hadoop\\testData\\out") //hdfs://192.168.2.88:9000/output/out

    //停止sc，结束该任务
    sc.stop()
  }

}
