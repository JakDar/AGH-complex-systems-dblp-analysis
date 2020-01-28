package com.coding.guys.readers

import com.coding.guys.writers.CsvWriter
import com.coding.guys.writers.node.Persons
import org.dblp.mmdb.Mmdb

import scala.collection.JavaConverters._


object PersonProvider {

  def main(db: Mmdb, personwr: CsvWriter) = {
    db.getPersonNames.iterator().asScala.foreach(name =>
      personwr.write(Persons.key(name.name()) :: name.name() :: Nil)
    )

  }

}
