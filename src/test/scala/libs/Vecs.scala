package libs.vecs

import utest.*
import scala.language.implicitConversions

object VecsTests extends TestSuite:
  val tests = Tests {

    test("Vec2") {
      test("can add") {
        Vec2(2, 3) + Vec2(3, 4) ==> Vec2(5, 7)
      }

      test("convert tuples to vecs") {
        Vec2(2, 3) + (3.0, 4.0) ==> Vec2(5, 7)
      }
    }
  }
