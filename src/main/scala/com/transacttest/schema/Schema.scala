package com.transacttest.schema

import net.liftweb.mapper.{BaseMetaMapper, Schemifier}
import com.transacttest.model.{Contact, User}

/**
 * @author Yaroslav Klymko
 */
object Schema {
  lazy val tables = List[BaseMetaMapper](
    Contact, User)

  def create() {
    Schemifier.schemify(true, Schemifier.infoF _, tables: _*)
  }

  def destroy() {
    Schemifier.destroyTables_!!(Schemifier.infoF _, tables: _*)
  }
}

