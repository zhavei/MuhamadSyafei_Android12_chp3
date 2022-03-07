class ScoreBoard {

    private var playerScore  = 0

    private var computerScore = 0

    fun increasePlayerScore() {
        playerScore = playerScore + 1
    }

    fun increaseComputerScore() {
        computerScore = computerScore + 1
    }

    fun printScoreBoard() {
        println("Kamu telah menang $playerScore kali. Computer telah menang $computerScore kali.")
    }
}