package R2mix.MooUI;

import processing.core.PApplet;

public class VerticalSliderInt {
    private final PApplet myParent;
  MooUI moo;

  private int value = 0,
    minValue = 0,
    maxValue = 127;
  private int backColor = 180,
    frontColor = 0,
    fontColor = 255,
    sliderWidth = 16,
    sliderHeight = 200,
    x = 0,
    y = 0,
    dragOffset = 0;

  public String NAME = "slider";
  public int id = 0;
  private boolean selected, nameDisplay = true, valueDisplay = true, display = true;

  VerticalSliderInt(MooUI m) {
    moo = m;
    myParent = m.myParent;
    id = m.id;
  }

  VerticalSliderInt(MooUI m, int xx, int yy) {
    moo = m;
    myParent = m.myParent;
    id = m.id;
    x = xx;
    y = yy;
  }

  public int sliderValue() {
    if (display) {

      int sliderHeightMapY = (int)( PApplet.map(value, minValue, maxValue, 0, sliderHeight));

       myParent.push();
      myParent.fill(backColor);
      myParent.noStroke();
      myParent.rect(x, y, sliderWidth, sliderHeight, 8);
      myParent.fill(frontColor);
      myParent.rect(x, y + sliderHeight - sliderHeightMapY, sliderWidth, sliderHeightMapY, 0, 0, 8, 8);
      myParent.fill(255);
      int handleY = y + sliderHeight - sliderHeightMapY;
      myParent.rect(x - 2, handleY, sliderWidth + 4, 6, 4);
      myParent.fill(fontColor);
      if (nameDisplay) myParent.text(NAME, x, y - 8);
      if (valueDisplay) myParent.text(value, x + sliderWidth + 8, y + sliderHeight - sliderHeightMapY);
      myParent.pop();

      // ---- if over get selected ------
      if (mouseOver(x, handleY, sliderWidth, 12) && myParent.mousePressed && !selected &&  moo.activeControlId == -1) {
        selected = true;
        dragOffset = myParent.mouseY - handleY;  // garde la distance entre souris et curseur
        moo.activeControlId = id;
      } else if (!myParent.mousePressed && moo.activeControlId == id) {
        selected = false;
        moo.activeControlId = -1;
      }
    }
    // ---- if selected return value and move ------
    if (selected) {
      value = (int) PApplet.map( myParent.mouseY - dragOffset - 1, y + sliderHeight, y, minValue, maxValue);
      value = PApplet.constrain(value, minValue, maxValue);
      return value;
    } else {
      return 0;
    }
  }


  private boolean mouseOver(int x, int y, int w, int h) {
    return myParent.mouseX > x-w && myParent.mouseX < x + w && myParent.mouseY > y && myParent.mouseY < y + h;
  }

  // SETTERS CHAÎNABLES
  public VerticalSliderInt setValue(int v) {
    value = v;
    return this;
  }
  public VerticalSliderInt setBackColor(int c) {
    backColor = c;
    return this;
  }
  public VerticalSliderInt setFrontColor(int c) {
    frontColor = c;
    return this;
  }
  public VerticalSliderInt setFontColor(int c) {
    fontColor = c;
    return this;
  }
  public VerticalSliderInt setMinValue(int v) {
    minValue = v;
    return this;
  }
  public VerticalSliderInt setMaxValue(int v) {
    maxValue = v;
    return this;
  }
  public VerticalSliderInt setSliderWidth(int w) {
    sliderWidth = w;
    return this;
  }
  public VerticalSliderInt setSliderHeight(int h) {
    sliderHeight = h;
    return this;
  }
  public VerticalSliderInt setX(int xx) {
    x = xx;
    return this;
  }
  public VerticalSliderInt setY(int yy) {
    y = yy;
    return this;
  }
  public VerticalSliderInt setName(String n) {
    NAME = n;
    return this;
  }
  public VerticalSliderInt setId(int i) {
    id = i;
    return this;
  }
  public VerticalSliderInt setSelected(boolean s) {
    selected = s;
    return this;
  }
  public VerticalSliderInt setNameDisplay(boolean d) {
    nameDisplay = d;
    return this;
  }
  public VerticalSliderInt setValueDisplay(boolean d) {
    valueDisplay = d;
    return this;
  }
  public VerticalSliderInt setDisplay(boolean state) {
    this.display = state;
    return this;
  }

  // GETTERS
  public int getValue() {
    return value;
  }
  public int getBackColor() {
    return backColor;
  }
  public int getFrontColor() {
    return frontColor;
  }
  public int getFontColor() {
    return fontColor;
  }
  public int getMinValue() {
    return minValue;
  }
  public int getMaxValue() {
    return maxValue;
  }
  public int getSliderWidth() {
    return sliderWidth;
  }
  public int getSliderHeight() {
    return sliderHeight;
  }
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  public String getName() {
    return NAME;
  }
  public int getId() {
    return id;
  }
  public boolean isSelected() {
    return selected;
  }
  public boolean isNameDisplay() {
    return nameDisplay;
  }
  public boolean isValueDisplay() {
    return valueDisplay;
  }
  public boolean isDisplay() {
    return this.display;
  }
}
