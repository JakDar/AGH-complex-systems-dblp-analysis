package com.coding.guys.writers.edge

import com.coding.guys.writers.CsvDefinition

object InVenue extends CsvDefinition {
  override def filename: String = "in_venue.csv"

  override def headers: List[String] = "publication_key" :: "venue_name" :: Nil
}
