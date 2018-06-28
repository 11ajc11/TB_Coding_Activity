package excelCompiler;

public class SizeChecker {
	public static boolean checker(Object o, Object o2){
		if (o.equals(o2)){
			//System.out.println("Same Size!");
			return true;
		}
		else {
			return false;
		}
	}
}
