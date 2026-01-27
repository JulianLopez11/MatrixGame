package domain;

public class Agent extends Thread {
    private int xPosition;
    private int yPosition;

    public Agent(int posX, int posY){
        this.xPosition=posX;
        this.yPosition=posY;
        
    }
    
    @Override
    public void run(){
        try{
            while(!isInterrupted()){
                Thread.sleep(1500);
            }
        }catch(InterruptedException e){
            
        }
        
    }
    
    public int getxPosition() {
        return xPosition;
    }
    
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    
    public int getyPosition() {
        return yPosition;
    }
    
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
