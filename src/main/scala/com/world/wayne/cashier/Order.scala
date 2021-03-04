package com.world.wayne.cashier

import com.world.wayne.common.Utilities._
import com.world.wayne.menu.Burgers.{Cheeseburger, Hamburger}
import com.world.wayne.menu.{Burgers, Items}
import com.world.wayne.report.DailyStatus

import java.util.Scanner
import scala.collection.mutable.ArrayBuffer

class Order(order: ArrayBuffer[Burgers], quantities: ArrayBuffer[Int]) {

  private final val ORDER_AND_QTY = order zip quantities

  val customerOrders: ArrayBuffer[Items] = {
    ORDER_AND_QTY.map(
      burgerType => burgerType._1.name match {
        case "Cheeseburger" => new Cheeseburger(burgerType._2)
        case "Hamburger" => new Hamburger(burgerType._2)
        case _ => throw new Exception("No such burger in the menu")
      }
    )
  }

  var orderTotal: Double = 0.0
  var numberOfItems: Int = 0
  var itemized: List[(String, Int, Double)] = List()

  final val BURGER_TYPE_INDEX = 0
  final val ORDER_QTY_INDEX = 1
  final val ORDER_TOTAL_INDEX = 2


  for(item <- customerOrders) {
    orderTotal += item.total.roundTwoDecimal
    numberOfItems += item.qty
    itemized:+= ((item.burgerType, item.qty, item.total.roundTwoDecimal))
  }
}

object Order {
  def apply() {
    val sc = new Scanner(System.in)

    val numOfHamBurger = screenInput(sc, "How many hamburger do you want?", "[0-9]+".r).toInt

    val numOfCheeseBurger = screenInput(sc, "How many cheeseburger do you want?", "[0-9]+".r).toInt

    var orders: ArrayBuffer[Burgers] = ArrayBuffer[Burgers]()
    var quantity: ArrayBuffer[Int] = ArrayBuffer[Int]()

    if (numOfCheeseBurger > 0) {
      orders += new Burgers("Cheeseburger")
      quantity += numOfCheeseBurger
    }

    if (numOfHamBurger > 0) {
      orders += new Burgers("Hamburger")
      quantity += numOfHamBurger
    }

    val newOrder = new Order(orders, quantity)
    TakePayment(sc, newOrder)

    DailyStatus.addOrder(newOrder)

    val hasNext = screenInput(sc, "Is there a next customer?", "(yes|no)".r)
    if (hasNext.toLowerCase == "yes") Order.apply()
  }
}
