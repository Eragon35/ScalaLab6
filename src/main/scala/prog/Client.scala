package prog

import prog.Model.Flat

import scala.collection.mutable
import scala.io.StdIn
import java.util.Date

object Client {

  var collection = mutable.ArrayDeque[Flat]()
  val start: Date = null

  def main(args: Array[String]): Unit = {
    println("Beginning of lab 6 variant 778, scala edition\nClient")

    //send first request to initialize

    while (true) {
      Thread.sleep(50)
      print("\nType your command: ")
      ConsoleHandler.handler(StdIn.readLine())
    }

  }
}
