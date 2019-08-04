import java.time.LocalDateTime
import java.util.UUID

sealed trait Plan
case object Monthly extends Plan
case object BiAnnual extends Plan
case object Annual extends Plan

sealed trait Subscribable

case class Channel(name: String) extends Subscribable
case class TVPackage(name: String, channels: Set[Channel]) extends Subscribable

case class SubscriptionPeriod(startDate: LocalDateTime, endDate: LocalDateTime)
case class Subscription(name: String
                        , defaultTVPackages: Map[TVPackage, Plan]
                        , additionalTVPackages: Map[TVPackage, Plan]
                        , additionalChannels: Map[Channel, Plan]
                        , subscriptionPeriod: SubscriptionPeriod) extends Subscribable

case class Subscribed(name: String)

case class User(name: String, accountId: UUID)

// a type class
trait Subscriber[T] {
  def subscribe(subscribable: T, user: User): Subscribed
}

object Subscriber {
  //instances of Subscriber type class
  implicit val channelSubscriber: Subscriber[Channel] = new Subscriber[Channel] {
    override def subscribe(subscribable: Channel, user: User): Subscribed = {
      Subscribed(s"${subscribable.name}")
    }
  }

  implicit val tvPackageSubscriber: Subscriber[TVPackage] = new Subscriber[TVPackage] {
    override def subscribe(subscribable: TVPackage, user: User): Subscribed = {
      Subscribed(s"${subscribable.name}")
    }
  }

  implicit val subscriptionSubscriber: Subscriber[Subscription] = new Subscriber[Subscription] {
    override def subscribe(subscribable: Subscription, user: User): Subscribed = {
      Subscribed(s"${subscribable.name}")
    }
  }
}

// use type classes
object SubscriberOps{
  def subscribe[T](subscribable: T, user: User)(implicit ev: Subscriber[T]) : Subscribed =
    ev.subscribe(subscribable,user)
}

object DthDemo extends App {
  import SubscriberOps._

  val user = User("Alice",UUID.randomUUID())
  val channelOne = Channel("One")

  val userSubscribed = subscribe(channelOne,user)
  println(s"Subscribed name: ${userSubscribed.name}")
}