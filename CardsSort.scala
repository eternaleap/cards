import scala.util.Random
import scala.collection.mutable.ArrayBuffer

object CardsSort {

  val random = new Random()
  val maxCapacity = 52
  var cards = ArrayBuffer.range(0, maxCapacity)

  def getRandom: Int = {
    random.nextInt(maxCapacity)
  }

  def swapCards(first: Int, second: Int): Unit = {
    val swappedValue = cards(first);
    cards(first) = cards(second);
    cards(second) = swappedValue;
  }

  def moveSomeCards() = {
    cards.splitAt(getRandom)
  }

  def isSordedProperly(): Boolean = {
    for (i <- cards.indices)
      if (i != cards(i))
        return false
    return true
  }

  def main(args: Array[String]) {
    for (card <- cards) // mess with the cards
      swapCards(card, getRandom)

    var i : Int = 0

    while(!isSordedProperly) { // try to sort cards back in hope we're lucky ones
      val splittedCards = moveSomeCards
      cards = splittedCards._2 ++ splittedCards._1
      i += 1
      println(cards)
    }

    println("Total sorts: " + i)
    println(cards)
  }

}
