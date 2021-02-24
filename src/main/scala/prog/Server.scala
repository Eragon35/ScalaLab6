package prog

import akka.io.Tcp._
import prog.IO.ReadFromFile
import .args
import prog.Model.Flat

import java.util.{Calendar, Date}
import scala.collection.mutable

object Server {
  def main(args: Array[String]): Unit = {
    println("Beginning of lab 6 variant 778, scala edition\nServer")

    if (FileChecker.check(args(0))) sys.exit()
    val start: Date = Calendar.getInstance().getTime
    val filename = args(0)
    val collection = mutable.ArrayDeque[Flat]()
    ReadFromFile.readXml()

  }

}
