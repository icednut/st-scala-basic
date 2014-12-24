package chapter4

/**
  * Created by 1002371 on 14. 12. 24..
  */
object ChecksumAccumulator {
   private var cache = Map[String, Int]()

   def calculate(s: String): Int = {
     if (cache.contains(s)) {
       cache(s)
     } else {
       val acc = new ChecksumAccumulator

       for (c <- s) {
         acc.add(c.toByte)
       }
       val cs = acc.checksum()
       cache += (s -> cs)
       cs
     }
   }
 }

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = {
    sum += b
  }
  def checksum(): Int = ~(sum & 0xFF) + 1
}
