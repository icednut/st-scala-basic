package chapter6

/**
 * Created by 1002371 on 14. 12. 24..
 */
object Rational {
  def main(args: Array[String]): Unit = {
    val x = new Rational(1, 3)
    println(x)

    val y = new Rational(5, 0)
    println(y)
  }
}

class Rational(n: Int, d: Int) {
  require(d != 0)
  override def toString = n + "/" + d
}

