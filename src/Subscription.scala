import java.time.LocalDateTime

case class Channel(name: String)

case class TVPackage(name: String, channels: Set[Channel])

sealed trait Plan

case object Monthly extends Plan

case object BiAnnual extends Plan

case object Annual extends Plan

case class SubscriptionPeriod(startDate: LocalDateTime, endDate: LocalDateTime)

case class Subscription(name: String
                        , defaultTVPackages: Map[TVPackage, Plan]
                        , additionalTVPackages: Map[TVPackage, Plan]
                        , additionalChannels: Map[Channel, Plan]
                        , subscriptionPeriod: SubscriptionPeriod)

object DthDemo extends App {
  val channelOne = Channel("One")
  val channelTwo = Channel("Two")
  val sportsChannelOne = Channel("SportsOne")
  val sportsChannelTwo = Channel("SportsTwo")

  val tvPackageGen = TVPackage("GenPack", Set(channelOne, channelTwo, sportsChannelOne))
  val tvPackageSports = TVPackage("SportsPack", Set(sportsChannelOne, sportsChannelTwo))
  val goldSubscription = Subscription(
    "Gold"
    , Map(tvPackageGen -> Annual)
    , Map(tvPackageSports -> Monthly)
    , Map()
    , SubscriptionPeriod(LocalDateTime.of(2019, 5, 9, 12, 0)
      , LocalDateTime.of(2019, 5, 9, 12, 0)))

  println(goldSubscription.subscriptionPeriod)
}