package chapter7

import java.io.File

/**
 * Created by 1002371 on 14. 12. 24..
 */
object MultipleGenerator {
  def main(args: Array[String]): Unit = {
    val generator: MultipleGenerator = new MultipleGenerator()
    val files: Array[File] = generator.scalaFiles

    for (file <- files)
      println(file)
  }
}

class MultipleGenerator {
  def filesHere = (new java.io.File(".")).listFiles

  def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList
  
  def grep(pattern: String) = {
    for (
      file <- filesHere
      if file.getName.endsWith(".scala");
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)
  }
  
  def grep2(pattern: String) =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(file + ": " + trimmed)
  
  // .scala 파일을 식별하고 결과를 배열에 저장하는 함수
  def scalaFiles: Array[File] =
    for {
      file <- filesHere
      if file.getName.contains("sbt")
    } yield file
}
