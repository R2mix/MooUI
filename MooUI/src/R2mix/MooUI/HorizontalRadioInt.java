package R2mix.MooUI;

import processing.core.PApplet;

public class HorizontalRadioInt {
  private final PApplet myParent;
  MooUI moo;

  private int value = 0,
      backColor = 180,
      frontColor = 0,
      fontColor = 255,
      minValue = 0,
      maxValue = 127,
      radioWidth = 500,
      radioHeight = 16,
      jumpSteps = 10, // nombre de paliers
      x = 0,
      y = 0;

  public String NAME = "Horizontal Radio";
  public int id = 0;
  private boolean selected, nameDisplay = true, valueDisplay = true, display = true;

  private int[] stepValues; // tableau des valeurs des paliers

  HorizontalRadioInt(MooUI m) {

    moo = m;
    myParent = m.myParent;
    id = m.id;
    initSteps();
  }

  HorizontalRadioInt(MooUI m, int xx, int yy) {
    moo = m;
    myParent = m.myParent;
    id = m.id;
    x = xx;
    y = yy;
    initSteps();
  }

  // ======= Initialiser les paliers ==========
  private void initSteps() {
    stepValues = new int[jumpSteps];
    for (int i = 0; i < jumpSteps; i++) {
      stepValues[i] = (int) PApplet.map(i, 0, jumpSteps - 1, minValue, maxValue);
    }
  }

  private void stepsBars() {
    for (int i = 1; i < jumpSteps - 1; i++) {
     myParent.push();
      myParent.stroke(frontColor);
      myParent.strokeWeight(2);

      // ✅ on calcule la position X de chaque barre
      float stepX = PApplet.map(i, 0, jumpSteps - 1, x, x + radioWidth);

      // ✅ on trace la barre verticale
      myParent.line(stepX, y, stepX, y + radioHeight / 2 + radioHeight / 4);
      myParent.pop();
    }
  }

  // ======= return slider value ==========
  public int radioValue() {
    if (display) {
      int radioWidthMapX = (int) (PApplet.map(value, minValue, maxValue, 0, radioWidth));

      stepsBars();
      // ----- Horizontal Radio ------
     myParent.push();
      myParent.fill(backColor);
      myParent.noStroke();
      myParent.rect(x, y + radioHeight / 4, radioWidth, radioHeight / 4, 8);
      myParent.fill(frontColor);
      myParent.rect(x, y + radioHeight / 4, radioWidthMapX, radioHeight / 4, 8, 0, 0, 8);
      myParent.fill(255);
      int handleX = x + radioWidthMapX;
      myParent.rect(handleX, y, 6, radioHeight / 2 + radioHeight / 4, 4);

      // ---- text ------
      myParent.fill(fontColor);
      if (nameDisplay)
        myParent.text(NAME, x, y - 8);
      if (valueDisplay)
        myParent.text(value, x, y + radioHeight + 16);
      myParent.pop();

      // ---- if over get selected ------
      if (mouseOver(handleX, y, 6, radioHeight) && myParent.mousePressed && moo.activeControlId == -1) {
        selected = true;
        moo.activeControlId = id;
      } else if (!myParent.mousePressed && moo.activeControlId == id) {
        selected = false;
        moo.activeControlId = -1;
      }
    }

    // ---- Si l'élément est sélectionné, récupérer la valeur du palier sélectionné
    if (selected) {
      value = getNearestStep();
      return value;
    } else {
      return value; // Garder la dernière valeur sélectionnée
    }
  }

  // Fonction pour obtenir la valeur du palier le plus proche
  private int getNearestStep() {
    int relativeX = myParent.mouseX - x; // Calculer la position relative par rapport au slider
    int stepIndex = (int) PApplet.map(relativeX, 0, radioWidth, 0, jumpSteps);
    stepIndex = PApplet.constrain(stepIndex, 0, jumpSteps - 1);

    return stepValues[stepIndex];
  }

  // ======= mouseOver ==========
  private boolean mouseOver(int x, int y, int w, int h) {
    return myParent.mouseX > x && myParent.mouseX < x + w && myParent.mouseY > y && myParent.mouseY < y + h;
  }

  // ==============================
  // SETTERS CHAÎNABLES
  // ==============================
  public HorizontalRadioInt setValue(int v) {
    this.value = v;
    return this;
  }

  public HorizontalRadioInt setBackColor(int c) {
    this.backColor = c;
    return this;
  }

  public HorizontalRadioInt setFrontColor(int c) {
    this.frontColor = c;
    return this;
  }

  public HorizontalRadioInt setFontColor(int c) {
    this.fontColor = c;
    return this;
  }

  public HorizontalRadioInt setMinValue(int v) {
    this.minValue = v;
    initSteps();
    return this;
  }

  public HorizontalRadioInt setMaxValue(int v) {
    this.maxValue = v;
    initSteps();
    return this;
  }

  public HorizontalRadioInt setRadioWidth(int w) {
    this.radioWidth = w;
    return this;
  }

  public HorizontalRadioInt setRadioHeight(int h) {
    this.radioHeight = h;
    return this;
  }

  public HorizontalRadioInt setX(int x) {
    this.x = x;
    return this;
  }

  public HorizontalRadioInt setY(int y) {
    this.y = y;
    return this;
  }

  public HorizontalRadioInt setName(String name) {
    this.NAME = name;
    return this;
  }

  public HorizontalRadioInt setId(int id) {
    this.id = id;
    return this;
  }

  public HorizontalRadioInt setSelected(boolean s) {
    this.selected = s;
    return this;
  }

  public HorizontalRadioInt setNameDisplay(boolean d) {
    this.nameDisplay = d;
    return this;
  }

  public HorizontalRadioInt setValueDisplay(boolean d) {
    this.valueDisplay = d;
    return this;
  }

  public HorizontalRadioInt setDisplay(boolean state) {
    this.display = state;
    return this;
  }

  public HorizontalRadioInt setJumpSteps(int state) {
    this.jumpSteps = state;
    initSteps();
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

  public int getMinValue() {
    return this.minValue;
  }

  public int getMaxValue() {
    return this.maxValue;
  }

  public int getRadioWidth() {
    return this.radioWidth;
  }

  public int getRadioHeight() {
    return this.radioHeight;
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

  public int jumpSteps() {
    return this.jumpSteps;
  }
}
