import java.util.Scanner;

public class MethodsTask2 {

    //Определяет количество модулей ПО

    public static double InpOutVars(double[] ArrData){
        return (ArrData[0]*ArrData[1]*ArrData[2]+ArrData[0]*ArrData[3]);
    }

    public static double quantProg(double[] ArrData){
        return (InpOutVars((ArrData)))/8;
    }

    //Количество уровней в многоуровневой программе
    public static double quantLevel(double[] ArrData){
        return Math.log(InpOutVars(ArrData))/Math.log(2)/3+1;
    }

    //Количество модулей К
    public static double quantProgMod(double[] ArrData){
       double K = 0;
        if (quantProg(ArrData)>8*3) {
            K= 1.125 * quantProg(ArrData);
        }
        else {K =quantProg(ArrData);
        }
        return K;
    }

    //Длина программы N
    public static double lenghtProg(double[] ArrData){
        return quantProgMod(ArrData)*(220 + Math.log(quantProgMod(ArrData))/Math.log(2));
    }

    //Объем ПО V
    public static double sizeProg(double[] ArrData){
        return quantProgMod(ArrData)*220*Math.log(48)/Math.log(2);
    }

    //Количество программ ассемблера Р
    public static double quantProrA(double[] ArrData){
        return 3*lenghtProg(ArrData)/8;
    }
    //Расчет календарного времени программирования: Tk
    public static double timeToDoProg(double[] ArrData, int m, int v){
        return 3*lenghtProg(ArrData)/(8*m*v);
    }

    //Расчет потенциального количества ошибок B
    public static double quantExceptions(double[] ArrData){
        return sizeProg(ArrData)/3000;
    }

    // Расчет начальной надёжности tн
    public static double progTr(double[] ArrData, int m, int v, double n){
         return  timeToDoProg(ArrData,m,v)*n/2/Math.log(quantExceptions(ArrData));
    }

    public static double progTrA(double[] ArrData, int m, int v, double n){
        return  timeToDoProg(ArrData,m,v)*n/2/Math.log(quantExceptions(ArrData));
    }

}
