package com.world.wayne.menu

trait Items {
  def qty: Int

  def burgerType: String

  def unitPrice: BigDecimal

  def total: BigDecimal
}
