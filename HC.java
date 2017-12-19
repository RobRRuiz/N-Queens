import java.util.ArrayList;
import java.util.PriorityQueue;

public class HC {
	private Board board;
	private Board temp;
	private int searchCount=0;
	
	
	/**
	 * Takes in the initial setup of the board and the number of queens
	 * @param initialProblem The way the queens are set up represented as a 1-D array
	 * @param num The number of queens/ the board size
	 */
	public HC(int[] initialProblem,int num){
		board= new Board(initialProblem,num);
		System.out.println("Initial Board:\n"+board);
		System.out.println("Number of attacking pairs:"+board.getHeur());
	}
	public Board solve(){
		while(true){
			PriorityQueue<Board> pq=new PriorityQueue<Board>();
			//used to hold the successors of the board
			ArrayList<Board> succs;
			Board succc;
			//calls the board's succ method to get succesors
			succs=board.succ(board);
			//this loops goes through all the succesors
			//and adds them to a priority queue
			for(int i=0;i<succs.size();i++){
				succc=new Board(succs.get(i));
				pq.add(succc);
				searchCount++;
			}
			//This returns the best successor 
			temp=pq.poll();
			//If the value of the current is better than the 
			//value of the best succesor then end the hill climbing and
			//return the board
			if(board.getHeur()<=temp.getHeur()){
				if(board.getHeur()==0){
					System.out.print("Hill Climbing Solution:\n"+board+"\n");
					return board;
				}
				else{
					System.out.print("The closest HC solution:\n"+board);
					System.out.println("with "+board.getHeur()+" conflicts");
					return board;
				}
			}
			//if the successor is better than the current
			//then make board equal to the successor state
			else{
			this.board=new Board(temp);}
		}
	}
	public int count(){
		return searchCount;
	}
	
}
