package com.world.wayne.cashier

import com.world.wayne.common.Utilities._

import java.util.Scanner

object TakePayment {
  def apply(sc: Scanner, order: Order) = {
    val orderTotal = getOrderTotal(order)
    val payment = screenInput(sc, s"Your total is $orderTotal.  Please enter your payment => ", "^\\d+(\\.\\d{1,2}$)".r).toDouble.roundTwoDecimal

   TakePayment(sc, orderTotal, payment)
  }

  def getOrderTotal(order: Order): Double = {
    order.orderTotal
  }

  private def TakePayment(sc: Scanner, orderTotal: Double, payment: Double):Double = {
    if (orderTotal - payment == 0.00) {
      println("Thank you for your business!  Have a great day!")
      0.0
    } else if(payment > orderTotal) {
      println(s"Thank you!  Here is your change: ${payment - orderTotal}")
      0.0
    } else {
      val newPayment = screenInput(sc, s"Your remaining balance is ${orderTotal - payment}.  Please enter your payment => ", "^\\d+(\\.\\d{1,2}$)".r)
      TakePayment(sc,  orderTotal - payment, newPayment.toDouble)
    }
  }
}
