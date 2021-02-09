package prog

import prog.IO.WriteToFile
import Main._


object ConsoleHandler {
  def handler(input: String) {
    var line = input
    while (line.contains("  ")) line = line.trim.replaceAll("\\s\\s", " ")
    val command = line.split(" ", 2)
//    TODO: add history of commands and catch exceptions
//    TODO: add validation for zero input for some commands
    command(0).trim match {
      case "help" => println(help)
      case "info" => println("\tType of collection is: " + collection.getClass + "\n\t" +
        "Initialization time is: " + start.toString + "\n\t" +
        "Collection size is: " + collection.size + "\n\t" +
        "Collection hash-code is: " + collection.hashCode())
      case "show" =>
        if (collection.isEmpty) println("\tCollection is empty")
        else collection.foreach(f => println(f))
      case "remove_by_id" => collection.removeFirst(f => f.id_() == command(1).toInt) match {
        case Some(i) => println(s"\tDelete:\n$i")
        case None => println("\tElement with such id doesn't exist")
      }
      case "clear" =>
        collection.clear()
        println("\tCollection is cleared")
      case "save" => WriteToFile.writeToFile(filename, collection)
      case "exit" => sys.exit()
      case "remove_head" => println("\tDelete:" + collection.remove(0))

      case "remove_all_by_number_of_rooms" =>
        val size = collection.size
        collection.removeAll(f => f.numberOfRooms_() == command(1).toInt)
        println("\tDelete " + (size-collection.size) + " elements")
      case "count_by_number_of_rooms" => println("\t" + collection.count(f => f.numberOfRooms_() == command(1).toInt))
      case "print_field_descending_view" =>
        if (collection.isEmpty) println("\tCollection is empty, can't show you anything")
        else collection.sortBy(-_.hashCode()).foreach(x => println("\t" + x.view_()))
      case _ => Console.err.println("\tYou write wrong command, type 'help' to get list of commands")
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
