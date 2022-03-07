import java.lang.IllegalStateException

/**
 * return 1 if user wins, -1 if computer win, 0 if it is unclear.
 * @throws IllegalStateException if <code>OPTION.UNKNOWN</code> is supplied in any parameter.
 */

public class Referee {
    fun referee(usersChoice: RockPaperScissors.Option, computersChoice: RockPaperScissors.Option): Int {
        return when (usersChoice) {
            RockPaperScissors.Option.KERTAS -> when (computersChoice) {
                RockPaperScissors.Option.KERTAS -> 0
                RockPaperScissors.Option.BATU -> 1
                RockPaperScissors.Option.GUNTING -> -1
                RockPaperScissors.Option.UNKNOWN -> throw IllegalStateException("Tidak Boleh!")
            }
            RockPaperScissors.Option.BATU -> when (computersChoice) {
                RockPaperScissors.Option.KERTAS -> -1
                RockPaperScissors.Option.BATU -> 0
                RockPaperScissors.Option.GUNTING -> 1
                RockPaperScissors.Option.UNKNOWN -> throw IllegalStateException("Tidak Boleh!")
            }
            RockPaperScissors.Option.GUNTING -> when (computersChoice) {
                RockPaperScissors.Option.KERTAS -> 1
                RockPaperScissors.Option.BATU -> -1
                RockPaperScissors.Option.GUNTING -> 0
                RockPaperScissors.Option.UNKNOWN -> throw IllegalStateException("Tidak Boleh!")
            }
            RockPaperScissors.Option.UNKNOWN -> throw IllegalStateException("Tidak Boleh!")
        }
    }

}