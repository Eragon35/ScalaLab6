package prog.Model
import prog.ConnectionUtils.Request

object ServerHandler {
  def handler(requst: Request) = {
    requst.command_ match {
      case prog.ConnectionUtils.ConsoleCommand.add =>
      case prog.ConnectionUtils.ConsoleCommand.update =>
      case prog.ConnectionUtils.ConsoleCommand.remove_by_id =>
      case prog.ConnectionUtils.ConsoleCommand.clear =>
      case prog.ConnectionUtils.ConsoleCommand.remove_head =>
      case prog.ConnectionUtils.ConsoleCommand.remove_greater =>
      case prog.ConnectionUtils.ConsoleCommand.remove_all_by_number_of_rooms =>
    }
  }

}
