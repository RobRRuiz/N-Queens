public class Queen {
	private int row;
	private int column;
	
	public Queen(int row, int column){
		this.row=row;
		this.column=column;
	}
	public Queen(Queen q){
		this.row=q.getRow();
		this.column=q.getCol();
	}
	/*
	 * Returns true if the calling queen can attack the parameter queen
	 */
	public boolean attack(Queen victim){
		if(this.row==victim.getRow()){
			//System.out.println("Queen "+(column+1)+"attacks "+"Queen"+(victim.getCol()+1));
			return true;
		}
		else if(Math.abs(this.row-victim.getRow())-(Math.abs(this.column-victim.getCol()))==0){
			//System.out.println("Queen "+(column+1)+"attacks "+"Queen"+(victim.getCol()+1));
			return true;
		}
		
		return false;
	}
	/*
	 * Returns the column in which the queen is located
	 */
	public int getCol() {
		// TODO Auto-generated method stub
		return column;
	}
	/*
	 * Returns the row where the queen is located
	 */
	public int getRow() {
		// TODO Auto-generated method stub
		return row;
	}
	public void setRow(int r) {
		// TODO Auto-generated method stub
		this.row=r;
		
	}
}
