class ImageBox {
    private String name;
    private float x0,y0,x1,y1;
    private int frame = 0;
    
    public ImageBox(String name_) {
        name = name_;

    }
    
    public void addCords(float x0_,float y0_,float width_, float height_){
        x0 = x0_;
        y0 = y0_;
        x1 = width_;
        y1 = height_; 
    }
    
    public void addFrame(int frame_) {
        frame = frame_;
    }
    
    public void draw(int frame_){
        if(frame_ < frame)
           return;
        PImage img; 
        img = loadImage(name);
        img.resize((int)x1,(int)y1);
        image(img,x0,y0);
        
    }   
    
     
    
}
