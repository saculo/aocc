package utils

import scala.io.Source
import scala.util.Using

object FileReader {
  def getInput(path: String): Seq[String] = {
    Using(Source.fromFile(path)) { source => source.getLines().toSeq }.get
  }
}
