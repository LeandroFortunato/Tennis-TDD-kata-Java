import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TennisTest {

    // input string "121222"
    // Love,15,30,40,A (Advantage)
    //         format: player1-player2
    // output string  "Love-Love,15-Love,15-15,30-15,30-40,30-Winner"

    @Test
    public void testPlayer1ScoredTheFirstPoint (){
            assertEquals("Love-Love,15-Love",Tennis.convertPointsToScores("1"));

    }
    @Test
    public void testPlayer2ScoredTheFirstPoint (){
        assertEquals("Love-Love,Love-15",Tennis.convertPointsToScores("2"));

    }
    @Test
    public void testPlayer1AndPlayer2ScoredOnePointEach (){
        assertEquals("Love-Love,15-Love,15-15",Tennis.convertPointsToScores("12"));

    }
    @Test
    public void testPlayer1ScoredTheFirstPointAndPlayer2Scored2PointsAfterThat (){
        assertEquals("Love-Love,15-Love,15-15,15-30",Tennis.convertPointsToScores("122"));

    }
    @Test
    public void testPlayer1Reaches40AndWinsTheGameRightAfter (){
        assertEquals("Love-Love,15-Love,15-15,15-30,30-30,40-30,WINNER-30",Tennis.convertPointsToScores("122111"));

    }
    @Test
    public void testTheSameConditionBeforeButStringComesLongerAndExtraLengthHasToBeIgnored (){
        assertEquals("Love-Love,15-Love,15-15,15-30,30-30,40-30,WINNER-30",
                Tennis.convertPointsToScores("122111222121212"));

    }
    @Test
    public void testATieAt40 (){
        assertEquals("Love-Love,15-Love,15-15,15-30,30-30,40-30,40-40",Tennis.convertPointsToScores("122112"));

    }

    @Test
    public void testATieAt40Player2HasTheAdvantage (){
        assertEquals("Love-Love,15-Love,15-15,15-30,30-30,40-30,40-40,40-A",Tennis.convertPointsToScores("1221122"));

    }

    @Test
    public void testATieAt40Player2HadTheAdvantageButPlayer1ScoredAPointAfterThat (){
        assertEquals("Love-Love,15-Love,15-15,15-30,30-30,40-30,40-40,40-A,40-40",Tennis.convertPointsToScores("12211221"));

    }

    @Test
    public void testTheSameConditionBeforeAndAfterThatPlayer2ScoresTwiceAndWins (){
        assertEquals("Love-Love,15-Love,15-15,15-30,30-30,40-30,40-40,40-A,40-40,40-A,40-WINNER",Tennis.convertPointsToScores("1221122122"));

    }
}