package antdek.cashdesk

import antdek.cashdesk.SellItems.Apple

object Main extends App {

  val APPLE = Apple(0.60)
  val ORANGE = Apple(0.25)

  val checkoutDesk = new AllCheckout()

  val itemsInBasket = List(APPLE, APPLE, ORANGE, APPLE)
  System.out.println(checkoutDesk.calculatePrice(itemsInBasket))
}
