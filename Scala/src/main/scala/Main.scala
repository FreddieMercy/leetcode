import _2017.June2017.Jun22nd2017._505TheMazeII;
object Main extends App {

  val a = Array(Array(0,0,1,0,0),Array(0,0,0,0,0),Array(0,0,0,1,0),Array(1,1,0,1,1),Array(0,0,0,0,0))
  val b = Array(0,4)
  val c= Array(4,4)
  val x = new _505TheMazeII()
  println(x.Solution.shortestDistance(a,b,c))
}