package libs.vecs

// === Vec2 ===

case class Vec2(x: Double, y: Double):
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

case class Vec3(x: Double, y: Double, z: Double)
    extends PartialVectors3(x, y, z):
  inline def +(v: Vec3) = Vec3(x + v.x, y + v.y, z + v.z)
  inline def +(a: Double) = Vec3(a + x, a + y, a + z)
  inline def *(v: Vec3) = Vec3(x * v.x, y * v.y, z * v.z)
  inline def *(a: Double) = Vec3(a * x, a * y, a * z)
  inline infix def dot(v: Vec3): Double = x * v.x + y * v.y + z * v.z
end Vec3

case object Vec3:
  inline def apply(a: Double): Vec3 = Vec3(a, a, a)
  inline def apply(v: Vec2, a: Double): Vec3 = Vec3(v.x, v.y, a)
  inline def apply(a: Double, v: Vec2): Vec3 = Vec3(a, v.x, v.y)
end Vec3

// === Vec4 ===

case class Vec4(x: Double, y: Double, z: Double, w: Double)
    extends PartialVectors3(x, y, z),
      PartialVectors4(x, y, z, w):
  inline def +(v: Vec4) = Vec4(x + v.x, y + v.y, z + v.z, w + v.w)
  inline def +(a: Double) = Vec4(a + x, a + y, a + z, w + a)
  inline def *(v: Vec4) = Vec4(x * v.x, y * v.y, z * v.z, w * v.w)
  inline def *(a: Double) = Vec4(a * x, a * y, a * z, w * a)
  inline infix def dot(v: Vec4): Double = x * v.x + y * v.y + z * v.z + w * v.w
end Vec4

case object Vec4:
  inline def apply(a: Double): Vec4 = Vec4(a, a, a, a)
  inline def apply(v: Vec3, a: Double): Vec4 = Vec4(v.x, v.y, v.z, a)
  inline def apply(a: Double, v: Vec3): Vec4 = Vec4(a, v.x, v.y, v.z)
  inline def apply(v1: Vec2, v2: Vec2): Vec4 = Vec4(v1.x, v1.y, v2.x, v2.y)
  inline def apply(v: Vec2, a: Double, b: Double): Vec4 = Vec4(v.x, v.y, a, b)
  inline def apply(a: Double, v: Vec2, b: Double): Vec4 = Vec4(a, v.x, v.y, b)
  inline def apply(a: Double, b: Double, v: Vec2): Vec4 = Vec4(a, b, v.x, v.y)
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
  inline def apply(t: (Double, Double, Double, Double)) =
    Vec4(t._1, t._2, t._3, t._4)

given Conversion[(Int, Int, Int, Int), Vec4] with
  inline def apply(t: (Int, Int, Int, Int)) = Vec4(t._1, t._2, t._3, t._4)

given Conversion[Vec4, (Double, Double, Double, Double)] with
  inline def apply(v: Vec4) = (v.x, v.y, v.z, v.w)

// === partial vector factories ===

trait PartialVectors3(x: Double, y: Double, z: Double):
  inline def xy = Vec2(x, y)
  inline def xz = Vec2(x, z)
  inline def yx = Vec2(y, x)
  inline def yz = Vec2(y, z)
  inline def zx = Vec2(z, x)
  inline def zy = Vec2(z, y)

  inline def xyz = Vec3(x, y, z)
  inline def xzy = Vec3(x, z, y)
  inline def yxz = Vec3(y, x, z)
  inline def yzx = Vec3(y, z, x)
  inline def zxy = Vec3(z, x, y)
  inline def zyx = Vec3(z, y, x)

  inline def xx = Vec2(x)
  inline def yy = Vec2(y)
  inline def zz = Vec2(z)

  inline def xxx = Vec3(x)
  inline def yyy = Vec3(y)
  inline def zzz = Vec3(z)

  inline def xxxx = Vec4(x)
  inline def yyyy = Vec4(y)
  inline def zzzz = Vec4(z)
end PartialVectors3

trait PartialVectors4(x: Double, y: Double, z: Double, w: Double):
  inline def xyzw = Vec4(x, y, z, w)
  inline def xzyw = Vec4(x, z, y, w)
  inline def yxzw = Vec4(y, x, z, w)
  inline def yzxw = Vec4(y, z, x, w)
  inline def zxyw = Vec4(z, x, y, w)
  inline def zyxw = Vec4(z, y, x, w)

  inline def xywz = Vec4(x, y, w, z)
  inline def xzwy = Vec4(x, z, w, y)
  inline def yxwz = Vec4(y, x, w, z)
  inline def yzwx = Vec4(y, z, w, x)
  inline def zxwy = Vec4(z, x, w, y)
  inline def zywx = Vec4(z, y, w, x)

  inline def xwyz = Vec4(x, w, y, z)
  inline def xwzy = Vec4(x, w, z, y)
  inline def ywxz = Vec4(y, w, x, z)
  inline def ywzx = Vec4(y, w, z, x)
  inline def zwxy = Vec4(z, w, x, y)
  inline def zwyx = Vec4(z, w, y, x)

  inline def wxyz = Vec4(w, x, y, z)
  inline def wxzy = Vec4(w, x, z, y)
  inline def wyxz = Vec4(w, y, x, z)
  inline def wyzx = Vec4(w, y, z, x)
  inline def wzxy = Vec4(w, z, x, y)
  inline def wzyx = Vec4(w, z, y, x)

  inline def wxz = Vec3(w, x, z)
  inline def wxy = Vec3(w, x, y)
  inline def wyz = Vec3(w, y, z)
  inline def wyx = Vec3(w, y, x)
  inline def wzy = Vec3(w, z, x)
  inline def wzx = Vec3(w, z, y)

  inline def xwz = Vec3(x, w, z)
  inline def xwy = Vec3(x, w, y)
  inline def ywz = Vec3(y, w, z)
  inline def ywx = Vec3(y, w, x)
  inline def zwy = Vec3(z, w, y)
  inline def zwx = Vec3(z, w, x)

  inline def xyw = Vec3(x, y, w)
  inline def xzw = Vec3(x, z, w)
  inline def yzw = Vec3(y, z, w)
  inline def yxw = Vec3(y, x, w)
  inline def zyw = Vec3(z, y, w)
  inline def zxw = Vec3(z, x, w)

  inline def xw = Vec2(x, w)
  inline def yw = Vec2(y, w)
  inline def zw = Vec2(z, w)

  inline def wx = Vec2(w, x)
  inline def wy = Vec2(w, y)
  inline def wz = Vec2(w, z)

  inline def ww = Vec2(w, w)
  inline def www = Vec3(w, w, w)
  inline def wwww = Vec4(w, w, w, w)
end PartialVectors4
