package Animal;

import java.lang.reflect.Field;

class Animal {
    private String name;
    protected int age;
    public boolean isAlive;

    public Animal(String name, int age, boolean isAlive) {
        this.name = name;
        this.age = age;
        this.isAlive = isAlive;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isAlive=" + isAlive +
                '}';
    }
}

class Cat {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Animal animal = new Animal("Leo", 5, true);
        System.out.println("Початковий стан об'єкта Animal:");
        System.out.println(animal);

        // Використання рефлексії для отримання доступу до полів класу Animal
        Class<?> animalClass = animal.getClass();
        Field nameField = animalClass.getDeclaredField("name");
        Field ageField = animalClass.getDeclaredField("age");
        Field isAliveField = animalClass.getDeclaredField("isAlive");

        // Зміна значень полів
        nameField.setAccessible(true);
        nameField.set(animal, "Max");

        ageField.setAccessible(true);
        ageField.set(animal, 7);

        isAliveField.setAccessible(true);
        isAliveField.set(animal, false);

        System.out.println("\nЗмінений стан об'єкта Animal:");
        System.out.println(animal);
    }
}
