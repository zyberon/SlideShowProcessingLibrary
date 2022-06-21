package slideshow;

abstract public class Drawable {
	
    /**
     * Method that draws in the sketch
     */
    abstract public void draw();
    
    /**
     * Resets the current frame
     */
    abstract public void reset();
    
    /**
     * Step the frame if is not at the maximum
     * @return if it at the maximum or not
     */
    abstract public boolean stepForward();
    
    /**
     * Step the frame if is not at the minimum
     * @return if it at the minimum or not
     */
    abstract public boolean stepBackward();
}

