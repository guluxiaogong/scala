package com.antin.obj

import scala.collection.immutable.HashSet


/**
  * Created by Administrator on 2017/4/25.
  */
object ImmutSetDemo extends App{

  val set1 = new HashSet[Int]()
  //将元素和set1合并生成一个新的set，原有set不变
  val set2 = set1 + 4
  //set中元素不能重复
  val set3 = set1 ++ Set(5, 6, 7)
  val set0 = Set(1,3,4) ++ set1
  println(set0.getClass)

}
object MutSetDemo extends App{
  //创建一个可变的HashSet
  val set1 = new scala.collection.mutable.HashSet[Int]()
  //向HashSet中添加元素
  set1 += 2
  //add等价于+=
  set1.add(4)
  set1 ++= Set(1,3,5)
  println(set1)
  //删除一个元素
  set1 -= 5
  set1.remove(2)
  println(set1)

}
object MutMapDemo extends App{
  val map1 = new scala.collection.mutable.HashMap[String, Int]()
  //向map中添加数据
  map1("spark") = 1
  map1 += (("hadoop", 2))
  map1.put("storm", 3)
  println(map1)

  //从map中移除元素
  map1 -= "spark"
  map1.remove("hadoop")
  println(map1)
}
