public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Sheru");
        dog.eat();
        dog.breathe();

        Parrot parrot = new Parrot("Meethu");
        parrot.eat();
        parrot.breathe();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.eat();
        penguin.breathe();
        penguin.fly();

    }
}