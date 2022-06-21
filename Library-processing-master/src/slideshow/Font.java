package slideshow;

import processing.core.PFont;

/**
 * Class that contains the different PFonts of the text
 * @author Alex Rivas Romagnoli
 *
 */
public class Font {
private PFont normal,bold,italic;
    
    /**
     * Constructor of the Font
     * @param normal PFont for the normal letter
     */
    public Font(PFont normal) {
        this.normal = normal;
    }
    
    
    /**
     * Constructor of the Font
     * @param normal PFont for the normal letter
     * @param bold PFont for the bold letter
     * @param italic PFont for the italic letter
     */
    public Font(PFont normal, PFont bold, PFont italic) {
        this.normal = normal;
        this.bold = bold;
        this.italic = italic;
    }
    
    
    /**
     * Return the bold PFont
     * @return return the bold PFont
     */
    public PFont getBold() {
        return bold; 
    }
    
    /**
     * Return the italic PFont
     * @return return the italic PFont
     */
    public PFont getItalic() {
        return italic; 
    }
    
    /**
     * Return the normal PFont
     * @return
     */
    public PFont getNormal() {
        return normal;
    }
    
    
    /**
     * Add a Pfont for the normal PFont
     * @param normal new font that is going to be used when the letter is normal
     */
    public void addNormal(PFont normal) {
        this.normal = normal; 
    }   
    
    /**
     * Add a Pfont for the italic PFont
     * @param normal new font that is going to be used when the letter is italic
     */
    public void addItalic(PFont italic) {
        this.italic = italic; 
    }
    
    /**
     * Add a Pfont for the bold PFont
     * @param normal new font that is going to be used when the letter is bold
     */
    public void addBold(PFont bold) {
        this.bold = bold; 
    }
    
}
