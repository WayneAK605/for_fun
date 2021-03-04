package com.world.wayne

object DailyStatus {
  private var numberOfCustomer: Int = 0
  private var totalProfit: Float = 0f

  def addOrder(order: Order) = {
    for (item <- order.customerOrders) {
      numberOfCustomer += 1
      totalProfit += item.total
    }
  }

  def printDailyStats () = {
    println (f"Total profit: $$$totalProfit%.2f")
    println (s"Total customer: $numberOfCustomer")
  }
}
