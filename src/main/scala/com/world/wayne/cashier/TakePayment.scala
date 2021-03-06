package com.world.wayne.cashier

import com.world.wayne.common.Utilities._

import java.util.Scanner

object TakePayment {

  def apply(sc: Scanner, order: Order) = {
    val orderTotal = getOrderTotal(order)
    val orderTax = getSalesTaxes(order)
    val payment = screenInput(sc, s"Your total is $$$orderTotal + $$$orderTax (Sales Taxes) = $$${orderTotal + orderTax}.  Please enter your payment => ", "^\\d+([.]\\d{2}$)".r).toDouble.roundTwoDecimal

    TakePayment(sc, orderTotal + orderTax, payment)
  }

  def getOrderTotal(order: Order): BigDecimal = {
    order.orderTotal
  }

  def getSalesTaxes(order: Order): BigDecimal = {
    order.salesTaxes
  }

  private def TakePayment(sc: Scanner, orderTotal: BigDecimal, payment: BigDecimal): BigDecimal = {
    if (orderTotal - payment == 0.00) {
      println("Thank you for your business!  Have a great day!")
      0.0
    } else if (payment > orderTotal) {
      println(s"Thank you!  Here is your change: $$${payment - orderTotal}")
      0.0
    } else {
      val newPayment = screenInput(sc, s"Your remaining balance is $$${orderTotal - payment}.  Please enter your payment => ", "^\\d+([.]\\d{2}$)".r)
      TakePayment(sc, orderTotal - payment, newPayment.toDouble.roundTwoDecimal)
    }
  }
}
