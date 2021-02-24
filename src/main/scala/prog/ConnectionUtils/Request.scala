package prog.ConnectionUtils

import prog.ConnectionUtils.ConsoleCommand.ConsoleCommand
import prog.Model.Flat

class Request (command: ConsoleCommand, flat: Flat) extends Serializable{
  def command_ : ConsoleCommand = command

}
