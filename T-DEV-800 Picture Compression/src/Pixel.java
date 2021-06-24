import java.util.Random;

public class Pixel {
    
    private int Red;
    private int Green;
    private int Blue;

    public Pixel(){
        this.Red = 0;
        this.Green = 0;
        this.Blue = 0;
    }

    public Pixel (int R, int G, int B){
        this.Red = R;
        this.Green = G;
        this.Blue = B;
    }

    public void setRGB (int R, int G, int B){
        this.Red = R;
        this.Green = G;
        this.Blue = B;
    }

    public int getRed(){
        return this.Red;
    }
    public int getGreen(){
        return this.Green;
    }
    public int getBlue(){
        return this.Blue;
    }

    public void randomizePixel(int R){
        Random random = new Random();
        int nb;
        nb = random.nextInt(256);
        this.Red = nb;
        nb = random.nextInt(256);
        this.Green = nb;
        nb = random.nextInt(256);
        this.Blue = nb;
        }

    public String toString(){
        return "["+ this.Red + "/" + this.Green + "/" + this.Blue + "]";
    }


}
