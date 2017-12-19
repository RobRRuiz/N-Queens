import java.util.Random;
import java.util.Scanner;

public class Test {
	private static int testing=0;
	public static void main(String args[]){
		Scanner kb= new Scanner(System.in);
		int n;
	
		//int solved=0;
		//int search=0;
		Board bor;
		System.out.print("Please enter the number of queens:");
		n=kb.nextInt();
		//int[] arrr={2,3,4,5,7,3,0,4};
		//long startTime=System.nanoTime();
		//while(testing<100){
			int[] arrr=generateInitial(n);
			HC hillclimb=new HC(arrr,n);
			bor=hillclimb.solve();
			MinCon mc=new MinCon(arrr,1000000);
			bor=mc.Solve();
			//if(bor.getHeur()==0){
			//solved+=1;
			//}
			//search+=hillclimb.count();
			//search+=mc.count();
			//testing++;
		//}
		//long endTime=System.nanoTime();
		//long elapsedTime=endTime-startTime;
		//System.out.print("solved solution:"+solved+"\nTotal Time:"+elapsedTime+"\nCount"+search);
		
		//HC hillclimb=new HC(generateInitial(n),n);
		
		
		
		//MinCon mc=new MinCon(arrr,1000);
		
	}
	/**
	 * this method generates the initial state by creating an int
	 * array which is uses the array index to represent the column 
	 * the queen is at and the value at that index to represent row
	 * @param num
	 * @return
	 */
	public static int[] generateInitial(int num){
		int[] temp=new int[num];
		Random r= new Random();
		for(int i=0;i<num;i++){
			//a number between 0 and num to represent the row
			temp[i]=r.nextInt(num);
		}
		return temp;
	}
}
