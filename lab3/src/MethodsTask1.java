public class MethodsTask1 {

    public static double ProgLength (double[]ArrData){
        double InpOutVars = (ArrData[0]*ArrData[1]*ArrData[2]+ArrData[0]*ArrData[3]);
        double ProgLength = ((InpOutVars+2)*(Math.log(InpOutVars+2)/Math.log(2)));
        return ProgLength;
    }

    public static double ProgException (double ProgLength, double lambda){
        double ProgException = Math.pow(ProgLength, 2)/3000/lambda;
        return Math.round(ProgException);
    }

    public static double ProgException1 (double ProgLength, double lambda){
        double ProgException = Math.pow(ProgLength, 2)/3000/lambda;
        return Math.round(ProgException);
    }

}
