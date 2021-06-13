package libs.vecs

import utest.*
import scala.language.implicitConversions

object VecsTests extends TestSuite:
  val tests = Tests {

    test("Vec2") {
      test("have unary constructor") {
        Vec2(2) ==> Vec2(2, 2)
      }

      test("length") {
        Vec2(4, 3).length ==> 5
      }

      test("can add") {
        Vec2(2, 3) + Vec2(3, 4) ==> Vec2(5, 7)
        Vec2(2, 3) + 3 ==> Vec2(5, 6)
      }

      test("can multipy") {
        Vec2(2, 3) * Vec2(3, 4) ==> Vec2(6, 12)
        Vec2(2, 3) * 3 ==> Vec2(6, 9)
      }

      test("has dot") {
        Vec2(1, 2).dot(Vec2(2, 3)) ==> 8.0
        (Vec2(1, 2) dot Vec2(2, 3)) ==> 8.0
        val v1 = Vec2(1, 2)
        val v2 = Vec2(2, 3)
        val v3 = v1 dot v2
        val v4 = Vec2(1, 2) dot Vec2(2, 3)
        v3 ==> 8
        v4 ==> 8
      }

      test("convert tuples to vecs") {
        (2, 3) + (3, 4) ==> Vec2(5, 7)
        (2, 3) + 3 ==> Vec2(5, 6)
        (2, 3) * 2 ==> Vec2(4, 6)
      }

      test("normalize") {
        (0, 3).normalize ==> Vec2(0, 1)
        (2, 0).normalize ==> Vec2(1, 0)
        (2, 3).normalize ==> Vec2(2 / Math.sqrt(13), 3 / Math.sqrt(13))
      }
    }

    test("Vec3") {
      test("have compable constructor") {
        val v = Vec2(1, 2)
        Vec3(2) ==> Vec3(2, 2, 2)
        Vec3(3, v) ==> Vec3(3, 1, 2)
        Vec3(v, 3) ==> Vec3(1, 2, 3)
      }

      test("length") {
        Vec3(1, 2, 3).length ==> Math.sqrt(1 + 4 + 9)
      }

      test("can add") {
        Vec3(2, 3, 4) + Vec3(3, 4, 5) ==> Vec3(5, 7, 9)
        Vec3(2, 3, 4) + 3 ==> Vec3(5, 6, 7)
        3 + (2, 3, 4) ==> Vec3(5, 6, 7)
      }

      test("can multiply") {
        Vec3(2, 3, 4) * Vec3(1, 2, 3) ==> Vec3(2, 6, 12)
        Vec3(2, 3, 4) * 2 ==> Vec3(4, 6, 8)
        2 * (2, 3, 4) ==> Vec3(4, 6, 8)
      }

      test("has dot") {
        val v1 = Vec3(1, 2, 3)
        val v2 = Vec3(2, 3, 4)
        val v3 = v1 dot v2
        v3 ==> 20
      }

      test("normalize") {
        (0, 3, 0).normalize ==> Vec3(0, 1, 0)
        (2, 0, 0).normalize ==> Vec3(1, 0, 0)
        (0, 0, 1).normalize ==> Vec3(0, 0, 1)
        (2, 3, 4).normalize ==> Vec3(
          2 / Math.sqrt(29),
          3 / Math.sqrt(29),
          4 / Math.sqrt(29)
        )
      }

      test("convert tuples to vecs") {
        (2, 3, 4) + (3, 4, 5) ==> Vec3(5, 7, 9)
        (2, 3, 4) + 3 ==> Vec3(5, 6, 7)
      }

      test("have partial component accessors") {
        val v = Vec3(1, 2, 3)
        v.xy ==> Vec2(1, 2)
        v.yx ==> Vec2(2, 1)
        v.zyx ==> Vec3(3, 2, 1)
        v.xyz ==> v
        v.xxxx ==> Vec4(1)
      }
    }

    test("Vec4") {
      test("have composable constructor") {
        val v2 = (1, 2)
        val v3 = (1, 2, 3)
        Vec4(2) ==> Vec4(2, 2, 2, 2)
        Vec4(v3, 4) ==> Vec4(1, 2, 3, 4)
        Vec4(4, v3) ==> Vec4(4, 1, 2, 3)
        Vec4(v2, v2) ==> Vec4(1, 2, 1, 2)
        Vec4(v2, 3, 4) ==> Vec4(1, 2, 3, 4)
        Vec4(3, v2, 4) ==> Vec4(3, 1, 2, 4)
        Vec4(3, 4, v2) ==> Vec4(3, 4, 1, 2)
      }

      test("length") {
        Vec4(1, 2, 3, 4).length ==> Math.sqrt(1 + 4 + 9 + 16)
      }

      test("can add") {
        Vec4(2, 3, 4, 5) + Vec4(3, 4, 5, 6) ==> Vec4(5, 7, 9, 11)
        Vec4(2, 3, 4, 5) + 3 ==> Vec4(5, 6, 7, 8)
        3 + (2, 3, 4, 5) ==> Vec4(5, 6, 7, 8)
      }

      test("can multiply") {
        Vec4(2, 3, 4, 5) * Vec4(1, 2, 3, 4) ==> Vec4(2, 6, 12, 20)
        Vec4(2, 3, 4, 5) * 2 ==> Vec4(4, 6, 8, 10)
        2 * (2, 3, 4, 5) ==> Vec4(4, 6, 8, 10)
      }

      test("has dot") {
        val v1 = Vec4(1, 2, 3, 4)
        val v2 = Vec4(2, 3, 4, 5)
        val v3 = v1 dot v2
        v3 ==> 40
      }

      test("normalize") {
        (0, 3, 0, 0).normalize ==> Vec4(0, 1, 0, 0)
        (2, 0, 0, 0).normalize ==> Vec4(1, 0, 0, 0)
        (0, 0, 0, 1).normalize ==> Vec4(0, 0, 0, 1)
        (2, 3, 4, 5).normalize ==> Vec4(
          2 / Math.sqrt(54),
          3 / Math.sqrt(54),
          4 / Math.sqrt(54),
          5 / Math.sqrt(54)
        )
      }

      test("have partial component accessors") {
        val v = Vec4(1, 2, 3, 4)
        v.xy ==> Vec2(1, 2)
        v.yx ==> Vec2(2, 1)
        v.zyx ==> Vec3(3, 2, 1)
        v.xyz ==> Vec3(1, 2, 3)

        v.zyxw ==> Vec4(3, 2, 1, 4)
        v.xyzw ==> v
        v.www ==> Vec3(4, 4, 4)
      }

      test("convert tuples to vecs") {
        (2, 3, 4, 5) + (3, 4, 5, 6) ==> Vec4(5, 7, 9, 11)
        (2, 3, 4, 5) + 3 ==> Vec4(5, 6, 7, 8)
      }
    }
  }
