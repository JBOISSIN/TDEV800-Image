import java.time.LocalDate;
import java.util.Random;


public class App {
    public static void main(String[] args) throws Exception {
        /*
        LocalDate Today = LocalDate.now();
        System.out.println("Hello, World!");
        System.out.println(Today);
        */

        ImageGetter IG = new ImageGetter();
        //IG.getInputImage("D:/EPITECH Projets/T DEV 800/Shepard.jpg");
        IG.getInputImage(args[0]);
        Image ImageTest = IG.transformToVirtualImage();
        Compressor Cmp = new Compressor(ImageTest);
        Cmp.CompressionTypeA();

        IG.creatOutputImage(Cmp.getCompressedImage());


        //System.out.println(Cmp.getStringCompressee());
 //  "D:/EPITECH Projets/T DEV 800/Shepard.jpg"
/*
        Image ImageTest = new Image(159, 481, 256);
        System.out.println(ImageTest.getDimentions());
        System.out.println(ImageTest.ToString());

        

        System.out.println(Cmp.getStringCompressee());
        
        Cmp.CompressionTypeA();

        System.out.println(Cmp.getStringCompressee());
*/

        //Pixel Testpix = new Pixel();
        //Pixel Test2 = new Pixel(5,145,96);

        //System.out.println(Test.toString());
        //System.out.println(Test2.toString());
        //System.out.println(Testpix.toString());
       // Testpix.setRGB(24, 35, 48);

       // Image ImageTest = new Image(2, 2);
        /*Test.ImageTab[0][0].setRGB(24, 35, 48);
        Test.ImageTab[0][1].setRGB(54, 32, 12);
        Test.ImageTab[1][0].setRGB(12, 85, 39);
        Test.ImageTab[1][1].setRGB(38, 12, 37);*/


/*
        Test.modifyPixelImage(0, 0, 24, 35, 48);
        Test.modifyPixelImage(0, 1, 54, 32, 12);
        Test.modifyPixelImage(1, 0, 12, 85, 39);
        Test.modifyPixelImage(1, 1, 38, 12, 37);
*/
        //Test.ImageTab[0][0].randomizePixel(5);
        
        /*Random random = new Random();
        int nb;
        nb = random.nextInt(256);

        System.out.println(nb);
        nb = random.nextInt(256);*/
        
    }
}
