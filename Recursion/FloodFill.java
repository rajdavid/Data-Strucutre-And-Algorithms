import java.util.Scanner;

class FloodFill{

    
    public void floodFill(int [][]screen ,int row, int col ,int prevNumber,int newNum){

        if(row< 0||row >=screen.length ||col <0 ||col >=screen[0].length)
            return;

        if(screen[row][col]!= prevNumber)
            return;    
        
            screen[row][col] = newNum;

        floodFill(screen , row+1 ,col ,prevNumber , newNum);
        floodFill(screen , row-1 ,col ,prevNumber , newNum);
        floodFill(screen , row ,col+1 ,prevNumber , newNum);
        floodFill(screen , row ,col-1 ,prevNumber , newNum);

    }

    public static void printScreen(int [][]screen){

        for(int i=0 ; i< screen.length ;i++){
            
            for(int j=0 ; j<screen[0].length ;j++){

                System.out.print(screen[i][j]+ " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {

            int [][] screen ={  {1, 1, 1, 1, 1, 1, 1, 1}, 
                                {1, 1, 1, 1, 1, 1, 0, 0}, 
                                {1, 0, 0, 1, 1, 0, 1, 1}, 
                                {1, 2, 2, 2, 2, 0, 1, 0}, 
                                {1, 1, 1, 2, 2, 0, 1, 0}, 
                                {1, 1, 1, 2, 2, 2, 2, 0}, 
                                {1, 1, 1, 1, 1, 2, 1, 1}, 
                                {1, 1, 1, 1, 1, 2, 2, 1}, 
                            };
            System.out.println("Screen before modifcation ");

            printScreen(screen);

             System.out.println("Enter row number");

             Scanner sc=new Scanner(System.in);
             int row=sc.nextInt();
        
             System.out.println("Enter col number");
             int col=sc.nextInt();

             System.out.println("Enter new number ");
            
             int newNum= sc.nextInt();
             
             sc.close();

            int prevNumber =screen[row][col];


            FloodFill fill=new FloodFill();
            
            fill.floodFill(screen,row ,col,prevNumber,newNum);
            
            System.out.println("Modified Screen  ");

            printScreen(screen);
    
    }

}