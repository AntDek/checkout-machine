package antdek.cashdesk

import antdek.cashdesk.SellItems.{Apple, Orange, SellItem}

sealed trait Checkout {
  def calculatePrice(items: List[SellItem]): BigDecimal
}

class AllCheckout extends Checkout {

  override def calculatePrice(items: List[SellItem]): BigDecimal = {
    items.map(_.price).sum
  }

}

class SaleCheckout extends Checkout {
  override def calculatePrice(items: List[SellItem]): BigDecimal = {
    val groupedByType = items.groupBy {
      case i: Apple => 1
      case v: Orange => 2
    }
    calculateHalfPrice(groupedByType.getOrElse(1, Nil)) +
      calculateTwoForThreePrice(groupedByType.getOrElse(2, Nil))
  }

  private def calculateHalfPrice(items: List[SellItem]): BigDecimal = {
    val item = items.headOption
    val price: BigDecimal = if (item.isDefined) item.get.price else 0
    price * Math.ceil(items.size / 2.0)
  }

  private def calculateTwoForThreePrice(items: List[SellItem]): BigDecimal = {
    val item = items.headOption
    val price: BigDecimal = if (item.isDefined) item.get.price else 0

    2 * price * Math.floor(items.size / 2.0) + price * (items.size % 3)
  }
}
