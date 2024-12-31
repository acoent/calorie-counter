class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i+1 + "-й день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int day : days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int day : days) {
            maxSteps = Math.max(maxSteps, day);
            // поиск максимального элемента
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
            } else{
                currentSeries = 0;
            }
            if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
            }
            // поиск максимальной серии
        }
        return finalSeries;
    }
}
