package com.coding.guys.writers.node

import com.coding.guys.writers.CsvDefinition

object Publications extends CsvDefinition {
  val headers = List("key", "type", "title", "year")
  val filename: String = "publications.csv"
}
