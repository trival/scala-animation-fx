package libs
import scala.collection.*

type GridPos = (Int, Int)

case class Grid[+V](
    val width: Int,
    val height: Int,
    val map: immutable.HashMap[GridPos, V] = immutable.HashMap()
) extends immutable.Iterable[(GridPos, V)]
    with IterableOps[(GridPos, V), Grid, Grid[V]]:

  // === implement abstract methods ===

  // Members declared in scala.collection.IterableOnce
  def iterator = map.iterator

  def getPos(x: Int, y: Int) = ???
  def set[V1 >: V](k: GridPos, v: V1): Grid[V1] =
    Grid(width, height, map.updated(k, v))

  def getCol(x: Int) =
    for y <- 0 until height
    yield getPos(x, y)

  def getRow(y: Int) =
    for x <- 0 until width
    yield getPos(x, y)

  override def iterableFactory: IterableFactory[Grid] =
    map.iterableFactory.asInstanceOf[IterableFactory[Grid]]
  override protected def fromSpecific[V1 >: V](
      coll: IterableOnce[V1]
  ): Grid[V] =
    iterableFactory.from(coll).asInstanceOf[Grid[V]]
  override protected def newSpecificBuilder[V1 >: V]
      : mutable.Builder[(GridPos, V1), Grid[V1]] =
    iterableFactory.newBuilder
      .asInstanceOf[mutable.Builder[(GridPos, V1), Grid[V1]]]
end Grid
