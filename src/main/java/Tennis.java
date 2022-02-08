import java.util.ArrayList;
import java.util.Arrays;

public class Tennis {

    public static String convertPointsToScores(String inputPoints) {
        String[] scores = new String[]{"Love", "15", "30", "40"};
        String player1CurrentState = "Love";
        String player2CurrentState = "Love";
        String scoresOnGame = player1CurrentState + "-" + player2CurrentState + ",";

        for (String playerWhoScored : inputPoints.split("")) {
            if (player1CurrentState =="WINNER" || player2CurrentState =="WINNER") {
                break;
            }
            if (playerWhoScored.equals("1")) {
                if (player1CurrentState.equals("A")) {
                    player1CurrentState = "WINNER";
                } else {
                    if (player1CurrentState.equals("40")) {
                        if (player2CurrentState.equals("40")) {
                            player1CurrentState = "A";
                        } else {
                            if (player2CurrentState.equals("A")) {
                                player2CurrentState = "40";
                            } else {
                                player1CurrentState = "WINNER";
                            }
                        }
                    } else {
                        player1CurrentState = scores[Arrays.asList(scores).indexOf(player1CurrentState) + 1];
                    }
                }
            } else {// playerWhoScored == 2

                if (player2CurrentState.equals("A")) {
                    player2CurrentState = "WINNER";
                } else {
                    if (player2CurrentState.equals("40")) {
                        if (player1CurrentState.equals("40")) {
                            player2CurrentState = "A";
                        } else {
                            if (player1CurrentState.equals("A")) {
                                player1CurrentState = "40";
                            } else {
                                player2CurrentState = "WINNER";
                            }
                        }
                    } else {
                        player2CurrentState = scores[Arrays.asList(scores).indexOf(player2CurrentState) + 1];
                    }
                }
            }
            scoresOnGame = scoresOnGame + player1CurrentState + "-" + player2CurrentState + ",";
        }
        return scoresOnGame.substring(0,scoresOnGame.length()-1);
    }
}
