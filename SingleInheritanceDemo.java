class Animal {
    String name = "Dog";

    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class SingleInheritanceDemo {
    public static void main(String[] args) {
        Dog d = new Dog();

        System.out.println("Animal name is: " + d.name);
        d.eat();
        d.bark();
    }
}

