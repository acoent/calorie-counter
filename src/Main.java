import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(sc);
        int command;
        while (true) {
            printMenu();
            command = sc.nextInt();
            if (command >0 && command < 5){
                System.out.println("Выполняется команда " + command);
            }
            if (command == 4) {
                break;
            } else if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else{
                System.out.println("Некоректный ввод");
            }
        }
    }

    static void printMenu(){
        System.out.println("""
                Выберете действие:
                1. Ввести количество шагов за определённый день;
                2. Изменить цель по количеству шагов в день;
                3. Напечатать статистику за определённый месяц;
                4. Выйти из приложения.""");
    }
}