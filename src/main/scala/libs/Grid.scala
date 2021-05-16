package libs
import scala.collection.immutable.*

type GridPos = (Int, Int)

case class Grid[+V](
    val width: Int,
    val height: Int,
    val map: HashMap[GridPos, V] = HashMap()
) extends Map[GridPos, V]:

  // === implement abstract methods ===

  // Members declared in scala.collection.IterableOnce
  def iterator: Iterator[((Int, Int), V)] = map.iterator
  // Members declared in scala.collection.MapOps
  def get(pos: GridPos): Option[V] = map.get(pos)
  // Members declared in scala.collection.immutable.MapOps
  def removed(pos: GridPos): Grid[V] = Grid(width, height, map.removed(pos))
  def updated[V1 >: V](pos: GridPos, value: V1): Grid[V1] =
    Grid(width, height, map.updated(pos, value))
