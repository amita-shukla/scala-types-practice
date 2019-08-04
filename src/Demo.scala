object Demo extends App {
  class Amount(val value: Double,val currency: String){
    override def toString: String = s"Amount($value,$currency)"
  }

  // object creates a singleton object for utility methods
  // these methods need not be instantiated everytime you create an amount instance
  object AmountUtils {
    def convert(from: Amount, to:String): Amount = {
      val conversionRate = 69.45
      new Amount(from.value* conversionRate, to)
    }
  }

  import AmountUtils._
  val twoDollars = new Amount(2,"USD")
//  val twoDollarsEqINR = AmountUtils.convert(twoDollars,"INR")
  val twoDollarsEqINR = convert(twoDollars,"INR")
  println(twoDollarsEqINR)

}
