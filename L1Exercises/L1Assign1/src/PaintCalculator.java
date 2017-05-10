import java.util.Scanner;

public class PaintCalculator {
    
	private float height;
    private float length;
    private float width;
    float amountCans;
    float cans;
  
    
    public PaintCalculator() {
    	amountCans=0.0f;
    	cans=0;

    	height=0;
        length=0;
        width=0;
    }
    
    public void getDimensionsFromUser() {
    	System.out.println("Enter the height, length and width in metres of this room:");
		
		Scanner input = new Scanner (System.in);
		height=input.nextFloat();
		length=input.nextFloat();
		width=input.nextFloat();
		
		if (height<=0 || length<=0 || width<=0) {
			System.out.println("Invalid message");
			System.exit(1);
		}
    }
    
    public void calcPaint() {
    	float area=2*length*height+2*width*height-2*4-2*1;
    	amountCans=area/50;    
    	if ((amountCans-(int)amountCans)==0)
    		cans= (int)amountCans;
    	else
    		cans=(int)amountCans+1;
 
    }
 
    public void display() {
    	System.out.print("You need "+amountCans+" cans of paint ");
		System.out.println("so you should buy "+cans+" cans"); 
	}
}
    
    

