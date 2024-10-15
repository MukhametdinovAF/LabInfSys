import java.util.List;

public class ScaleFactor {

	
	public double ScaleFactorCalc (double c, List<Integer> bugTime, List<Integer> bugNumber ) {
		double k1 = 0;
		double k2 = 0;
		double partFirstB = 0;
		double partOfPartFirstB = 0;
		double partSecondB = 0;
		double partThirdB = 0;
	
	for (int i = 0; i<bugTime.size(); i++) {
		
		partOfPartFirstB=(c-i)*bugTime.get(i);
		partFirstB = partFirstB+partOfPartFirstB;
		
		partSecondB = partSecondB+bugTime.get(i);
		
		partThirdB = partThirdB+bugNumber.get(i)*bugTime.get(i);
		
		
	
	}
	
		
	k1=bugTime.size()/partFirstB;
	System.out.println ("Коэффициент пропорциональности1 " +k1);
			
	k2=bugTime.size()/((c+1)*partSecondB-partThirdB);
	System.out.println ("Коэффициент пропорциональности2 " +k2);
	
	return k1;

	}
}