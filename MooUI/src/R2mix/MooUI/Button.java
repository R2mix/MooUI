package R2mix.MooUI;

import processing.core.*;

public class Button {
  private final PApplet myParent;

  private int value = 0,
      backColor = 180,
      frontColor = 0,
      fontColor = 255,
      buttonSize = 25,
      x = 0,
      y = 0;

  public String NAME = "button";
  public int id = 0;
  private boolean selected, nameDisplay = true, valueDisplay = false, display = true;

  MooUI moo;

  Button(MooUI m) {
    moo = m;
    myParent = m.myParent;
    id = m.id;
  }

  Button(MooUI m, int xx, int yy) {
    moo = m;
    myParent = m.myParent;
    id = m.id;
    x = xx;
    y = yy;
  }

  // ======= return slider value ========== -> in void draw
  int buttonValue() {
    if (display) {

      // ----- Button ------
      myParent.push();
      myParent.fill(backColor);
      myParent.noStroke();
      myParent.rect(x, y, buttonSize, buttonSize);
      myParent.fill(frontColor);
      if (!selected)
        myParent.rect(x, y, buttonSize, buttonSize, 90);
      // ---- text ------
      myParent.fill(fontColor);
      if (nameDisplay)
        myParent.text(NAME, x, y - 8);
      if (valueDisplay)
        myParent.text(value, x, y + buttonSize + 16);
      myParent.pop();

      // ----- détection du clic -----
      boolean over = mouseOver(x, y, buttonSize, buttonSize);
      // on déclenche le front montant :
      if (over && myParent.mousePressed && !selected && moo.activeControlId == -1) {
        // clic vient juste de commencer
        value = 1; // envoie un "1" pendant une frame
        selected = true;
        moo.activeControlId = id;
      } else {
        value = 0; // sinon 0
      }
    }
    // reset de selected quand le clic est relâché
    if (!myParent.mousePressed && moo.activeControlId == id) {
      selected = false;
      moo.activeControlId = -1;
    }

    return value;
  }

  // ======= mouseOver ==========
  private boolean mouseOver(int x, int y, int w, int h) {
    return myParent.mouseX > x && myParent.mouseX < x + w && myParent.mouseY > y && myParent.mouseY < y + h;
  }

  // ==============================
  // SETTERS CHAÎNABLES
  // ==============================
  public Button setValue(int v) {
    this.value = v;
    return this;
  }

  public Button setBackColor(int c) {
    this.backColor = c;
    return this;
  }

  public Button setFrontColor(int c) {
    this.frontColor = c;
    return this;
  }

  public Button setFontColor(int c) {
    this.fontColor = c;
    return this;
  }

  public Button setButtonSize(int w) {
    this.buttonSize = w;
    return this;
  }

  public Button setX(int x) {
    this.x = x;
    return this;
  }

  public Button setY(int y) {
    this.y = y;
    return this;
  }

  public Button setName(String name) {
    this.NAME = name;
    return this;
  }

  public Button setId(int id) {
    this.id = id;
    return this;
  }

  public Button setSelected(boolean s) {
    this.selected = s;
    return this;
  }

  public Button setNameDisplay(boolean d) {
    this.nameDisplay = d;
    return this;
  }

  public Button setValueDisplay(boolean d) {
    this.valueDisplay = d;
    return this;
  }

  public Button setDisplay(boolean state) {
    this.display = state;
    return this;
  }

  // ==============================
  // GETTERS
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

  public int getButtonSize() {
    return this.buttonSize;
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
