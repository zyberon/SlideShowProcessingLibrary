package slideshow;
import processing.core.*;

/**
 * Class that shows an image
 * @author Alex Rivas Romagnoli
 *
 */
public class ImageBox {
	
    private String name;
    private float x0,y0,x1,y1;
    private int frame = 0;
    PApplet parent;
    
    /**
     * Constructor of the ImageBoc
     * @param name_ name of the image to be shown
     * @param parent_ skech in which the image is shown
     */
    public ImageBox(String name_, PApplet parent_) {
        name = name_;
        parent = parent_;
    }
    
    /**
     * Add the coordinates of the image
     * @param x0_ X of the  left top of the image
     * @param y0_ Y of the left top of the image
     * @param width_ width of the image
     * @param height_ height of the image
     */
    public void addCoords(float x0_,float y0_,float width_, float height_){
        x0 = x0_;
        y0 = y0_;
        x1 = width_;
        y1 = height_; 
    }
    
    /**
     * Puts the frame in which the image must be shown
     * @param frame_ the frame to be shown
     */
    public void addFrame(int frame_) {
        frame = frame_;
    }
    
    
    /**
     * Draws the image if the frame_ is less than the current frame
     * @param frame_ frame to compare with the current frame
     */
    public void draw(int frame_){
        if(frame_ < frame)
           return;
        PImage img; 
        img = parent.loadImage(name);
        img.resize((int)x1,(int)y1);
        parent.image(img,x0,y0);
    }   
}
