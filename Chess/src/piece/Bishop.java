package piece;
import c.Board;
import c.Chess;
/**
 * class of Bishop
 * @author Qihan Lu
 *
 */
public class Bishop extends Piece{
	/**
	 * 
	 * @param isblack if the bishop is black
	 */
	public Bishop(Boolean isblack) {
		super(isblack);
		
		// TODO Auto-generated constructor stub
	}
	public String getname() {
    	if (isblack==true) {return "bB";}
    	else return "wB"; 
	}
	public Boolean ismovevalid(int r0, int c0,int r1,int c1) {
		if(isblack==Chess.iswhiteturn) return false;
		if(Math.abs(r0-r1)!=Math.abs(c0-c1)) return false;
		if(r0==r1 && c0==c1) {
			return false;
		}else if(r1-r0>0 && c1-c0>0) {
			for (int a=1;a<r1-r0;a++) {
				if(Board.p[r0+a][c0+a]!=null) {
					return false;
			    }
			}
		} else if(r0-r1>0 && c1-c0>0) {
			for (int a=1;a<r0-r1;a++) {
					if(Board.p[r0-a][c0+a]!=null) {
						return false;
					}
			}
		} else if(r1-r0>0 && c0-c1>0) {
			for (int a=1;a<r1-r0;a++) {
					if(Board.p[r0+a][c0-a]!=null) {
						return false;
					}
			}
		} else {
			for(int a=1;a<r0-r1;a++) {
					if(Board.p[r0-a][c0-a]!=null) {
						return false;
					}
			}
		}
		if(Board.p[r1][c1]!=null) {
			if(Board.p[r0][c0].isblack==Board.p[r1][c1].isblack) return false;
		}
		
		return true;
	}
    public void move(int r0, int c0, int r1,int c1) {
    	Board.p[r1][c1]=Board.p[r0][c0];
    	Board.p[r0][c0]=null;
    }
}
