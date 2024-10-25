import java.util.Scanner;


public class LinearEquationLogic {
    private Scanner myScanner;
    private LinearEquation linearEquation;




    public LinearEquationLogic(){
        myScanner = new Scanner(System.in);
        linearEquation = null;
    }




    public void start(){
        getCoordInfo();
        getData();
    }




    private void getCoordInfo(){
        System.out.println("Enter a coordinate (use the form (x,y)");
        String coord1 = myScanner.nextLine();
        System.out.println("Now enter another coordinate");
        String coord2 = myScanner.nextLine();
        int idx = coord1.indexOf(",");
        int x1 = Integer.parseInt(coord1.substring(1, idx));
        int y1 = Integer.parseInt(coord1.substring(idx+2,coord1.length()-1));
        idx = coord2.indexOf(",");
        int x2 = Integer.parseInt(coord2.substring(1, idx));
        int y2 = Integer.parseInt(coord2.substring(idx+2,coord2.length()-1));




        linearEquation = new LinearEquation(x1,y1,x2,y2);
    }




    private void getData(){
        System.out.println(linearEquation.lineInfo());
        if (!linearEquation.equation().substring(0,1).equals("x")){
            System.out.println("Enter a value for x: ");
            double x = myScanner.nextDouble();
            myScanner.nextLine();
            System.out.println();
            System.out.println(linearEquation.coordinateForX(x));
        }
        System.out.println("Would you like to enter another pair of coordinates? (y/n)");
        String answer = myScanner.nextLine();
        if (answer.equals("y")){
            getCoordInfo();
            getData();
        } else if (answer.equals("n")){
            System.out.println("Seeya!");
        } else {
            System.out.println("the program automatically quit");
        }
    }
















}
