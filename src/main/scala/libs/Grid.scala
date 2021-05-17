package libs
import scala.collection.*
import scala.annotation.unchecked.uncheckedVariance

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

  override def iterableFactory =
    map.iterableFactory.asInstanceOf[IterableFactory[
      [X0] =>> scala.collection.immutable.Iterable[X0] & libs.Grid[X0]
    ]]
  override protected def fromSpecific(
      coll: IterableOnce[(libs.GridPos, V) @uncheckedVariance]
  ): Grid[V] =
    iterableFactory
      .from(coll.asInstanceOf[IterableOnce[V]])
      .asInstanceOf[Grid[V]]
  override protected def newSpecificBuilder
      : mutable.Builder[(libs.GridPos, V) @uncheckedVariance, libs.Grid[V]] =
    iterableFactory.newBuilder
      .asInstanceOf[collection.mutable.Builder[(libs.GridPos, V), libs.Grid[
        V
      ]]]

end Grid
