package libs.vecs

case class Vec2(x: Double, y: Double) {
  def +(other: Vec2) = Vec2(x + other.x, y + other.y)
}

given Conversion[(Double, Double), Vec2] with
  def apply(t: (Double, Double)) = Vec2(t._1, t._2)
