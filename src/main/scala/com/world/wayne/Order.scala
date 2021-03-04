package com.world.wayne

import com.world.wayne.Burgers.{Cheeseburger, Hamburger}

import java.util.Scanner
import scala.collection.mutable.ArrayBuffer

class Order(order: Array[Burgers], quantities: Array[Int]) {

  private final val ORDER_AND_QTY = order zip quantities

  val customerOrders: Array[Menu] =
    ORDER_AND_QTY.map(
    burgerType => burgerType._1.name match {
      case "Cheeseburger" => new Cheeseburger(burgerType._2)
      case "Hamburger" => new Hamburger(burgerType._2)
      case _ => throw new Exception("No such burger in the menu")
    }
  )
}

object Order {
  def apply() {
    val sc = new Scanner(System.in)
    println("How many hamburger do you want?")
    val numOfHamBurger = sc.nextInt()

    println("How many cheeseburger do you want?")
    val numOfCheeseBurger = sc.nextInt()

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

    DailyStatus.addOrder(new Order(orders.toArray, quantity.toArray))

    println("Is there a next customer?")
    val hasNext = sc.next()
    if(hasNext.toLowerCase == "y") Order.apply()
  }
}
