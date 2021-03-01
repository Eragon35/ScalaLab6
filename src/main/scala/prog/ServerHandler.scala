package prog

import prog.ConnectionUtils.{ConsoleCommand, Request, Response, ServerAnswer}
import prog.Server.collection

object ServerHandler {
  def handler(request: Request): Response = {
    val size = collection.size
    request.command match {
      case ConsoleCommand.initial => new Response(collection, "initial response")
      case ConsoleCommand.add => collection.addOne(request.flat)
        new Response(collection, "Element was added")
      case ConsoleCommand.update => collection.update(collection.indexWhere(f => f.id_() == request.number), request.flat)
        collection.size - size match {
          case 1 => new Response(collection, "Element was updated")
          case 0 => new Response(collection, "Element with such id doesn't exist")
          case _ => new Response(collection, "Something goes wrong", ServerAnswer.Error)
        }
      case ConsoleCommand.remove_by_id => collection.removeFirst(f => f.id_() == request.number) match {
        case Some(i) => new Response(collection, s"Delete:\n$i")
        case None => new Response(collection,"Element with such id doesn't exist")
      }
      case ConsoleCommand.clear => collection.clear()
        new Response(collection, "Collection was cleared")
      case ConsoleCommand.remove_head => val temp = collection.remove(0)
        new Response(collection, s"Delete $temp")
      case ConsoleCommand.remove_greater => val temp = collection.removeAll(f => f.hashCode() > request.flat.hashCode()).size
        new Response(collection, s"Delete $temp elements")
      case ConsoleCommand.remove_all_by_number_of_rooms => val temp = collection.removeAll(f => f.numberOfRooms_() == request.number).size
        new Response(collection, s"Delete $temp elements")
      case _ => new Response(collection, "Unknown command", ServerAnswer.Error)
    }
  }
}
