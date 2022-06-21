package slideshow;

/**
 * Class Slide that is the base for the other slides
 * @author Alex Rivas Romagnoli
 *
 */
abstract class Slide {
	
    /**
     * Draws a Slide
     */
    public abstract void draw();
    
    /**
     * reset the frame of the items of the slide
     */
    public abstract void reset();
    
    /**
     * Depends on the key calculates if possible step back or step forward
     * @param key key pressed
     * @return if you are in the minimum or maximum
     */
    public abstract boolean keyPressed(char key);
}

