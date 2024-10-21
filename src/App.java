import processing.core.*;

public class App extends PApplet {
    PImage img1;
    PImage img2;
    float length;
    float ballX = 250;
    float ballY = 380;
    float ballSpeedX = 0;
    float ballSpeedY = 0;
    boolean launched = false;
    boolean scored = false;
    int missCount = 0;
    int score = 0;

    float rectX = 455;
    float rectY = 80;
    float rectW = 50;
    float rectH = 70;

    float playerX = 60;
    float playerY = 300;
    float Speedplayer = 40;
    private boolean missed;
    boolean frameWhenCollided =  checkCollision();

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
        image(img2, playerX, playerY, 200, 350);

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
        if (scored) {

            int score = 0;
            launched = false;
            scored = true;
            score += 1;
            text("score: " + score, 200, 10);
            textSize(40);
            fill(0, 255, 0);
        }

        if (ballX > width || ballX < 0 || ballY > height || ballY < 0) {
            System.out.println(ballX > width);
            System.out.println("Ballx is " + ballX);
            System.out.println("width " + width);

            System.out.println("reset");
            fill(255, 0, 0);
            textSize(100);
            text("HOLY BRICK", width / 20 - 10, height / 3);
            resetBall(); 
            
            if (frameWhenCollided == 150 >= frameCount){
                fill(0, 255, 0);
            textSize(100);
            text("JT for 3EEEEE", width / 20 - 10, height / 3);

            }

           
               
            

        }

        
        if (checkCollision()) {
            ballSpeedX = 0;
            ballSpeedY = 0;
            launched = false;

            resetBall();
            fill(0, 255, 0);
            textSize(100);
            text("JT for 3EEEEE", width / 20 - 10, height / 3);

            // if (missed) {
            // fill(255, 0, 0);
            // textSize(100);
            // text("HOLY BRICK", width / 20 - 10, height / 3);
            // }
        }

    }

    public void keyPressed() {

        boolean scored;
        if (key == ' ' && !launched) {
            ballSpeedX = 10;
            ballSpeedY = -15;
            launched = true;

        }

        if (keyCode == RIGHT) {
            playerX += 30;
            ballX += 30;

        }
        if (keyCode == LEFT) {
            playerX -= 30;
            ballX -= 30;
        }
        if (keyCode == UP) {
            playerY -= 60;
            ballY -= 60;
        }
        if (keyCode == DOWN) {
            playerY += 60;
            ballY += 60;

        }
    }

    public boolean checkCollision() {
        
        int frameWhenCollided = frameCount; 
       
       
        float ballRadius = 20; 

        if (ballX + ballRadius > rectX && ballX - ballRadius < rectX + rectW &&
                ballY + ballRadius > rectY && ballY - ballRadius < rectY + rectH) {
            return true; 
        }
        return false;
    }

    public void resetBall() {
        ballX = playerX + 170;
        ballY = playerY + 170;
        ballSpeedX = 0;
        ballSpeedY = 0;
        launched = false;

    }

}
