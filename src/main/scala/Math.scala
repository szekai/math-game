import scala.io.StdIn
import scala.util.Random

object Math {
  def main(args: Array[String]) {
    run()
  }

  def minus(randomNumber1: Int, randomNumber2: Int): Unit ={
    if(randomNumber1 > randomNumber2) println(s"$randomNumber1 - $randomNumber2 = ")
    else println(s"$randomNumber2 - $randomNumber1 = ")

    def minus1(answer: Int, number: Int = -1, count: Int = 0): Unit ={
      try{
        number match {
          case -1 =>
          case x if x == answer => println("Congratulations! You only needed " + count + " tries to answer!"); return
          case _ => println("Wrong answer. Try again.")
        }
        val g = StdIn.readInt
        println(g)
        minus1(answer, g, count + 1)
      }catch {
        case e: NumberFormatException => {
          println("Invalid input. Try again.")
          minus1(answer, number, count)}
      }
    }

    minus1((randomNumber1 - randomNumber2).abs)

  }

  def playAgain(): Boolean ={
    println("Would you like to play again? (yes or no)")
    val response = StdIn.readLine.toLowerCase
    println(response)
    def playAgain1(response: String): Boolean ={
      response match {
        case "yes" | "y" => true
        case "no" | "n" => false
        case _ => {println("Unrecognized answer. Play again? (yes or no)")
          val response = StdIn.readLine.toLowerCase
          playAgain1(response)}
      }
    }
    playAgain1(response)
  }

  def run(play: Boolean = true): Unit ={
    if(play){
      println("\nWelcome to")
      println("     *** Minus the number! ***")
      println("Minus the number below 100, what is the answer")
      val random = new Random
      minus(random.nextInt(100) + 1, random.nextInt(100) + 1)
      run(playAgain)
    }
  }
}
