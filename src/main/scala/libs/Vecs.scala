package libs.vecs

import scala.language.implicitConversions


// === Vec2 ===

case class Vec2(x: Double, y: Double):
  inline def apply(a: Double) = Vec2(a, a)
  inline def +(v: Vec2) = Vec2(x + v.x, y + v.y)
  inline def +(a: Double) = Vec2(a + x, a + y)
  inline def *(v: Vec2) = Vec2(x * v.x, y * v.y)
  inline def *(a: Double) = Vec2(a * x, a * y)

  inline infix def dot(v: Vec2): Double = x * v.x + y * v.y
end Vec2

case object Vec2:
  inline def apply(a: Double): Vec2 = Vec2(a, a)
end Vec2

// === Vec3 ===

case class Vec3(x: Double, y: Double, z: Double):
  inline def +(v: Vec3) = Vec3(x + v.x, y + v.y, z + v.z)
  inline def +(a: Double) = Vec3(a + x, a + y, a + z)
  inline def *(v: Vec3) = Vec3(x * v.x, y * v.y, z * v.z)
  inline def *(a: Double) = Vec3(a * x, a * y, a * z)
  inline infix def dot(v: Vec3): Double = x * v.x + y * v.y + z * v.z
end Vec3

case object Vec3:
  inline def apply(a: Double): Vec3 = Vec3(a, a, a)
end Vec3

// === Vec4 ===

case class Vec4(x: Double, y: Double, z: Double, w: Double):
  inline def +(v: Vec4) = Vec4(x + v.x, y + v.y, z + v.z, w + v.w)
  inline def +(a: Double) = Vec4(a + x, a + y, a + z, w + a)
  inline def *(v: Vec4) = Vec4(x * v.x, y * v.y, z * v.z, w * v.w)
  inline def *(a: Double) = Vec4(a * x, a * y, a * z, w * a)
  inline infix def dot(v: Vec4): Double = x * v.x + y * v.y + z * v.z + w * v.w
end Vec4

case object Vec4:
  inline def apply(a: Double): Vec4 = Vec4(a, a, a, a)
end Vec4

// === Extensions ===

extension (d: Double) 
  inline def +(v: Vec2) = v + d
  inline def +(v: Vec3) = v + d
  inline def +(v: Vec4) = v + d

  inline def *(v: Vec2) = v * d
  inline def *(v: Vec3) = v * d
  inline def *(v: Vec4) = v * d
end extension

// === Conversions ===

given Conversion[(Double, Double), Vec2] with
  inline def apply(t: (Double, Double)) = Vec2(t._1, t._2)

given Conversion[(Int, Int), Vec2] with
  inline def apply(t: (Int, Int)) = Vec2(t._1, t._2)

given Conversion[Vec2, (Double, Double)] with
  inline def apply(v: Vec2) = (v.x, v.y)

given Conversion[(Double, Double, Double), Vec3] with
  inline def apply(t: (Double, Double, Double)) = Vec3(t._1, t._2, t._3)

given Conversion[(Int, Int, Int), Vec3] with
  inline def apply(t: (Int, Int, Int)) = Vec3(t._1, t._2, t._3)

given Conversion[Vec3, (Double, Double, Double)] with
  inline def apply(v: Vec3) = (v.x, v.y, v.z)

given Conversion[(Double, Double, Double, Double), Vec4] with
  inline def apply(t: (Double, Double, Double, Double)) = Vec4(t._1, t._2, t._3, t._4)

given Conversion[(Int, Int, Int, Int), Vec4] with
  inline def apply(t: (Int, Int, Int, Int)) = Vec4(t._1, t._2, t._3, t._4)

given Conversion[Vec4, (Double, Double, Double, Double)] with
  inline def apply(v: Vec4) = (v.x, v.y, v.z, v.w)
