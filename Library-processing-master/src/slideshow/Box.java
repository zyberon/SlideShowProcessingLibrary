package slideshow;
import processing.core.*;

/**
 * Class that draws parsed text in the correct X and Y 
 * @author Alex Rivas Romagnoli
 *
 */
public class Box {
    float x,y;
    String text;
    Style style;
    int frame; 
    float dot = 0;
    PApplet parent;
    
    
    /**
     * Constructor of Box class
     * @param x_ x of the box
     * @param y_ y of the box
     * @param text_ text of the box
     * @param style_ style of the box
     * @param frame_ frame of the box
     * @param parent_ sketch of the box
     */
    public Box(float x_, float y_, String text_, Style style_, int frame_, PApplet parent_) {
        x = x_;
        y = y_;
        text = text_;
        style = style_;
        frame = frame_;
        parent = parent_;
    }
    
    /**
     *Shifts the current X
     * @param x_ number that we add to the current X
     */
    public void shiftX(float x_) {
        x += x_;
    }
    
    /**
     * Shifts the current Y
     * @param y_ number that we add to the current Y
     */
    public void setY(float y_) {
        y = y_;
    }
    
    
    /**
     * Returns the current Y
     * @return returns the current Y
     */
    public float getY() {
        return y;
    }
    
    /**
     * Returns the current X
     * @return returns the current X
     */
    public float getX() {
        return x;
    }
    
    /**
     * Adds new dotSize
     * @param dot_  size of the new dot
     */
    public void addDot(float dot_) {
        dot = dot_;
    }
    
    
    /**
     * Draws the Box in the parent Sketch if the current frame passed is less than the current one
     * @param frame_ frame used to compare with the current one
     */
    public void draw(int frame_) {
        if (frame_ < frame)
            return;
        if(style.getFont() != null) {
        parent.textFont(style.getFont(), style.getSize());
        }
        else if(style.getSize() >= 0) {
        	parent.textSize(style.getSize());
        }
        parent.fill(style.getColor());
        if (dot > 0) {
            parent.circle(x - dot,(float) (y - dot / 4.0),dot); 
        }
        parent.text(text, x,y);
        
    }
}
