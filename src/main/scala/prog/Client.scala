package prog

import scala.io.StdIn

object Client {
  def main(args: Array[String]): Unit = {
    println("Beginning of lab 6 variant 778, scala edition\nClient")
    while (true) {
      Thread.sleep(50)
      print("\nType your command: ")
      ConsoleHandler.handler(StdIn.readLine())
    }

  }
}
