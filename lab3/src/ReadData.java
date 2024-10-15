import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


// Класс содержит методы для чтения и обработки прочитанных данных.
public class ReadData {

    // Чтение из документа
        public static ArrayList<String> FileLineReader (String filename) { // на вход подаем строку с путем к файлу
            BufferedReader reader; // создаем ридер для чтения из файла
            ArrayList <String> readLines = new ArrayList<>(); // создаем массив строк
            try {
                reader = new BufferedReader(new FileReader(filename)); // указываем из какого файла читать
                String line = reader.readLine(); // читаем строку
                while (line != null) { // если не конец файла
                    readLines.add(line); //записываем прочитанное в массив строк
                    line = reader.readLine(); // переходим на следующую строку
                }
                reader.close(); // закрываем ридер
            } catch (IOException e) {
                throw new RuntimeException(e); // выбрасываем ошибку в случае чего
            }
            return readLines; // возвращаем массив строк
        }


    //Печать прочитанного массива
        public static void PrintArray (ArrayList<String> readLines) {
            for (int i=0;  i <readLines.size(); i++){
                System.out.println(readLines.get(i));
            }
        }

    //Преобразование в числа


    public static double [] StringDouble (ArrayList<String> readLines,int lineNum){


            int n = 0;
            if (readLines.get(lineNum).indexOf(";")>0){
                n=readLines.get(lineNum).split(";").length;
            }
            else {
                n=1;
            }

            double[] arrayDouble = new double[n];
            if (readLines.get(lineNum).indexOf(";")>0){
                String [] Lines = readLines.get(lineNum).split(";");
                for (int i=0; i<Lines.length;i++) {
                    arrayDouble[i] = Double.valueOf(Lines[i]);

                }
            }

            else {
               arrayDouble[0]=Double.valueOf(readLines.get(lineNum));

            }
        return arrayDouble;
    }



    public static ArrayList <Double> ListDouble (ArrayList<String> readLines,int lineNum){


        int n = 0;
        if (readLines.get(lineNum).indexOf(";")>0){
            n=readLines.get(lineNum).split(";").length;
        }
        else {
            n=1;
        }

        ArrayList<Double> arrayDouble = new ArrayList<>();
        if (readLines.get(lineNum).indexOf(";")>0){
            String [] Lines = readLines.get(lineNum).split(";");
            for (int i=0; i<Lines.length;i++) {
                arrayDouble.add(Double.valueOf(Lines[i]));

            }
        }

        else {
            arrayDouble.add(Double.valueOf(readLines.get(lineNum)));

        }
        return arrayDouble;
    }

    //Печать массива
    public static void printArray (double[] Array){
            for (int i=0;i<Array.length;i++){
                System.out.print(Array[i]+" ");
            }
        System.out.println();
    }


    //Печать списка
    public static void printListArray (ArrayList<Double> Array){
        for (int i=0;i<Array.size();i++){
            System.out.print(Math.round(Array.get(i)) + " ");
        }
        System.out.println();
    }


    }

