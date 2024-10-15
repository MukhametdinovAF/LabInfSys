import java.io.*;
import java.text.DecimalFormat;
import java.util.List;

public class NumberOfBugs {

	
	
	public double BugsCalc  (double a, double b, double e, List<Integer> bugTime, List<Integer> bugNumber) {
		double c = 0;
		double ya = 0;
		double yb = 0;
		double yc = 0;
		double partOfFirstPartA =0;
		double firstPartA =0;

		double partOfFirstPartB =0;
		double firstPartB =0;

		double partOfFirstPartC =0;
		double firstPartC =0;

		double secondPart =0;
		double thirdPart =0;

		double x;
		
		//System.out.println  ("|LowerPoint a |MiddlePoint c|UpperPoint b |B(a)       |B(с)         |B(b)        |LeftPart(a)  |LeftPart(b) |LeftPart(c)  |RightPartDivisible |RightPartDivider|");
				
		
		
		while(Math.abs(b-a)>e) {
				c = (a+b)/2;
							
				firstPartA = 0; //левая часть уравнения (1/(B+i-1) от переменной a
				firstPartB = 0; //левая часть уравнения (1/(B+i-1) от переменной b
				firstPartC = 0;	//левая часть уравнения (1/(B+i-1) от переменной c
				secondPart = 0;//делимое правой части уравнения 
				thirdPart = 0; //делитель правой части уравнения
				for (int i = 0; i<bugTime.size(); i++ ) {
					
					
					partOfFirstPartA = 1/(a-bugNumber.get(i)+1);
					firstPartA = firstPartA+partOfFirstPartA;
										
					partOfFirstPartB = 1/(b-bugNumber.get(i)+1);
					firstPartB = firstPartB+partOfFirstPartB;
										
					partOfFirstPartC = 1/(c-bugNumber.get(i)+1);
					firstPartC = firstPartC+partOfFirstPartC;
					
					secondPart =secondPart+ bugTime.get(i);
										
					thirdPart = thirdPart+bugNumber.get(i)*bugTime.get(i);
				}
				
				ya = firstPartA-((bugTime.size()*secondPart)/((a+1)*secondPart-thirdPart));
				yb = firstPartB-((bugTime.size()*secondPart)/((b+1)*secondPart-thirdPart));
				yc = firstPartC-((bugTime.size()*secondPart)/((c+1)*secondPart-thirdPart));
							
				
//			String str = String.format (
//					"|%1$+.8f |%2$+.8f |%3$+.8f |%4$+.8f|%5$+.8f  |%6$+.8f |%7$+.8f  |%8$+.8f |%9$+.8f  |%10$+.8f      |%11$+.8f  |" ,
//					a, c, b, ya, yb, yc,	firstPartA, firstPartB, firstPartC, secondPart, thirdPart);
//			System.out.println(str);
			
					
			
			if (ya*yc<0) {
				a=a; b=c;
			}
			else if (yb*yc<0) {
				a=c; b=b;
				
			}
			else { 
				System.out.println ("На заданном промежутке ошибка: нет корня / значения точек диапазона не в области определения функции / на промежутке несколько корней");	
				c = (Float) null;
				break;
						}
			
		}
			
			System.out.println("Величина B равна: " + c);
		
			return c;
	}
	
}
