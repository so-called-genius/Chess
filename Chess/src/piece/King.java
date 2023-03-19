package piece;
import c.Board;
import c.Chess;
/**
 * class of King
 * @author Qihan Lu
 *
 */
public class King extends Piece{
boolean ismoved=false;
/**
 * 
 * @param isblack if the King is black
 */
	public King(Boolean isblack) {
		super(isblack);
		// TODO Auto-generated constructor stub
	}
	public String getname() {
    	if (isblack==true) {return "bK";}
    	else return "wK"; 
	}
	@Override
	public Boolean ismovevalid(int r0, int c0, int r1, int c1) {
		if(isblack==Chess.iswhiteturn) return false;
		if(((King)Board.p[r0][c0]).iscastling(r0, c0, r1, c1)) return true;
		if(Math.abs(r0-r1)>1 || Math.abs(c0-c1)>1) return false;
		if(Board.p[r1][c1]!=null) {
			if(Board.p[r0][c0].isblack==Board.p[r1][c1].isblack) return false;
		}
		return true;
	}
	@Override
	public void move(int r0, int c0, int r1, int c1) {
		if(((King)Board.p[r0][c0]).iscastling(r0, c0, r1, c1)) {
			if(c0>c1) {
				Board.p[r0][0].move(r0,0,r0,3);
			}else {
				Board.p[r0][7].move(r0,7,r0,5);
			}
		}
		Board.p[r1][c1]=Board.p[r0][c0];
		Board.p[r0][c0]=null;
		ismoved=true;
		// TODO Auto-generated method stub
		
	}

	 /**
     * 
     * @param r0 row number of original place
     * @param c0 column number of original place
     * @param r1 row number of destination place
     * @param c1 column number of the destination place
     * @return if the move is castling move
     */
	public Boolean iscastling(int r0, int c0, int r1, int c1) {
		
		if(ismoved==true) return false;
		if(r0!=r1) return false;
		
		if(isblack==true) {
			if(c0-c1==2) {
				if(Board.p[r0][0]==null) return false;
				if(Board.p[r0][0].getname()!="bR") {
					return false;
				}else if(((Rock)Board.p[r0][0]).ismoved==true) {
					return false;
				}else if(Board.p[r0][1]!=null || Board.p[r0][2]!=null || Board.p[r0][3]!=null) {
					return false;
				}else if(Board.isBlackInCheck()) {
					return false;
				}else {
					move(r0,4,r0,3);			
					if(Board.isBlackInCheck()) {
						move(r0,3,r0,4);
						ismoved=false;
						return false;
					}
					move(r0,3,r0,2);	
					if(Board.isBlackInCheck()) {
						move(r0,2,r0,3);
						move(r0,3,r0,4);
						ismoved=false;
						return false;
					}
					move(r0,2,r0,3);
					move(r0,3,r0,4);
					ismoved=false;
					return true;
				}
			}else if(c0-c1==-2) {
				if(Board.p[r0][7]==null) return false;
				if(Board.p[r0][7].getname()!="bR") {
					return false;
				}else if(((Rock)Board.p[r0][7]).ismoved==true) {
					return false;
				}else if(Board.p[r0][5]!=null || Board.p[r0][6]!=null) {
					return false;
				}else if(Board.isBlackInCheck()) {
					return false;
				}else {
					move(r0,4,r0,5);		
					if(Board.isBlackInCheck()) {
						move(r0,5,r0,4);
						ismoved=false;	
						return false;
					}
					move(r0,5,r0,6);
					if(Board.isBlackInCheck()) {
						move(r0,6,r0,5);
						move(r0,5,r0,4);
						ismoved=false;
						return false;
					}
					move(r0,6,r0,5);
					move(r0,5,r0,4);
					ismoved=false;
					return true;
				}
			}else return false;
		}else {
			if(c0-c1==2) {
				if(Board.p[r0][0]==null) return false;
				if(Board.p[r0][0].getname()!="wR") {
					return false;
				}else if(((Rock)Board.p[r0][0]).ismoved==true) {
					return false;
				}else if(Board.p[r0][1]!=null || Board.p[r0][2]!=null || Board.p[r0][3]!=null) {
					return false;
				}else if(Board.isWhiteInCheck()) {
					return false;
				}else {
					move(r0,4,r0,3);		
					if(Board.isWhiteInCheck()) {
						move(r0,3,r0,4);
						ismoved=false;	
						return false;
					}
					move(r0,3,r0,2);
					if(Board.isWhiteInCheck()) {
						move(r0,2,r0,3);
						move(r0,3,r0,4);
						ismoved=false;
						return false;
					}
					move(r0,2,r0,3);
					move(r0,3,r0,4);
					ismoved=false;
					return true;
				}
			}else if(c0-c1==-2) {
				if(Board.p[r0][7]==null) return false;
				if(Board.p[r0][7].getname()!="wR") {
					return false;
				}else if(((Rock)Board.p[r0][7]).ismoved==true) {
					return false;
				}else if(Board.p[r0][5]!=null || Board.p[r0][6]!=null) {
					return false;
				}else if(Board.isWhiteInCheck()) {
					return false;
				}else {
					move(r0,4,r0,5);			
					if(Board.isWhiteInCheck()) {
						move(r0,5,r0,4);
						ismoved=false;
						return false;
					}
					move(r0,5,r0,6);
					if(Board.isWhiteInCheck()) {
						move(r0,6,r0,5);
						move(r0,5,r0,4);
						ismoved=false;
						return false;
					}
					move(r0,6,r0,5);
					move(r0,5,r0,4);
					ismoved=false;
					return true;
				}
			}else return false;
		
		}
	}
}
