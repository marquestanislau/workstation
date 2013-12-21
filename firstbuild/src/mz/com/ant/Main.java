package mz.com.ant;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		int a, b;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Insira o valor de 'X' .");
		a = in.nextInt();
		
		System.out.println("Insira o valor de 'Y' .");
		b= in.nextInt();
		
		System.out.println("O maior numero entre " + a +" e " + b + " e': " + compareTwoInteger(a,b));
		System.out.println("Bye bye! ;)");
		in.close();
		
	}
	
	protected boolean isNull(Object object) {
		return object == null;
	}
	
	public static int compareTwoInteger(int first, int second) {
		return first > second ? first: second;
	}
        
        //Compara dois numeros inteiros, se sao iguais ou nao.
        public static int theyAreTheSame(int first, int second) {
             return first == second ? first: -1;
        }
}
