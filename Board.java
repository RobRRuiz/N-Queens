import java.util.ArrayList;
public class Board implements Comparable<Board> {
	private Queen[] array;
	private int n;
	private int H;
	
	public Board(int[]arr,int n){
		this.n=n;
		array=new Queen[n];
		initialize(arr);
		H=getH();
		
	}
	public Board(Board b){
		this.n=b.getN();
		array=new Queen[n];
		for(int i=0;i<n;i++){
			this.array[i]=new Queen(b.array[i]);
		}
		H=getH();
	}

	private void initialize(int[] ar) {
		// TODO Auto-generated method stub
	
		for(int i=0;i<n;i++){
			int row=ar[i];
			int col=i;
			//Assigns a queen object to the position
			array[i]=new Queen(row,col);;
		}
	}
	/*
	 * This method is used to get the successors of board
	 * by going through each column(Queen) and placing that queen 
	 * in every possible row, except the row in which it is already
	 * placed. Return this as an arraylist of boards type.  
	 */
	public ArrayList<Board> succ(Board temp){
		ArrayList<Board> successors= new ArrayList<Board>();
		Board t=new Board(temp);
		Board tt;
		int curRow; 
		//col
		for(int i=0;i<n;i++){
			curRow=t.array[i].getRow();
			//row
			for(int j=0;j<n;j++){
				tt=new Board(t);
				if(curRow!=j){
					tt.array[i].setRow(j);
					successors.add(tt);
				}
			}
		}
		return successors;
	}
	/*
	 * This method is used by the min conflicts algorithm 
	 * to determine the successor states. These successors are obtained by 
	 * moving the specified queen(column-Col) to every other possible row in 
	 * that column(not including the one it is already placed in).
	 */
	public ArrayList<Board> succCol(Board temp,int Col){
		ArrayList<Board> successors= new ArrayList<Board>();
		Board t=new Board(temp);
		Board tt;
		int curRow;
		int curCol=Col;
		//get row for curCol
			curRow=t.array[curCol].getRow();
			//row
			for(int j=0;j<n;j++){
				tt=new Board(t);
				if(curRow!=j){
					tt.array[curCol].setRow(j);
					successors.add(tt);
				}
			}
		
		return successors;
	}
	public String toString(){
		String st="";
		char[][] arr=new char[n][n];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr[i][j]=' ';
			}
		}
		for(int i=0;i<n;i++){
			arr[array[i].getRow()][array[i].getCol()]='Q';
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				st+="["+ arr[i][j]+"]";
			}
			st+="\n";	
		}
		return st;
	}
	/*
	 * This method is used to set the number of conflicting pairs 
	 * of queens on the board
	 */
	private int getH(){
		int count=0;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(array[i].attack(array[j])){
					count++;
				}
			}
		}
		return count;
	}
	/*
	 * This method is used to return the number of conflicting pairs
	 * of queens on the board
	 */
	public int getHeur(){
		return H;
	}
	public int getN(){
		return n;
	}
	/*
	 * This method returns a list of queens which can attack each other.
	 * It is used for Min Confic algorithm to find the Variables which are conflicted.
	 * It returns the column number of the queen which is able to attack another queen using
	 *  an ArrayList of Integer type
	 */
	public ArrayList<Integer> getConflicted(){
		ArrayList<Integer> confQueens= new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(array[i].attack(array[j])){
					if(!confQueens.contains(i)){
						confQueens.add(i);
					}
					if(!confQueens.contains(j)){
						confQueens.add(j);
					}
					if(j==7&&!confQueens.contains(j)){
						confQueens.add(j);
					}
				}
			}
		}
		return confQueens;
	}
	@Override
	public int compareTo(Board br) {
		// TODO Auto-generated method stub
		if(this.H==br.getHeur()){
			return 0;
		}
		else if(this.H>br.getHeur()){
			return 1;
		}
		else if(this.H<br.getHeur()){
			return -1;
		}
		return 0;
	}
}
