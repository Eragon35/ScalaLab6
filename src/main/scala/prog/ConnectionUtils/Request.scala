package prog.ConnectionUtils

import prog.ConnectionUtils.ConsoleCommand.ConsoleCommand
import prog.Model.Flat

class Request (var _command: ConsoleCommand, var _flat: Flat, var _number: Int) extends Serializable{
  def command : ConsoleCommand = _command
  def flat : Flat = _flat
  def number : Int = _number

  def command_ (newCommand: ConsoleCommand): Unit = _command = newCommand
  def flat_ (newFlat: Flat): Unit = _flat = newFlat
  def number_ (newNumber: Int): Unit = _number = newNumber


}
