package libs

import utest.*

object GridTests extends TestSuite:
  val tests = Tests {
    val p00 = 0 -> 0 -> "0,0"
    val p10 = 1 -> 0 -> "1,0"
    val p01 = 0 -> 1 -> "0,1"
    val p11 = 1 -> 1 -> "1,1"
    val p02 = 0 -> 2 -> "0,2"
    val p12 = 1 -> 2 -> "1,2"

    test("Grid as collection") {
      var g = Grid(2, 2).set(p00)

      g.get(1 -> 2) ==> None
      g.get(0 -> 1) ==> None

      g += p01
      g.get(0 -> 1) ==> Some("0,1")
    }

    test("row and collumn operations") {
      val g = Grid(2, 3) ++ Seq(p00, p10, p01, p11, p02, p12)

      g.getRow(0) ==> Seq(Some(p00._2), Some(p10._2))
    }
  }
