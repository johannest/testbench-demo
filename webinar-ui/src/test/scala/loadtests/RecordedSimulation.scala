import io.gatling.core.body.ElFileBody
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import io.gatling.http.request.ExtraInfo
import io.gatling.http.check.HttpCheck
import io.gatling.http.check.HttpCheck
import io.gatling.commons.validation.Validation
import io.gatling.http.check.HttpCheckScope
import io.gatling.http.response.ResponseBodyUsageStrategy
import io.gatling.core.check.Check
import io.gatling.core.check.CheckResult

import scala.collection.mutable

import io.gatling.commons.validation.Validation
import io.gatling.core.check.{ CheckResult, Check }
import io.gatling.core.session.Session
import io.gatling.http.response.{ Response, ResponseBodyUsageStrategy }

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8080")
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:49.0) Gecko/20100101 Firefox/49.0")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")
	val headers_1 = Map("Accept" -> "*/*")
	val headers_4 = Map("Accept" -> "text/css,*/*;q=0.1")
	val headers_5 = Map("Content-Type" -> "application/json; charset=UTF-8")

  val initSyncAndClientIds = exec((session) => {
      session.setAll( 
          "syncId" -> 0,
          "clientId" -> 0
        )
  })
    
  val logIds = exec((session) => {
      println("SyncId: "+(session("syncId").as[String]))
      println("ClientId: "+(session("clientId").as[String]))
      session
  })

  val syncIdExtract = regex("""syncId": ([0-9]*),""").saveAs("syncId")
  val clientIdExtract = regex("""clientId": ([0-9]*),""").saveAs("clientId")
  
  object Login {
    val loginFeeder = csv("test-data.csv").circular
    
	  val login = exec(http("request_0")
			.get("/ui")
			.headers(headers_0))
		.pause(143 milliseconds)
		.exec(http("request_3")
			.post("/ui?v-1476724510846")
			.formParam("v-browserDetails", "1")
			.formParam("theme", "mytheme")
			.formParam("v-appId", "ROOT-2521314")
			.formParam("v-sh", "800")
			.formParam("v-sw", "1280")
			.formParam("v-cw", "1280")
			.formParam("v-ch", "590")
			.formParam("v-curdate", "1476724510846")
			.formParam("v-tzo", "-180")
			.formParam("v-dstd", "60")
			.formParam("v-rtzo", "-120")
			.formParam("v-dston", "true")
			.formParam("v-vw", "1280")
			.formParam("v-vh", "0")
			.formParam("v-loc", "http://localhost:8080/ui")
			.formParam("v-wn", "ROOT-2521314-0.9997585510716186")
    )
		.pause(6)
    .feed(loginFeeder)
    .exec(initSyncAndClientIds)
    .exec(logIds)
		.exec(http("request_5")
			.post("/UIDL/?v-uiId=0")
			.headers(headers_5)
			.body(ElFileBody("RecordedSimulation_0005_request.txt"))
      .check(syncIdExtract).check(clientIdExtract)
     )
    .exec(logIds)
		.pause(1)
		.exec(http("request_6")
			.post("/UIDL/?v-uiId=0")
			.headers(headers_5)
			.body(ElFileBody("RecordedSimulation_0006_request.txt"))
      .check(syncIdExtract).check(clientIdExtract)
    )
		.pause(5)
    .exec(logIds)
  }

  object InsertNewProduct {
		val doInsert = exec(http("request_7")
			.post("/UIDL/?v-uiId=0")
			.headers(headers_5)
			.body(ElFileBody("RecordedSimulation_0007_request.txt"))
      .check(syncIdExtract).check(clientIdExtract)
    )
    .exec(logIds)
		.pause(5)
		.exec(http("request_8")
			.post("/UIDL/?v-uiId=0")
			.headers(headers_5)
			.body(ElFileBody("RecordedSimulation_0008_request.txt"))
      .check(syncIdExtract).check(clientIdExtract)
    )
    .exec(logIds)
		.pause(141 milliseconds)
		.exec(http("request_9")
			.post("/UIDL/?v-uiId=0")
			.headers(headers_5)
			.body(ElFileBody("RecordedSimulation_0009_request.txt"))
      .check(syncIdExtract).check(clientIdExtract)
    )
    .exec(logIds)
		.pause(211 milliseconds)
		.exec(http("request_10")
			.post("/UIDL/?v-uiId=0")
			.headers(headers_5)
			.body(ElFileBody("RecordedSimulation_0010_request.txt"))
      .check(syncIdExtract).check(clientIdExtract)
    )
		.pause(4)
    .exec(logIds)
  }

  object Logout {
		val logout = exec(http("request_11")
			.post("/UIDL/?v-uiId=0")
			.headers(headers_5)
			.body(ElFileBody("RecordedSimulation_0011_request.txt"))
    )
		.exec(http("request_12")
			.get("/ui")
			.headers(headers_0))
		.exec(http("request_16")
			.post("/ui?v-1476724537393")
			.formParam("v-browserDetails", "1")
			.formParam("theme", "mytheme")
			.formParam("v-appId", "ROOT-2521314")
			.formParam("v-sh", "800")
			.formParam("v-sw", "1280")
			.formParam("v-cw", "1280")
			.formParam("v-ch", "590")
			.formParam("v-curdate", "1476724537393")
			.formParam("v-tzo", "-180")
			.formParam("v-dstd", "60")
			.formParam("v-rtzo", "-120")
			.formParam("v-dston", "true")
			.formParam("v-vw", "1280")
			.formParam("v-vh", "0")
			.formParam("v-loc", "http://localhost:8080/ui#!Inventory/")
			.formParam("v-wn", "ROOT-2521314-0.9997585510716186"))
  }

  val users = scenario("RecordedSimulation").exec(Login.login,InsertNewProduct.doInsert,Logout.logout)

	setUp(users.inject( rampUsers(10) over (5 seconds)) ).protocols(httpProtocol)
}