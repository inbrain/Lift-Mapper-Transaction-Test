package com.transacttest.rest

import net.liftweb.http.OkResponse
import net.liftweb.http.rest.RestHelper
import net.liftweb.common.Loggable
import com.transacttest.model.{Contact, User}

/**
 */

object TestRest extends RestHelper with Loggable {

  serve {
    "test" :: "transaction" :: Nil prefix {
      case JsonGet(_, _) =>
        User.create.name("user").save()
        interruptExecution()
        Contact.create.name("contact").save()
        OkResponse()
    }
  }

  def interruptExecution() {
    throw new IllegalStateException()
  }

}



