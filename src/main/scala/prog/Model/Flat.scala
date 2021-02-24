package prog.Model

import prog.Model.Furnish.Furnish
import prog.Model.Transport.Transport
import prog.Model.View.View
import prog.Server.collection

import java.time.LocalDate

class Flat(val id: Int = IdGenerator.getId, name: String, coordinates: Coordinates,
           creationDate: LocalDate = java.time.LocalDate.now, area: Float, numberOfRooms : Int,
           furnish: Furnish = Furnish.NONE, view: View, transport: Transport = Transport.NONE, house: House, legal: Boolean = true) {
  if (id <= 0) throw new IllegalArgumentException("id must be more than 0")
//  if (legal && collection.exists(f => f.id_() == id)) throw new IllegalArgumentException("id already in use, can't create this flat")
  if (name == null) throw new IllegalArgumentException("name can't be null")
  if (name.isEmpty) throw new IllegalArgumentException("name must be longer than 0")
  if (coordinates == null) throw new IllegalArgumentException("coordinates can't be null")
  if (creationDate == null) throw new IllegalArgumentException("creationDate can't be null")
  if (area <= 0) throw new IllegalArgumentException("area must be more than 0")
  if (numberOfRooms <= 0) throw new IllegalArgumentException("numberOfRooms must be more than 0")
  if (furnish == null) throw new IllegalArgumentException("furnish can't be null")
  if (house == null) throw new IllegalArgumentException("house can't be null")

  def id_(): Int = id
  def numberOfRooms_(): Int = numberOfRooms
  def view_(): View = view
  override def toString: String = s"\tFlat {id: $id; name: $name; $coordinates; creation date: $creationDate; area: $area; " +
    s"number of rooms: $numberOfRooms; \n\t\tfurnish: $furnish; view: $view; transport: $transport; $house; hashCode: $hashCode()}"

  /**
   * @return String(xml Node) from Flat object that would be written to file
   */
  def toXml: String =
    <flat>
      <id>{ id }</id>
      <name>{ name }</name>
      <coordinates>
        <x>{ coordinates.x() }</x>
        <y>{ coordinates.y() }</y>
      </coordinates>
      <creation-date>{ creationDate }</creation-date>
      <area>{ area }</area>  <!-- can be null-->
      <number-of-rooms>{ numberOfRooms }</number-of-rooms>
      <furnish>{ furnish }</furnish>  <!-- can be null-->
      <view>{ view }</view>
      <transport>{ transport }</transport>  <!-- can be null-->
      <house>
        <name>{ house.name() }</name>
        <year>{ house.year() }</year>
        <number-of-lifts>{ house.numberOfFloors() }</number-of-lifts>
      </house>
    </flat>.toString()
}
