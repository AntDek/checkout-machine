package antdek.cashdesk

import antdek.cashdesk.SellItems.{Apple, Orange}
import org.scalatest.{FunSuite, Matchers}

class CheckoutTest extends FunSuite with Matchers {

  val apple = Apple(5.5)
  val orange = Orange(10.3)

  test("checkout desk should sum items values") {
    val items = List(apple, apple, orange)
    val checkoutDesc = new AllCheckout()

    val expectedResult = items.map(_.price).sum

    expectedResult should be (checkoutDesc.calculatePrice(items))
  }

  test("sale checkout should calculate apples with action price") {
    val items = List(apple, apple, apple)
    val checkoutDesc = new SaleCheckout()

    val expectedResult: BigDecimal = apple.price * 2

    expectedResult should be (checkoutDesc.calculatePrice(items))
  }

  test("sale checkout should calculate oranges with action price") {
    val items = List(orange, orange, orange)
    val checkoutDesc = new SaleCheckout()

    val expectedResult = orange.price * 2

    expectedResult should be (checkoutDesc.calculatePrice(items))
  }
}
