public class Lion implements TiredAnimal {

    @Override
    public void whatsMyName() {
        System.out.println("Lion: Helloooo Snake! My Name is SherKhan. ");
    }

    @Override
    public void eat() {
        System.out.println("Lion: I am Lion and I eat flesh of other animals.");
    }

    @Override
    public void howManyLegs() {
        System.out.println("Lion: I have four legs.");
    }

    @Override
    public void produceSound() {
        System.out.println("Lion: I always like Roaring.");
    }

    @Override
    public void whenTired() {
        System.out.println("Lion: When I am tired I like Sleeping.");
    }
}
