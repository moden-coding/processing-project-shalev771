import processing.core.*;

public class App extends PApplet{
    PImage img;
    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        background(173,216,230);
        img = loadImage("crowd.png");
    }

    public void settings(){
        size(650,500);
      
    }
    public void draw(){
        image(img,0 ,0 );

        fill(150, 75, 0);
       ellipse(80, 400, 80,80);
       fill(255,165 ,0 );  
       stroke(0, 0, 0); 
       ellipse(100, 380, 40, 40);
       fill(255, 200, 100);  
       stroke(0, 0, 0); 
       rect(400,25,150,100);
       fill(255, 255, 255);  
       stroke(0, 0, 0); 
       rect(455,80,50,70);




    }
}
