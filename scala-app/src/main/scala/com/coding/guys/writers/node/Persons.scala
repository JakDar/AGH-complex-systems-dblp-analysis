package com.coding.guys.writers.node

import com.coding.guys.writers.CsvDefinition

object Persons extends CsvDefinition {

  def key(name:String) = name.toLowerCase().trim + "_pers"
  val headers: List[String] = "key" :: "name" :: Nil
  val filename = "persons.csv"

}
