package chapter4

/**
 * Created by 1002371 on 14. 12. 24..
 */
object FallWinterSpringSummer extends Application {
  for (season <- List("fall", "winter", "spring")) {
    println(season + ": " + ChecksumAccumulator.calculate(season))
  }
}
