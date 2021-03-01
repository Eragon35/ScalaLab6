package prog.ConnectionUtils

import prog.ConnectionUtils.ServerAnswer.{Ok, ServerAnswer}
import prog.Model.Flat
import prog.Server

import java.util.Date
import scala.collection.mutable

class Response (collection: mutable.ArrayDeque[Flat], message: String, status: ServerAnswer = Ok, start: Date = Server.start){

  def collection_ : mutable.ArrayDeque[Flat] = collection
  def status_ : ServerAnswer = status
  def message_ : String = message
  def start_ : Date = start
}
