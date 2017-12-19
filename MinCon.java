import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class MinCon {
private Board board;
private int sCount=0;
private int maxSteps;

	public MinCon(int[] initialProb,int maxStep){
		board=new Board(initialProb,initialProb.length);
		this.maxSteps=maxStep;
		System.out.println("Initial State:\n"+board);
		System.out.println("Number of attacking pairs:"+board.getHeur());
	}
	public Board Solve(){
		
		Board temp;
		int minimize;
		int i=0;
		while(i<maxSteps){
			PriorityQueue<Board> pq=new PriorityQueue<Board>();
			//Checks to see if the board is a solution
			if(board.getHeur()==0){
				System.out.println("Min Conflict Solution:\n"+board);
				return board;
			}
			//holds the list of column numbers(queens) 
			//which are attacking each other 
			ArrayList<Integer>in=board.getConflicted();
			//stores the variable chosen randomly using
			//get conflictQ method 
			int var=getConflictQ(in);
			//holds the succesors that are a result of moving 
			//the queen in the var column
			ArrayList<Board> b=board.succCol(board, var);
			//adds them to a priority queue to get the one 
			//that minimizes conflicts
			for(int k=0;k<b.size();k++){
				temp=new Board(b.get(k));
				pq.add(temp);
				sCount+=1;
			}
			b.clear();
			//gets the state that minimizes conflicts the most 
			minimize=pq.peek().getHeur();
			b.add(pq.poll());
			
			if(pq.size()>0){
				int check=pq.size();
				while(check>0){
					//checks to see if there are more positions minimize
					//conflicts just as well. If there are add them to 
					//arraylist b
					if(pq.peek().getHeur()==minimize){
						b.add(pq.poll());
					}
					if(pq.size()==0){
						break;
					}
					//System.out.println("loop");
					check+=-1;
				}
			}
			//randomly chooses among the states that
			//minimize conflicts the most
			Random r = new Random();
			board=new Board(b.get(r.nextInt(b.size())));
		i++;
		}
		return board;		
	}
	/**
	 * chooses the random variable chosen next from conflicted variables
	 * @return
	 */
	private int getConflictQ(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int queen=list.get(r.nextInt(list.size()));
		return queen;	
	}
	public int count(){
		return sCount;
	}
}
