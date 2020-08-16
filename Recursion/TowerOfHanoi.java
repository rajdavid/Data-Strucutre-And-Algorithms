import java.util.Scanner;

public class TowerOfHanoi {

    public static void main(String args[]) {
	System.out.println("Enter number of Disc in tower of Hanoi");
	Scanner sc=new Scanner(System.in);
	int noOfDisc=sc.nextInt();
	sc.close();
	towerOfHanoi(noOfDisc,'A','C','B');
	
    }
    private static void towerOfHanoi(int noOfDisc, char fromRod, char toRod ,char auxilaryRod) {
    
        if(noOfDisc==1) {
		    System.out.println("Moved  disk 1 from "+fromRod+" to "+toRod);
		    return;
	    }
	    else {
		    towerOfHanoi(noOfDisc-1,fromRod,auxilaryRod,toRod);
		    System.out.println("Moved disk " + noOfDisc + " from rod " +  fromRod + " to rod " + toRod);
		    towerOfHanoi(noOfDisc-1,auxilaryRod,toRod,fromRod);
	    }
	
    }	

}