package R2mix.MooUI;

import processing.core.PApplet;

public class HorizontalSliderFloat {
  private final PApplet myParent;
  MooUI moo;
  private float value = 0,
      minValue = 0,
      maxValue = 127;
  private int backColor = 180,
      frontColor = 0,
      fontColor = 255,
      sliderWidth = 500,
      sliderHeight = 16,
      x = 0,
      y = 0,
      dragOffset = 0;

  public String NAME = "horizontal slider float";
 public int id = 0;
  private boolean selected, nameDisplay = true, valueDisplay = true, display = true;

  HorizontalSliderFloat(MooUI m) {
    moo = m;
    myParent = m.myParent;
    id = m.id;

  }

  HorizontalSliderFloat(MooUI m, int xx, int yy) {
    moo = m;
    myParent = m.myParent;
    id = m.id;
    x = xx;
    y = yy;
  }

  // ======= return slider value ========== -> in void draw
  public float sliderValue() {
    if (display) {
      int sliderWidthMapX = (int) (PApplet.map(value, minValue, maxValue, 0, sliderWidth));
      // ----- HorizontalSliderFloat ------
       myParent.push();
       myParent.fill(backColor);
       myParent.noStroke();
       myParent.rect(x, y, sliderWidth, sliderHeight, 8);
       myParent.fill(frontColor);
       myParent.rect(x, y, sliderWidthMapX, sliderHeight, 8, 0, 0, 8);
       myParent.fill(255);
      int handleX = x + sliderWidthMapX;
       myParent.rect(handleX, y - 2, 6, sliderHeight + 4, 4);
      // ---- text ------
       myParent.fill(fontColor);
      if (nameDisplay)
         myParent.text(NAME, x, y - 8);
      if (valueDisplay)
         myParent.text(value, x, y + sliderHeight + 16);
       myParent.pop();

      // ---- if over get selected ------
      if (mouseOver(handleX, y, 12, sliderHeight) &&  myParent.mousePressed && moo.activeControlId == -1) {
        selected = true;
        dragOffset =  myParent.mouseX - handleX;
        moo.activeControlId = id;
      } else if (! myParent.mousePressed && moo.activeControlId == id) {
        selected = false;
        moo.activeControlId = -1;
      }
    }

    // ---- if selected return value and move ------
    if (selected) {
      value = PApplet.map(myParent.mouseX - dragOffset, x, x + sliderWidth, minValue, maxValue);
      value = PApplet.constrain(value, minValue, maxValue);
      return value;
    } else {
      return 0;
    }
  }

  // ======= mouseOver ==========
  private boolean mouseOver(int x, int y, int w, int h) {
    return  myParent.mouseX > x - w &&  myParent.mouseX < x + w &&  myParent.mouseY > y - h &&  myParent.mouseY < y + h;
  }

  // ==============================
  // SETTERS CHAÎNABLES
  // ==============================
  public HorizontalSliderFloat setValue(float v) {
    this.value = v;
    return this;
  }

  public HorizontalSliderFloat setBackColor(int c) {
    this.backColor = c;
    return this;
  }

  public HorizontalSliderFloat setFrontColor(int c) {
    this.frontColor = c;
    return this;
  }

  public HorizontalSliderFloat setFontColor(int c) {
    this.fontColor = c;
    return this;
  }

  public HorizontalSliderFloat setMinValue(float v) {
    this.minValue = v;
    return this;
  }

  public HorizontalSliderFloat setMaxValue(float v) {
    this.maxValue = v;
    return this;
  }

  public HorizontalSliderFloat setSliderWidth(int w) {
    this.sliderWidth = w;
    return this;
  }

  public HorizontalSliderFloat setSliderHeight(int h) {
    this.sliderHeight = h;
    return this;
  }

  public HorizontalSliderFloat setX(int x) {
    this.x = x;
    return this;
  }

  public HorizontalSliderFloat setY(int y) {
    this.y = y;
    return this;
  }

  public HorizontalSliderFloat setName(String name) {
    this.NAME = name;
    return this;
  }

  public HorizontalSliderFloat setId(int id) {
    this.id = id;
    return this;
  }

  public HorizontalSliderFloat setSelected(boolean s) {
    this.selected = s;
    return this;
  }

  public HorizontalSliderFloat setNameDisplay(boolean d) {
    this.nameDisplay = d;
    return this;
  }

  public HorizontalSliderFloat setValueDisplay(boolean d) {
    this.valueDisplay = d;
    return this;
  }

  public HorizontalSliderFloat setDisplay(boolean state) {
    this.display = state;
    return this;
  }

  // ==============================
  // GETTERS
  // ==============================
  public float getValue() {
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

  public float getMinValue() {
    return this.minValue;
  }

  public float getMaxValue() {
    return this.maxValue;
  }

  public int getSliderWidth() {
    return this.sliderWidth;
  }

  public int getSliderHeight() {
    return this.sliderHeight;
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
