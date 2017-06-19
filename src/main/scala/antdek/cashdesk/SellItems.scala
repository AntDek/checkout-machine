package antdek.cashdesk

object SellItems {

  sealed trait SellItem {
    def price: BigDecimal
  }

  case class Apple(price: BigDecimal) extends SellItem
  case class Orange(price: BigDecimal) extends SellItem

}
