import ProjetoUtils.{getUserInput, showPrompt}
import MyTree.{getBitmap, getSizeBitMap, makeQTree}

object Main {
  def main(args: Array[String]): Unit = {
    mainloop()
    def mainloop(): Unit ={
      showPrompt()
      val b=getUserInput()
      val bm=getBitmap(b)
      val y= makeQTree(bm)
      val z=getSizeBitMap(b)
      println(z)
    }
  }
}