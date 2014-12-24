package chapter6

/**
 * Created by 1002371 on 14. 12. 24..
 */
object Rational {
  def main(args: Array[String]): Unit = {
    val x = new Rational(1, 2)
    println(x)

    val y = new Rational(2, 3)
    println(y)
    
    val z = new Rational(5)
    println(z)
    
    val gcdRational = new Rational(66, 42)
    println(gcdRational)
    
    val addResult = x + y
    println(addResult)
    
    val multipleResult = x * y
    println(multipleResult)
    
    val multipleResult2 = x + x * y
    println(multipleResult2)
    
    val addResult2 = x + 3
    println(addResult2)
  }
}

class Rational(n: Int, d: Int) {
  // 주 생성자 (primary Constructor)
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  // 보조 생성자 (auxiliary constructor)
  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  
  def +(tempNumer: Int): Rational = new Rational(numer + tempNumer * denom, denom)

  def *(that: Rational): Rational = new Rational(numer * that.numer, denom * that.denom)

  def lessThan(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = {
    if (lessThan(that)) {
      that
    } else {
      this
    }
  }

  override def toString = numer + "/" + denom
  
  private def gcd(firstValue: Int, secondValue: Int): Int = {
    if (secondValue == 0) {
      firstValue
    } else {
      gcd(secondValue, firstValue % secondValue)
    }
  }
}
