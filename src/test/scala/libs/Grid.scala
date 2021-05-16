package libs

import utest.*

object GridTests extends TestSuite:
  val tests = Tests {
    test("Grid as collection") {
      val p1 = 0 -> 0 -> "0,0"
      val p2 = 1 -> 0 -> "1,0"
      val p3 = 0 -> 1 -> "0,1"
      val p4 = 1 -> 1 -> "1,0"

      var g = Grid[String](2, 2) + p1

      g.get(1 -> 2) ==> None
      g.get(0 -> 1) ==> None

      g += p3
      g.get(0 -> 1) ==> Some("0,1")
      g(0 -> 1) ==> "0,1"
    }
  }
