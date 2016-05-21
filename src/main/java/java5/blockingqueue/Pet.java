package java5.blockingqueue;

public abstract class Pet {

    protected final String name;

    public Pet(String name) {
        this.name = name;
    }

    public abstract void examine();
}

class Cat extends Pet{

    public Cat(String name) {
        super(name);
    }

    @Override
    public void examine() {
        System.out.println("Meow-Meow!");
    }
}

class Dog extends Pet{

    public Dog (String name) {
        super(name);
    }

    @Override
    public void examine() {
        System.out.println("Wow-Wow!");
    }
}

