package com.grove.bigdata.spark.core.wc

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_WordCount {

  def main(args: Array[String]): Unit = {
    // TODO 建立连接
    val sparkConf = new SparkConf().setMaster("localhost").setAppName("WordCount")
    val sc = new SparkContext(sparkConf);
    // TODO 执行业务操作

    //1.读取文件
    
    // TODO 关闭连接
  }
}
