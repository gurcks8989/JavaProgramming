package KimJunghyun;

import java.util.Scanner;
import java.lang.Math;

public class Calculator{

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);	// Scanner class declaration
		
		System.out.println("계산기입니다.");	// Introduce what program
		System.out.println("원하시는 작업을 선택해주세요.");
		System.out.println("1.실수 계산 2.삼각함수 계산");	// choose a kind of number between real number and  trigonometrical function
		
		int choose1, choose2, choose3, choose4, choose5, choose6;	// declare how to calculate
		int inputNum1;	// continue calculate
		int decision;	// decide continue calculation or not
		choose1 = keyboard.nextInt();	// choose real number or  trigonometrical function
		double n1, n2, result;	// input first calculate number
		
		if(choose1 == 1)	// calculate real number
		{
			System.out.println("원하시는 계산 방식을 선택해주세요.");
			System.out.println("1.addition 2.subtraction 3.multiplication 4.division 5.involution");
		
			choose2 = keyboard.nextInt();	// choose method of calculation
				
			System.out.println("계산하고싶은 숫자 두 개를 입력하세요.");
			n1 = keyboard.nextDouble();
			n2 = keyboard.nextDouble();
		
			if(choose2 == 1)	// addition
				result = n1 + n2;
			
			else if(choose2 == 2)	// subtraction
				result = n1 - n2;
			
			else if(choose2 == 3)	// multiplication
				result = n1 * n2;
			
			else if(choose2 == 4)	// division
				result = n1 / n2;
			
			else	// involution
				result = Math.pow(n1, n2);
			
			System.out.println("결과값은 " + result + " 입니다.");	// result of calculation between n1 and n2
		
			while(true)	// continue calculation or not
			{
				System.out.println("계산을 더 하시겠습니까? (Y = 1 / N = 0)");
				decision = keyboard.nextInt();	// decide continue or not
				if(decision == 1)	// continue
				{
					System.out.println("원하시는 작업을 선택해주세요.");	
					System.out.println("1.addition 2.subtraction 3.multiplication 4.division 5.involution");
					choose3 = keyboard.nextInt();
					System.out.println("이어서 계산하실 수를 입력해주세요.");
					inputNum1 = keyboard.nextInt();	// continue number
					if(choose3 == 1)	// addition
					{
						result = result + inputNum1;
						System.out.println("결과값은 " + result + " 입니다.");
					}
					else if(choose3 == 2)	// subtraction
					{
						result = result - inputNum1;
						System.out.println("결과값은 " + result + " 입니다.");
					}
					else if(choose3 == 3)	// multiplication
					{
						result = result * inputNum1;
						System.out.println("결과값은 " + result + " 입니다.");
					}
					else if(choose3 == 4)	// division
					{
						result = result / inputNum1;
						System.out.println("결과값은 " + result + " 입니다.");
					}
					else	// involution
					{
						result = Math.pow(result, inputNum1);
						System.out.println("결과값은 " + result + " 입니다.");
					}
				}
				
				else	// stop
					break;
			}
			
		System.out.print("결과값은 " + result + " 입니다.");	// print the final result value
		
		}
		
		else	// calculate trigonometrical function
		{
			double saveTri1, saveTri2, saveTri3;	// save value
			double inputNum2, inputNum3, inputNum4;	// input want knowing trigonometrical function

			System.out.println("첫 번째는 어떤 삼각함수인가요?");
			System.out.println("1.cos 2.sin 3.tan");
			choose2 = keyboard.nextInt();	// choose what trigonometrical function
			System.out.println("삼각함수를 구하고 싶은 수를 입력하세요.");
			inputNum2 = keyboard.nextDouble();	// want knowing inputNum2's trigonometrical function
			
			if(choose2 == 1)	// cos trigonometrical function
				saveTri1 = Math.cos(inputNum2);
			else if(choose2 == 2)	// sin trigonometrical function
				saveTri1 = Math.sin(inputNum2);
			else	// tan trigonometrical function
				saveTri1 = Math.tan(inputNum2);
			System.out.println(saveTri1);	// print first trigonometrical function
			
			System.out.println("두 번째는 어떤 삼각함수인가요?");
			System.out.println("1.cos 2.sin 3.tan");
			choose3 = keyboard.nextInt();
			System.out.println("삼각함수를 구하고 싶은 수를 입력하세요.");
			inputNum3 = keyboard.nextDouble();
			
			if(choose3 == 1)
				saveTri2 = Math.cos(inputNum3);
			else if(choose3 == 2)
				saveTri2 = Math.sin(inputNum3);
			else
				saveTri2 = Math.tan(inputNum3);
			System.out.println(saveTri2);	// print second trigonometrical function
			
			System.out.println("원하시는 계산 방식을 선택해주세요.");
			System.out.println("1.addition 2.subtraction 3.multiplication 4.division 5.involution");
			
			choose4 = keyboard.nextInt();
			
			if(choose4 == 1)	// addition
				result = saveTri1 + saveTri2;
			
			else if(choose4 == 2)	// subtraction
				result = saveTri1 - saveTri2;
			
			else if(choose4 == 3)	// multiplication
				result = saveTri1 * saveTri2;
			
			else if(choose4 == 4)	// division
				result = saveTri1 / saveTri2;
			
			else	// involution
				result = Math.pow(saveTri1, saveTri2);
			
			System.out.println("결과값은 " + result + " 입니다.");	// print result of calculation between saveTri1 and saveTri2
			
			while(true) // continue calculation or not
			{
				System.out.println("계산을 더 하시겠습니까? (Y = 1 / N = 0)");
				decision = keyboard.nextInt();	// decide continue or not
				if(decision == 1)	// continue
				{
					System.out.println("원하시는 작업을 선택해주세요.");	
					System.out.println("1.addition 2.subtraction 3.multiplication 4.division 5.involution");
					choose5 = keyboard.nextInt();
					System.out.println("이어서 계산하실 수를 입력해주세요.");
					System.out.println("어떤 삼각함수인가요?");
					System.out.println("1.cos 2.sin 3.tan");
					choose6 = keyboard.nextInt();
					System.out.println("삼각함수를 구하고 싶은 수를 입력하세요.");
					inputNum4 = keyboard.nextDouble();
					if(choose6 == 1)
						saveTri3 = Math.cos(inputNum4);
					else if(choose6 == 2)
						saveTri3 = Math.sin(inputNum4);
					else
						saveTri3 = Math.tan(inputNum4);
					System.out.println(saveTri3);	// print continue number
					
					if(choose5 == 1)	// addition
					{
						result = result + saveTri3;
						System.out.println("결과값은 " + result + " 입니다.");
					}
					else if(choose5 == 2)	// subtraction
					{
						result = result - saveTri3;
						System.out.println("결과값은 " + result + " 입니다.");
					}
					else if(choose5 == 3)	// multiplication
					{
						result = result * saveTri3;
						System.out.println("결과값은 " + result + " 입니다.");
					}
					else if(choose5 == 4)	// division
					{
						result = result / saveTri3;
						System.out.println("결과값은 " + result + " 입니다.");
					}
					else	// involution
					{
						result = Math.pow(result, saveTri3);
						System.out.println("결과값은 " + result + " 입니다.");
					}
				}
				
				else	// stop
					break;
			}
			
			System.out.print("결과값은 " + result + " 입니다.");	// print the final result value
		}
	}
	
	public double addition(double num1, double num2) {
		return num1 + num2;
	}
	public double subtraction(double num1, double num2) {
		return num1 + num2;
	}
	public double multiplication(double num1, double num2) {
		return num1 + num2;
	}
	public double division(double num1, double num2) {
		return num1 + num2;
	}
	public double involution(double num1, double num2) {
		return num1 + num2;
	}
	

}
