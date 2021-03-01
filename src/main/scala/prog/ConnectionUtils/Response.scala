package prog.ConnectionUtils

import prog.ConnectionUtils.ServerAnswer.ServerAnswer
import prog.Model.Flat

import java.util.Date
import scala.collection.mutable

class Response (collection: mutable.ArrayDeque[Flat], status: ServerAnswer, message: String,start: Date){

  def collection_ : mutable.ArrayDeque[Flat] = collection
  def status_ : ServerAnswer = status
  def message_ : String = message
  def start_ : Date = start
}
