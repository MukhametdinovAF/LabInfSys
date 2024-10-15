import java.util.ArrayList;

public class MethodsTask3 {
    // коэффициент в зависимости от рейтинга и сложности языка с1 = 1/(R+lambda)
    public static double corRandL1 (double rate, double lambda){
        return 1/(rate + lambda);
    }


    // коэффициент в зависимости от рейтинга и сложности языка с2 = 1/(R*lambda)
    public static double corRandL2 (double rate, double lambda){
        return 1/rate/lambda;
    }


    // коэффициент в зависимости от рейтинга и сложности языка с3 = 1/R+1/lambda
    public static double corRandL3 (double rate, double lambda){
        return 1/rate+1/lambda;
    }

    // Расчет рейтинга
    public static double rating (double ratingBefore, double lambda, double sumProg, double sumEx){
        double rating = ratingBefore*(1+0.001*(sumProg-sumEx));
        return rating;
    }

    //Прогнозное число ошибок для коэффициента corRandL1
    public static double planExL1 (double rating,double lambda, double V){
        double planEx=corRandL1(rating,lambda)*V;
        return Math.round(planEx);
    }

    //Прогнозное число ошибок для коэффициента corRandL2
    public static double planExL2 (double rating,double lambda, double V){
        double planEx=corRandL2(rating,lambda)*V;
        return Math.round(planEx);
    }

    //Прогнозное число ошибок для коэффициента corRandL3
    public static double planExL3 (double rating,double lambda, double V){
        double planEx=corRandL3(rating,lambda)*V;
        return Math.round(planEx);
    }

    // Расчет ожидаемых ошибок

  //Определение рейтингов при расчете коэффициента corRandL1
    public static ArrayList<Double> ratingL1 (double [] ArrData, ArrayList<Double> ArrDataProgWr, ArrayList<Double> ArrDataProgEx){
        ArrayList<Double> ratings = new ArrayList<>(); //Определяем длину массива с рейтингами
        ratings.add(ArrData[4]); //Записываем начальный рейтинг
        double sumB = 0; //Сумма ошибок/коэффициент
        double sumV = 0; // Сумма длин программ

        for (int i=0; i<ArrDataProgWr.size();i++){
            sumB = sumB + ArrDataProgEx.get(i)/corRandL1(ratings.get(i),ArrData[5]);
            sumV = sumV+ArrDataProgWr.get(i);
            ratings.add(rating(ratings.get(i), ArrData[5],sumV,sumB)); //Находим рейтинг
        }
        return ratings;
    }

    //Определение рейтингов при расчете коэффициента corRandL2
    public static ArrayList<Double> ratingL2 (double [] ArrData, ArrayList<Double> ArrDataProgWr, ArrayList<Double> ArrDataProgEx){
        ArrayList<Double> ratings = new ArrayList<>(); //Определяем длину массива с рейтингами
        ratings.add(ArrData[4]); //Записываем начальный рейтинг
        double sumB = 0; //Сумма ошибок/коэффициент
        double sumV = 0; // Сумма длин программ

        for (int i=0; i<ArrDataProgWr.size();i++){
            sumB = sumB + ArrDataProgEx.get(i)/corRandL2(ratings.get(i),ArrData[5]);
            sumV = sumV+ArrDataProgWr.get(i);
            ratings.add(rating(ratings.get(i), ArrData[5],sumV,sumB)); //Находим рейтинг
        }
        return ratings;
    }

    //Определение рейтингов при расчете коэффициента corRandL3
    public static ArrayList<Double> ratingL3 (double [] ArrData, ArrayList<Double> ArrDataProgWr, ArrayList<Double> ArrDataProgEx){
        ArrayList<Double> ratings = new ArrayList<>(); //Определяем длину массива с рейтингами
        ratings.add(ArrData[4]); //Записываем начальный рейтинг
        double sumB = 0; //Сумма ошибок/коэффициент
        double sumV = 0; // Сумма длин программ

        for (int i=0; i<ArrDataProgWr.size();i++){
            sumB = sumB + ArrDataProgEx.get(i)/corRandL3(ratings.get(i),ArrData[5]);
            sumV = sumV+ArrDataProgWr.get(i);
            ratings.add(rating(ratings.get(i), ArrData[5],sumV,sumB)); //Находим рейтинг
        }
        return ratings;
    }

}
