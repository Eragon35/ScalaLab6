package prog

import akka.io.Tcp._
import prog.IO.ReadFromFile
import prog.Model.Flat

import java.util.{Calendar, Date}
import scala.collection.mutable

object Server {
  val start: Date = Calendar.getInstance().getTime
  var collection = mutable.ArrayDeque[Flat]() // : mutable.Seq[Flat]
  var filename: String = ""

  def main(args: Array[String]): Unit = {

    println("Beginning of lab 6 variant 778, scala edition\nServer")

    if (FileChecker.check(args(0))) sys.exit()
    filename = args(0)

    ReadFromFile.readXml()

    while (true){
      // get requests & send responses
    }

  }

}
