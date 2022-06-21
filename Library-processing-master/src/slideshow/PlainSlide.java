package slideshow;

import java.util.ArrayList;

import processing.core.*;

/**
 * Slide without a Title, only has the background and the text
 * @author Alex Rivas Romagnoli
 *
 */
public class PlainSlide extends Slide {
    private int R,G,B;
    private int width, height;
    private PImage background = null;
    private ArrayList<Drawable> items = new ArrayList<Drawable>();
    protected PApplet parent;
    
    /**
     * Constructor of the PlainSlide
     * @param width_ width of the slide
     * @param height_ height of the slide
     * @param parent_ sketch of the slide
     */
    public PlainSlide(int width_, int height_, PApplet parent_) {
        width = width_;
        height = height_;
        parent = parent_;
    }
    
    @Override
    public void reset() {
        for (Drawable item : items) {
            item.reset();
        }
    }
    @Override
    public void draw() {
        if (background != null) {
            background.resize(width,height);
            parent.image(background,0,0); 
            
        } else {
        	
            parent.background(R,G,B); 
       
        }
        for (Drawable item : items) {
            item.draw();
        }
    }
    
    @Override
    public boolean keyPressed(char key) {
        boolean ended = true;
        for (Drawable item : items) {
            if (key == PApplet.CODED) {
                if (parent.keyCode == PApplet.RIGHT) {
                    ended &=  item.stepForward();
                } else if (parent.keyCode == PApplet.LEFT) {
                    ended &= item.stepBackward();
                }
            }
            else if (key == PApplet.ENTER || key == ' ') {
                ended &= item.stepForward();
            }
            else if (key == PApplet.BACKSPACE) {
                ended &= item.stepBackward();
            }
            
        }
        return ended;
    }
    
    /**
     * Set the background to the slide
     * @param background image of the background
     */
    public void setBackground(PImage background) {
        this.background = background;
    }
    
    /**
     * add a item to be shown
     * @param item item that we want to show
     */
    public void addItem(Drawable item) {
        items.add(item);
    }
    
}

