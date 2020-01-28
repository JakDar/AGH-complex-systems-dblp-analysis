package com.coding.guys.writers.edge

import com.coding.guys.writers.CsvDefinition

object Authored extends CsvDefinition{

  val headers = "author_name" :: "publication_key" :: Nil

  val filename = "authored.csv"


}
