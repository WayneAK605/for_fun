package com.world.wayne.menu

sealed case class Burgers(name: String)

object Burgers {

  class Hamburger(quantity: Int) extends Items {

    private final val UNIT_PRICE: BigDecimal = 1.19

    override def unitPrice: BigDecimal = UNIT_PRICE

    override def total: BigDecimal = (UNIT_PRICE * quantity)

    println(s"Ordered Hamburger Qty: $quantity @$$$unitPrice.  Total: " + "$" +  f"${total}%.2f Thank You!")

    override def qty: Int = quantity

    override def burgerType: String = "Hamburger"
  }

  class Cheeseburger(quantity: Int) extends Items {

    private final val UNIT_PRICE: BigDecimal = 1.39

    override def unitPrice: BigDecimal = UNIT_PRICE

    override def total: BigDecimal = (UNIT_PRICE * quantity)

    println(s"Ordered Cheeseburger Qty: $quantity @$$$unitPrice.  Total: " + "$" +  f"${total}%.2f Thank You!")

    override def qty: Int = quantity

    override def burgerType: String = "Cheeseburger"
  }
}
