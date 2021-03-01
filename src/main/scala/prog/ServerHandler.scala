package prog

import prog.ConnectionUtils.{ConsoleCommand, Request}
import prog.Server.collection

object ServerHandler {
  def handler(request: Request): Any = {
    request.command match {
      case ConsoleCommand.initial =>
      case ConsoleCommand.add => collection.addOne(request.flat)
      case ConsoleCommand.update => collection.update(collection.indexWhere(f => f.id_() == request.number), request.flat)
      case ConsoleCommand.remove_by_id => collection.removeFirst(f => f.id_() == request.number) match {
        case Some(i) => println(s"\tDelete:\n$i")
        case None => println("\tElement with such id doesn't exist")
      }
      case ConsoleCommand.clear => collection.clear()
      case ConsoleCommand.remove_head => collection.remove(0)
      case ConsoleCommand.remove_greater => collection.removeAll(f => f.hashCode() > request.flat.hashCode())
      case ConsoleCommand.remove_all_by_number_of_rooms => collection.removeAll(f => f.numberOfRooms_() == request.number)
    }
  }
}
