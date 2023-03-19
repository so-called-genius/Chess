package c;

import java.util.Arrays;
import java.util.Scanner;
import piece.Pawn;
import piece.Piece;
/**
 * The class to work with input and output
 * @author Qihan Lu 
 */
public class Chess {
/**
 * Check if white turn
 */
    public static boolean iswhiteturn=true;
/**
 * @param args method to read and write and choose what to do
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board.set();
        Board.print();
        System.out.println();
        String a;
        Scanner scanner = new Scanner(System.in);
        int r0,r1,c0,c1;
        while(true) {
        if(iswhiteturn==true) {
        	System.out.print("\nWhite's move:");
        }else {
        	System.out.print("\nBlack's move:");
        }
        
        a = scanner.nextLine();
        String [] input=a.split(" ");
        if(input.length>3 || input.length<1) {
        	System.out.println("No.0 Illegal move, try again");
        	continue;
        }
        if(input.length==3) {
        	if(input[2].equals("draw?")) {
        		System.out.println("draw");
        		break;
        	}
        }
        if(input.length==1 && input[0].equals("resign")) {
        	System.out.println("resign");
        	if(iswhiteturn==true) {
        	System.out.println("Black wins");
        	}else {
        	System.out.println("White wins");
        	}
        	break;
        }
        if(input.length<2 || input.length>3) continue;
        if(input[0].length()!=2) continue;
        if(input[1].length()!=2) continue;
        r0=8-Character.getNumericValue(input[0].charAt(1));
        c0=(int)input[0].charAt(0)-97;
        r1=8-Character.getNumericValue(input[1].charAt(1));
        c1=(int)input[1].charAt(0)-97;
//		   System.out.println(r0);
	//	   System.out.println(c0);
		//   System.out.println(r1);
		  // System.out.println(c1);
	   if(r0>7 || r0<0 || c0>7 || c0<0 || r1>7 || r1<0 || c1>7 || c1<0) {
		   System.out.print("No.1 Illegal move, try again");
	   }else if(Board.p[r0][c0]==null) {
    	   System.out.print("No.2 Illegal move, try again");
       }else {
    	   if(Board.p[r0][c0].ismovevalid(r0,c0,r1,c1)) {
    		   Board.temp=Arrays.stream(Board.p).map(Piece[]::clone).toArray(Piece[][]::new);
    		   if(input.length==3) {
    			   if(Board.p[r0][c0].getname().charAt(1)=='p') {
    				   if(r1!=0 && r1!=7) {
    					   System.out.print("No.5 Illegal move, try again");
    					   continue;
    				   }
    				   if(!input[2].equals("Q") && !input[2].equals("R") && !input[2].equals("B") && !input[2].equals("N")) {
    					   System.out.print("No.1 Illegal move, try again");
    					   continue;
    				   }
    				   ((Pawn)Board.p[r0][c0]).move(r0,c0,r1,c1,input[2]);
    			   }else {
    				   System.out.print("No.5 Illegal move, try again");
					   continue;
    			   }
    		   }else {
    			   Board.p[r0][c0].move(r0,c0,r1,c1);
    		   }
    		   Board.move++;
    		   /*
    		   if(!iswhiteturn) {
    			   iswhiteturn=true;
    			   System.out.println("black in check ="+Board.isBlackInCheck());
    		       iswhiteturn=false;
    		       System.out.println("white in check ="+Board.isWhiteInCheck());
    		       if(Board.p[6][5]!=null) {
    		    	   System.out.println(Board.p[6][5].getname());
					   System.out.println(Board.p[6][5].ismovevalid(6, 5, Board.wk.row, Board.wk.column));
    		       }
    		       System.out.println("whiteturn ="+ iswhiteturn);
    		   }else {
    			   System.out.println("black in check ="+Board.isBlackInCheck());
    		       iswhiteturn=false;
    		       if(Board.p[6][5]!=null) {
    		    	   System.out.println(Board.p[6][5].getname());
    		    	   System.out.print(Board.wk.row+" "+Board.wk.column+" ");
					   System.out.println(Board.p[6][5].ismovevalid(6, 5, Board.wk.row, Board.wk.column));
    		       }
    		       System.out.println("white in check ="+Board.isWhiteInCheck());
    		       iswhiteturn=true;
    		       System.out.println("whiteturn ="+ iswhiteturn);
    		   }
               */
    		   
               if(iswhiteturn) {
            	   iswhiteturn=false;
            	   if(Board.isWhiteInCheck()==true) {
        			   System.out.print("No.4 Illegal move, try again");
        			   Board.p=Arrays.stream(Board.temp).map(Piece[]::clone).toArray(Piece[][]::new);
        			   Board.move--;
        			   iswhiteturn=true;
        			   continue;
        		   }
            	   iswhiteturn=true;
        		   if(Board.isBlackInCheck()==true) {
        			   iswhiteturn=false;
        			   if(Board.isBlackInCheckMate()) {
        				   System.out.println();
        				   Board.print();
        				   System.out.println();
        				   System.out.println("\nCheckmate, White wins");
        				   break;
        			   }
        			   System.out.println("Check");
        		   }
               }else {
            	   iswhiteturn=true;
            	   if(Board.isBlackInCheck()==true) {
            		   System.out.print("No.3 Illegal move, try again");
            		   Board.p=Arrays.stream(Board.temp).map(Piece[]::clone).toArray(Piece[][]::new);
            		   Board.move--;
            		   iswhiteturn=false;
            		   continue;
            	   }
            	   iswhiteturn=false;

            	   if(Board.isWhiteInCheck()==true) {
            		   iswhiteturn=true;
           			   if(Board.isWhiteInCheckMate()) {
           				   System.out.println();
           				   Board.print();
           				   System.out.println();
           				   System.out.println("\nCheckmate, Black wins");
           				   break;
           			   }
           			   System.out.println("Check");
           		   }
               }
    		   iswhiteturn=!iswhiteturn;
    		   System.out.println();
    		   Board.print();
    		   System.out.println();
    	   }else {
    		   System.out.println(Board.p[r0][c0].getname());
    		   System.out.print("No.5 Illegal move, try again");
    	   }
       }
        
        
        }
        scanner.close();
        
        
        
	}

}
