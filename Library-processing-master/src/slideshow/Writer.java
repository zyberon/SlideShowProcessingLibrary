package slideshow;

import java.util.ArrayList;

import processing.core.*;

/**
 * This class is the one that draws some items of an Slide, a Slide could have multiple Writers
 * @author Alex Rivas Romagnoli
 *
 */
public class Writer extends Drawable {
    private float x0,y0,x1,y1;
    private ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();
    private ArrayList<Box> boxes = new ArrayList<Box>();
    private ArrayList<ImageBox> images = new ArrayList<ImageBox>();
    private Style style;
    private Align align = Align.LEFT;
    private float dot = 60;
    private boolean pendingLineBreak = false;
    private int frame = 0;
    private PApplet parent;
    
    /**
     * Constructor of the writer
     * @param style_ style of the writer
     * @param x0_ X left top of the writer
     * @param y0_ Y left top of the writer
     * @param width_ width of the writer
     * @param height_ height of the writer
     * @param text_ text of the writer, which will use the style
     * @param parent_ sketch in which we draw
     */
    public Writer(Style style_, float x0_, float y0_, float width_, float height_, String text_, PApplet parent_) {
        paragraphs.add(new Paragraph(text_, style_, frame, align));
        style = style_;
        x0 = x0_;
        y0 = y0_;
        x1 = x0_ + width_;
        y1 = y0_ + height_;
        parent = parent_;
    }
    /**
     * Constructor of the writer
     * @param style_ style of the writer
     * @param x0_ X left top of the writer
     * @param y0_ Y left top of the writer
     * @param width_ width of the writer
     * @param height_ height of the writer
     * @param parent_ sketch in which we draw
     */
    public Writer(Style style_, float x0_, float y0_, float width_, float height_, PApplet parent_) {
        style = style_;
        x0 = x0_;
        y0 = y0_;
        x1 = x0_ + width_;
        y1 = y0_ + height_;
        parent = parent_;
    }
    
    
    /**
     * Activate the bold
     */
    public void bold() {
        style.setBold(true);
    }
    
    
    /**
     * Deactivate the bold
     */
    public void unBold() {
        style.setBold(false);
    }
    
    /**
     * Set the color of the style
     * @param color_ color of the style
     */
    public void setColor(int color_) {
        style.setColor(color_);
    }
    
    /**
     * Set Size of the style
     * @param size_
     */
    public void setSize(float size_) {
        style.setSize(size_);
    }
    
    /**
     *  Activate the italic
     */
    public void italic() {
        style.setItalic(true);
    }
    
    /**
     * Deactivate the italic
     */
    public void unItalic() {
        style.setItalic(false);
    }
    
    /**
     * Add an image to the writer
     * @param image image to be add
     * @param x0 top left X of the image
     * @param y0 top left Y of the image
     * @param width_ width of the image
     * @param height_ height of the image
     */
    public void addImage(ImageBox image,float x0,float y0,float width_, float height_) {
        image.addCoords(x0,y0,width_,height_);
        image.addFrame(frame);
        images.add(image);
        
        
    }
    
    /**
     * Add an image to the writer with a frame that is not going to  be shown until we reach that frame
     * @param frame_ frame frame of the image
     * @param image image to be add
     * @param x0 top left X of the image
     * @param y0 top left Y of the image
     * @param width_ width of the image
     * @param height_ height of the image
     */
    public void addImage(int frame_,ImageBox image,float x0,float y0,float width_, float height_) {
        image.addCoords(x0,y0,width_,height_);
        image.addFrame(frame_);
        images.add(image);
        
        
    }
    
    /**
     * Add text with the Style of the writer
     * @param text text to be added
     */
    public void addText(String text) {
        if (paragraphs.isEmpty() || pendingLineBreak) {
            paragraphs.add(new Paragraph(text, new Style(style), frame, align));
            pendingLineBreak = false;
        } else {
            int last = paragraphs.size() - 1;
            paragraphs.get(last).add(text, new Style(style), frame);
        }
    }
    
    /**
     * Add text with the Style of the writer and with dot
     * @param text text to be added
     */
    public void addTextDot(String text) {
        
        paragraphs.add(new Paragraph(text, new Style(style), frame, align,true));
        pendingLineBreak = false;
        
    }
    
    /**
     * Add text with the Style of the writer, with dot and with lane change
     * @param text text to be added
     */
    public void addTextLineDot(String text) {
        paragraphs.add(new Paragraph(text, new Style(style), frame, align,true));
        pendingLineBreak = true;
    }
    
    /**
     * Add text with the Style of the writer and with lane change
     * @param text text to be added
     */
    public void addTextLine(String text) {
        paragraphs.add(new Paragraph(text, new Style(style), frame, align));
        pendingLineBreak = true;
    }
    
    /**
     * Change the lane
     */
    public void addTextLine() {
        pendingLineBreak = true;
    }
    
    
    /**
     * Change the alignment
     * @param align_ alignment of the text
     */
    public void setAlign(Align align_) {
        align = align_; 
        if (!paragraphs.isEmpty() && pendingLineBreak) {
            int last = paragraphs.size() - 1;
            //paragraphs.get(last).setAlign(align);
        }
    }
    
    /**
     * Return the align
     * @return return the align
     */
    public  Align getAlign() {
    	
    return align;
    }
    
    
    /**
     * This method changes the frame, so makes that the continue items will have another frame and
     * are not going to be shown until that frame is reached
     */
    public void pause() {
        frame++;
    }
    
    int minFrame; 
    int maxFrame;
    int currentFrame;
    
