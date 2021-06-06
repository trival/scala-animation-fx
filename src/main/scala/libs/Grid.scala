package libs.grid

import scala.collection.immutable.{HashMap}

type GridPos = (Int, Int)

case class Grid[+V](
    val width: Int,
    val height: Int,
    private val map: HashMap[GridPos, V] = HashMap()
):
  def get(x: Int, y: Int) = map.get((x, y))
  def get(pos: GridPos) = map.get(pos)

  def set[V1 >: V](k: GridPos, v: V1): Grid[V1] =
    Grid(width, height, map.updated(k, v))
  def set[V1 >: V](v1: (GridPos, V1)): Grid[V1] =
    val (k, v) = v1
    set(k, v)

  def concat[V1 >: V](vals: Iterable[(GridPos, V1)]) =
    Grid(width, height, map ++ vals)

  inline def +[V1 >: V](x: (GridPos, V1)): Grid[V1] = set(x)
  inline def ++[V1 >: V](xs: Iterable[(GridPos, V1)]): Grid[V1] = concat(xs)

  def getCol(x: Int) =
    for y <- 0 until height
    yield get(x, y)

  def getRow(y: Int) =
    for x <- 0 until width
    yield get(x, y)
