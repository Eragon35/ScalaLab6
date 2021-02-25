package prog.ConnectionUtils

import prog.ConnectionUtils.ConsoleCommand.ConsoleCommand
import prog.Model.Flat

class Request (command: ConsoleCommand, flat: Flat, number: Int) extends Serializable{
  def command_ : ConsoleCommand = command
  def flat_ : Flat = flat
  def number_ : Int = number

}
