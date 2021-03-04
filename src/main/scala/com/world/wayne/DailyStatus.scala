package com.world.wayne

object DailyStatus {
  private var numberOfCustomer: Int = 0
  private var numberOfItem: Int = 0
  private var totalProfit: Float = 0f

  def addOrder(order: Order) = {
    for (item <- order.customerOrders) {
      numberOfItem += 1
      totalProfit += item.total
    }
    numberOfCustomer += 1 // Assuming one customer one order
  }

  def printDailyStats () = {
    println (f"Total profit: $$$totalProfit%.2f")
    println (s"Total $numberOfCustomer customers with $numberOfItem items ordered")
  }
}
