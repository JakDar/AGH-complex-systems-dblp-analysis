package com.coding.guys.readers

import com.coding.guys.writers.CsvWriter
import org.dblp.mmdb.Mmdb

import scala.collection.JavaConverters._

object CiteProvider {


  def main(db: Mmdb, citeWr: CsvWriter): Unit = {
    db.records().iterator().asScala.filter(r => r.getFieldReader.contains("cite") && r.getTag != "person").foreach { record =>


      record.getFieldReader.getFields("cite").asScala.foreach(
        cited =>
          citeWr.write(List(record.getKey, cited.value()))
      )

    }
  }
}
