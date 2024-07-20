package SnakeGame.view;

/**
 * This class demostarte factory pattern of food and obstacle classes
 * @author: Jiahe Cai
 * @program: SnakeGame
 */
public class ObjectFactory {
    /**
     * This method get object initializer based on object type. <br/>
     * @param objectType
     * @return specific type of game initializer
     */
    public static Object getObjectType(String objectType){
        if(objectType == "obstacle"){
            return new Obstacle();
        }else if(objectType == "food"){
            return new Food();
        }
        return null;
    }
}
