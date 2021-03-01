package prog

import prog.ConnectionUtils.Request
import prog.Model.Flat

import scala.collection.mutable
import scala.io.StdIn
import java.util.Date

object Client {

  var collection: mutable.ArrayDeque[Flat] = mutable.ArrayDeque[Flat]()
  var start: Date = null
  var request: Request = null
  var size = 0

  def main(args: Array[String]): Unit = {
    println("Beginning of lab 6 variant 778, scala edition\nClient")

    //send first request to initialize

    while (true) {
      size = collection.size
      Thread.sleep(50)
      print("\nType your command: ")
      ConsoleHandler.handler(StdIn.readLine())
      // send request
    }

  }
}
