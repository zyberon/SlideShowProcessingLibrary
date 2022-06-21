package slideshow;
import java.util.ArrayList;
import processing.core.*;

/**
 * Class that will show all the slides
 * @author Alex Rivas Romagnoli
 *
 */
public class SlideShow extends PApplet {
	private ArrayList<Slide> slides;
	int currentSlide;
	PApplet parent;


	/**
	 * Constructor of the SlideShow 
	 * @param parent_ sketch in which it will draw
	 */
	public SlideShow(PApplet parent_) {
		slides = new ArrayList<Slide>();
		currentSlide = -1;
		parent = parent_;
	}
	
	/**
	 * Constructor of the SlideShow
	 */
	public SlideShow() {
		slides = new ArrayList<Slide>();
		currentSlide = -1;

	}


	/**
	 * Add a parent to the SlideShow
	 * @param parent_ the new sketch
	 */
	public void addparent(PApplet parent_) {
		parent = parent_;   
	}

		
	/**
	 * Return the current parent
	 * @return return the current parent
	 */
	public PApplet getParent() {
		return parent;   
	}

	/**
	 * Add a slide to the SlideShow
	 * @param slide slide that is going to be shown
	 */
	public void addSlide(Slide slide) {
		if(currentSlide < 0)
			currentSlide = 0;
		slides.add(slide);
	}

	
	/**
	 *draw the slides
	 */
	public void draw() {
		if(currentSlide >= 0) {
			slides.get(currentSlide).draw();
		}
	}

	/**
	 * change the slide by the following one if it is possible
	 */
	public void stepForward() {
		if(currentSlide+1 < slides.size()) {
			currentSlide++;
			slides.get(currentSlide).reset();
		}
	}
	
	/**
	 * Change the slide by the previous one if it is possible
	 */
	public void stepBack() {
		if(currentSlide-1 >= 0) {
			currentSlide--;
		}
	}

		
	/**
	 * Return all the slides
	 * @return return all the slides
	 */
	public ArrayList<Slide> getSlides() {
		return slides;   

	}

	
	/**
	 * Check the key, and if its correct try to change the slide
	 * @param key  key to be compared
	 * @return true if the key is the same and false if not
	 */
	public boolean checkSlideChange(char key) {
		if (key == PApplet.CODED) {
			if (parent.keyCode == PApplet.RIGHT) {
				stepForward();
				return true;
			} else if (parent.keyCode == PApplet.LEFT) {
				stepBack();
				return true;
			}
		}
		return false;
	}

	
	/**
	 * compare all the keys 
	 */
	public void keyPressed() {
		if(currentSlide >= 0) {

			if(checkSlideChange(parent.key));
			else if(! slides.get(currentSlide).keyPressed(parent.key))
				return;
		}
		if(checkSlideChange(parent.key));
		else if (parent.key == PApplet.ENTER || parent.key == ' ') {
			stepForward();
		}
		else if (parent.key == PApplet.BACKSPACE) {
			stepBack();
		}
		else if (Character.toLowerCase(parent.key) == 'q') {
			parent.exit();
		}
	}

}

