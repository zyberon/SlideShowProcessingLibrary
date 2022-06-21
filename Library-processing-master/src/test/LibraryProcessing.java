package test;

import java.io.File;
import slideshow.*;
import processing.core.*;

public class LibraryProcessing extends PApplet {
   private static SlideShow theSlideShow = new SlideShow();
   private static float width;
   private static float height;
   private static Theme theme;

   @Override
   public void settings() {
      fullScreen();
   }

   @Override
   public void setup() {
      theSlideShow.addparent(this);
      width = 1080;
      height = 1920;
      theme = new Theme();
      theme.textStyle = new Style(
            this.createFont("Roboto-Regular.ttf",60),
            this.createFont("Roboto-Bold.ttf",60),
            this.createFont("Roboto-Italic.ttf",60),
            this.createFont("Roboto-BoldItalic.ttf",60),
            (float) 60.0,0xffc5d492);
      theme.background = loadImage("dark.jpg"); 
      theSlideShow.addSlide(new MySlide((int)width, (int)height, theme,this));
   }

   @Override
   public void draw() {
	   System.out.println("Working Directory = " + System.getProperty("user.dir"));
      theSlideShow.draw();
      this.save("tmp"+ File.separator+"test.jpg");
      exit();	
   }

   public static void main(String[] args) {
      PApplet.main(new String[] { "test.LibraryProcessing"});
   }
}

class MySlide extends ThemedSlide {
   Writer textArea1;
   MySlide(int width_, int height_,Theme theme, PApplet sketch) {
      super(width_, height_,theme,sketch);
      Style textStyle = new Style(theme.textStyle);
      textStyle.setSize(20);
      textArea1 = new Writer(textStyle, 300, 200, (float)0.6*width_, (float)0.2*height_,sketch);
      textArea1.addTextLine("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi faucibus interdum elit, molestie dictum tortor consectetur nec. Nam dignissim efficitur mi vel sagittis. Duis iaculis egestas ante. Vestibulum varius, dui vitae maximus euismod, nunc nisl volutpat diam, vel sodales ex lacus vel eros. Sed ac nisi at enim accumsan dignissim vel a arcu. Duis sodales aliquet eros sed facilisis. Phasellus aliquam lacus non urna imperdiet, eu efficitur purus auctor. Praesent eget dignissim dolor, at lacinia diam. Donec ac gravida justo. Quisque maximus mattis est at vestibulum. Ut lectus sem, ultrices quis dapibus eu, hendrerit ultricies libero. Suspendisse at feugiat elit. Aenean viverra eros eget lorem semper, a consequat ex vulputate. Cras congue nisl erat, non convallis velit egestas ac. Donec vulputate posuere dolor, sit amet dapibus mi tincidunt blandit.");
      addItem(textArea1);
   }
}

