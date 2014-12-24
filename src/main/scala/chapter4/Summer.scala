package chapter4

/**
 * Created by 1002371 on 14. 12. 24..
 */
object Summer {
  def main(args: Array[String]): Unit = {
    for (arg <- args) {
      println(arg + ": " + ChecksumAccumulator.calculate(arg))
    }
  }
}
