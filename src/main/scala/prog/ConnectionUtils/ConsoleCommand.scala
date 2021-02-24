package prog.ConnectionUtils

object ConsoleCommand extends Enumeration {
  type ConsoleCommand = Value
  val help,  info ,show ,add, update, remove_by_id, clear, execute_script, remove_head, remove_greater, history,
  remove_all_by_number_of_rooms, count_by_number_of_rooms, print_field_descending_view = Value

}
