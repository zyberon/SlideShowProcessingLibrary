package slideshow;

import processing.core.*;

/**
 * Class that defines some aspects that can be given to a text
 * @author Alex Rivas Romagnoli
 *
 */
public class Style {
    private int colour;
    private float size;
    private PFont regularFont;
    private PFont boldFont;
    private PFont italicFont;
    private PFont boldItalicFont;
    private boolean bold,italic;

    /**
     * Constructor of the Style class
     * @param regularFont_ PFont for the normal text
     * @param boldFont_ PFont for the bold text
     * @param italicFont_ PFont for the italic text
     * @param boldItalicFont_ PFont for the boldItalic text
     * @param size_ size of the text
     * @param colour_ colour of the text
     */
    public Style(PFont regularFont_, PFont boldFont_, PFont italicFont_, PFont boldItalicFont_, float size_, int colour_) {
        regularFont = regularFont_;
        boldFont = boldFont_;
        italicFont = italicFont_;
        boldItalicFont = boldItalicFont_;
        bold = false;
        italic = false;
        size = size_;
        colour = colour_;
    }
    
    /**
     * Constructor of the Style class
     * @param font_ PFont of the text 
     * @param size_ size of the text
     * @param colour_ colour of the text
     */
    public Style(PFont font_, float size_, int colour_) {
        regularFont = font_;
        boldFont = font_;
        italicFont = font_;
        boldItalicFont = font_;
        bold = false;
        italic = false;
        size = size_;
        colour = colour_;
    }
    
    /**
     * Copy Constructor of this class
     * @param style_ style to be copied
     */
    public Style(Style style_) {
    	if(style_ != null) {
        regularFont = style_.regularFont;
        boldFont = style_.boldFont;
        italicFont = style_.italicFont;
        boldItalicFont = style_.boldItalicFont;
        bold = style_.bold;
        italic = style_.italic;
        size = style_.size;
        colour = style_.colour;
    	}
    }
    
    
    /**
     * Constructor of the Style class 
     * @param size_ size if the text
     * @param color_ colour of the text
     */
    public Style(float size_,int color_ ) {
    	 size = size_;
         colour = color_;
    }
    
    /**
     *Add a new PFont
     * @param font_ font to be added
     */
    public void setNormalFont(PFont font_) {
        regularFont = font_;
        boldFont = font_;
        italicFont = font_;
        boldItalicFont = font_;
    }
    
    /**
     * return the font
     * @return return the font
     */
    public PFont getFont() {
        if(bold) {
           if(italic) {
              return boldItalicFont;
           } else {
              return boldFont;
           }
        } else if(italic) {
           return italicFont;
        }
        return regularFont;
    }
    
    /**
     * Set the size of the style
     * @param size_ size of the style
     */
    public void setSize(float size_) {
        size = size_;
    }
    
    /**
     * return the size
     * @return return the size
     */
    public float getSize() {
        return size;
    }
    
    /**
     *Activate the bold mode
     * @param bold_ new value of the bold
     */
    public void setBold(boolean bold_) {
        bold = bold_;
    }
    
    
    /**
     * Activate the italic mode
     * @param italic_ new value of the italic
     */
    public void setItalic(boolean italic_) {
        italic = italic_; 
    }
    
    /**
     * Return the value of the bold
     * @return return true if its activated or false if not
     */
    public boolean getBold() {
        return bold;
    }
    
    /**
     * return the value of the italic
     * @return return true if its activated or false if not
     */
    public boolean getItalic() {
        return italic; 
    }
    
    /**
     * Set the color of the style
     * @param colour_ color that the style will have
     */
    public void setColor(int colour_) {
        colour = colour_;
    }
    
    /**
     * Return the color
     * @return  return the color
     */
    public int getColor() {
        return colour;
    }
}
