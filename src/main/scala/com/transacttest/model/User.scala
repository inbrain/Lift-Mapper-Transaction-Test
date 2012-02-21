package com.transacttest.model

import net.liftweb.mapper._

/**
 */

class User extends LongKeyedMapper[User] with IdPK {

  def getSingleton = User

  object name extends MappedString(this, 100)

}


object User extends User with LongKeyedMetaMapper[User] {
  override def dbTableName = "user"
}


