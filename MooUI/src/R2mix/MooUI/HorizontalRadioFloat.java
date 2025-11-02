package R2mix.MooUI;

import processing.core.PApplet;

public class HorizontalRadioFloat {
  private final PApplet myParent;
  MooUI moo;

  private float value = 0,
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

  public String NAME = "Horizontal Radio Float";
  public int id = 0;
  private boolean selected, nameDisplay = true, valueDisplay = true, display = true;

  private float[] stepValues; // tableau des valeurs des paliers

  HorizontalRadioFloat(MooUI m) {
    moo = m;
    myParent = m.myParent;
    id = m.id;
    initSteps();
  }

  HorizontalRadioFloat(MooUI m, int xx, int yy) {
    moo = m;
    id = m.id;
    myParent = m.myParent;
    x = xx;
    y = yy;
    initSteps();
  }

  // ======= Initialiser les paliers ==========
  private void initSteps() {
    stepValues = new float[(int) jumpSteps];
    for (int i = 0; i < jumpSteps; i++) {
      stepValues[i] = PApplet.map(i, 0, jumpSteps - 1, minValue, maxValue);
    }
  }

  // ======= Dessiner les barres intermédiaires =======
  private void stepsBars() {
    for (int i = 1; i < jumpSteps - 1; i++) {
      myParent.push();
      myParent.stroke(frontColor);
      myParent.strokeWeight(2);

      float stepX = PApplet.map(i, 0, jumpSteps - 1, x, x + radioWidth);
      myParent.line(stepX, y, stepX, y + radioHeight / 2 + radioHeight / 4);
      myParent.pop();
    }
  }

  // ======= Calcul + affichage ==========
  public float radioValue() {
    if (display) {
      float radioWidthMapX = PApplet.map(value, minValue, maxValue, 0, radioWidth);

      stepsBars();

      // ----- fond -----
      myParent.push();
      myParent.fill(backColor);
      myParent.noStroke();
      myParent.rect(x, y + radioHeight / 4, radioWidth, radioHeight / 4, 8);

      // ----- zone active -----
      myParent.fill(frontColor);
      myParent.rect(x, y + radioHeight / 4, radioWidthMapX, radioHeight / 4, 8, 0, 0, 8);

      // ----- poignée -----
      myParent.fill(255);
      float handleX = x + radioWidthMapX;
      myParent.rect(handleX, y, 6, radioHeight / 2 + radioHeight / 4, 4);

      // ----- texte -----
      myParent.fill(fontColor);
      if (nameDisplay)
        myParent.text(NAME, x, y - 8);
      if (valueDisplay)
        myParent.text(PApplet.nf(value, 1, 2), x, y + radioHeight + 16); // 2 décimales
      myParent.pop();

      // ----- Interaction -----
      if (mouseOver(handleX, y, 6, radioHeight) && myParent.mousePressed && moo.activeControlId == -1) {
        selected = true;
        moo.activeControlId = id;
      } else if (!myParent.mousePressed && moo.activeControlId == id) {
        selected = false;
        moo.activeControlId = -1;
      }
    }

    // ----- Calcul de la valeur -----
    if (selected) {
      value = getNearestStep();
      return value;
    } else {
      return value;
    }
  }

  // ======= Trouver la valeur du palier le plus proche =======
  private float getNearestStep() {
    float relativeX = myParent.mouseX - x;
    int stepIndex = (int) PApplet.map(relativeX, 0, radioWidth, 0, jumpSteps);
    stepIndex = PApplet.constrain(stepIndex, 0, (int) jumpSteps - 1);
    return stepValues[stepIndex];
  }

  // ======= Détection souris =======
  private boolean mouseOver(float x, float y, float w, float h) {
    return myParent.mouseX > x && myParent.mouseX < x + w && myParent.mouseY > y && myParent.mouseY < y + h;
  }

  // ==============================
  // SETTERS CHAÎNABLES
  // ==============================
  public HorizontalRadioFloat setValue(float v) {
    this.value = PApplet.constrain(v, minValue, maxValue);
    return this;
  }

  public HorizontalRadioFloat setBackColor(int c) {
    this.backColor = c;
    return this;
  }

  public HorizontalRadioFloat setFrontColor(int c) {
    this.frontColor = c;
    return this;
  }

  public HorizontalRadioFloat setFontColor(int c) {
    this.fontColor = c;
    return this;
  }

  public HorizontalRadioFloat setMinValue(float v) {
    this.minValue = v;
    initSteps();
    return this;
  }

  public HorizontalRadioFloat setMaxValue(float v) {
    this.maxValue = v;
    initSteps();
    return this;
  }

  public HorizontalRadioFloat setRadioWidth(float w) {
    this.radioWidth = w;
    return this;
  }

  public HorizontalRadioFloat setRadioHeight(float h) {
    this.radioHeight = h;
    return this;
  }

  public HorizontalRadioFloat setX(float x) {
    this.x = x;
    return this;
  }

  public HorizontalRadioFloat setY(float y) {
    this.y = y;
    return this;
  }

  public HorizontalRadioFloat setName(String name) {
    this.NAME = name;
    return this;
  }

  public HorizontalRadioFloat setId(int id) {
    this.id = id;
    return this;
  }

  public HorizontalRadioFloat setSelected(boolean s) {
    this.selected = s;
    return this;
  }

  public HorizontalRadioFloat setNameDisplay(boolean d) {
    this.nameDisplay = d;
    return this;
  }

  public HorizontalRadioFloat setValueDisplay(boolean d) {
    this.valueDisplay = d;
    return this;
  }

  public HorizontalRadioFloat setDisplay(boolean state) {
    this.display = state;
    return this;
  }

  public HorizontalRadioFloat setJumpSteps(float state) {
    this.jumpSteps = state;
    initSteps();
    return this;
  }

  // ==============================
  // GETTERS
  // ==============================
  public float getValue() {
    return this.value;
  }

  public float getBackColor() {
    return this.backColor;
  }

  public float getFrontColor() {
    return this.frontColor;
  }

  public float getFontColor() {
    return this.fontColor;
  }

  public float getMinValue() {
    return this.minValue;
  }

  public float getMaxValue() {
    return this.maxValue;
  }

  public float getRadioWidth() {
    return this.radioWidth;
  }

  public float getRadioHeight() {
    return this.radioHeight;
  }

  public float getX() {
    return this.x;
  }

  public float getY() {
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

  public float jumpSteps() {
    return this.jumpSteps;
  }
}
