public class Snake implements TiredAnimal {

    @Override
    public void whatsMyName() {
        System.out.println("Snake: Hi there! I am Python.");
    }
    @Override
    public void eat() {
        System.out.println("Snake: I land in category of snakes and I swallow my preys.");
    }

    @Override
    public void howManyLegs() {
        System.out.println("Snake: I don't have legs.");
    }


    @Override
    public void produceSound() {
        System.out.println("Snake: I produce Hissing sound.");
    }

    @Override
    public void whenTired() {
        System.out.println("Snake: I too love sleeping.");
    }
}
