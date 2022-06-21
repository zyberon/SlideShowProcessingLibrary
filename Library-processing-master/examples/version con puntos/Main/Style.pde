class Style {
    private int colour;
    private float size;
    private PFont regularFont;
    private PFont boldFont;
    private PFont italicFont;
    private PFont boldItalicFont;
    private boolean bold,italic;

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
    public Style(Style e) {
        regularFont = e.regularFont;
        boldFont = e.boldFont;
        italicFont = e.italicFont;
        boldItalicFont = e.boldItalicFont;
        bold = e.bold;
        italic = e.italic;
        size = e.size;
        colour = e.colour;
    }
    public void setNormalFont(PFont font_) {
        regularFont = font_;
        boldFont = font_;
        italicFont = font_;
        boldItalicFont = font_;
    }
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
    public void setSize(float size_) {
        size = size_;
    }
    public float getSize() {
        return size;
    }
    public void setBold(boolean bold_) {
        bold = bold_;
    }
    public void setItalic(boolean italic_) {
        italic = italic_; 
    }
    public boolean getBold() {
        return bold;
    }
    public boolean getItalic() {
        return italic; 
    }
    public void setColor(int colour_) {
        colour = colour_;
    }
    public int getColor() {
        return colour;
    }
}
