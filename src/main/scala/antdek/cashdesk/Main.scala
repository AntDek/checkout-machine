package antdek.cashdesk

import antdek.cashdesk.CheckoutDesk.SaleCheckout
import antdek.cashdesk.SellItems.Apple

object Main extends App {

  val APPLE = Apple(0.60)
  val ORANGE = Apple(0.25)

  val checkoutDesk = new SaleCheckout()

  val itemsInBasket = List(APPLE, APPLE, ORANGE, APPLE)
  System.out.println("Total cost: " + checkoutDesk.calculatePrice(itemsInBasket))
}
