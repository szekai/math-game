import scala.io.StdIn
import scala.util._

object Guess {
  def main(args: Array[String]) {
    run()
  }

  def guess(randomNumber: Int, number: Int = -1, count: Int = 0): Unit ={
    try{
      number match {
        case -1 =>
        case x if x < randomNumber => println("Too low! Guess again.")
        case x if x > randomNumber => println("Too high! Guess again.")
        case x if x == randomNumber => println("Congratulations! You only needed " + count + " tries to guess my number!"); return
      }
      val g = StdIn.readInt
      guess(randomNumber, g, count + 1)
    }catch {
      case e: NumberFormatException => {
        println("Invalid input. Guess again.")
        guess(randomNumber, number, count)}
      }
    }

  def playAgain(): Boolean ={
    println("Would you like to play again? (yes or no)")
    val response = StdIn.readLine.toLowerCase
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
      println("     *** GUESS MY NUMBER! ***")
      println("I'm thinking of a number between 1 and 100. What do you think it is?")
      val random = new Random
      guess(random.nextInt(100) + 1)
      run(playAgain)
    }
  }
}