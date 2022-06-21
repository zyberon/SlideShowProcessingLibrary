package slideshow;

/**
 * This class represent the text of a Paragraph
 * @author Alex Rivas Romagnoli
 *
 */
public class Span {
    private String text;
    private Style style;
    private int frame = 0;
    private boolean dot = false;
    
    /**
     * Constructor of the Span
     * @param text_ text of the span
     * @param style_ style of the text
     * @param frame_ frame of the span
     */
    public Span(String text_, Style style_, int frame_) {
        text = text_;
        style = style_;  
        frame = frame_;
    }
    /**
     * Constructor of the Span
     * @param text_ text of the span
     * @param style_ style of the text
     * @param frame_ frame of the text
     * @param dot_  says if a dot is necessary
     */
    public Span(String text_, Style style_, int frame_,boolean dot_) {
        text = text_;
        style = style_;  
        frame = frame_;
        dot = dot_;
    }
    
    /**
     * Add a dot
     */
    public void setDot() {
        dot = true;
    }
    
    /**
     * Return the value of the dot
     * @return return the value of the dot
     */
    public boolean getDot() {
        return dot; 
    }
    
    /**
     * Set Style of the text
     * @param style_ style of the text
     */
    public void setStyle(Style style_) {
        style = style_;
    }
   
    /**
     * Set a text
     * @param text_ text to be set
     */
    public void setText(String text_) {
        text = text_;
    }
    
    /**
     * Return the style of the text
     * @return return the style of the text
     */
    public Style getStyle() {
        return style; 
    }
    
    /**
     * Return the text
     * @return return the text
     */
    public String getText() {
        return text;
    }
    
    /**
     * Return the frame of the span
     * @return return the frame of the span
     */
    public int getFrame() {
        return frame;
    }
}

