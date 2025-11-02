package R2mix.MooUI;

import processing.core.PApplet;

public class Toggle {
  private final PApplet myParent;
  MooUI moo;

  private int value = 0,
    backColor = 180,
    frontColor = 0,
    fontColor = 255,
    toggleSize = 25,
    x = 0,
    y = 0;

  public String NAME = "toggle";
  public int id = 0;
  private boolean selected, nameDisplay = true, valueDisplay = false, display = true, clickedLastFrame;


  Toggle(MooUI m) {
    moo = m;
    myParent = m.myParent;
    id = m.id;    
  }

  Toggle(MooUI m, int xx, int yy) {
    moo = m;
    myParent = m.myParent;
    id = m.id;   
    x = xx;
    y = yy;
  }


  // ======= return slider value  ========== -> in void draw
 public int toggleValue() {
    if (display) {



      // ----- Toggle  ------
       myParent.push();
       myParent.fill(backColor);
       myParent.noStroke();
       myParent.rect( x, y, toggleSize * 2, toggleSize, 90);
       myParent.fill(frontColor);
       myParent.rect( x, y, toggleSize + toggleSize * value, toggleSize, 90);
       myParent.fill(255);
       myParent.rect( x + toggleSize * value, y, toggleSize , toggleSize, 90);
      //  ----  text  ------
       myParent.fill(fontColor);
      if (nameDisplay)  myParent.text(NAME, x, y - 8);
      if (valueDisplay)  myParent.text(value, x, y + toggleSize + 16);
      myParent.pop();

      // ----- logique du toggle -----
      boolean over = mouseOver(x, y, toggleSize * 2, toggleSize);

      // if clicked and focused
      if (over &&  myParent.mousePressed && !clickedLastFrame &&  moo.activeControlId == -1) {
        value = 1 - value;  // bascule (toggle)
        moo.activeControlId = id;
      }else if ( moo.activeControlId == id){
        moo.activeControlId = -1;
      }
      //
      clickedLastFrame =  myParent.mousePressed;
    }


    return value;
  }



  // ======= mouseOver ==========
  private boolean mouseOver(int x, int y, int w, int h) {
    return  myParent.mouseX > x &&  myParent.mouseX < x + w &&  myParent.mouseY > y &&  myParent.mouseY < y + h;
  }
  // ==============================
  //        SETTERS CHAÎNABLES
  // ==============================
  public Toggle setValue(int v) {
    this.value = v;
    return this;
  }
  public Toggle setBackColor(int c) {
    this.backColor = c;
    return this;
  }
  public Toggle setFrontColor(int c) {
    this.frontColor = c;
    return this;
  }
  public Toggle setFontColor(int c) {
    this.fontColor = c;
    return this;
  }

  public Toggle setToggleSize(int w) {
    this.toggleSize = w;
    return this;
  }
  public Toggle setX(int x) {
    this.x = x;
    return this;
  }
  public Toggle setY(int y) {
    this.y = y;
    return this;
  }
  public Toggle setName(String name) {
    this.NAME = name;
    return this;
  }
  public Toggle setId(int id) {
    this.id = id;
    return this;
  }
  public Toggle setSelected(boolean s) {
    this.selected = s;
    return this;
  }
  public Toggle setNameDisplay(boolean d) {
    this.nameDisplay = d;
    return this;
  }
  public Toggle setValueDisplay(boolean d) {
    this.valueDisplay = d;
    return this;
  }
  public Toggle setDisplay(boolean state) {
    this.display = state;
    return this;
  }

  // ==============================
  //            GETTERS
  // ==============================
  public int getValue() {
    return this.value;
  }
  public int getBackColor() {
    return this.backColor;
  }
  public int getFrontColor() {
    return this.frontColor;
  }
  public int getFontColor() {
    return this.fontColor;
  }
  public int getToggleSize() {
    return this.toggleSize;
  }
  public int getX() {
    return this.x;
  }
  public int getY() {
    return this.y;
  }
  public String getName() {
    return this.NAME;
  }
  public int getId() {
    return this.id;
  }
  public boolean isSelected() {
    return this.selected;
  }
  public boolean isNameDisplay() {
    return this.nameDisplay;
  }
  public boolean isValueDisplay() {
    return this.valueDisplay;
  }
  public boolean isDisplay() {
    return this.display;
  }
}
