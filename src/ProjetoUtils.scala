import java.io.{DataInputStream, FileInputStream}
import scala.io.StdIn

object ProjetoUtils{
  def showPrompt():Unit = {
    print("\nIntroduza o nome do ficheiro:")
  }
  def getUserInput(): String ={
    StdIn.readLine
  }
}