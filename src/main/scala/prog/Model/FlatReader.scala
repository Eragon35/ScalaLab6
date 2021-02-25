package prog.Model

import java.time.LocalDate
import scala.xml.Node

/**
 * parse xml node
 *
 * @return Option[Flat] if all is ok
 *         else return None
 */
object FlatReader {
  def fromXml(node: Node): Option[Flat] = {
    try {
      val id = (node \ "id").text.toInt
      val name = (node \ "name").text
      val coordinates = new Coordinates((node \ "coordinates" \ "x").text.toLong, (node \ "coordinates" \ "y").text.toFloat)
      val creationDate = LocalDate.parse((node \ "creation-date").text)
      val area = (node \ "area").text.toFloat
      val numberOfRooms = (node \ "number-of-rooms").text.toInt
      val furnish = Furnish.withName((node \ "furnish").text)
      val view = View.withName((node \ "view").text)
      val transport = Transport.withName((node \ "transport").text)
      val house = new House((node \ "house" \ "name").text, (node \ "house" \ "year").text.toInt, (node \ "house" \ "number-of-lifts").text.toInt)

      Option(new Flat(id, name, coordinates, creationDate, area, numberOfRooms, furnish, view, transport, house))
    } catch {
      case e: Throwable => Console.err.println("\tProblem with parsing Flat from xml\n\t" + e.getMessage)
        None
    }
  }

  def stringToFlat(line: String, id: Int = IdGenerator.getId): Flat = line match {
    case s"Flat {name: $name; Coordinates ($x, $y); creation date: $date; area: $area; number of rooms: $rooms; furnish: $furnish; view: $view; transport: $transport; House: $houseName (year: $year, number of floors: $floors)}" =>
      new Flat(id = id, name = name, coordinates = new Coordinates(x.toLong, y.toFloat), creationDate = LocalDate.parse(date), area = area.toFloat,
        numberOfRooms = rooms.toInt, furnish = Furnish.withName(furnish), view = View.withName(view), transport = Transport.withName(transport),
        house = new House(houseName, year.toInt, floors.toInt), legal = false)

    case s"Flat {name: $name; Coordinates ($x, $y); creation date: $date; area: $area; number of rooms: $rooms; furnish: $furnish; view: $view; House: $houseName (year: $year, number of floors: $floors)}" =>
      new Flat(id = id, name = name, coordinates = new Coordinates(x.toLong, y.toFloat),
        creationDate = LocalDate.parse(date), area = area.toFloat, numberOfRooms = rooms.toInt, furnish = Furnish.withName(furnish),
        view = View.withName(view), house = new House(houseName, year.toInt, floors.toInt), legal = false)

    case s"Flat {name: $name; Coordinates ($x, $y); creation date: $date; area: $area; number of rooms: $rooms; view: $view; transport: $transport; House: $houseName (year: $year, number of floors: $floors)}" =>
      new Flat(id = id, name = name, coordinates = new Coordinates(x.toLong, y.toFloat),
        creationDate = LocalDate.parse(date), area = area.toFloat, numberOfRooms = rooms.toInt, view = View.withName(view),
        transport = Transport.withName(transport), house = new House(houseName, year.toInt, floors.toInt), legal = false)

    case s"Flat {name: $name; Coordinates ($x, $y); creation date: $date; area: $area; number of rooms: $rooms; view: $view; House: $houseName (year: $year, number of floors: $floors)}" =>
      new Flat(id = id, name = name, coordinates = new Coordinates(x.toLong, y.toFloat), creationDate = LocalDate.parse(date), area = area.toFloat,
        numberOfRooms = rooms.toInt, view = View.withName(view), house = new House(houseName, year.toInt, floors.toInt), legal = false)

    case _ => throw new IllegalArgumentException("can't parse Flat from you input string")
  }
}
