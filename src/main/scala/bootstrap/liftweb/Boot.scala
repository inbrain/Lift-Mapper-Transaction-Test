package bootstrap.liftweb

import net.liftweb._
import util._
import net.liftweb.common._
import net.liftweb.http._
import mapper.{DB, DefaultConnectionIdentifier, StandardDBVendor}
import com.transacttest.rest.TestRest
import com.transacttest.schema.Schema

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot extends Loggable{
  def boot() {
    if (!DB.jndiJdbcConnAvailable_?) {
      val vendor = new StandardDBVendor(
        Props.get("db.driver") open_!,
        Props.get("db.url") open_!,
        Props.get("db.user"),
        Props.get("db.password"))

      LiftRules.unloadHooks.append(vendor.closeAllConnections_! _)

      DB.defineConnectionManager(DefaultConnectionIdentifier, vendor)
    }

    List(
      TestRest
    ).foreach(service => {
      LiftRules.dispatch.append(service)
    })

    S.addAround(DB.buildLoanWrapper())

    Schema.destroy()
    Schema.create()
  }
}
