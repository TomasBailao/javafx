import javafx.fxml.FXML
import javafx.scene.control.{Button, MenuButton, TextField, ToggleButton}
import javafx.scene.paint.Color
class Controller {
  @FXML
  private var menuButton1: MenuButton = _
  @FXML
  private var textField1: TextField = _
  @FXML
  private var toggleButton1: ToggleButton=_

  def onButton1Clicked(): Unit = {
    textField1.setText("Hello World!")
  }
  def onMouseEnteredToggleButton(): Unit = {
    textField1.setVisible(true)
  }
  def onToggleButtonPressed(): Unit = {
    toggleButton1.setSelected(true)
    toggleButton1.setTextFill(Color.RED)
    toggleButton1.setOpacity(0.50)
    toggleButton1.setText("Clicked")

  }
}