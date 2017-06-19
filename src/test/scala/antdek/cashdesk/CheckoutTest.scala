package antdek.cashdesk

import antdek.cashdesk.SellItems.{Apple, Orange}
import org.scalatest.{FunSuite, Matchers}

class CheckoutTest extends FunSuite with Matchers {

  val apple = Apple(5.5)
  val orange = Orange(10.3)

  test("checkout desk should sum items values") {
    val items = List(apple, apple, orange)
    val checkoutDesck = new Checkout()

    val expectedResult = items.map(_.price).sum

    expectedResult should be (checkoutDesck.calculatePrice(items))
  }
}
