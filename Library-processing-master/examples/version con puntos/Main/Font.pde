class Font {
    private PFont normal,bold,italic;
    
    public Font(PFont normal) {
        this.normal = normal;
    }
    
    public Font(PFont normal, PFont bold, PFont italic) {
        this.normal = normal;
        this.bold = bold;
        this.italic = italic;
    }
    
    public PFont getBold() {
        return bold; 
    }
    
    public PFont getItalic() {
        return italic; 
    }
    
    public PFont getNormal() {
        return normal;
    }
    
    public void addNormal(PFont normal) {
        this.normal = normal; 
    }   
    
    public void addItalic(PFont italic) {
        this.italic = italic; 
    }
    
    public void addNegrira(PFont bold) {
        this.bold = bold; 
    }
    
}
