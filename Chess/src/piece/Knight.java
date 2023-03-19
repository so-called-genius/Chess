package piece;
import c.Board;
import c.Chess;
/**
 * class of Knight
 * @author Qihan Lu
 *
 */
public class Knight extends Piece{
/**
 * 
 * @param isblack if the Knight is black
 */
	public Knight(Boolean isblack) {
		super(isblack);
		// TODO Auto-generated constructor stub
	}
	public String getname() {
    	if (isblack==true) {return "bN";}
    	else return "wN"; 
	}
	@Override
	public Boolean ismovevalid(int r0, int c0, int r1, int c1) {
		// TODO Auto-generated method stub
		if(isblack==Chess.iswhiteturn) return false;
		if(Math.abs(r1-r0)==1 && Math.abs(c1-c0)==2) return true;
		if(Math.abs(r1-r0)==2 && Math.abs(c1-c0)==1) return true;
		return false;
	}
	@Override
	public void move(int r0, int c0, int r1, int c1) {
		// TODO Auto-generated method stub
		Board.p[r1][c1]=Board.p[r0][c0];
		Board.p[r0][c0]=null;
	}

}
