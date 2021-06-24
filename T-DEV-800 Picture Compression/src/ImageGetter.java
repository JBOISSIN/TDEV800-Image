import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;

public class ImageGetter {

    BufferedImage ImageInput = null;
    BufferedImage ImageOut = null;
    String ImagePath;

    public ImageGetter (){

    } 


    // Récupération de l'image initiale
    public void getInputImage(String path){
        ImagePath = path;
        try {
            ImageInput = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        System.out.println(""+ImageInput.getWidth()+""+ImageInput.getHeight()+"");

    }


    // Récupérations des pixels de l'image originale vers l'image Virtuelle d'entrée
    public Image transformToVirtualImage(){
        Image virtualImage = new Image(ImageInput.getWidth(),ImageInput.getHeight());
        for (int i = 0 ; i < ImageInput.getWidth() ; i++){
            for (int j = 0 ; j < ImageInput.getHeight(); j++){

                Color pix = new Color(ImageInput.getRGB(i,j));

                virtualImage.modifyPixelImage(i, j, pix.getRed(), pix.getGreen(), pix.getBlue());

            }
        }
        return virtualImage;
    }
    

    // Allocation de la BufferedImage de sortie avec les bonnes dimentions puis remplissage des pixels via appel de fonction
    public void creatOutputImage(Image pixelTable){
        ImageOut = new BufferedImage(ImageInput.getWidth(),ImageInput.getHeight(),BufferedImage.TYPE_INT_RGB);
            System.out.println("Buffered dim = Width = "+ ImageInput.getWidth()+" | Height = "+ImageInput.getHeight()+"");
        try {
            fillOutputImage(pixelTable);
        } catch (Exception f) {
            System.out.println("Error: " + f);
        }
        System.out.println("Creating File Image");
        createFileImage();

    }


    public void createFileImage(){
        File outputfile = new File(ImagePath);
        try {
            ImageIO.write(ImageOut, "jpg", outputfile);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // Remplie l'image de sortie avec les pixels de l'image Virtuelle
    public void fillOutputImage(Image pixelTable){
        
        for (int i = 0 ; i < pixelTable.getWidth() ; i++){
            for (int j = 0 ; j < pixelTable.getHeight() ; j++){
                
                int rgb = 0;
			    rgb = rgb | (255 << 24);
			    rgb = rgb | (pixelTable.getPixel(i, j).getRed() << 16);
			    rgb = rgb | (pixelTable.getPixel(i, j).getGreen() << 8);
			    rgb = rgb | pixelTable.getPixel(i, j).getBlue();

                ImageOut.setRGB(i, j, rgb);

            }
        }
    }

}


