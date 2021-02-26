package prog.Model
import prog.ConnectionUtils.Request
import prog.Server._

object ServerHandler {
  def handler(request: Request): Any = {
    request.command match {
      case prog.ConnectionUtils.ConsoleCommand.add => collection.addOne(request.flat)
      case prog.ConnectionUtils.ConsoleCommand.update => collection.update(collection.indexWhere(f => f.id_() == request.number), request.flat)
      case prog.ConnectionUtils.ConsoleCommand.remove_by_id => collection.removeFirst(f => f.id_() == request.number) match {
                  case Some(i) => println(s"\tDelete:\n$i")
                  case None => println("\tElement with such id doesn't exist") }
      case prog.ConnectionUtils.ConsoleCommand.clear => collection.clear()
      case prog.ConnectionUtils.ConsoleCommand.remove_head => collection.remove(0)
      case prog.ConnectionUtils.ConsoleCommand.remove_greater => collection.removeAll(f => f.hashCode() > request.flat.hashCode())
      case prog.ConnectionUtils.ConsoleCommand.remove_all_by_number_of_rooms => collection.removeAll(f => f.numberOfRooms_() == request.number)
    }
  }
}
