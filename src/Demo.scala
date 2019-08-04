object Demo extends App {
  class Amount(value: Double, currency: String)
  val twoDollars = new Amount(2,"USD")
  println(twoDollars) // prints Demo$Amount@13c27452
}
