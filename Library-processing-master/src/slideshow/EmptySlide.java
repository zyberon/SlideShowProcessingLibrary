package slideshow;
import processing.core.*;
/**
 * Class that is a PlainSlide with a title
 * @author Alex Rivas Romagnoli
 *
 */
public class EmptySlide extends PlainSlide {
    Writer title = null;
    
    /**
     * Create an EmptySlide
     * @param width_ width of the slide
     * @param height_ height of the slide
     * @param parent_ sketch of the slide
     */
    EmptySlide(int width_, int height_, PApplet parent_) {
        super(width_, height_, parent_);
    }
    
    /**
     * Set a the title of the EmptySlide
     * @param title_ string of the title
     * @param titleStyle style of the text
     */
    public void setTitle(String title_, Style titleStyle) {
        title = new Writer(titleStyle, 50, 50, 1000, 100, title_, parent);
        addItem(title);
    }
    
    /**
     * return the title of the slide
     * @return the title of the slide
     */
    public Writer getTitle() {  	
    	return title;
    }
}
