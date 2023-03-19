package piece;
/**
 * class of the piece
 * @author Qihan Lu
 *
 */
public abstract class Piece {
	/**
	 * store the Boolean value to see if the piece if black
	 */
public Boolean isblack;
/**
 * initiate the piece
 * @param isblack if the piece is black
 */
	public Piece(Boolean isblack) {
		this.isblack=isblack;
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @return name of piece
	 */
    public abstract String getname();
    /**
     * 
     * @param r0 row number of original place
     * @param c0 column number of original place
     * @param r1 row number of destination place
     * @param c1 column number of the destination place
     * @return if the move is valid
     */
    public abstract Boolean ismovevalid(int r0, int c0,int r1,int c1);
    /**
     * move the piece from original place to the destination place
     * @param r0 row number of original place
     * @param c0 column number of original place
     * @param r1 row number of destination place
     * @param c1 column number of the destination place
     */
    public abstract void move(int r0, int c0,int r1,int c1);
}
