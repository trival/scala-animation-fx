package libs.vecs

import utest.*
import scala.language.implicitConversions

object VecsTests extends TestSuite:
  val tests = Tests {

    test("Vec2") {
      test("have unary constructor") {
        Vec2(2) ==> Vec2(2, 2)
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
    }

    test("Vec3") {
      test("have unary constructor") {
        Vec3(2) ==> Vec3(2, 2, 2)
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

      test("convert tuples to vecs") {
        (2, 3, 4) + (3, 4, 5) ==> Vec3(5, 7, 9)
        (2, 3, 4) + 3 ==> Vec3(5, 6, 7)
      }
    }

    test("Vec4") {
      test("have unary constructor") {
        Vec4(2) ==> Vec4(2, 2, 2, 2)
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

      test("convert tuples to vecs") {
        (2, 3, 4, 5) + (3, 4, 5, 6) ==> Vec4(5, 7, 9, 11)
        (2, 3, 4, 5) + 3 ==> Vec4(5, 6, 7, 8)
      }
    }
  }
