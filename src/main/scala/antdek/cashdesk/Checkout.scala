package antdek.cashdesk

import antdek.cashdesk.SellItems.SellItem

class Checkout() {

  def calculatePrice(items: List[SellItem]): BigDecimal = {
    items.map(_.price).sum
  }

}
