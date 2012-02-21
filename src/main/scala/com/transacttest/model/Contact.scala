package com.transacttest.model

import net.liftweb.mapper._

/**
 */

class Contact extends LongKeyedMapper[Contact] with IdPK {

  def getSingleton = Contact

  object name extends MappedString(this, 100)

}


object Contact extends Contact with LongKeyedMetaMapper[Contact] {
  override def dbTableName = "contact"
}


