package R2mix.MooUI;

import processing.core.PApplet;

public class VerticalRadioFloat {
  private final PApplet myParent;
  MooUI moo;

  private float value = 0,
      backColor = 180,
      frontColor = 0,
      fontColor = 255,
      minValue = 0,
      maxValue = 127,
      radioWidth = 16,
      radioHeight = 300, // hauteur dominante
      jumpSteps = 10, // nombre de paliers
      x = 0,
      y = 0;

  public String NAME = "Vertical Radio Float";
  public int id = 0;
  private boolean selected, nameDisplay = true, valueDisplay = true, display = true;

  private float[] stepValues; // tableau des valeurs des paliers

  VerticalRadioFloat(MooUI m) {
    moo = m;
    myParent = m.myParent;
    id = m.id;
    initSteps();
  }

  VerticalRadioFloat(MooUI m, int xx, int yy) {
    moo = m;
    myParent = m.myParent;
    id = m.id;
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

      // ✅ Position Y de chaque barre (de bas vers haut)
      float stepY = PApplet.map(i, 0, jumpSteps - 1, y + radioHeight, y);

      // ✅ On trace une barre horizontale
      myParent.line(x, stepY, x + radioWidth / 2 + radioWidth / 4, stepY);
      myParent.pop();
    }
  }

  // ======= Rendu + interaction ==========
  public float radioValue() {
    if (display) {
      // map value -> position Y
      float radioHeightMapY = PApplet.map(value, minValue, maxValue, 0, radioHeight);

      // barres intermédiaires
      stepsBars();

      myParent.push();
      // fond du slider
      myParent.fill(backColor);
      myParent.noStroke();
      myParent.rect(x + radioWidth / 4, y, radioWidth / 4, radioHeight, 8);

      // barre de progression (de bas en haut)
      myParent.fill(frontColor);
      myParent.rect(x + radioWidth / 4, y + radioHeight - radioHeightMapY, radioWidth / 4, radioHeightMapY, 8, 8, 0, 0);

      // poignée
     myParent.fill(255);
      float handleY = y + radioHeight - radioHeightMapY;
     myParent.rect(x, handleY, radioWidth / 2 + radioWidth / 4, 6, 4);

      // texte
      myParent.fill(fontColor);
      if (nameDisplay)
       myParent. text(NAME, x + radioWidth + 8, y + 12);
      if (valueDisplay)
        myParent.text(PApplet.nf(value, 1, 2), x + radioWidth + 8, y + radioHeight / 2); // 2 décimales
      myParent.pop();

      // Interaction : clic et glissement
      if (mouseOver(x, handleY, radioWidth, 6) && myParent.mousePressed && moo.activeControlId == -1) {
        selected = true;
        moo.activeControlId = id;
      } else if (!myParent.mousePressed && moo.activeControlId == id) {
        selected = false;
        moo.activeControlId = -1;
      }
    }

    // Mise à jour valeur si sélectionné
    if (selected) {
      value = getNearestStep();
      return value;
    } else {
      return value;
    }
  }

  // ======= Trouver le palier le plus proche en Y =======
  private float getNearestStep() {
    float relativeY = (y + radioHeight) - myParent.mouseY; // Inverser (origine en bas)
    int stepIndex = (int) PApplet.map(relativeY, 0, radioHeight, 0, jumpSteps);
    stepIndex = PApplet.constrain(stepIndex, 0, (int) jumpSteps - 1);
    return stepValues[stepIndex];
  }

  // ======= Mouse Over =======
  private boolean mouseOver(float x, float y, float w, float h) {
    return myParent.mouseX > x && myParent.mouseX < x + w && myParent.mouseY > y && myParent.mouseY < y + h;
  }

  // ==============================
  // SETTERS CHAÎNABLES
  // ==============================
  public VerticalRadioFloat setValue(float v) {
    this.value = PApplet.constrain(v, minValue, maxValue);
    return this;
  }

  public VerticalRadioFloat setBackColor(int c) {
    this.backColor = c;
    return this;
  }

  public VerticalRadioFloat setFrontColor(int c) {
    this.frontColor = c;
    return this;
  }

  public VerticalRadioFloat setFontColor(int c) {
    this.fontColor = c;
    return this;
  }

  public VerticalRadioFloat setMinValue(float v) {
    this.minValue = v;
    initSteps();
    return this;
  }

  public VerticalRadioFloat setMaxValue(float v) {
    this.maxValue = v;
    initSteps();
    return this;
  }

  public VerticalRadioFloat setRadioWidth(float w) {
    this.radioWidth = w;
    return this;
  }

  public VerticalRadioFloat setRadioHeight(float h) {
    this.radioHeight = h;
    return this;
  }

  public VerticalRadioFloat setX(float x) {
    this.x = x;
    return this;
  }

  public VerticalRadioFloat setY(float y) {
    this.y = y;
    return this;
  }

  public VerticalRadioFloat setName(String name) {
    this.NAME = name;
    return this;
  }

  public VerticalRadioFloat setId(int id) {
    this.id = id;
    return this;
  }

  public VerticalRadioFloat setSelected(boolean s) {
    this.selected = s;
    return this;
  }

  public VerticalRadioFloat setNameDisplay(boolean d) {
    this.nameDisplay = d;
    return this;
  }

  public VerticalRadioFloat setValueDisplay(boolean d) {
    this.valueDisplay = d;
    return this;
  }

  public VerticalRadioFloat setDisplay(boolean state) {
    this.display = state;
    return this;
  }

  public VerticalRadioFloat setJumpSteps(float state) {
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
