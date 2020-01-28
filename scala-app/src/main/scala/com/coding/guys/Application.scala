package com.coding.guys

import cats.effect.IO
import com.coding.guys.readers.{CiteProvider, PersonProvider, PublicationProvider}
import com.coding.guys.writers.edge.{Authored, Cited, InVenue}
import com.coding.guys.writers.node.{Persons, Publications, Venues}
import com.coding.guys.writers.{BaseDir, CsvWriter}
import hero.common.logging.slf4j.LoggingConfigurator
import org.dblp.mmdb.Mmdb

class Application(config: ConfigValues) {

  LoggingConfigurator.setRootLogLevel(config.app.rootLogLevel)
  LoggingConfigurator.setLogLevel("com.coding.guys", config.app.appLogLevel)

  val small = "/home/owner/blob/data/data_mining/dblp/small_dblp.xml"
  val big = "/home/owner/blob/data/data_mining/dblp/dblp.xml"
  val xml: String = big
  implicit val csvDir: BaseDir = BaseDir("/home/owner/blob/data/data_mining/dblp/csv/")

  def recordDbParsing(): IO[Unit] = IO {

    val db = new Mmdb(xml, true)

    val pubWr = new CsvWriter(Publications)
    val authoredWr = new CsvWriter(Authored)
    val inVenueWr = new CsvWriter(InVenue)
    val venueVr = new CsvWriter(Venues)
    val pubWrs = List(pubWr, authoredWr, inVenueWr, venueVr)
    pubWrs.foreach(_.init())

    PublicationProvider.main(db, pubWr = pubWr, authoredWr = authoredWr, venueWr = venueVr, inVenueWr = inVenueWr)
    pubWrs.foreach(_.close())



        val personWr = new CsvWriter(Persons)
        personWr.init()
        PersonProvider.main(db, personWr)
        personWr.close()

        val citeWr = new CsvWriter(Cited)
        citeWr.init()
        CiteProvider.main(db, citeWr)
        citeWr.close()

  }
}

