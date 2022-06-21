package test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class ImageCompare {

	public static double compare(File file1, File file2) {

		BufferedImage img1=null,img2 = null;
		try {		
			//img1 = ImageIO.read(new File(".."+File.separator+"data" + File.separator + "test" + File.separator + "output_001.jpg" ));
			img1 = ImageIO.read(file1);
		} catch (IOException e) {
			System.err.println("Can't read "+file1);
			return 100.0;
		}
		try {
			//img2 = ImageIO.read(new File(".."+File.separator+"tmp" + File.separator + "test.jpg"));
			img2 = ImageIO.read(file2);
		} catch (IOException e) {
			System.err.println("Can't read "+file2);
			return 100.0;
		}

		int w1 = img1.getWidth();
		int w2 = img2.getWidth(); 
		int h1 = img1.getHeight();
		int h2 = img2.getHeight();
		if ((w1!=w2)||(h1!=h2)) {
			System.out.println("Both images should have same dimensions");
			return 100.0;
		}

		long diff = 0;
		for (int j = 0; j < h1; j++) {
			for (int i = 0; i < w1; i++) {
				int pixel1 = img1.getRGB(i, j);
				Color color1 = new Color(pixel1, true);
				int r1 = color1.getRed();
				int g1 = color1.getGreen();
				int b1 = color1.getBlue();
				int pixel2 = img2.getRGB(i, j);
				Color color2 = new Color(pixel2, true);
				int r2 = color2.getRed();
				int g2 = color2.getGreen();
				int b2= color2.getBlue();
				long data = Math.abs(r1-r2)+Math.abs(g1-g2)+ Math.abs(b1-b2);
				diff = diff+data;
			}
		}
		double avg = diff/(w1*h1*3);
		return (avg/255.0)*100.0;
	}
}


