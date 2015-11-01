package eu.timepit.refined
package scalacheck

import eu.timepit.refined.auto._
import eu.timepit.refined.numeric._
import eu.timepit.refined.scalacheck.TestUtils._
import eu.timepit.refined.scalacheck.numeric._
import eu.timepit.refined.util.time.Minute
import org.scalacheck.Prop._
import org.scalacheck.Properties

class NumericArbitrarySpec extends Properties("NumericArbitrary") {

  property("Less.positive") = checkArbitrary[Int, Less[W.`100`.T]]

  property("Less.negative") = checkArbitrary[Int, Less[W.`-100`.T]]

  property("LessEqual.positive") = checkArbitrary[Int, LessEqual[W.`42`.T]]

  property("LessEqual.negative") = checkArbitrary[Int, LessEqual[W.`-42`.T]]

  property("Greater.positive") = checkArbitrary[Int, Greater[W.`100`.T]]

  property("Greater.negative") = checkArbitrary[Int, Greater[W.`-100`.T]]

  property("GreaterEqual.positive") = checkArbitrary[Int, GreaterEqual[W.`123456`.T]]

  property("GreaterEqual.negative") = checkArbitrary[Int, GreaterEqual[W.`-123456`.T]]

  property("Interval.Open") = checkArbitrary[Int, Interval.Open[W.`-23`.T, W.`42`.T]]

  property("Interval.OpenClosed") = checkArbitrary[Double, Interval.OpenClosed[W.`2.71828`.T, W.`3.14159`.T]]

  property("Interval.ClosedOpen") = checkArbitrary[Double, Interval.ClosedOpen[W.`-2.71828`.T, W.`3.14159`.T]]

  property("Interval.Closed") = checkArbitrary[Int, Interval.Closed[W.`23`.T, W.`42`.T]]

  property("Interval.alias") = forAll { m: Minute =>
    m >= 0 && m <= 59
  }
}