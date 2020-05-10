//Demonstrating interfaces and packages

interface Animal{
    void eat();
    void howManyLegs();
    void whatsMyName();
}

interface TiredAnimal extends Animal{
    void produceSound();
    void whenTired();
}

public class Main{
    public static void main(String args[]){
        Lion lion = new Lion();
        Snake snake = new Snake();

        //methods in Animal Interface
        lion.whatsMyName();
        snake.whatsMyName();

        lion.eat();
        snake.eat();

        lion.howManyLegs();
        snake.howManyLegs();

        //methods in TiredAnimal Interface
        lion.produceSound();
        snake.produceSound();

        lion.whenTired();
        snake.whenTired();
    }
}
