package etc

/**
 * Created by 1002371 on 14. 12. 26..
 */
class HelloWorldPrinter {
  def print(): Unit = {
    println("Hello, World!")
  }
}

object HelloWorldPrinter {
  def main(args: Array[String]): Unit = {
    val hp: HelloWorldPrinter = new HelloWorldPrinter
    hp.print();
  }

}