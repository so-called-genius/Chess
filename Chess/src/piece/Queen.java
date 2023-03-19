package piece;
import c.Board;
import c.Chess;
/**
 * class of Queen
 * @author Qihan Lu
 *
 */
public class Queen extends Piece{
/**
 * 
 * @param isblack if the Queen is black
 */
	public Queen(Boolean isblack) {
		super(isblack);
		// TODO Auto-generated constructor stub
	}
	public String getname() {
    	if (isblack==true) {return "bQ";}
    	else return "wQ"; 
	}
	@Override
	public Boolean ismovevalid(int r0, int c0, int r1, int c1) {
		if(r0==r1 && c0==c1) return false;
		// Rock
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
		}else if(c0==c1){
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
			//Bishop
		}else if(Math.abs(r0-r1)!=Math.abs(c0-c1)) { 
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
			if(Board.p[r1][c1].isblack==Board.p[r0][c0].isblack) return false;
		}
	    return true;
	}
	@Override
	public void move(int r0, int c0, int r1, int c1) {
		// TODO Auto-generated method stub
		Board.p[r1][c1]=Board.p[r0][c0];
		Board.p[r0][c0]=null;
	}

}
