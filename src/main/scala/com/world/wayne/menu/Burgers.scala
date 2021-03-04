package com.world.wayne.menu

import com.world.wayne.common.Utilities.roundingEnhance

sealed case class Burgers(name: String)

object Burgers {

  class Hamburger(quantity: Int) extends Items {

    private final val UNIT_PRICE: Double = 1.19

    override def unitPrice: Double = UNIT_PRICE.roundTwoDecimal

    override def total: Double = (UNIT_PRICE * quantity).roundTwoDecimal

    println(s"Ordered Hamburger Qty: $quantity @$$$unitPrice.  Total: " + "$" +  f"${total}%.2f Thank You!")

    override def qty: Int = quantity

    override def burgerType: String = "Hamburger"
  }

  class Cheeseburger(quantity: Int) extends Items {

    private final val UNIT_PRICE: Double = 1.390.roundTwoDecimal

    override def unitPrice: Double = UNIT_PRICE.roundTwoDecimal

    override def total: Double = (UNIT_PRICE * quantity).roundTwoDecimal

    println(s"Ordered Cheeseburger Qty: $quantity @$$$unitPrice.  Total: " + "$" +  f"${total}%.2f Thank You!")

    override def qty: Int = quantity

    override def burgerType: String = "Cheeseburger"
  }
}
