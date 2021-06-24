public class Compressor {
    
    private Image imageInitiale;
    private Image imageCompressee;


    public Compressor(Image I){
        this.imageInitiale = I;
        this.imageCompressee = new Image(I.getWidth(), I.getHeight());
    }

    public void CompressionTypeA(){
        for(int i = 0; i < this.imageInitiale.getWidth();i = i+2){
            for(int j = 0; j < this.imageInitiale.getHeight();j = j+2){
                //System.out.println(""+i+" / "+ j +"");
                if (j == (this.imageInitiale.getHeight()-1) && i != (this.imageInitiale.getWidth()-1)){
                    //System.out.println("Cas Spé Bot Only! "+j+" / " + (this.imageInitiale.getHeight()-1) +"");
                    this.specialCaseBotOnly(i, j);
                
                }else if(i == (this.imageInitiale.getWidth()-1) && j != (this.imageInitiale.getHeight()-1)){
                    //System.out.println("Cas Spé Right Only ! "+i+" / " + (this.imageInitiale.getWidth()-1) +"");
                    this.specialCaseRightOnly(i, j);
                    
                }else if(i == (this.imageInitiale.getWidth()-1) && j == (this.imageInitiale.getHeight()-1)){
                    //System.out.println("Cas Spé SOLO ! ");
                    this.specialCaseSoloOnly(i, j);
                }
                else{
                    //this.putAvgOnNew(imageInitiale.getPixel(i, j), i, j);
                    //System.out.println("" +this.getAvgPixel(i, j) + " TO "+i+" / "+ j +"");
                    this.putAvgOnNew(this.getAvgPixel(i, j), i, j);
                }

        }
        
    }

    }

    public Pixel getAvgPixel(int i, int j){
        
        int newR = (imageInitiale.getPixel(i,j).getRed() + imageInitiale.getPixel(i,j+1).getRed() + imageInitiale.getPixel(i+1,j).getRed() + imageInitiale.getPixel(i+1,j+1).getRed())/4;
        int newG = (imageInitiale.getPixel(i,j).getGreen() + imageInitiale.getPixel(i,j+1).getGreen() + imageInitiale.getPixel(i+1,j).getGreen() + imageInitiale.getPixel(i+1,j+1).getGreen())/4;
        int newB = (imageInitiale.getPixel(i,j).getBlue() + imageInitiale.getPixel(i,j+1).getBlue() + imageInitiale.getPixel(i+1,j).getBlue() + imageInitiale.getPixel(i+1,j+1).getBlue())/4;
        Pixel avgPixel = new Pixel(newR, newG, newB);  
        //System.out.println("NewR - "+newR+" | " + imageInitiale.getPixel(i,j).getRed() + " | " + imageInitiale.getPixel(i,j+1).getRed()+ " | " + imageInitiale.getPixel(i+1,j).getRed()+ " | " + imageInitiale.getPixel(i+1,j+1).getRed());
        return avgPixel;
    }


    public void putAvgOnNew(Pixel newPixel, int initWidth, int initHeight){
        this.imageCompressee.modifyPixelImage(initWidth, initHeight, newPixel.getRed(), newPixel.getGreen(), newPixel.getBlue());
        this.imageCompressee.modifyPixelImage(initWidth, initHeight+1, newPixel.getRed(), newPixel.getGreen(), newPixel.getBlue());
        this.imageCompressee.modifyPixelImage(initWidth+1, initHeight, newPixel.getRed(), newPixel.getGreen(), newPixel.getBlue());
        this.imageCompressee.modifyPixelImage(initWidth+1, initHeight+1, newPixel.getRed(), newPixel.getGreen(), newPixel.getBlue());
        //System.out.println(this.imageCompressee.getPixel(initWidth, initHeight) +"=="+ this.imageCompressee.getPixel(initWidth, initHeight+1) +"=="+ this.imageCompressee.getPixel(initWidth+1, initHeight) +"==" + this.imageCompressee.getPixel(initWidth+1, initHeight+1));
    }

    public void putAvgOnRightOnly(Pixel newPixel, int initWidth, int initHeight){
        System.out.println("b");
        this.imageCompressee.modifyPixelImage(initWidth, initHeight, newPixel.getRed(), newPixel.getGreen(), newPixel.getBlue());
        this.imageCompressee.modifyPixelImage(initWidth, initHeight+1, newPixel.getRed(), newPixel.getGreen(), newPixel.getBlue());
    }

    public void putAvgOnBotOnly(Pixel newPixel, int initWidth, int initHeight){
        System.out.println("c");
        this.imageCompressee.modifyPixelImage(initWidth, initHeight, newPixel.getRed(), newPixel.getGreen(), newPixel.getBlue());
        this.imageCompressee.modifyPixelImage(initWidth+1, initHeight, newPixel.getRed(), newPixel.getGreen(), newPixel.getBlue());
    }

    public void putAvgOnSolo(Pixel newPixel, int initWidth, int initHeight){
        System.out.println("d");
        this.imageCompressee.modifyPixelImage(initWidth, initHeight, newPixel.getRed(), newPixel.getGreen(), newPixel.getBlue());
    }

    public Image getCompressedImage(){
        return this.imageCompressee;
    }

    public String getStringCompressee(){
        return this.imageCompressee.ToString();
    }

    private void specialCaseBotOnly(int i, int j){
        
        this.putAvgOnBotOnly(imageInitiale.getPixel(i, j), i, j);
    }

    private void specialCaseRightOnly(int i, int j){

        this.putAvgOnRightOnly(imageInitiale.getPixel(i, j), i, j);
    }

    private void specialCaseSoloOnly(int i, int j){
        
        this.putAvgOnSolo(imageInitiale.getPixel(i, j), i, j);
    }

}