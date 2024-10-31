public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;




    public LinearEquation(int a, int b, int c, int d){
        x1 = a;
        y1 = b;
        x2 = c;
        y2 = d;
    }




    public double distance(){
        double x = x2-x1;
        double y = y2-y1;
        return roundedToHundredth(Math.sqrt(Math.pow(x,2)+Math.pow(y,2)));
    }




    public double yIntercept(){
        int add = 0;
        double x=x1;
        double y = y1;
        double slope = slope();
        if (x1<0){
            add=1;
        } else if (x1>0){
            add=-1;
            slope*=-1;
        } else {
            return y1;
        }




        if (x2==0){
            return y2;
        }




        while (x!=0){
            y+=slope;
            x+=add;
        }




        return roundedToHundredth(y);
    }




    public double slope(){
        double rise = y2-y1;
        double run = x2-x1;
        return roundedToHundredth(rise/run);
    }




    public String equation(){
        double y = yIntercept();
        String slope = "";
        String symbol = "+";
        if (y<0){
            symbol = "-";
            y*=-1;
        }


        int rise = y2-y1;
        int run = x2-x1;
        slope = rise+"/"+run;
        if (run!=0){
            if ((double)rise/(double)run==1 || (double)rise/(double)run==0){
                slope = "";
            } else if (rise/run==-1){
                slope = "-";
            }
        }




        if (rise<0 && run<0){
            rise*=-1;
            run*=-1;
        } else if (run<0){
            rise*=-1;
            run*=-1;
        }


        if (run!=0) {
            if (rise % run == 0 && rise/run!=1 && rise/run!=-1 && rise/run!=0) {
                if (y==0){
                    return "y = " + (rise / run) + "x";
                }
                return "y = " + (rise / run) + "x " + symbol + " " + y;
            }
        }


        if (rise == 0){
            return "y = "+y1;
        } else if (run==0){
            return "x = "+x1;
        } else {
            if (y==0){
                return "y = "+slope+"x";
            }
            return "y = "+slope+"x "+symbol+" "+y;
        }
    }




    public String coordinateForX(double x){
        double y = (slope()*x)+yIntercept();
        return "("+x+","+roundedToHundredth(y)+")";
    }




    public String lineInfo(){
        if (equation().substring(0,1).equals("x")){
            return "These points are on a vertical line: "+equation();
        }
        return "The two points are ("+x1+","+y1+") and ("+x2+","+y2+")\nThe equation of the line between these points is: "+equation()+"\nThe y-intercept of this line is: "+yIntercept()+"\nThe slope of this line is "+slope()+"\nThe distance between these points is "+distance();
    }




    private double roundedToHundredth(double toRound){
        return Math.round(toRound*100.0)/100.0;
    }




}


