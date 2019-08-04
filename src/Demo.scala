object Demo extends App {
  // companion object is directly available
  // methods like apply, equals, toString, unapply, copy, hashcode available
  // pattern matching
  case class Amount(value: Double,currency: String)

  val twoDollars = Amount(2,"USD")

  println(twoDollars)

}
