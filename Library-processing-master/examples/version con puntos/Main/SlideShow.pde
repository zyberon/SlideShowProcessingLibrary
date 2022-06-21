class SlideShow {
   ArrayList<Slide> slides;
   int currentSlide;
   SlideShow() {
      slides = new ArrayList<Slide>();
      currentSlide = -1;
   }
   void addSlide(Slide slide) {
      if(currentSlide < 0)
         currentSlide = 0;
      slides.add(slide);
   }
   void draw() {
      if(currentSlide >= 0) {
         slides.get(currentSlide).draw();
      }
   }

   void stepForward() {
      if(currentSlide+1 < slides.size()) {
         currentSlide++;
         slides.get(currentSlide).reset();
      }
   }

   void stepBack() {
      if(currentSlide-1 >= 0) {
         currentSlide--;
      }
   }
   
   public boolean checkSlideChange(char key) {
     if (key == CODED) {
         if (keyCode == RIGHT) {
            stepForward();
            return true;
         } else if (keyCode == LEFT) {
            stepBack();
            return true;
         }
      }
      return false;
   }

   void keyPressed() {
      if(currentSlide >= 0) {
        
        if(checkSlideChange(key));
        else if(! slides.get(currentSlide).keyPressed(key))
            return;
      }
      if(checkSlideChange(key));
      else if (key == ENTER || key == ' ') {
         stepForward();
      }
      else if (key == BACKSPACE) {
         stepBack();
      }
      else if (Character.toLowerCase(key) == 'q') {
         exit();
      }
   }
} 
