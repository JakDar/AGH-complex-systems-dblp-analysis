package com.coding.guys.writers.edge

import com.coding.guys.writers.CsvDefinition

object Cited extends CsvDefinition {
  override def filename: String = "cited.csv"

  override def headers: List[String] = "citing" :: "cited" :: Nil
}
