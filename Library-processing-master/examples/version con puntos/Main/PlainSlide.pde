abstract class Slide {
    abstract void draw();
    abstract void reset();
    abstract boolean keyPressed(char key);
}

class PlainSlide extends Slide {
    private int R,G,B;
    private int width, height;
    private PImage background = null;
    private ArrayList<Drawable> items = new ArrayList<Drawable>();
    
    PlainSlide(int width_, int height_) {
        width = width_;
        height = height_;
    }
    void reset() {
        for (Drawable item : items) {
            item.reset();
        }
    }
    void draw() {
        if (background != null) {
            background.resize(width,height);
            image(background,0,0); 
        } else {
            background(R,G,B); 
        }
        for (Drawable item : items) {
            item.draw();
        }
    }
    
    boolean keyPressed(char key) {
        boolean ended = true;
        for (Drawable item : items) {
            if (key == CODED) {
                if (keyCode == RIGHT) {
                    ended &=  item.stepForward();
                } else if (keyCode == LEFT) {
                    ended &= item.stepBackward();
                }
            }
            else if (key == ENTER || key == ' ') {
                ended &= item.stepForward();
            }
            else if (key == BACKSPACE) {
                ended &= item.stepBackward();
            }
            
        }
        return ended;
    }
    
    public void setBackground(PImage background) {
        this.background = background;
    }
    void addItem(Drawable item) {
        items.add(item);
    }
    
}

class EmptySlide extends PlainSlide {
    Writer title = null;
    EmptySlide(int width_, int height_) {
        super(width_, height_);
    }
    void setTitle(String title_, Style titleStyle) {
        title = new Writer(titleStyle, 50, 50, 1000, 100, title_);
        addItem(title);
    }
}

class Theme {
    Style titleStyle;
    Style textStyle;
    PImage background; 
}

class ThemedSlide extends EmptySlide {
    Theme theme;
    ThemedSlide(int width_, int height_, Theme theme_) {
        super(width_, height_);
        theme = theme_;
        setBackground(theme.background);
    }
    void setTitle(String title_) {
        title = new Writer(theme.titleStyle, 50, 50, 1000, 100, title_);
        addItem(title);
    }
}
