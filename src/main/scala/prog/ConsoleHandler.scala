package prog

import scala.collection.mutable
import prog.Client._
import prog.ConnectionUtils.ConsoleCommand
import prog.Model.FlatReader


object ConsoleHandler {
  val history = new mutable.Queue[String]
  def handler(input: String) {
    try {
      var line = input
      while (line.contains("  ")) line = line.trim.replaceAll("\\s\\s", " ")
      val command = line.split(" ", 2)
      command(0).trim match {
        case "help" => println(help)
        case "info" => println("\tType of collection is: " + collection.getClass + "\n\t" +
          "Initialization time is: " + start.toString + "\n\t" +
          "Collection size is: " + collection.size + "\n\t" +
          "Collection hash-code is: " + collection.hashCode())
        case "show" =>
          if (collection.isEmpty) println("\tCollection is empty")
          else collection.foreach(f => println(f))
        case "add" =>
          request.command_(ConsoleCommand.add)
          request.flat_(FlatReader.stringToFlat(command(1).trim))
        case "update" =>
          request.command_(ConsoleCommand.update)
          val updateCommand = command(1).trim.split(" ", 2)
          val id = updateCommand(0).trim.toInt
          request.number_(id)
          request.flat_(FlatReader.stringToFlat(updateCommand(1).trim, id))
        case "remove_by_id" =>
          request.command_(ConsoleCommand.remove_by_id)
          request.number_(command(1).trim.toInt)
        case "clear" => request.command_(ConsoleCommand.clear)
        case "execute_script" => // TODO: rework readCommands
//          ReadFromFile.readCommands(command(1).trim)
        case "exit" => sys.exit()
        case "remove_head" =>  request.command_(ConsoleCommand.remove_head)
        case "remove_greater" =>  request.command_(ConsoleCommand.remove_greater)
        case "history" => history.foreach(line => println(s"\t$line"))
        case "remove_all_by_number_of_rooms" =>
          request.command_(ConsoleCommand.remove_all_by_number_of_rooms)
          request.number_(command(1).trim.toInt)
        case "count_by_number_of_rooms" => println("\t" + collection.count(f => f.numberOfRooms_() == command(1).trim.toInt))
        case "print_field_descending_view" =>
          if (collection.isEmpty) println("\tCollection is empty, can't show you anything")
          else collection.sortBy(-_.hashCode()).foreach(x => println("\t" + x.view_()))
        case _ => println("\tYou write wrong command, type 'help' to get list of commands")
      }
      history += command(0)
      if (history.size > 10) history.remove(0)
    } catch {
      case e : Throwable => Console.err.println("\tProblem execution the command:\n\t" + e.getMessage)
    }
  }

  private val help: String =
    """    help : вывести справку по доступным командам
      |    info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
      |    show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
      |    add {element} : добавить новый элемент в коллекцию
      |    update id {element} : обновить значение элемента коллекции, id которого равен заданному
      |    remove_by_id id : удалить элемент из коллекции по его id
      |    clear : очистить коллекцию
      |    save : сохранить коллекцию в файл
      |    execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
      |    exit : завершить программу (без сохранения в файл)
      |    remove_head : вывести первый элемент коллекции и удалить его
      |    remove_greater {element} : удалить из коллекции все элементы, превышающие заданный (сравниваются хэш-коды)
      |    history : вывести последние 10 команд (без их аргументов)
      |    remove_all_by_number_of_rooms numberOfRooms : удалить из коллекции все элементы, значение поля numberOfRooms которого эквивалентно заданному
      |    count_by_number_of_rooms numberOfRooms : вывести количество элементов, значение поля numberOfRooms которых равно заданному
      |    print_field_descending_view : вывести значения поля view всех элементов в порядке убывания (убывания хэш-кодов)""".stripMargin
}
