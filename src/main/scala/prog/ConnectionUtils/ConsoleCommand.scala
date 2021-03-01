package prog.ConnectionUtils

object ConsoleCommand extends Enumeration {
  type ConsoleCommand = Value
  val add, update, remove_by_id, clear, remove_head, remove_greater, remove_all_by_number_of_rooms, initial = Value
}
