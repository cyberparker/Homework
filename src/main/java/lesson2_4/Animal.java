package lesson2_4;

public class Animal {
    String name;
    int maxRunMeters;
    int maxSwimMeters;
    private static int animalCount = 0;
    protected static int catCount = 0;
    protected static int dogCount = 0;

    public Animal(String name, int maxRunMeters, int maxSwimMeters) {
        this.name = name;
        this.maxRunMeters = maxRunMeters;
        this.maxSwimMeters = maxSwimMeters;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public static int getCatCount() {
        return catCount;
    }

    public static int getDogCount() {
        return dogCount;
    }

    public void run(int runDistance) {
        if (runDistance <= maxRunMeters) {
            System.out.println(name + " пробежал " + runDistance + " метров");
        } else {
            System.out.println(name + " не смог пробежать " + runDistance + " метров");
        }
    }

    public void swim(int swimDistance) {
        if (swimDistance <= maxSwimMeters) {
            System.out.println(name + " проплыл " + swimDistance + " метров");
        } else {
            System.out.println(name + " не смог проплыть " + swimDistance + " метров");
        }
    }
}

class Cat extends Animal {
    private boolean satiety; // Сытость кота
    private final int appetite; // Сколько еды нужно коту для сытости

    public Cat(String name, int appetite) {
        super(name, 200, 0);
        this.appetite = appetite;
        this.satiety = false;
        Animal.catCount++;
    }

    public void eat(Bowl bowl) {
        if (bowl.decreaseFood(appetite)) {
            satiety = true;
            System.out.println(name + " поел из миски и теперь сыт");
        } else {
            System.out.println(name + " не смог поесть - в миске недостаточно еды");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name, 500, 10);
        Animal.dogCount++;
    }
}

class Bowl {
    private int foodAmount; // Текущее количество еды в миске

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    // Пытаюсь уменьшить количество еды в миске
    // Возвращает true, если еды хватило, false - если нет
    public boolean decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    // докидываю еду в миску
    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Помойник", 30);
        Cat cat2 = new Cat("Барсик", 25);
        Cat cat3 = new Cat("Мурзик", 40);
        Dog dog = new Dog("Слюнявый");

        Bowl bowl = new Bowl(50); // Миска с 50 единицами еды

        // Массив котов
        Cat[] cats = {cat1, cat2, cat3};

        // Кормлю всех котов из миски
        for (Cat cat : cats) {
            cat.eat(bowl);
        }


        System.out.println("\nИнформация о сытости котов:");
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isSatiety());
        }


        bowl.addFood(50);
        System.out.println("Текущее количество еды в миске: " + bowl.getFoodAmount());


        System.out.println("\nПробуем покормить котов снова:");
        for (Cat cat : cats) {
            if (!cat.isSatiety()) {
                cat.eat(bowl);
            }
        }

        System.out.println("\nИнформация о сытости ктов после второй попытки:");
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isSatiety());
        }

        System.out.println("\n======== Подсчет животных ========");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Сколько котов: " + Animal.getCatCount());
        System.out.println("Сколько собак: " + Animal.getDogCount());
    }
}