package R2mix.MooUI;

import processing.core.PApplet;

public class VerticalRadioInt {
  private final PApplet myParent;
  MooUI moo;

  private int value = 0,
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

  public String NAME = "Vertical Radio";
  public int id = 0;
  private boolean selected, nameDisplay = true, valueDisplay = true, display = true;

  private int[] stepValues;  // tableau des valeurs des paliers

  VerticalRadioInt(MooUI m) {
    moo = m;
    myParent = m.myParent;
    id = m.id;
    initSteps();
  }

  VerticalRadioInt(MooUI m, int xx, int yy) {
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

  // ======= Dessiner les barres intermédiaires =======
  private void stepsBars() {
    for (int i = 1; i < jumpSteps - 1; i++) {
       myParent.push();
       myParent.stroke(frontColor);
       myParent.strokeWeight(2);

      // ✅ Position Y de chaque barre
      float stepY = PApplet.map(i, 0, jumpSteps - 1, y + radioHeight, y);

      // ✅ On trace une barre horizontale
       myParent.line(x, stepY, x + radioWidth / 2 + radioWidth / 4, stepY);
       myParent.pop();
    }
  }

  // ======= Rendu + interaction ==========
  public int radioValue() {
    if (display) {

      // map value -> position Y
      int radioHeightMapY = (int) PApplet.map(value, minValue, maxValue, 0, radioHeight);

      // barres intermédiaires
      stepsBars();

       myParent.push();
      // fond du slider
       myParent.fill(backColor);
       myParent.noStroke();
       myParent.rect(x + radioWidth/4, y, radioWidth/4, radioHeight, 8);

      // barre de progression (de bas en haut)
       myParent.fill(frontColor);
       myParent.rect(x + radioWidth/4, y + radioHeight - radioHeightMapY, radioWidth/4, radioHeightMapY, 8, 8, 0, 0);



      // poignée
       myParent.fill(255);
      int handleY = y + radioHeight - radioHeightMapY;
       myParent.rect(x, handleY, radioWidth/2 + radioWidth/4, 6, 4);

      // texte
       myParent.fill(fontColor);
      if (nameDisplay)  myParent.text(NAME, x + radioWidth + 8, y + 12);
      if (valueDisplay)  myParent.text(value, x + radioWidth + 8, y + radioHeight / 2);
       myParent.pop();

      // Interaction : clic et glissement
      if (mouseOver(x, handleY, radioWidth, 6) &&  myParent.mousePressed &&  moo.activeControlId == -1) {
        selected = true;
        moo.activeControlId = id;
      } else if (!myParent.mousePressed &&  moo.activeControlId == id) {
        selected = false;
        moo.activeControlId = -1;
      }
    }



    // Mise à jour valeur
    if (selected) {
      value = getNearestStep();

      return value;
    } else {
      return value;
    }
  }

  // ======= Trouver le palier le plus proche en Y =======
  private int getNearestStep() {
    int relativeY = (y + radioHeight) - myParent.mouseY;  // Inverser (origine en bas)
    int stepIndex = (int) PApplet.map(relativeY, 0, radioHeight, 0, jumpSteps);
    stepIndex = PApplet.constrain(stepIndex, 0, jumpSteps - 1);
    return stepValues[stepIndex];
  }

  // ======= Mouse Over =======
  private boolean mouseOver(int x, int y, int w, int h) {
    return myParent.mouseX > x && myParent.mouseX < x + w && myParent.mouseY > y && myParent.mouseY < y + h;
  }

  // ==============================
  //        SETTERS CHAÎNABLES
  // ==============================
  public VerticalRadioInt setValue(int v) {
    this.value = v;
    return this;
  }
  public VerticalRadioInt setBackColor(int c) {
    this.backColor = c;
    return this;
  }
  public VerticalRadioInt setFrontColor(int c) {
    this.frontColor = c;
    return this;
  }
  public VerticalRadioInt setFontColor(int c) {
    this.fontColor = c;
    return this;
  }
  public VerticalRadioInt setMinValue(int v) {
    this.minValue = v;
    initSteps();
    return this;
  }
  public VerticalRadioInt setMaxValue(int v) {
    this.maxValue = v;
    initSteps();
    return this;
  }
  public VerticalRadioInt setRadioWidth(int w) {
    this.radioWidth = w;
    return this;
  }
  public VerticalRadioInt setRadioHeight(int h) {
    this.radioHeight = h;
    return this;
  }
  public VerticalRadioInt setX(int x) {
    this.x = x;
    return this;
  }
  public VerticalRadioInt setY(int y) {
    this.y = y;
    return this;
  }
  public VerticalRadioInt setName(String name) {
    this.NAME = name;
    return this;
  }
  public VerticalRadioInt setId(int id) {
    this.id = id;
    return this;
  }
  public VerticalRadioInt setSelected(boolean s) {
    this.selected = s;
    return this;
  }
  public VerticalRadioInt setNameDisplay(boolean d) {
    this.nameDisplay = d;
    return this;
  }
  public VerticalRadioInt setValueDisplay(boolean d) {
    this.valueDisplay = d;
    return this;
  }
  public VerticalRadioInt setDisplay(boolean state) {
    this.display = state;
    return this;
  }
  public VerticalRadioInt setJumpSteps(int state) {
    this.jumpSteps = state;
    initSteps();
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
