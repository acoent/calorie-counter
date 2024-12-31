import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();
    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        int monthNumber;
        int day;
        int steps;
        // ввод и проверка номера месяца
        System.out.println("Введите номер месяца");
            monthNumber = scanner.nextInt();
            if (monthNumber < 0 || monthNumber > 12){
                System.out.println("Некоректный ввод");
                return;
            }
        // ввод и проверка дня
        System.out.println("Введите день от 1 до 30 (включительно)");
        day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Некоректный ввод");
            return;
        }
        // ввод и проверка количества шагов
        System.out.println("Введите количество шагов");
        steps = scanner.nextInt();
        if (steps < 0){
            System.out.println("Некоректный ввод");
            return;
        }
        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[monthNumber - 1];
        // сохранение полученных данных
        monthData.days[day-1] = steps;
    }
    void changeStepGoal(){
        System.out.println("Введите новую цель по количеству шагов в день");
        int goal = scanner.nextInt();
        if (goal > 0){
            goalByStepsPerDay = goal;
        } else{
            System.out.println("Цель не может быть меньше нуля");
        }
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        // ввод и проверка номера месяца
        MonthData monthData = monthToData[scanner.nextInt()-1];// получение соответствующего месяца
        int sumSteps = monthData.sumStepsFromMonth();// получение суммы шагов за месяц
                // вывод общей статистики по дням
        monthData.printDaysAndStepsFromMonth();
                // вывод суммы шагов за месяц
        System.out.println("*** Общее количество шагов за месяц: " + sumSteps);
                // вывод максимального пройденного количества шагов за месяц
        System.out.println("*** Максимальное пройденное количество шагов за месяц: " + monthData.maxSteps());
                // вывод среднего пройденного количества шагов за месяц
        System.out.println("*** Среднее количество шагов: " + sumSteps/30);
                // вывод пройденной за месяц дистанции в километрах
        System.out.println("*** Пройденная дистанция (в км): " + converter.convertToKm(sumSteps));
                // вывод количества сожжённых килокалорий за месяц
        System.out.println("*** Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
                // вывод лучшей серии
        System.out.println("*** Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println(); // дополнительный перенос строки
    }
}
