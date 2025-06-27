package lesson2_3.Task3;

/*
Я так понял лучше в таком порядке делать:
1. Класс
2. Конструктор
3. Метод
Но сам сперва сделал в другом порядке, потом решил не переиначивать на всякий.
 */
public class Park {
    public static void main(String[] args) {
        Attraction attraction1 = new Attraction("Roller Coaster", 10, "10:00-17:00"); //объявляю аттракционы
        Attraction attraction2 = new Attraction("Steering Wheel", 5, "09:00-20:30");
        Attraction attraction3 = new Attraction("BumperCars", 15, "12:00-20:00");
        System.out.println("In our park we have: "); //вывожу какие у меня есть для наглядности
        System.out.println("- " + attraction1);
        System.out.println("- " + attraction2);
        System.out.println("- " + attraction3);
    }

    static class Attraction {                        //создаю нестед и поля для него(как я понял иннер это тот же нестед, только не статический)
        String attractionType;
        int priceInDollars;
        String workingTime;

        public Attraction(String attractionType, int priceInDollars, String workingTime) {  //создаю конструктор

            this.attractionType = attractionType;
            this.priceInDollars = priceInDollars;
            this.workingTime = workingTime;
        }


    }

}


