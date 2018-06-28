package excelCompiler;

public class TypeChecker {
	
	public static boolean checker(Object o, Object o2){
		if (o.getClass().equals(o2.getClass())){
			//System.out.println("Same Type!");
			return true;
		}
		else {
			return false;
		}
	}
}
