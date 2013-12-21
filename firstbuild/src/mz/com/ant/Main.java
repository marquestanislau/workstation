package mz.com.ant;

public class Main {
	
	public static void main(String[] args) {
		
		for(int i = 0; i < args.length; i++)
			System.out.println(args[i]);
		
	}
	
	protected boolean isNull(Object object) {
		return object == null;
	}
	
	public static int compareTwoInteger(int first, int second) {
		return first > second ? first: second;
	}
}
