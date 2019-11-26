package game.frog;

public class Location {

	private int row;
	private int col;
	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Location(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
	
	public void goLeft()
	{
		this.row -= 1;
	}
	
	public void goRight()
	{
		this.row += 1;
	}
	
	public void goStraight()
	{
		this.col -= 1;
	}
	
	
	public void frogGoLeft()
	{
		if(this.row > 0)
			this.row -= 1;
	}
	
	public void frogGoRigt(int size)
	{
		if(this.row < size - 1)
		this.row += 1;
	}

	
	
	
}
