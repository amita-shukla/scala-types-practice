object Demo extends App {
  class Amount(value: Double, currency: String){
    override def toString: String = s"Amount($value,$currency)"
  }
  val twoDollars = new Amount(2,"USD")
  println(twoDollars) // prints Amount(2.0,USD)
}
