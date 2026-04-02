import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fifteenlove {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    Game game = new Game();

    int N = Integer.valueOf(in.readLine());
    String results = in.readLine();
    if (N < 1 || N > 300) {
      System.out.println("error in input");
      return;
    }
    if (results.length() != N) {
      System.out.println("error in input");
      return;
    }
    for (int i = 0; i < N; i++) {
      char score = results.charAt(i);
      if (game.isGameOver()) {
        System.out.println("error in input");
      }
      if (score == 'W') {
        game.wonPoint();
      } else if (score == 'L') {
        game.lostPoint();
      } else {
        System.out.println("error in input");
      }
    }
    System.out.println(game);
  }

}

class Game {
  int player1Score;
  int player2Score;
  int player1Sets;
  int player2Sets;
  int player1Games;
  int player2Games;
  boolean isTieBreak;
  boolean isPlayer1Serving;
  boolean isGameOver;
  String[] points = { "0", "15", "30", "40" };
  boolean wasPlayer1ServingBeforeTieBreak = false;

  Game() {
    player1Score = 0;
    player2Score = 0;
    player1Sets = 0;
    player2Sets = 0;
    player1Games = 0;
    player2Games = 0;
    isPlayer1Serving = true;
    isTieBreak = false;
    isGameOver = false;
  }

  boolean isGameOver() {
    return isGameOver;
  }

  void wonPoint() {
    if (isGameOver) {
      return;
    }
    if (isPlayer1Serving) {
      player1Score++;
    } else {
      player2Score++;
    }
    handleScore();
  }

  void lostPoint() {
    if (isGameOver) {
      return;
    }
    if (isPlayer1Serving) {
      player2Score++;
    } else {
      player1Score++;
    }
    handleScore();
  }

  void handleScore() {
    if (isGameOver) {
      return;
    }
    if (isTieBreak) {
      if (checkIfAnyoneHasWonTheTieBreakAndAdjustIt()) {
        if (checkIfAnyoneHasWonTheSetAndAdjustIt()) {
          if (checkIfAnyoneHasWonTheMatch()) {
            return;
          } else {
            player1Games = 0;
            player2Games = 0;
            player1Score = 0;
            player2Score = 0;
            isTieBreak = false;

            if (wasPlayer1ServingBeforeTieBreak) {
              isPlayer1Serving = false;
            } else {
              isPlayer1Serving = true;
            }
          }
        }
        changeSides();
      } else {
        if (player1Score + player2Score == 1) {
          changeSides();
        } else if (player1Score + player2Score > 1 && (player1Score + player2Score) % 2 != 0) {
          changeSides();
        }
      }
    } else {
      if (checkIfAnyoneHasWonTheGameAndAdjustIt()) {
        if (checkIfAnyoneHasWonTheSetAndAdjustIt()) {
          if (checkIfAnyoneHasWonTheMatch()) {
            return;
          } else {
            player1Games = 0;
            player2Games = 0;
            player1Score = 0;
            player2Score = 0;
            isTieBreak = false;
          }
        } else {
          player1Score = 0;
          player2Score = 0;
        }
        changeSides();
      }
    }

  }

  void changeSides() {
    isPlayer1Serving = !isPlayer1Serving;
  }

  boolean checkIfAnyoneHasWonTheGameAndAdjustIt() {
    if ((player1Score >= 4 || player2Score >= 4) && Math.abs(player1Score - player2Score) >= 2) {
      if (player1Score > player2Score) {
        player1Games++;
      } else {
        player2Games++;
      }
      return true;
    }
    return false;
  }

  boolean checkIfAnyoneHasWonTheTieBreakAndAdjustIt() {
    if ((player1Score >= 7 || player2Score >= 7) && Math.abs(player1Score - player2Score) >= 2) {
      if (player1Score > player2Score) {
        player1Games++;
      } else {
        player2Games++;
      }
      return true;
    }
    return false;
  }

  boolean doesAnyoneWonTheSet() {
    return (player1Games == 7 || player2Games == 7
        || ((player1Games == 6 || player2Games == 6) && Math.abs(player1Games - player2Games) >= 2));
  }

  boolean checkIfAnyoneHasWonTheSetAndAdjustIt() {
    if (doesAnyoneWonTheSet()) {
      if (player1Games > player2Games) {
        player1Sets++;
      } else {
        player2Sets++;
      }
      return true;
    } else if (player1Games == 6 && player2Games == 6) {
      isTieBreak = true;
      wasPlayer1ServingBeforeTieBreak = isPlayer1Serving;
    }
    return false;
  }

  boolean doesAnyoneWonTheMatch() {
    return (player1Sets == 3 || player2Sets == 3);
  }

  boolean checkIfAnyoneHasWonTheMatch() {
    if (doesAnyoneWonTheMatch()) {
      isGameOver = true;
      return true;
    }
    return false;
  }

  public String getPlayer1Score() {
    int score = player1Score;
    if (isTieBreak) {
      return String.valueOf(score);
    } else if (score <= 3) {
      return points[score];
    } else {
      if (score > player2Score) {
        if (score - player2Score >= 2) {
          return "GAME";
        }
        return "ADV";
      } else {
        return "40";
      }
    }
  }

  public String getPlayer2Score() {
    int score = player2Score;
    if (isTieBreak) {
      return String.valueOf(score);
    } else if (score <= 3) {
      return points[score];
    } else {
      if (score > player1Score) {
        if (score - player1Score >= 2) {
          return "GAME";
        }
        return "ADV";
      } else {
        return "40";
      }
    }
  }

  public String toString() {
    return player1Sets + "(" + player1Games + ")[" + getPlayer1Score() + "]-" + player2Sets + "(" + player2Games + ")["
        + getPlayer2Score() + "]";
  }

}