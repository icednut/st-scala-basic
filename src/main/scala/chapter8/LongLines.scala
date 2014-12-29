package chapter8

import scala.io.Source

/**
 * Created by 1002371 on 14. 12. 29..
 */
object LongLines {
  def processLine(fileName: String, width: Int, line: String): Unit = {
    if (line.length > width) {
      println(fileName + ": " + line.trim)
    }
  }

  def processFile(fileName: String, width: Int): Unit = {
    val source = Source.fromFile(fileName)
    for (line <- source.getLines()) {
      processLine(fileName, width, line)
    }
  }
}
