package chapter8

import scala.io.Source

/**
 * Created by 1002371 on 14. 12. 29..
 */
object LongLines {
  def processFile(fileName: String, width: Int): Unit = {
    def processLine(line: String): Unit = {
      if (line.length > width) {
        println(fileName + ": " + line.trim)
      }
    } // 외부에서는 접근 불가
    
    val source = Source.fromFile(fileName)
    for (line <- source.getLines()) {
      processLine(line)
    }
  }
}
