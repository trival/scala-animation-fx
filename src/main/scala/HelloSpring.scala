package hello

import scala.language.implicitConversions
import scalafx.Includes.*

import scalafx.animation.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.*
import scalafx.scene.text.Text
import scalafx.scene.shape.Circle
import scalafx.scene.shape.StrokeType.Outside
import xyz.trival.libs.math.vecs.*
import xyz.trival.libs.math.vecs.{given}
import libs.particles.*

object HelloSpring extends JFXApp3:

  override def start(): Unit =

    val bob = new Particle2D:
      pos = Vec2(100, 0)
      mass = 100

    val anchor = new Particle2D:
      pos = Vec2(400, 0)

    val spring = SpringForce(299.9, 3.5)

    val anchorRender = new Circle:
      radius = 10
      fill = Color.Aqua opacity 0.5d
      stroke = Color.AliceBlue opacity 0.8d
      strokeWidth = 4
      strokeType = Outside
      centerX = anchor.pos.x
      centerY = anchor.pos.y

    val bobRender = new Circle:
      radius = 30
      fill = Color.Aqua opacity 0.5d
      stroke = Color.AliceBlue opacity 0.8d
      strokeWidth = 4
      strokeType = Outside
      centerX = bob.pos.x
      centerY = bob.pos.y

    stage = new PrimaryStage:
      title = "ScalaFX Hello Spring"
      width = 800
      height = 400
      scene = new Scene:
        fill = Color.rgb(38, 38, 38)
        content = Seq(bobRender, anchorRender)

    var prevTime = 0L
    val animation: AnimationTimer = AnimationTimer((now) => {
      if prevTime != 0 then
        val delta = now - prevTime
        // println(delta)
        val gravity = (0, 10)

        // spring.applyTo(bob, anchor.pos)
        // bob.addForce(gravity)
        // bob.accelarate()

        spring.applyTo(bob, anchor.pos)
        bob.addForce(gravity)
        bob.accelarate()

        spring.applyTo(bob, anchor.pos)
        bob.addForce(gravity)
        bob.accelarate()

        bobRender.centerX = bob.pos.x
        bobRender.centerY = bob.pos.y

      prevTime = now
    })

    animation.start()
