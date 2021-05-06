import MyTree.BitMap

import java.awt.Color

case class MyTree[A](MyField: QTree[A]){

  def mirrorH():QTree[A]=MyTree.mirrorH(this.MyField)
  def mirrorV():QTree[A]=MyTree.mirrorV(this.MyField)
  def rotateR():QTree[A]=MyTree.rotateR(this.MyField)
  def rotateL():QTree[A]=MyTree.rotateL(this.MyField)



}

object MyTree{
  type Point = (Int, Int)
  type Coords = (Point, Point)
  type Section = (Coords, Color)
  type BitMap = (Array[Array[Int]])


  def getSizeBitMap(b:String): (Int,Int)={
    val x= ImageUtil.readColorImage(b)
    (x.length, x(0).length)

  }
  def getBitmap(b:String): BitMap = {
    ImageUtil.readColorImage(b)

  }


  def makeQTree[A](b:BitMap):Unit={
    val x=b.map(_.toList).toList
    println(b)
    println(x)
    val y=predecode(x)
    println(y)
    //val tree1= QNode(value,QNode(),QNode(),QNode(),QNode())



  }
  //def makeBitMap(x:QTree[Coords]):BitMap={
    //x match {
      //case QEmpty => new BitMap(Array[Array[Nothing]])
      ///case QNode(value,one,two,three,four) =>
   // }

  def predecode(x:List[List[Int]]):List[Any]={
    x match {
      case Nil => Nil
      case x::xs=>{
        decodeR(x)::predecode(xs)

      }
    }
  }
  def decodeR(x:List[Int]):List[Any]= {
    x match {
      case Nil => Nil
      case y :: ys => (ImageUtil.decodeRgb(y).toList :: decodeR(ys))


    }
  }
  def mirrorH[Coords](qt: QTree[Coords]): QTree[Coords] = qt match {
    case QEmpty => QEmpty
    case QNode(value,one,two,three,four) =>
      val nOne = mirrorH(two)
      val nTwo = mirrorH(one)
      val nThree = mirrorH(four)
      val nFour = mirrorH(three)
      QNode(value, nOne, nTwo, nThree, nFour)
  }
  def mirrorV[Coords](qt: QTree[Coords]): QTree[Coords] = qt match {
    case QEmpty => QEmpty
    case QNode(value,one,two,three,four) =>
      val nOne = mirrorV(three)
      val nTwo = mirrorV(four)
      val nThree = mirrorV(one)
      val nFour = mirrorV(two)
      QNode(value, nOne, nTwo, nThree, nFour)
  }
  def rotateR[A](qt: QTree[A]): QTree[A] = qt match{
    case QEmpty=> QEmpty
    case QNode(value,one,two,three,four)=>
      val nOne = rotateR(two)
      val nTwo = rotateR(four)
      val nThree = rotateR(one)
      val nFour = rotateR(three)
      QNode(value, nOne, nTwo, nThree, nFour)
  }
  def rotateL[A](qt: QTree[A]): QTree[A] = qt match{
    case QEmpty=> QEmpty
    case QNode(value,one,two,three,four)=>
      val nOne = rotateL(three)
      val nTwo = rotateL(one)
      val nThree = rotateL(four)
      val nFour = rotateL(two)
      QNode(value, nOne, nTwo, nThree, nFour)
  }


}


