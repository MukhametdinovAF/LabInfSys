import java.util.List;

public class AverageBugTime {
	public double AverageBugTimeCalc (double c, double k1, List<Integer> bugTime) {
		double t1 = 0;
	t1=1/(k1*(c-bugTime.size()));
	System.out.println ("Среднее время до появления ошибки " + t1);
	return t1;
	}
}
