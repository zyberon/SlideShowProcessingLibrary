package slideshow;

import processing.core.*;

/**
 * Slide which is like an EmptySlide but with an asociated Theme
 * @author Alex Rivas Romagnoli
 *
 */
public class ThemedSlide extends EmptySlide {
    public Theme theme;
    
    /**
     * Constructor of the ThemedSlide
     * @param width_ width of the Slide
     * @param height_ height of the Slide
     * @param theme_ theme of the Slide
     * @param parent_ sketch of the Slide
     */
    public ThemedSlide(int width_, int height_, Theme theme_, PApplet parent_) {
        super(width_, height_, parent_);
        theme = theme_;
        if(theme.background != null) {
        setBackground(theme.background);
        }
    }
     
     /**
     *Set a title to the themedSlide 
     * @param title_ string of the title
     */
    public void setTitle(String title_) {
        title = new Writer(theme.titleStyle, 50, 50, 1000, 100, title_, parent);
        addItem(title);
    }
}
