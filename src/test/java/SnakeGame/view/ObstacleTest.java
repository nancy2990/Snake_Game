package SnakeGame.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObstacleTest {
    final int NUM = (int) (Math.random() *4);

    private Obstacle obstacle = (Obstacle) ObjectFactory.getObjectType("obstacle");
    @Test
    public void hit(){
        MySnake snake = new MySnake(obstacle.xlocation_Array.get(NUM), obstacle.ylocation_Array.get(NUM),false);
        assertEquals(obstacle.hit(snake),false);
    }
}