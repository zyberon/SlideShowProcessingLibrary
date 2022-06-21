package slideshow;

import java.util.ArrayList;



/**
 * Class that contains the spans but with the correct alignment
 * @author Alex Rivas Romagnoli
 *
 */
public class Paragraph {
    private Align align;
    private ArrayList<Span> spans = new ArrayList<Span>();
    
    /**
     * Constructor of the paragraph
     * @param text_ text of paragraph
     * @param style_ style of the text 
     * @param frame_ frame of the text
     * @param align_ alignment of the frame
     */
    public Paragraph(String text_, Style style_, int frame_, Align align_) {
        spans.add(new Span(text_, style_, frame_));
        align = align_;
    }
    
    /**
     * Constructor of the paragraph
     * @param text_ text of paragraph
     * @param style_ style of the text 
     * @param frame_ frame of the text
     * @param align_ alignment of the frame
     * @param dot_ true if it has dot or false if not
     */
    public Paragraph(String text_, Style style_, int frame_, Align align_,boolean dot_) {
        spans.add(new Span(text_, style_, frame_,dot_));
        align = align_;
    }
    
    /**
     * Return the ArrayList of spans
     * @return  return the ArrayList of spans
     */
    public ArrayList<Span> getSpans() {
        return spans;
    }
    
    /**
     * Set the Align of the Paragraph
     * @param align_
     */
    public void setAlign(Align align_) {
        align = align_;
    }
    
    /**
     * Return the align of the paragraph
     * @return return the align of the paragraph
     */
    public Align getAlign() {
        return align;
    }
    
    /**
     * Adds a new span
     * @param text_ text of the span
     * @param style_ style of the text
     * @param frame_ frame of the text
     */
    public void add(String text_, Style style_, int frame_) {
        spans.add(new Span(text_, style_, frame_));     
    }
}

