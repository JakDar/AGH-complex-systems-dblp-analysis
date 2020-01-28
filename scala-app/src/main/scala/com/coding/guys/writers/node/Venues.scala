package com.coding.guys.writers.node

import com.coding.guys.writers.CsvDefinition

object Venues extends CsvDefinition {
  def key(name: String) = name.toLowerCase().trim + "_venue"

  override def filename: String = "venues.csv"

  override def headers: List[String] = "key" :: "name" :: "type" :: Nil
}
