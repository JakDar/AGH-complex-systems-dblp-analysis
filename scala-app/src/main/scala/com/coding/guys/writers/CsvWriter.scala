package com.coding.guys.writers

import java.io.{BufferedWriter, File, FileWriter}


class CsvWriter(definition: CsvDefinition)(implicit baseDir: BaseDir) {


  private val name = baseDir.dir + definition.filename
  val sep = ","

  val file = new File(name)
  lazy val fr = new BufferedWriter(new FileWriter(file))

  def init(): Unit = {
    file.mkdirs()
    file.delete()
    file.createNewFile()
    write(definition.headers)
  }

  def write(words: List[String]): Unit =
    fr.write(words.map(_
      .replace(sep, "")
      .replace("\"", "")
      .replace("\u007F", "")
      .replace("'", ""))
      .mkString(sep) + "\n")

  def close(): Unit = fr.close()

}
