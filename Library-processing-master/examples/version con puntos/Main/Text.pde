public enum Align { LEFT, CENTER, RIGHT, BOTH };

class Paragraph {
    private Align align;
    private ArrayList<Span> spans = new ArrayList<Span>();
    Paragraph(String text_, Style style_, int frame_, Align align_) {
        spans.add(new Span(text_, style_, frame_));
        align = align_;
    }
    Paragraph(String text_, Style style_, int frame_, Align align_,boolean dot_) {
        spans.add(new Span(text_, style_, frame_,dot_));
        align = align_;
    }
    ArrayList<Span> getSpans() {
        return spans;
    }
    void setAlign(Align align_) {
        align = align_;
    }
    Align getAlign() {
        return align;
    }
    void add(String text_, Style style_, int frame_) {
        spans.add(new Span(text_, style_, frame_));     
    }
}

class Span {
    private String text;
    private Style style;
    private int frame = 0;
    private boolean dot = false;
    
    public Span(String text_, Style style_, int frame_) {
        text = text_;
        style = style_;  
        frame = frame_;
    }
    public Span(String text_, Style style_, int frame_,boolean dot_) {
        text = text_;
        style = style_;  
        frame = frame_;
        dot = dot_;
    }
    
    public void setDot() {
        dot = true;
    }
    public boolean getDot() {
        return dot; 
    }
    public void setStyle(Style style_) {
        style = style_;
    }
    public void setText(String text_) {
        text = text_;
    }
    public Style getStyle() {
        return style; 
    }
    public String getText() {
        return text;
    }
    public int getFrame() {
        return frame;
    }
}
