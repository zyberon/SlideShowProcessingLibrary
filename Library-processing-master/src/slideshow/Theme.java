package slideshow;

import processing.core.*;

/**
 * Class that gives to a Slide a style to the title and normal text, it also gives a background
 * @author Alex Rivas Romagnoli
 *
 */
public class Theme {
    public Style titleStyle;
    public Style textStyle;
    public PImage background;
    
    /**
     * Constructor of the Theme
     */
    public Theme() {
    	titleStyle = null;
    	textStyle = null;
    	background = null;
    	
    	
    }
    
}