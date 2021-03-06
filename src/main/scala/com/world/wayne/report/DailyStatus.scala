package com.world.wayne.report

import com.world.wayne.cashier.Order

object DailyStatus {
  private var numberOfCustomer: Int = 0
  private var numberOfItem: Int = 0
  private var totalProfit: BigDecimal = 0

  def addOrder(order: Order) = {
    numberOfCustomer += 1
    numberOfItem += order.numberOfItems
    totalProfit += order.grandOrderTotal
  }

  def printDailyStats() = {
    println(f"Total profit: $$$totalProfit%.2f")
    println(s"Total $numberOfCustomer customers with $numberOfItem items ordered")
  }
}
