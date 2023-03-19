package c;

import java.util.Arrays;

import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Piece;
import piece.Queen;
import piece.Rock;
/**
 * class to store the Board and process
 * @author Qihan Lu
 *
 */
public class Board {
	/**
	 * store the main Board
	 */
	public static Piece [][] p=new Piece[8][8];
	/**
	 * store the temp Board
	 */
	public static Piece [][] temp=new Piece[8][8];
	/**
	 * store the temp Board
	 */
	public static Piece [][] temp1=new Piece[8][8];
	/**
	 * store the number of moves
	 */
	public static int move=0;
	/**
	 * set the Board
	 */
	public static void set(){
		p [0][0]= new Rock(true);
		p [0][7]= new Rock(true);
		p [7][0]= new Rock(false);
		p [7][7]= new Rock(false);
		p [0][1]= new Knight(true);
		p [0][6]= new Knight(true);
		p [7][1]= new Knight(false);
		p [7][6]= new Knight(false);
		p [0][2]= new Bishop(true);
		p [0][5]= new Bishop(true);
		p [7][2]= new Bishop(false);
		p [7][5]= new Bishop(false);
		p [0][3]= new Queen(true);
		p [7][3]= new Queen(false);
		p [0][4]=new King(true);
		p [7][4]= new King(false);
		for(int a=0;a<8;a++) {
			p[1][a]= new Pawn(true);
			p[6][a]= new Pawn(false);
		}
	}
	/**
	 * @return true if black is in checkmate, false if black is not in checkmate
	 */
	public static Boolean isBlackInCheckMate() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(p[i][j]!=null) {
					if(p[i][j].isblack==true) {
						for(int a=0;a<8;a++) {
							for(int b=0;b<8;b++) {
								if(p[i][j].ismovevalid(i,j,a,b)){
									 temp1=Arrays.stream(p).map(Piece[]::clone).toArray(Piece[][]::new);
									 p[i][j].move(i, j, a, b);
									 move++;
									 Chess.iswhiteturn=true;
									 if(!isBlackInCheck()) {
										 System.out.print("hint ");
										 System.out.print(i+" ");
								  	     System.out.print(j+ " ");
									     System.out.print(a+ " ");
										 System.out.println(b+" ");
										 p=Arrays.stream(temp1).map(Piece[]::clone).toArray(Piece[][]::new);
										 move--;
										 return false;
									 }else {
										 Chess.iswhiteturn=false;
										 p=Arrays.stream(temp1).map(Piece[]::clone).toArray(Piece[][]::new);
										 move--;
									 }
								}
							}
						}
					}
				}
			}
		}
		Chess.iswhiteturn=true;
		return true;
	}
	/**
	 * @return true if white is in checkmate, false if white is not in checkmate
	 */
	public static Boolean isWhiteInCheckMate() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(p[i][j]!=null) {
					if(p[i][j].isblack==false) {
						for(int a=0;a<8;a++) {
							for(int b=0;b<8;b++) {
								if(p[i][j].ismovevalid(i,j,a,b)){
									 temp1=Arrays.stream(p).map(Piece[]::clone).toArray(Piece[][]::new);
									 p[i][j].move(i, j, a, b);
									 move++;
									 Chess.iswhiteturn=false;
									 if(!isWhiteInCheck()) {
										 System.out.print("hint ");
										 System.out.print(i+" ");
								  	     System.out.print(j+ " ");
									     System.out.print(a+" ");
										 System.out.println(b+" ");
										 p=Arrays.stream(temp1).map(Piece[]::clone).toArray(Piece[][]::new);
										 move--;
										 return false;
									 }else {
										 Chess.iswhiteturn=true;
										 p=Arrays.stream(temp1).map(Piece[]::clone).toArray(Piece[][]::new);
										 move--;
									 }
								}
							}
						}
					}
				}
			}
		}
		Chess.iswhiteturn=false;
		return true;
	}
	/**
	 * @return true if black is in check, false if black is not in check
	 */
	public static Boolean isBlackInCheck() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(p[i][j]!=null) {
					if(p[i][j].isblack==false && p[i][j].ismovevalid(i,j,BkRow(),BkColumn())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * @return true if white is in check, false if white is not in check
	 */
	public static Boolean isWhiteInCheck() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(p[i][j]!=null) {
					if(p[i][j].isblack==true && p[i][j].ismovevalid(i,j,WkRow(),WkColumn())) {

						
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * @return row number of black king
	 */
	public static int BkRow() {
		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				if(Board.p[r][c]!=null) {
					if(Board.p[r][c].getname().equals("bK")) return r;
				}
			}
		}
		return -1;
	}
	/**
	 * @return column number of black king
	 */
	public static int BkColumn() {
		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				if(Board.p[r][c]!=null) {
					if(Board.p[r][c].getname().equals("bK")) return c;
				}
			}
		}
		return -1;
	}
	/**
	 * @return row number of white king
	 */
	public static int WkRow() {
		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				if(Board.p[r][c]!=null) {
					if(Board.p[r][c].getname().equals("wK")) return r;
				}
			}
		}
		return -1;
	}
	/**
	 * @return column number of white king
	 */
	public static int WkColumn() {
		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				if(Board.p[r][c]!=null) {
					if(Board.p[r][c].getname().equals("wK")) return c;
				}
			}
		}
		return -1;
	}
	/**
	 * print the Board
	 */
    public static void print() {
    	for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
			if(p[r][c]!=null) {
				System.out.print(p[r][c].getname()+" ");
			}else if ((r+c)%2==1) {
					System.out.print("## ");
				}else System.out.print("   ");
			}
			System.out.println(8-r);
		}
    	System.out.print(" a  b  c  d  e  f  g  h");
	}
}
