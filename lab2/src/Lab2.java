import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab2 {

public static void main (String[] args) throws IOException  {
	
	//Прочитать из файла параметры функции: q - количество ошибок, m - интервал времени до ошибки 
	//System.out.println ("Данные файла lab2.txt");
	//System.out.println ("q  |"+ "m  |");
	
	//// Получение данных из файла
	Path filePath = Paths.get("../lab2/lab2.txt");
	Scanner scanner = new Scanner(filePath);
	
	////Запись в список и вывод в консоль
	List<Integer> bugTime = new ArrayList<>();
	List<Integer> bugNumber = new ArrayList<>();
	int q = 1;
	int i = -1;
	while (scanner.hasNext()) {
		if(scanner.hasNext()) {
			bugTime.add(scanner.nextInt());
			bugNumber.add(q++);
			i++;
			
			String formattedBugNumber = new DecimalFormat("00").format(bugNumber.get(i));
			String formattedBugTime = new DecimalFormat("00").format(bugTime.get(i));
			
			//System.out.println (formattedBugNumber+" |"+formattedBugTime+" |");
			
		}
		else {
			scanner.next();
		}
	}
	

	//Считать из консоли интервал [a, b]и погрешность e
	//Scanner in = new Scanner(System.in);
	//System.out.println ("Введите нижнюю границу интервала");
	double a = Double.valueOf(args[0]);
	//System.out.println ("Введите верхнюю границу интервала");
	double b = Double.valueOf(args[1]);
	//System.out.println ("Введите желаемую погрешность");
	double e = Double.valueOf(args[2]);
	
	//Вычислить общее количество ошибок в программе
	NumberOfBugs numberOfBugs = new NumberOfBugs();
	double c = numberOfBugs.BugsCalc(a, b, e, bugTime, bugNumber);
	
	
	//Вычислить коэффициент пропорциональности	
	ScaleFactor scaleFactor = new ScaleFactor();
	double k1= scaleFactor.ScaleFactorCalc(c, bugTime, bugNumber );
		
		
	//Вычислить среднее время до появления ошибки	
	AverageBugTime averageBugTime = new AverageBugTime();
	double t = averageBugTime.AverageBugTimeCalc(c, k1, bugTime);
	
	
	//Вычислить время до начала тестирования
	TestingStartTime testingStartTime  = new TestingStartTime();
	double tt =  testingStartTime.TestingStartTimeCalc (c, k1, bugTime, bugNumber);
	}
}
