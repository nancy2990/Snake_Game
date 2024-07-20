package SnakeGame.controller;

/**
 * @program: SnakeGame
 * @description: this class is used when player finish the game, and store data
 * @author: Jiahe Cai-modified
 **/
public class PlayerScore {
    /**
     * The score snake got
     */
    int score;

    /**
     * Player name entered
     */
    String playerName;

    /**
     * The constructor of Player score
     * @param score
     * @param playerName
     */
    public PlayerScore(int score, String playerName){
        this.score = score;
        this.playerName = playerName;
    }

    /**
     * This method is getter of score
     * @Description getter
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Get player's name
     * @Description getter
     * @return player's name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Show the player score and name
     * @return string to be stored in txt document
     */
    @Override
    public String toString() {
        return "PlayerScore{" +
                "score=" + score +
                ", playerName='" + playerName + '\'' +
                '}'+"\n";
    }
}
