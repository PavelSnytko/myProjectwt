package Lection4;


class Task4_1 {
    public static void main(String[] args) {
        TimePeriod timeFirst = new TimePeriod("First", 5, 53, 10);
        TimePeriod timeSecond = new TimePeriod("Second", 33, 110, 95);
        TimePeriod timeThird = new TimePeriod("Third", 21190);
        TimePeriod timeFourth = new TimePeriod("Fourth", 35435);

        printTimePeriod(timeFirst);
        printTimePeriod(timeSecond);
        printTimePeriod(timeThird);
        printTimePeriod(timeFourth);

    }

    public static void printTimePeriod(TimePeriod time) {
        System.out.println("Name _" + time.getName() + "_:");           // имя
        System.out.println("seconds = " + time.secondsQuantity());      // в секундах,
        System.out.println("time =    " + time);                        // по отдельности часы, минуты, секунды
    }
}

class TimePeriod {
    private String name;
    private int hours;
    private int minutes;
    private int seconds;

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public TimePeriod(String name, int hours, int minutes, int seconds) {  // метод "отсечения превышающих значений"
        this.name = name;                                      // для 1-го и 2-го объектов
        this.hours = Math.abs(hours) % 24;                     // перевод в формат 24-часовых суток
        this.minutes = Math.abs(minutes) % 60;                 // в формат 60мин в часе
        this.seconds = Math.abs(seconds) % 60;                 // в формат 60сек в минуте
    }

    public TimePeriod(String name, int seconds) {               // метод для 3-го и 4-го объектов
        this.name = name;
        convertSecondsToTime(seconds);
    }

    public int secondsQuantity() {                               // метод определения общего кол-ва секунд в объекте
        return this.hours * 3600 + this.minutes * 60 + seconds;
    }

    private void convertSecondsToTime(int seconds) {             // метод определения времени (час,мин,сек) из секунд
        seconds = Math.abs(seconds);
        this.hours = seconds / 3600;                        // расчет часов и т.д.
        seconds %= 3600;
        this.minutes = seconds / 60;
        this.seconds = seconds % 60;
    }


    public String toString() {                                   // выводим итог пересчета из секунд в час, мин,сек
        return String.format("%d h. %d m. %d s", this.hours, this.minutes, this.seconds);
    }

}




class TaskAKM {
    private static int val20;
    private static int val50;
    private static int val100;


    static void addMoney(int addvalue20, int addvalue50, int addvalue100) {

        val20 += addvalue20;
        val50 += addvalue50;
        val100 += addvalue100;

        System.out.println("В банкомате в наличии " + (addvalue20 * 20 + addvalue50 * 50 + addvalue100 * 100) + " руб.");
    }

    static void askMoney(int requestCash) {
        //программирую на выдачу 100-рублевых купюр

        if ((requestCash/10)%20!=0 && requestCash/100>val100 && val50>0) {   // исключение 1: выдача суммы при нечетном кол-ве десяток
            for (int i=1; i<=val50; i=i+2){
                if((requestCash-100*val100-50*i)/20<=val20) {
                    System.out.println("Запрос выполнен успешно");
                    System.out.println("Выдано: " + val100 + "шт. х 100руб., " + i + "шт. х 50руб., " + (requestCash - 100 * val100 - 50 * i) / 20 + "шт. х 20руб.");
                    break;
                } else {
                    System.out.println("Недостаточно купюр требуемого номинала");
                }
            }
        }
        else if ((requestCash/10)%20!=0 && requestCash/100==val100 && val50>0) { // искл. 2: выдача суммы при нечетном количестве десяток и соток одинаково
            for (int i=1; i<=val50; i=i+2){
                if((requestCash-100*(val100-1)-50*i)/20<=val20) {
                    System.out.println("Запрос выполнен успешно");
                    System.out.println("Выдано: " + (val100-1) + "шт. х 100руб., " + i + "шт. х 50руб., " + (requestCash - 100 * (val100-1) - 50 * i) / 20 + "шт. х 20руб.");
                    break;
                } else {
                    System.out.println("Недостаточно купюр требуемого номинала");
                }
            }
        }
        else if ((val20 * 20 + val50 * 50 + val100 * 100 >= requestCash) && requestCash/100<=val100) {   // выдача,когда 100 рублевых купюр больше
            if (requestCash%100==60 || requestCash%100==80 && (requestCash%100)/20<=val20) {             // искл 3
                System.out.println("Запрос выполнен успешно");
                System.out.println("Выдано: " + requestCash/100 + "шт. х 100руб., " + (requestCash%100)/20 + "шт. х 20руб." );
            } else if ((requestCash%100)/50 <= val50 && ((requestCash%100)%50)%20 == 0 && ((requestCash%100)%50)/20 <= val20) {
                System.out.println("Запрос выполнен успешно");
                System.out.println("Выдано: " + requestCash/100 + "шт. х 100руб., " + (requestCash%100)/50 + "шт. х 50руб., " + ((requestCash%100)%50)/20 + "шт. х 20руб.");
            } else if ((requestCash%100)/50 > val50 && ((requestCash%100)%50)%20 == 0 && ((requestCash%100)%50)/20 <= val20) {
                System.out.println("Запрос выполнен успешно");
                System.out.println("Выдано: " + requestCash/100 + "шт х 100руб.," + (requestCash%100)/50 + "шт х 50руб., " + (requestCash % 100 - 50) / 20 + "шт. х 20руб.");
            } else {
                System.out.println("Недостаточно купюр требуемого номинала");
            }
        } else if ((val20 * 20 + val50 * 50 + val100 * 100 >= requestCash) && requestCash/100>val100) {     // выдача если соток в наличии меньше
            if ((requestCash-100*val100)/50<=val50 && ((requestCash-100*val100)%50)%20==0 && ((requestCash-100*val100)%50)/20<=val20){
                System.out.println("Запрос выполнен успешно");
                System.out.println("Выдано: " + val100 + "шт. х 100руб., " + (requestCash-100*val100)/50 + "шт. х 50руб., " + ((requestCash-100*val100)%50)/20 + "шт. х 20руб.");
            } else if ((requestCash-100*val100)/50>val50 && ((requestCash-100*val100-50*val50)%20==0 && (requestCash-100*val100-50*val50)/20<=val20)) {
                System.out.println("Запрос выполнен успешно");
                System.out.println("Выдано: " + val100 + "шт. х 100руб., " + val50 + "шт. х 50руб., " + (requestCash-100*val100-50*val50)/20 + "шт. х 20руб.");
            } else {
                System.out.println("Недостаточно купюр требуемого номинала");
            }
        }
        else {
            System.out.println("В банкомате недостаточно средств для выполнения запроса");
        }
    }
}

class Bankomat {
    private int AKM100;
    private int AKM50;
    private int AKM20;

    public static void main(String[] args) {
        TaskAKM CM1 = new TaskAKM();

        CM1.addMoney(10, 1, 1);
        CM1.askMoney(350);

    }

}
