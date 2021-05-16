package libs
import scala.collection.immutable.*
import scala.collection.{MapFactoryDefaults, Map}

type GridPos = (Int, Int)

case class Grid[K >: GridPos, +V](
    val width: Int,
    val height: Int,
    val map: HashMap[K, V] = HashMap()
) extends Iterable[V]
    with Map[K, V]
    with MapOps[K, V, Grid, Grid[K, V]]
    with MapFactoryDefaults[K, V, Grid, Iterable]:

  // === implement abstract methods ===

  // Members declared in scala.collection.IterableOnce
  def iterator: Iterator[(K, V)] = map.iterator
  // Members declared in scala.collection.MapOps
  def get(pos: K): Option[V] = map.get(pos)
  // Members declared in scala.collection.immutable.MapOps
  def removed(pos: K): Grid[K, V] = Grid(width, height, map.removed(pos))
  def updated[V1 >: V](pos: K, value: V1): Grid[K, V1] =
    Grid(width, height, map.updated(pos, value))

  def getCol(x: Int) =
    for y <- 0 until height
    yield get(x, y)

  def getRow(y: Int) =
    for x <- 0 until width
    yield get(x, y)
