package com.world.wayne

sealed case class Burgers(name: String)

object Burgers {

  class Hamburger(quantity: Int) extends Menu {

    private final val UNIT_PRICE: Float = 1.19f

    override def unitPrice: Float = UNIT_PRICE

    override def total: Float = UNIT_PRICE * quantity

    println(s"Ordered Hamburger Qty: $quantity.  Total: " + "$" +  s"${total} Thank You!")

    override def qty: Int = quantity

    override def burgerType: String = "Hamburger"
  }

  class Cheeseburger(quantity: Int) extends Menu {

    private final val UNIT_PRICE: Float = 1.39f

    override def unitPrice: Float = UNIT_PRICE

    override def total: Float = UNIT_PRICE * quantity

    println(s"Ordered Hamburger Qty: $quantity.  Total: " + "$" +  s"${total} Thank You!")

    override def qty: Int = quantity

    override def burgerType: String = "Cheeseburger"
  }
}
