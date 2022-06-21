SlideShow theSlideShow;

class Title extends PlainSlide {
   Writer titleArea, authorArea, dateArea, instArea;
   Title(int width_, int height_) {
      super(width_, height_);
      Style textStyle = new Style(
         createFont("Roboto-Regular.ttf",120),
         createFont("Roboto-Bold.ttf",120),
         createFont("Roboto-Italic.ttf",120),
         createFont("Roboto-BoldItalic.ttf",120),
         120.0,0xffc5d492);
      setBackground(loadImage("dark.jpg"));

      titleArea = new Writer(textStyle, 0.2*width_, 0.4*height_, 0.6*width_, 0.6*height_);
      titleArea.setAlign(Align.CENTER);
      titleArea.addTextLine("Title of presentation");
      addItem(titleArea);

      textStyle.setSize(90);
      authorArea = new Writer(textStyle, 0.2*width_, 0.6*height_, 0.6*width_, 0.7*height_);
      authorArea.setAlign(Align.CENTER);
      authorArea.addTextLine("Mr. Author of the presentation");
      addItem(authorArea);

      textStyle.setSize(60);
      dateArea = new Writer(textStyle, 0.2*width_, 0.8*height_, 0.6*width_, 0.9*height_);
      dateArea.setAlign(Align.CENTER);
      dateArea.addTextLine("City, date");
      addItem(dateArea);

      textStyle.setSize(40);
      instArea = new Writer(textStyle, 0.1*width_, 0.1*height_, 0.2*width_, 0.2*height_);
      instArea.setAlign(Align.CENTER);
      instArea.addTextLine("company.com");
      addItem(instArea);
   }
}

class MySlide extends ThemedSlide {
   Writer textArea1, textArea2, textArea3; 
   ImageBox cervantes = new ImageBox("cervantes.jpg");
   MySlide(int width_, int height_, Theme theme_) {
      super(width_, height_, theme_);
      setTitle("Hello");
      Style textStyle = new Style(theme.textStyle);
      textStyle.setSize(20);
      textArea1 = new Writer(textStyle, 0.2*width_, 0.2*height_, 0.6*width_, 0.2*height_);
      
      textArea1.addTextLine("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi faucibus interdum elit, molestie dictum tortor consectetur nec. Nam dignissim efficitur mi vel sagittis. Duis iaculis egestas ante. Vestibulum varius, dui vitae maximus euismod, nunc nisl volutpat diam, vel sodales ex lacus vel eros. Sed ac nisi at enim accumsan dignissim vel a arcu. Duis sodales aliquet eros sed facilisis. Phasellus aliquam lacus non urna imperdiet, eu efficitur purus auctor. Praesent eget dignissim dolor, at lacinia diam. Donec ac gravida justo. Quisque maximus mattis est at vestibulum. Ut lectus sem, ultrices quis dapibus eu, hendrerit ultricies libero. Suspendisse at feugiat elit. Aenean viverra eros eget lorem semper, a consequat ex vulputate. Cras congue nisl erat, non convallis velit egestas ac. Donec vulputate posuere dolor, sit amet dapibus mi tincidunt blandit.");
      addItem(textArea1);
      textArea2 = new Writer(textStyle, 0.2*width_, 0.4*height_, 0.6*width_, 0.2*height_);
      textArea2.setAlign(Align.LEFT);
      textArea2.addTextLine("Pellentesque ultricies est ut massa consectetur, a sollicitudin eros dictum. Proin blandit nulla non libero ullamcorper blandit.AAAAAAAAAAAAAA");
      textArea2.setAlign(Align.CENTER);
      textArea2.addText("Proin sit amet augue tristique odio cursus euismod. Etiam vulputate a felis eget elementum.");
      textArea2.addText("Phasellus convallis consequat lobortis. Maecenas tincidunt hendrerit dolor sit amet scelerisque. Donec sit amet condimentum arcu. Integer aliquam sed lectus nec imperdiet. Interdum et malesuada fames ac ante ipsum primis in faucibus.");
      addItem(textArea2);
      textArea3 = new Writer(textStyle, 0.2*width_, 0.6*height_, 0.6*width_, 0.2*height_);
      textArea3.addText("Pellentesque ultricies est ut massa consectetur,");
      textArea3.bold();
      textArea3.addTextDot("a sollicitudin eros dictum.");
      textArea3.italic();
      textArea3.addText("Proin blandit nulla non libero ullamcorper blandit.");
      textArea3.unBold();
      textArea3.pause();
      textArea3.addTextDot("Proin sit amet augue tristique odio cursus euismod.");
      textArea3.pause();
      textArea3.addImage(cervantes,100,200,200,200);
      textArea3.pause();
      textArea3.unItalic();
      textArea3.setColor(0xff1faf1f);
      textArea3.addText("Etiam vulputate a felis eget elementum. Phasellus convallis consequat lobortis.");
      textArea3.pause();
      textArea3.setSize(40.0);
      textArea3.addText("Maecenas tincidunt hendrerit dolor sit amet scelerisque.");
      textArea3.setSize(30.0);
      textArea3.pause();
      textArea3.addText("Donec sit amet condimentum arcu. Integer aliquam sed lectus nec imperdiet.");
      textArea3.setColor(0xffafafaf);
      textArea3.addText("Interdum et malesuada fames ac ante ipsum primis in faucibus.");
      textArea3.setAlign(Align.RIGHT);
      addItem(textArea3);
   }
}

void setup() {
   fullScreen();
   theSlideShow = new SlideShow();

   Theme theTheme = new Theme();
   theTheme.titleStyle = new Style(
         createFont("Roboto-Regular.ttf",120),
         createFont("Roboto-Bold.ttf",120),
         createFont("Roboto-Italic.ttf",120),
         createFont("Roboto-BoldItalic.ttf",120),
         120.0,0xffc5d492);
   theTheme.textStyle = new Style(
         createFont("Roboto-Regular.ttf",60),
         createFont("Roboto-Bold.ttf",60),
         createFont("Roboto-Italic.ttf",60),
         createFont("Roboto-BoldItalic.ttf",60),
         60.0,0xffc5d492);
   theTheme.background = loadImage("dark.jpg");

   theSlideShow.addSlide(new Title(width, height));  
   theSlideShow.addSlide(new MySlide(width, height, theTheme));  
}

void draw() {
  theSlideShow.draw();  
}

synchronized void keyPressed() {
   theSlideShow.keyPressed();
}
