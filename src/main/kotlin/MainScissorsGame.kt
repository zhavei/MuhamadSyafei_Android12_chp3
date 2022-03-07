import java.lang.IllegalStateException

fun main() {
    val rps = RockPaperScissors();
    rps.play();
}

class RockPaperScissors {

    enum class Option(val option: String) {
        KERTAS("Kertas"),
        BATU("Batu"),
        GUNTING("Gunting"),
        UNKNOWN("unknown")
    }

    val scoreBoard = ScoreBoard()

    fun play() {
        do {
            val usersChoice = this.userDraw();
            val computersChoice = computerDraw();
            println("Pilihan Kamu $usersChoice");
            println("Pilihan Lawanmu $computersChoice")
            val whoWins = Referee().referee(usersChoice, computersChoice);
            when (whoWins) {
                -1 -> {println("Lawanmu Menang")
                    scoreBoard.increaseComputerScore()}
                0 -> println ("Seri!");
                1 -> {println("Kamu Menang")
                    scoreBoard.increasePlayerScore()}
                else -> throw IllegalStateException();
            }
            println("")
        } while (playAgain())
        print(scoreBoard.printScoreBoard());
    }

    private fun playAgain(): Boolean {
        var answer: String? = "";
        while (!("y".equals(answer) || "n".equals(answer))) {
            println("Main Lagi? Ketik 'y' jika IYA dan 'n' untuk TIDAK")
            answer = readLine()
        }
        return "y".equals(answer);
    }

    fun userDraw(): Option {
        var parsedInput = Option.UNKNOWN
        println("Hallo.")
        while (Option.UNKNOWN.equals(parsedInput)) {
            println("Ini adalah Permainan Gunting, Batu Kertas. pilih antara; \nBatu [b], Kertas [k] or Gunting [g] \nPilihanmu : ")
            var input = readLine()
            parsedInput = when (input) {
                "b" -> Option.BATU
                "k" -> Option.KERTAS
                "g" -> Option.GUNTING
                else -> Option.UNKNOWN
            }
            if (Option.UNKNOWN.equals(parsedInput)) {
                println("input salah, Masukan =  b | k | g")
                println("Coba Lagi")
                println("")
            }

        }
        return parsedInput
    }

    fun computerDraw(): Option {
        return arrayOf(Option.BATU, Option.KERTAS, Option.GUNTING).random()
    }

}