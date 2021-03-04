package com.world.wayne

import com.world.wayne.report.DailyStatus
import com.world.wayne.cashier._

object FastFood {
  def main(args: Array[String]): Unit = {
    Order.apply()
    DailyStatus.printDailyStats()
  }
}
