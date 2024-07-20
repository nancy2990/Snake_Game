package SnakeGame.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    Food food = (Food) ObjectFactory.getObjectType("food");

    @Test
    public void hit(){
        MySnake snake = new MySnake(food.x,food.y,false);
        food.hit(snake);
        assertEquals(snake.getLength(),2);
        assertEquals(snake.getScore(),521);
    }

}