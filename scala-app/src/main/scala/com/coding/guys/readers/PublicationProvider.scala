package com.coding.guys.readers

import com.coding.guys.writers.CsvWriter
import com.coding.guys.writers.node.{Persons, Venues}
import org.dblp.mmdb.{Mmdb, RecordDb}

import scala.collection.JavaConverters._


object PublicationProvider {


  def main(db: Mmdb, pubWr: CsvWriter, authoredWr: CsvWriter, inVenueWr: CsvWriter, venueWr: CsvWriter): Unit = {

    val savedVenues = scala.collection.mutable.Set.empty[String]

    db.publications().iterator().asScala.foreach(x => {

      val title = x.getFields("title").asScala.head.value()


      val labelledVenue = List(
        ("journal", Option(x.getJournal).map(_.getTitle)),
        ("book", Option(x.getBooktitle).map(_.getTitle)),
        ("school", x.getFields("school").asScala.headOption.map(_.value())),
        ("publisher", x.getFields("publisher").asScala.headOption.map(_.value()))
      ).find(_._2.isDefined).map { case (t, value) => (t, value.get) }

      labelledVenue.foreach { case (venueType, venueName) =>
        val venueKey = Venues.key(venueName)
        if (!savedVenues.contains(venueKey)) {
          venueWr.write(List(venueKey, venueName, venueType))
          savedVenues += venueKey
        }

        inVenueWr.write(List(x.getKey, venueKey))
      }


      pubWr.write(List(x.getKey, x.getTag, title, x.getYear.toString))


      x.getNames.asScala.map(_.name).foreach(name =>
        authoredWr.write(List(Persons.key(name), x.getKey))
      )

    }
    )
  }

}
