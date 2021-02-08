import java.time.format.DateTimeFormatter
import scala.xml._
"   ya ebal teb9 v rot ".trim.replaceAll("\\s\\s", " ").split("ya ebal")

Math.log(8)/Math.log(2)
java.time.LocalDate.now.format(DateTimeFormatter.ofPattern("dd-MM-YYYY"))

val text =
  <file>
    <flat>
      <id>1</id>
      <name>Parent's flat</name>
      <coordinates>
        <x>1</x>
        <y>1.2</y>
      </coordinates>
      <creation-date>20.08.1997</creation-date>
      <area>null</area>  <!-- can be null-->
      <number-of-rooms>2</number-of-rooms>
      <furnish>null</furnish>  <!-- can be null-->
      <view>null</view>
      <transport>null</transport>  <!-- can be null-->
      <house>
        <name>Pobedi 76</name>
        <year>1958</year>
        <number-of-lifts>5</number-of-lifts>
      </house>
    </flat>
    <flat>
      <id>2</id>
      <name>my flat flat</name>
      <coordinates>
        <x>4</x>
        <y>4.1</y>
      </coordinates>
      <creation-date>26.10.2019</creation-date>
      <area>null</area>  <!-- can be null-->
      <number-of-rooms>1</number-of-rooms>
      <furnish>null</furnish>  <!-- can be null-->
      <view>null</view>
      <transport>null</transport>  <!-- can be null-->
      <house>
        <name>Pobedi 76</name>
        <year>1958</year>
        <number-of-lifts>5</number-of-lifts>
      </house>
    </flat>
  </file>


val list = text.map(x => x \\ "flat")

