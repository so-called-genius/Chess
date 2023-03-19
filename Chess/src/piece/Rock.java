package piece;
import c.Board;
import c.Chess;
/**
 * class of Rock
 * @author Qihan Lu
 *
 */
public class Rock extends Piece {
	boolean ismoved=false;
	/**
	 * 
	 * @param isblack if the Rock is black
	 */
	public Rock(Boolean isblack) {
		super(isblack);
		// TODO Auto-generated constructor stub
	}
	public String getname() {
    	if (isblack==true) {return "bR";}
    	else return "wR"; 
	}
	@Override
	public Boolean ismovevalid(int r0, int c0, int r1, int c1) {
		// TODO Auto-generated method stub
		if(r0!=r1 && c0!=c1) return false;
		if(r0==r1 && c0==c1) return false;
		if(isblack==Chess.iswhiteturn) return false;
		if(r0==r1) {
			if(c1>c0) {
				for(int a=c0+1;a<c1;a++) {
					if(Board.p[r0][a]!=null) {
						return false;
					}
				}
			}else {
				for(int a=c1+1;a<c0;a++) {
					if(Board.p[r0][a]!=null) {
						return false;
					}
				}
			}
		}else {
			if(r1>r0) {
				for(int a=r0+1;a<r1;a++) {
					if(Board.p[a][c0]!=null) {
						return false;
					}
				}
			}else {
				for(int a=r1+1;a<r0;a++) {
					if(Board.p[a][c0]!=null) {
						return false;
					}
				}
			}
		}
		if(Board.p[r1][c1]!=null) {
			if(Board.p[r1][c1].isblack==Board.p[r0][c0].isblack) return false;
		}
	    return true;
	}
	@Override
	public void move(int r0, int c0, int r1, int c1) {
		// TODO Auto-generated method stub
		Board.p[r1][c1]=Board.p[r0][c0];
    	Board.p[r0][c0]=null;
    	ismoved=true;
	}
}
