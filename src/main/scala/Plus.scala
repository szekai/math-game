import scala.io.StdIn
import scala.util.Random

object Plus {
  def main(args: Array[String]) {
    run()
  }

  def plus(randomNumber1: Int, randomNumber2: Int): Unit ={
    println(s"$randomNumber1 + $randomNumber2 = ")

    def plus1(answer: Int, number: Int = -1, count: Int = 0): Unit ={
      try{
        number match {
          case -1 =>
          case x if x == answer => println("Congratulations! You only needed " + count + " tries to answer!"); return
          case _ => println("Wrong answer. Try again.")
        }
        val g = StdIn.readInt
        println(g)
        plus1(answer, g, count + 1)
      }catch {
        case e: NumberFormatException => {
          println("Invalid input. Try again.")
          plus1(answer, number, count)}
      }
    }

    plus1(randomNumber1 + randomNumber2)

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
      println("     *** Plus the number! ***")
      println("Plus the number below 200, what is the answer")
      val random = new Random
      plus(random.nextInt(100) + 1, random.nextInt(100) + 1)
      run(playAgain)
    }
  }
}
