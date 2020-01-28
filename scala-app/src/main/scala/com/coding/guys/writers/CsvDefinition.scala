package com.coding.guys.writers

trait CsvDefinition {
  def filename: String
  def headers: List[String]
}
