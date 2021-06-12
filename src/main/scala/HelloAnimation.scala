import scalafx.Includes._
import scalafx.animation._
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene._
import scalafx.scene.paint.Color
import scalafx.scene.text.Text
import scalafx.geometry.Insets

import scala.language.postfixOps
import scalafx.scene.control.Label
import scalafx.scene.layout.HBox

object HelloAnimation extends JFXApp3:
  override def start(): Unit =

    val label = Text(100, 100, "Hello")

    stage = new PrimaryStage:
      title = "Animation Test"
      width = 500
      height = 500
      scene = new Scene:
        content = label

    val animation = AnimationTimer((now) => {
      label.text = now.toString
    })

    animation.start()
end HelloAnimation
