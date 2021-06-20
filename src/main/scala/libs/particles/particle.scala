package libs.particles

import xyz.trival.libs.math.vecs.*

trait ForceTarget[A <: Vec with VecBase[A]]:
  protected var force: A
  inline def addForce(thatForce: A): Unit =
    force = force + thatForce

trait Particle[A <: Vec with VecBase[A]](zero: A) extends ForceTarget[A]:
  var pos: A = zero
  var vel: A = zero
  var mass: Double = 1.0
  var dump: Double = 1.0

  protected var force = zero

  inline def accelarate(): Unit =
    // println("accelerate")
    // println(force)
    // println(vel)
    // println(pos)

    if mass != 1.0 then force = force / mass
    vel = vel + force
    if dump != 1.0 then vel = vel * dump
    pos = pos + vel
    force = zero

// println(force)
// println(vel)
// println(pos)

end Particle

class Particle2D extends Particle[Vec2](Vec2.zero)
class Particle3D extends Particle[Vec3](Vec3.zero)

case class SpringForce(restLength: Double, elasticity: Double):
  inline def applyTo[A <: Vec with VecBase[A]](
      p: Particle[A],
      anchor: A
  ): Unit =
    val delta = p.pos - anchor
    val currentLenght = delta.length
    val extension = currentLenght - restLength
    p.addForce(delta.normalize * (-extension * elasticity))
