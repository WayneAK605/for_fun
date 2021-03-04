package com.world.wayne

import com.world.wayne.Burgers.{Cheeseburger, Hamburger}

import java.util.Scanner
import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex

class Order(order: ArrayBuffer[Burgers], quantities: ArrayBuffer[Int]) {

  private final val ORDER_AND_QTY = order zip quantities

  val customerOrders: ArrayBuffer[Items] =
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

    DailyStatus.addOrder(new Order(orders, quantity))

    val hasNext = screenInput(sc, "Is there a next customer?", "(yes|no)".r)
    if(hasNext.toLowerCase == "yes") Order.apply()
  }

  def screenInput(sc: Scanner, prompt: String, userPromptRegexPattern: Regex): String ={

    var loop = true
    var userInput: String = null

    while(loop) {
      print(s"$prompt [${userPromptRegexPattern.toString()}]==> ")

      userPromptRegexPattern.findFirstIn(sc.nextLine()) match {
         case Some(f) => {
           loop = false
           userInput = f
         }
         case None => loop = true
       }
    }
    userInput
  }
}
