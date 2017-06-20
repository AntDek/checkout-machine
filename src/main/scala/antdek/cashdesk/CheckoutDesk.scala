package antdek.cashdesk

import antdek.cashdesk.SellItems.{Apple, Orange, SellItem}

object CheckoutDesk {

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
      val appleCount = groupedByType.getOrElse(1, Nil).size
      val applePrice: BigDecimal = if (appleCount == 0) 0 else groupedByType(1).head.price

      val orangeCount = groupedByType.getOrElse(2, Nil).size
      val orangePrice: BigDecimal = if (orangeCount == 0) 0 else groupedByType(2).head.price

      calculateHalfPrice(applePrice, appleCount) +
        calculateTwoForThreePrice(orangePrice, orangeCount)
    }

    private def calculateHalfPrice(price: BigDecimal, itemsCount: Int): BigDecimal = {
      price * Math.ceil(itemsCount / 2.0)
    }

    private def calculateTwoForThreePrice(price: BigDecimal, itemsCount: Int): BigDecimal = {
      2 * price * Math.floor(itemsCount / 2.0) + price * (itemsCount % 3)
    }
  }
}
