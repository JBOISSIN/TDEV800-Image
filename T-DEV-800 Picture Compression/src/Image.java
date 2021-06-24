
public class Image {
    
    private int Width;
    private int height;
    private Pixel [][] ImageTab;

    public Image (int L, int W){
        this.Width = L;
        this.height = W;
        ImageTab = new Pixel[this.Width][this.height];
        for(int i = 0;i<this.Width;i++){
            for(int j = 0;j<this.height;j++){
                this.ImageTab[i][j] = new Pixel();
            }
        }
        System.out.println("Image Vide créée");
    }

    public Image (int L, int W, int R){
  
        this.Width = L;
        this.height = W;
        this.ImageTab = new Pixel[this.Width][this.height];
        for(int i = 0;i<this.Width;i++){
            for(int j = 0;j<this.height;j++){
                this.ImageTab[i][j] = new Pixel();
                this.ImageTab[i][j].randomizePixel(R);
            }
        }
        System.out.println("Image Random créée");
    }

    public void modifyPixelImage(int i, int j, int R, int G, int B){
        this.ImageTab[i][j].setRGB(R, G, B);
    }

    public String getDimentions(){

        return "Width = " + this.getWidth() + " | Height = " + this.getHeight();
    }

    public int getWidth(){
        return this.Width;
    }

    public int getHeight(){
        return this.height;
    }

    public Pixel getPixel(int i, int j){
        return this.ImageTab[i][j];
    }



    public String ToString(){
        String Answer = new String("");        
        for(int i = 0;i<this.Width;i++){
            for(int j = 0;j<this.height;j++){
                Answer = Answer.concat(this.ImageTab[i][j].toString());
            }
            Answer = Answer.concat("\n");
        }
        return Answer;
    }
}
