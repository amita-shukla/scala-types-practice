object Demo extends App {
  class Amount(val value: Double,val currency: String){
    override def toString: String = s"Amount($value,$currency)"
  }

  // companion object
  object Amount{
    def apply(value: Double, currency : String): Amount = new Amount(value,currency)
    def apply(value: Double): Amount = new Amount(value,"USD")
  }

  val twoDollars = new Amount(2,"USD")
  val twoUSDollars = Amount(2)

  println(twoDollars)
  println(twoUSDollars)

}