    /**
     *Reset the current frame to the minimum
     */
    public void reset() {
        currentFrame = minFrame;
    }
    
    /**
     *Returns if the frame is at the maximum point
     *@return  if the frame is at the maximum point or not
     */
    public boolean stepForward() {
        if (currentFrame == maxFrame)
            return true;
        else{
            currentFrame++;
            return false;
        }
    }
    
    /**
     *Returns if the frame is at the minimum point
     *@return  if the frame is at the minimum point or not
     */
    public boolean stepBackward() {
        if (currentFrame == minFrame)
            return true;
        else{
            currentFrame--;
            return false;
        }
    }
    
    
    /**
     * reset the maxFrame and the minFrame
     */
    public void resetMinMaxFrames() {
        maxFrame= -1;
        minFrame= -1;
    }
    
    /**
     * Updates the MaxFrame  and MinFrame
     * if it is reseted the new value is added, if not we get the max and the min from the MaxFrame/MinFrame  compared to the frame
     * @param frame frame to be added/compared
     */
    public void updateMinMaxFrames(int frame) {
        if (maxFrame == -1)
            maxFrame = frame;
        else
            maxFrame = PApplet.max(maxFrame, frame);
        if (minFrame == -1)
            minFrame = frame;
        else
            minFrame = PApplet.min(minFrame, frame);
    }
    
    
    
    /**
     * Method that add the boxes with the correct position in the X axis and Y axis
     * @param boxesTemp ArrayList with the boxes
     * @param y Y of the box
     * @param a shift the Y axis
     * @param d text descent
     * @param gap space left on the lane
     * @param align_ alignment of the text
     */
    public void consolidateBoxes(ArrayList<Box> boxesTemp, float y, float a, float d, float gap, Align align_) {
        for (Box box : boxesTemp) {
            box.setY(y + a);
            if (align_ == Align.RIGHT) {
                box.shiftX(gap);
            }
            else if (align_ == Align.CENTER) {
                box.shiftX(gap / 2);
            }
            else if (align_ == Align.BOTH) {
                //box.shiftX(gap);
            } 
            boxes.add(box);
        }
        boxesTemp.clear();
    }
    
    /**
     * Return the image size
     * @return return the image size
     */
    public int getImagesSize() {
    	return images.size();	
    }
    
    
    /**
     * Return the style
     * @return return the style
     */
    public Style getStyle() {
    	return style;
    }
    
    
    /**
     * Return the paragraphs
     * @return return the paragraphs
     */
    public ArrayList<Paragraph> emptyParagraph() {
    	return paragraphs;
    }
    
    /** Return if the pending line break is true or false
     * @return return if the pending line break is true or false
     */
    public boolean getPendingLineBreak() {
    	
    	return pendingLineBreak;
    }
    
    /**
     * Return the boxes
     * @return return the boxes
     */
    public ArrayList<Box> getBoxes() {
    	
    	return boxes;
    }
    
    /**
     * Parser of the text, this method convert the paragraphs into the boxes with the correct X and Y axis
     * This method also is responsible to add the dot to the text
     */
    private void parse() {
        float x = x0, y = y0, a = 0, d = 0;
        ArrayList<Box> boxesTemp = new ArrayList<Box>();
        boolean dotPrinted = false;
        float dotSize = 0;
        boxes.clear();
        
        paragraphs:
        for (Paragraph paragraph : paragraphs) {
            x = x0;
            y += a + d;
            if (y + a + d > y1) {
                consolidateBoxes(boxesTemp, y, a, d, x1 - x, paragraph.getAlign());
                break paragraphs;
            }
            a = 0;
            d = 0;
            resetMinMaxFrames();
            for (Span span : paragraph.getSpans()) {
                updateMinMaxFrames(span.getFrame());
                String[]words = span.getText().split(" ");
                if(span.getStyle().getFont() != null) {
                parent.textFont(span.getStyle().getFont(), span.getStyle().getSize());
                }
                else if(span.getStyle().getSize() >= 0) {
                	parent.textSize(span.getStyle().getSize());
                }          
                dotPrinted = false;
                for (String wordText : words) {
                    if (x + parent.textWidth(wordText) > x1) {
                        consolidateBoxes(boxesTemp, y, a, d, x1 - x, paragraph.getAlign());
                        
                        if (dotSize < a + d) {
                            y += a + d + dotSize / 4.0;
                            dotSize = 0;
                        } else{
                            y += a + d;
                            
                        }
                        
                        if (y + a + d > y1) {
                            break paragraphs;
                        }
                        x = x0;
                        a = 0;
                        d = 0;
                    }
                    Box box_ = new Box(x, y, wordText, span.getStyle(), span.getFrame(), parent);
                    if (span.getDot() && !dotPrinted) {
                        box_.addDot(this.dot);
                        box_.shiftX((float) (dot * 1.5));
                        x += dot * 1.5;
                        if (dot > 2 * parent.textAscent()) {
                            box_.setY((float) (dot / 2.0));                          
                            y += dot / 1.2;
                        }
                        dotPrinted = true;
                        dotSize = dot;
                    }
                    boxesTemp.add(box_);
                    a = PApplet.max(a,parent.textAscent());
                    d = PApplet.max(d,parent.textDescent());
                    x += parent.textWidth(wordText + " ");
                }
            }
            consolidateBoxes(boxesTemp, y, a, d, x1 - x, paragraph.getAlign());
        }
    }

    @Override
    public void draw() {
        parse();
        for (Box box : boxes) {
            box.draw(currentFrame);
        }
        for (ImageBox i : images) {
            i.draw(currentFrame);
        }
    }
    
}
