import processing.core.*;

public class App extends PApplet {
    PImage img1;
    PImage img2;
    float length;
    float width;
    float ballX = 250;
    float ballY = 380;
    float ballSpeedX = 0;
    float ballSpeedY = 0;
    boolean launched = false;
    boolean scored = false;
   
    

    float rectX = 455;
    float rectY = 80;
    float rectW = 50;
    float rectH = 70;
          
    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        background(173, 216, 230);
        img1 = loadImage("crowd.png");
        img2 = loadImage("Tatum.png");

    }

    public void settings() {
        size(700, 500);

    }

    public void draw() {
       
        image(img1, 0, 0);
        image(img2, 60, 300, 200, 350);

        fill(150, 75, 0);

        fill(255, 165, 0);
        stroke(0, 0, 0);
        ellipse(ballX, ballY, 40, 40);
        fill(255, 200, 100);
        stroke(0, 0, 0);
        rect(400, 25, 150, 100);
        fill(255, 255, 255);
        stroke(0, 0, 0);
        rect(455, 80, 50, 70);
        if (launched == true) {
            System.out.println("ball moving");
            ballX += ballSpeedX;
            ballY += ballSpeedY;
            
        }  
        

            
        
        
        if (ballX < width || ballX == 0 || ballY > height || ballY == 0){
            System.out.println(ballX > width);
            System.out.println(ballX == 0);
            System.out.println(ballY > height);
            System.out.println(ballY == 0);
            System.out.println("reset");
            resetBall();
        }
         
        boolean scored = false;
        if (!scored && checkCollision()) {
            ballSpeedX = 0;  
            ballSpeedY = 0;  
            launched = false;  
            scored = true;  
            if (scored) {
                fill(0,255,0);  
                textSize(100); 
                text("JT for 3EEEEE", width / 20 - 10, height / 3);  
            }
        }
        }
    

   

    public void keyPressed() {

        boolean scored;
        if (key == ' ' && !launched) {
            ballSpeedX = 5;
            ballSpeedY = -5;
            launched = true; 

        }
    } public boolean checkCollision() {
        float ballRadius = 20;  
        
       
        if (ballX + ballRadius > rectX && ballX - ballRadius < rectX + rectW && 
            ballY + ballRadius > rectY && ballY - ballRadius < rectY + rectH) {
            return true;  
        }
        return false;  
    }

        public void resetBall() {
            ballX = 250;  
            ballY = 380; 
            ballSpeedX = 0; 
            ballSpeedY = 0; 
            launched = false;  
    }

}
