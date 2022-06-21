
abstract class Drawable {
    abstract void draw();
    abstract void reset();
    abstract boolean stepForward();
    abstract boolean stepBackward();
}

class Box {
    float x,y;
    String text;
    Style style;
    int frame; 
    float dot = 0;
    Box(float x_, float y_, String text_, Style style_, int frame_) {
        x = x_;
        y = y_;
        text = text_;
        style = style_;
        frame = frame_;
    }
    void shiftX(float x_) {
        x += x_;
    }
    void setY(float y_) {
        y = y_;
    }
    void addDot(float dot_) {
        dot = dot_;
    }
    void draw(int frame_) {
        if (frame_ < frame)
            return;
        textFont(style.getFont(), style.getSize());
        fill(style.getColor());
        if (dot > 0) {
            circle(x - dot,y - dot / 4.0,dot); 
        }
        text(text, x,y);
    }
}

class Writer extends Drawable {
    private float x0,y0,x1,y1;
    private ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();
    private ArrayList<Box> boxes = new ArrayList<Box>();
    private ArrayList<ImageBox> images = new ArrayList<ImageBox>();
    private Style style;
    private Align align = Align.LEFT;
    private float dot = 60;
    private boolean pendingLineBreak = false;
    private int frame = 0;
    
    public Writer(Style style_, float x0_, float y0_, float width_, float height_, String text_) {
        paragraphs.add(new Paragraph(text_, style_, frame, align));
        style = style_;
        x0 = x0_;
        y0 = y0_;
        x1 = x0_ + width_;
        y1 = y0_ + height_;
    }
    
    public Writer(Style style_, float x0_, float y0_, float width_, float height_) {
        style = style_;
        x0 = x0_;
        y0 = y0_;
        x1 = x0_ + width_;
        y1 = y0_ + height_;
    }
    
    public void bold() {
        style.setBold(true);
    }
    
    public void unBold() {
        style.setBold(false);
    }
    
    public void setColor(int color_) {
        style.setColor(color_);
    }
    
    public void setSize(float size_) {
        style.setSize(size_);
    }
    
    public void italic() {
        style.setItalic(true);
    }
    
    public void unItalic() {
        style.setItalic(false);
    }
    
    public void addImage(ImageBox image,float x0,float y0,float width_, float height_) {
        image.addCords(x0,y0,width_,height_);
        image.addFrame(frame);
        images.add(image);
        
        
    }
    
    public void addImage(int frame_,ImageBox image,float x0,float y0,float width_, float height_) {
        image.addCords(x0,y0,width_,height_);
        image.addFrame(frame_);
        images.add(image);
        
        
    }
    
    public void addText(String text) {
        if (paragraphs.isEmpty() || pendingLineBreak) {
            paragraphs.add(new Paragraph(text, new Style(style), frame, align));
            pendingLineBreak = false;
        } else {
            int last = paragraphs.size() - 1;
            paragraphs.get(last).add(text, new Style(style), frame);
        }
    }
    
    public void addTextDot(String text) {
        
        paragraphs.add(new Paragraph(text, new Style(style), frame, align,true));
        pendingLineBreak = false;
        
    }
    
    public void addTextLineDot(String text) {
        paragraphs.add(new Paragraph(text, new Style(style), frame, align,true));
        pendingLineBreak = true;
    }
    
    public void addTextLine(String text) {
        paragraphs.add(new Paragraph(text, new Style(style), frame, align));
        pendingLineBreak = true;
    }
    public void addTextLine() {
        pendingLineBreak = true;
    }
    
    public void setAlign(Align align_) {
        align = align_; 
        if (!paragraphs.isEmpty() && pendingLineBreak) {
            int last = paragraphs.size() - 1;
            paragraphs.get(last).setAlign(align);
        }
    }
    
    public void pause() {
        frame++;
    }
    
    int minFrame; 
    int maxFrame;
    int currentFrame;
    
    public void reset() {
        currentFrame = minFrame;
    }
    public boolean stepForward() {
        if (currentFrame == maxFrame)
            return true;
        else{
            currentFrame++;
            return false;
        }
    }
    
    public boolean stepBackward() {
        if (currentFrame == minFrame)
            return true;
        else{
            currentFrame--;
            return false;
        }
    }
    
    public void resetMinMaxFrames() {
        maxFrame= -1;
        minFrame= -1;
    }
    
    public void updateMinMaxFrames(int frame) {
        if (maxFrame == -1)
            maxFrame = frame;
        else
            maxFrame = max(maxFrame, frame);
        if (minFrame == -1)
            minFrame = frame;
        else
            minFrame = min(minFrame, frame);
    }
    
    private void consolidateBoxes(ArrayList<Box> boxesTemp, float y, float a, float d, float gap, Align align_) {
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
                textFont(span.getStyle().getFont(), span.getStyle().getSize());
                dotPrinted = false;
                for (String wordText : words) {
                    if (x + textWidth(wordText) > x1) {
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
                    Box box_ = new Box(x, y, wordText, span.getStyle(), span.getFrame());
                    if (span.getDot() && !dotPrinted) {
                        box_.addDot(this.dot);
                        box_.shiftX(dot * 1.5);
                        x += dot * 1.5;
                        if (dot > textAscent() + textAscent()) {
                            box_.setY(dot / 2.0);
                            
                            y += dot / 1.2;
                        }
                        dotPrinted = true;
                        dotSize = dot;
                    }
                    boxesTemp.add(box_);
                    a = max(a,textAscent());
                    d = max(d,textDescent());
                    x += textWidth(wordText + " ");
                }
            }
            consolidateBoxes(boxesTemp, y, a, d, x1 - x, paragraph.getAlign());
        }
    }
    
    public void draw() {
        //fill(0x00ffffff);
        //rect(x0,y0,x1-x0,y1-y0);
        parse();
        for (Box box : boxes) {
            box.draw(currentFrame);
        }
        for (ImageBox i : images) {
            i.draw(currentFrame);
        }
    }
    
}
