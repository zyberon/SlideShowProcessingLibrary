package test;

import org.junit.BeforeClass;
import slideshow.*;
import processing.core.PApplet;
import java.io.File;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class JUnitTests {
   private static SlideShow theSlideShow = new SlideShow();
   private static Writer testWriter;
   private static float width=1920;
   private static float height=1080;
   private static PApplet sketch = new PApplet();
   private static ImageBox exampleIMG;
   private static ThemedSlide themedSlide;

   @BeforeClass
   public static void launch() {
      try {
    	
         String[] cmdarray = new String[] { "java", "-classpath", System.getProperty("java.class.path"), "test.LibraryProcessing" };
         Process process = Runtime.getRuntime().exec(cmdarray);
         process.waitFor();
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }

   @BeforeClass
   public static void initialize() {	
      exampleIMG = new ImageBox("cervantes.jpg",sketch);
      theSlideShow.addSlide(themedSlide);	
   }

   @Before
   public void createWriter() {
      Style style = new Style(20,20);
      testWriter = new Writer(style, 300, 200, (float)0.6*width, (float)0.2*height,sketch);
   }

   @Test
   public void test1() {
      assertTrue(ImageCompare.compare(
         new File(".."+File.separator+"data" + File.separator + "test" + File.separator + "output_001.jpg"),
         new File(".."+File.separator+"tmp" + File.separator + "test.jpg")
      ) < 0.1);
   }

   @Test
   public void addSlideTest() {	
      if(theSlideShow.getSlides().size() != 1) {			
         fail("Error adding slides");
      }
   }

   @Test
   public void addImageTest() {		
      testWriter.addImage(exampleIMG, height, height, width, height);
      if(testWriter.getImagesSize() != 1) {			
         fail("Error adding Images to the Writer");
      }
   }

   @Test
   public void addTextTest() {	
      testWriter.addText("Example text");
      if(testWriter.emptyParagraph().size() != 1) {			
         fail("Error adding text to the Writer");
      }
   }

   @Test
   public void addTextLine() {
      testWriter.addTextLine("Example text");
      if(testWriter.emptyParagraph().size() != 1|| testWriter.getPendingLineBreak() == false ) {			
         fail("Error adding textLine to the Writer");
      }
   }

   @Test
   public void addTextLineAlign() {
      testWriter.addTextLine("Example text");
      if(testWriter.emptyParagraph().size() != 1|| testWriter.getPendingLineBreak() == false || testWriter.emptyParagraph().get(0).getAlign() != testWriter.getAlign() ) {			
         fail("Problem with adding the alignment of the writer in addTextLine");
      }
   }

   @Test
   public void addTextDot() {
      testWriter.addTextDot("Example text");
      if(testWriter.emptyParagraph().size() != 1|| testWriter.getPendingLineBreak() != false || testWriter.emptyParagraph().get(0).getSpans().get(0).getDot() != true ) {			
         fail("Problem with adding the alignment of the writer in addTextLine");
      }
   }

   @Test
   public void ConsolidateBoxesTest() {
      Style style = new Style(20,20);
      ArrayList<Box> boxes = new ArrayList<Box>();
      Box box = new Box(100, 100,"test", style, 0, sketch);
      boxes.add(box);
      testWriter.consolidateBoxes(boxes , 100, 20, 20, 40, Align.RIGHT);
      if(box.getY() != 120 || box.getX() != 140 || testWriter.getBoxes().size() !=1) {	 
         fail("Error consolidating boxes in class Writer Rigth");
      }
      boxes = new ArrayList<Box>();
      box = new Box(100, 100,"test", style, 0, sketch);
      boxes.add(box);
      testWriter.consolidateBoxes(boxes , 100, 20, 20, 40, Align.LEFT);
      if(box.getY() != 120 || box.getX() != 100 || testWriter.getBoxes().size() !=2) {	 
         fail("Error consolidating boxes in class Writer LEFT");
      } 
      boxes = new ArrayList<Box>();
      box = new Box(100, 100,"test", style, 0, sketch);
      boxes.add(box);
      testWriter.consolidateBoxes(boxes , 100, 20, 20, 40, Align.CENTER);
      if(box.getY() != 120 || box.getX() != 120 || testWriter.getBoxes().size() !=3) {	 
         fail("Error consolidating boxes in class Writer CENTER");
      }
   }

   @Test
   public void boldTest() {
      testWriter.bold();
      if(testWriter.getStyle().getBold() != true) {	 
         fail("Error Bolding the text");
      }		
   }

   @Test
   public void unBoldTest() {
      testWriter.unBold();
      if(testWriter.getStyle().getBold() != false) {	 
         fail("Error UnBolding the text");
      }		
   }

   @Test
   public void setColorTest() {
      testWriter.setColor(200);
      if(testWriter.getStyle().getColor() != 200) {	 
         fail("Error changing the color of the text");
      }
   }

   @Test
   public void setSizeTest() {
      testWriter.setSize(20);
      if(testWriter.getStyle().getSize() != 20) {	 
         fail("Error changing the size of the text");
      }
   }

   @Test
   public void italicTest() {
      testWriter.italic();
      if(testWriter.getStyle().getItalic() != true) {	 
         fail("Error with ITtalic");
      }
   }

   @Test
   public void unItalicTest() {
      testWriter.unItalic();
      if(testWriter.getStyle().getItalic() != false) {	 
         fail("Error with UnItalic");
      }
   }
}
