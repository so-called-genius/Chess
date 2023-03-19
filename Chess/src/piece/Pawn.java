package piece;
import c.Board;
import c.Chess;
/**
 * class of Pawn
 * @author Qihan Lu
 *
 */
public class Pawn extends Piece{
	Boolean isfirstmove=true;
	int doublemove=-1;
	/**
	 * initiate the Pawn
	 * @param isblack if the pawn is black
	 */
	public Pawn(Boolean isblack) {
		super(isblack);		// TODO Auto-generated constructor stub
	}
    public String getname() {
    	if (isblack==true) {return "bp";}
    	else return "wp"; 
    }
    public Boolean ismovevalid(int r0, int c0,int r1,int c1) {

		if(isblack==Chess.iswhiteturn) return false;
    	if(((Pawn)Board.p[r0][c0]).ispassant(r0,c0,r1,c1)) return true;
		if(c0==c1) {
			if(Chess.iswhiteturn==false) {
				if(r1-r0==2) {
					if(!isfirstmove) return false;
					if(Board.p[r0+1][c0]==null && Board.p[r0+2][c0]==null) return true;
				}else if(r1-r0==1) {
					if(Board.p[r0+1][c0]==null) return true;
				}else {
					return false;
				}
			}else if(Chess.iswhiteturn==true){
				if(r1-r0==-2) {
					if(!isfirstmove) return false;
					if(Board.p[r0-1][c0]==null && Board.p[r0-2][c0]==null) return true;
				}else if(r1-r0==-1) {
					if(Board.p[r0-1][c0]==null) return true;
				}else {
					return false;
				}
			}else return false;
		}else if(Chess.iswhiteturn==true) {
			if(r0!=r1+1) return false;
			if(Board.p[r1][c1]==null) return false;
			if(Math.abs(c0-c1)!=1) return false;
			if(Board.p[r1][c1].isblack==false) return false;
			return true;
		}else if(Chess.iswhiteturn==false) {
			if(r0!=r1-1) return false;
			if(Board.p[r1][c1]==null) return false;
			if(Math.abs(c0-c1)!=1) return false;
			if(Board.p[r1][c1].isblack==true) return false;
			return true;
		}
		return false;
    }
    /**
     * 
     * @param r0 row number of original place
     * @param c0 column number of original place
     * @param r1 row number of destination place
     * @param c1 column number of the destination place
     * @return if it is passant
     */
    public Boolean ispassant(int r0, int c0,int r1,int c1) {
    	if(Math.abs(c1-c0)!=1) return false;
    	if(Chess.iswhiteturn==false) {
    		if(r1-r0!=1) return false;
    		if(Board.p[r0][c1]!=null) {
        		if(!Board.p[r0][c1].getname().equals("wp")) return false;
        		if(((Pawn)Board.p[r0][c1]).doublemove!=Board.move-1) return false;
        	}else return false;
    	}else {
    		if(r0-r1!=1) return false;
    		if(Board.p[r0][c1]!=null) {
        		if(!Board.p[r0][c1].getname().equals("bp")) return false;
        		if(((Pawn)Board.p[r0][c1]).doublemove!=Board.move-1) return false;
        	}else return false;
    		
    	}
    	return true;
    }
	public void move(int r0, int c0, int r1, int c1) {
		if(r1==0 || r1==7) {
			move(r0,c0,r1,c1,"Q");
		}else {
			if(ispassant(r0,c0,r1,c1)) {
				Board.p[r0][c1]=null;
			}
			// TODO Auto-generated method stub
			isfirstmove=false;
			if(Math.abs(r1-r0)>1) {
				doublemove=Board.move;
			}
			Board.p[r1][c1]=Board.p[r0][c0];
			Board.p[r0][c0]=null;	
			}
	}
    /**
     * promote the pawn
     * @param r0 row number of original place
     * @param c0 column number of original place
     * @param r1 row number of destination place
     * @param c1 column number of the destination place
     * @param c the piece to promote to
     */
	public void move(int r0,int c0,int r1, int c1, String c) {
			if(c.equals("Q")) {
				Board.p[r1][c1]=new Queen(isblack);
				Board.p[r0][c0]=null;
			}else if(c.equals("R")) {
				Board.p[r1][c1]=new Rock(isblack);
				Board.p[r0][c0]=null;
			}else if(c.equals("B")) {
				Board.p[r1][c1]=new Bishop(isblack);
				Board.p[r0][c0]=null;
			}else if(c.equals("N")) {
				Board.p[r1][c1]=new Knight(isblack);
				Board.p[r0][c0]=null;
			}
	}
}
