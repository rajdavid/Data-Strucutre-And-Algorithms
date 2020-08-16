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
            // move n-1 disc from rod(A)  to auxiallary rod (C) using "to rod" (B) as aux
		    towerOfHanoi(noOfDisc-1,fromRod,auxilaryRod,toRod);
		    System.out.println("Moved disk " + noOfDisc + " from rod " +  fromRod + " to rod " + toRod);
            // move n-1 disc from auxiallary rod (C) to  "to rod" (B)  using (A) as aux
            towerOfHanoi(noOfDisc-1,auxilaryRod,toRod,fromRod);
        }
        
	
    }	

}
/**
 * Time Complexity :
Let the time required for n disks is T(n) .
There are 2 recursive call for n-1 disks and one constant time operation to move a disk
from ‘from’ peg to ‘to’ peg . Let it be k1.
Therefore,
T(n) = 2 T(n-1) + k1
T(0) = k2 , a constant.
T(1) = 2 k2 + k1
T(2) = 4 k2 + 2k1 + k1
T(2) = 8 k2 + 4k1 + 2k1 + k1
Coefficient of k1 =2n
Coefficient of k2 =2n-1

*******Time complexity is O(2^n)  2 to power n , or O(a^n) where a is a constant greater than 1.******


So it has exponential time complexity. For single increase in problem size the time
required is double the previous one. This is computationally very expensive. Most of the
recursive programs takes exponential time that is why it is very hard to write them
iteratively .
Space Complexity:
Space for parameter for each call is independent of n i.e., constant. Let it be k .
When we do the 2nd recursive call 1st recursive call is over . So, we can reuse the space of
1st call for 2nd call . Hence ,
T(n) = T(n-1) + k
T(0) = k
T(1) = 2k
T(2) = 3k
T(3) = 4k

*******    So the space complexity is O(n). *******


Here time complexity is exponential but space complexity is linear . Often there is a trade
off between time and space complexity . 
 * 
 * 
 */