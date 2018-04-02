package kr.co.bit.linux;

import java.util.Random;
import java.util.Scanner;


public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainTest mt = new MainTest();
		mt.startGame();
	}
	
	public void startGame() {
	
		
		String[] hiddenNumber = null;
		String[] inputNumber = null;
		
		Scanner sc = new Scanner(System.in);
		
		hiddenNumber = this.makeHiddenNumber();
		
		while(true) {
			int strike=0;
			int ball=0;
			System.out.print("세 자리 수를 입력하시오\n>>>");
			String number =String.valueOf(sc.nextInt());
			
			if(this.isDuplicate(number)) {
				System.out.println("중복된 숫자는 입력이 불가합니다.");
			} else {
			
				inputNumber = getArray(number);
				
				for(int i=0; i<number.length(); i++) {
					for(int j=0; j<number.length();j++) {
						if(inputNumber[i].equals(hiddenNumber[j])&& i==j) {
							strike++;
							
						} else if(inputNumber[i].equals(hiddenNumber[j])) {
							ball++;
						}
				    }
				}
				System.out.println(strike+"스트라이크 "+ ball+ "볼");
				if(strike==3) {
					System.out.println("Success!!");
					break;	
				}
			}
		}
		
			
		sc.close();
	}
	
	
	public String[] getArray(String number) {
		
		String[] numbers = new String[number.length()];  
		
		for(int i=0; i<number.length(); i++) {
			numbers[i]= String.valueOf(number.charAt(i));   
		}
		
		return numbers;
	}
	
	
	public String[] makeHiddenNumber() {
		
		int count=0;
		
		while(true) {
			int num = new Random().nextInt(900)+100;  //0~0.99999 *900  0~899+100 === 100~999
			
			
			String number= String.valueOf(num);
			boolean flag = this.isDuplicate(number); 
	
			if(!flag) {
				
				System.out.println(number+"---->"+count);
				System.out.println("[게임 준비완료]");
			
				String[] numbers = getArray(number);
				return numbers;
			}
			
			count++;
		
		}
	}
	
	
	
	
	public boolean isDuplicate(String number) {  //들어가는건 String 변수인데 나오는건 boolean .. 멋진 발상
		
		String[] numbers = new String[number.length()];  // String[] 배열 선언할때는 반드시 [] 안에 배열의 길이를 적어주어야한다. 만약 적지 않으려면 list를 써야함.
		boolean flag = false;
		
		for(int i=0; i<number.length(); i++) {
			numbers[i]= String.valueOf(number.charAt(i));   // String.valueOf() --> 괄호안의 문자 또는 숫자 값을 String으로 변환.  cf) Integer.parseInt()   --> string을 int로 변환할때 씀 
		}													
		
		for(int i=0; i<numbers.length-1; i++) {
			
			for(int j=i+1; j<numbers.length ; j++) {
				
				if(numbers[i].equals(numbers[j])) {
					
					 flag= true;
					 break;
				}
			}
			
			if(flag) {
				
				 break;
			}
		}
		return flag;
		
	}

}
