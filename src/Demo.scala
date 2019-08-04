object Demo extends App {
  class Amount(val value: Double,val currency: String){
//    val amountValue = this.value
//    val amountCurrency = this.currency
    override def toString: String = s"Amount($value,$currency)"
  }
  val twoDollars = new Amount(2,"USD")
//  println(twoDollars.amountValue)
//  println(twoDollars.amountCurrency)

  // the parameters are accessible on addding val keyword in class
  println(twoDollars.value)
  println(twoDollars.currency)
}
