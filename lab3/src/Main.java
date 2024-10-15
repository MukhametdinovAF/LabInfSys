import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double ArrData [] = new double[6];
        for(int i = 0;i<6;i++){
            ArrData[i] = ReadData.StringDouble(ReadData.FileLineReader("lab3/Data"),i)[0];
        }

        ArrayList<Double> ArrDataProgWr  = ReadData.ListDouble(ReadData.FileLineReader("lab3/Data"),7);
        ArrayList<Double> ArrDataProgEx = ReadData.ListDouble(ReadData.FileLineReader("lab3/Data"), 8);
        double lenghtNewProg = ReadData.StringDouble(ReadData.FileLineReader("lab3/Data"),9)[0];

         // Вычисляем потенциальный объем программы

        System.out.println("Задание 1");
        double v = MethodsTask1.ProgLength(ArrData);
        System.out.println("Потенциальный объем программы - " + Math.round(v));

        // вычисляем потенциальный объем ошибок
        double b = MethodsTask1.ProgException(v,ArrData[5]);
        System.out.println("Количество ошибок в программе - " + b);

        System.out.println();

        System.out.println("Задание 2");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество программистов");
        int m = in.nextInt();
        System.out.println("Введите производительность");
        int p = in.nextInt();
        System.out.println("Введите продолжительность рабочего дня");
        double n = in.nextDouble();

        System.out.println("Число модулей программного средства - k - "+ Math.round(MethodsTask2.quantProg(ArrData)));
        System.out.println("Число уровней в иерархической системе - i - " + Math.round(MethodsTask2.quantLevel(ArrData)));
        System.out.println("Число модулей программного средства - K - " + Math.round(MethodsTask2.quantProgMod(ArrData)));
        System.out.println("Длина программы - N - " + Math.round(MethodsTask2.lenghtProg(ArrData)));
        System.out.println("Объем программы - V - " + Math.round(MethodsTask2.sizeProg(ArrData)));
        System.out.println("Количество программ ассемблера - P - " + Math.round(MethodsTask2.quantProrA(ArrData)));
        System.out.println("Календарное время программирования, дни - Tk - " + Math.round(MethodsTask2.timeToDoProg(ArrData,m,p)) + ", если количество программистов - " + m + ", а их производительность v - " +p);
        System.out.println("Потенциальное количество ошибок - В - " + Math.round(MethodsTask2.quantExceptions(ArrData)));
        System.out.println("Первоначальная надежность ПО - tн - " + Math.round(MethodsTask2.progTr(ArrData,m,p,n)) + ", при продолжительности рабочего дня в " + n + " часов");

        System.out.println();

        System.out.println("Задание 3");

        System.out.println("Текущий рейтинг программиста при расчете с=1/(rating+lambda) - " + Math.round(MethodsTask3.ratingL1(ArrData,ArrDataProgWr,ArrDataProgEx).getLast()));
        System.out.println("Текущий рейтинг программиста при расчете с=1/(rating*lambda) - " + Math.round(MethodsTask3.ratingL2(ArrData,ArrDataProgWr,ArrDataProgEx).getLast()));
        System.out.println("Текущий рейтинг программиста при расчете с=(1/rating+1/lambda) - " + Math.round(MethodsTask3.ratingL3(ArrData,ArrDataProgWr,ArrDataProgEx).getLast()));

        System.out.println("Прогнозное число ошибок при расчете с=1/(rating+lambda) - " + MethodsTask3.planExL1(MethodsTask3.ratingL1(ArrData,ArrDataProgWr,ArrDataProgEx).getLast(),ArrData[5],lenghtNewProg));
        System.out.println("Прогнозное число ошибок при расчете с=1/(rating*lambda) - " + MethodsTask3.planExL2(MethodsTask3.ratingL2(ArrData,ArrDataProgWr,ArrDataProgEx).getLast(),ArrData[5],lenghtNewProg));
        System.out.println("Прогнозное число ошибок при расчете с=(1/rating+1/lambda) - " + MethodsTask3.planExL3(MethodsTask3.ratingL3(ArrData,ArrDataProgWr,ArrDataProgEx).getLast(),ArrData[5],lenghtNewProg));

    }
}