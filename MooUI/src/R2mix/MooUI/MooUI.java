package R2mix.MooUI;

import java.util.ArrayList;
import processing.core.*;

public class MooUI {
  public final PApplet myParent;
  public final static String VERSION = "MooUI-0.0.1a by R2MIX", WEBSITE = "www.github.com/r2mix/MooUI";

  // For activate once gui at time
  public int activeControlId = -1;

  private ArrayList<HorizontalSliderInt> hSlidersInt;
  private ArrayList<HorizontalSliderFloat> hSlidersFloat;
  private ArrayList<VerticalSliderInt> vSlidersInt;
  private ArrayList<VerticalSliderFloat> vSlidersFloat;
  private ArrayList<HorizontalRadioInt> hRadioInt;
  private ArrayList<VerticalRadioInt> vRadioInt;
  private ArrayList<HorizontalRadioFloat> hRadioFloat;
  private ArrayList<VerticalRadioFloat> vRadioFloat;
  private ArrayList<Toggle> toggles;
  private ArrayList<Button> buttons;
  public int id = 0;

  public MooUI(PApplet theParent) {
    myParent = theParent;
    PApplet.println(VERSION);
    PApplet.println(WEBSITE);

    hSlidersInt = new ArrayList<>();
    hSlidersFloat = new ArrayList<>();
    vSlidersInt = new ArrayList<>();
    vSlidersFloat = new ArrayList<>();
    hRadioInt = new ArrayList<>();
    vRadioInt = new ArrayList<>();
    hRadioFloat = new ArrayList<>();
    vRadioFloat = new ArrayList<>();
    toggles = new ArrayList<>();
    buttons = new ArrayList<>();
  }

  public void updateGUI() {
    for (int i = 0; i < hSlidersInt.size(); i++) {
      hSlidersInt.get(i).sliderValue();
    }
    for (int i = 0; i < hSlidersFloat.size(); i++) {
      hSlidersFloat.get(i).sliderValue();
    }
    for (int i = 0; i < vSlidersInt.size(); i++) {
      vSlidersInt.get(i).sliderValue();
    }
    for (int i = 0; i < vSlidersFloat.size(); i++) {
      vSlidersFloat.get(i).sliderValue();
    }
    for (int i = 0; i < hRadioInt.size(); i++) {
      hRadioInt.get(i).radioValue();
    }
    for (int i = 0; i < vRadioInt.size(); i++) {
      vRadioInt.get(i).radioValue();
    }
    for (int i = 0; i < hRadioFloat.size(); i++) {
      hRadioFloat.get(i).radioValue();
    }
    for (int i = 0; i < vRadioFloat.size(); i++) {
      vRadioFloat.get(i).radioValue();
    }
    for (int i = 0; i < toggles.size(); i++) {
      toggles.get(i).toggleValue();
    }
    for (int i = 0; i < buttons.size(); i++) {
      buttons.get(i).buttonValue();
    }
  }

public Object get(int id) {
    // Vérifie dans chaque liste
    for (HorizontalSliderInt s : hSlidersInt)
        if (s.id == id) return s;

    for (HorizontalSliderFloat s : hSlidersFloat)
        if (s.id == id) return s;

    for (VerticalSliderInt s : vSlidersInt)
        if (s.id == id) return s;

    for (VerticalSliderFloat s : vSlidersFloat)
        if (s.id == id) return s;

    for (HorizontalRadioInt r : hRadioInt)
        if (r.id == id) return r;

    for (VerticalRadioInt r : vRadioInt)
        if (r.id == id) return r;

    for (HorizontalRadioFloat r : hRadioFloat)
        if (r.id == id) return r;

    for (VerticalRadioFloat r : vRadioFloat)
        if (r.id == id) return r;

    for (Toggle t : toggles)
        if (t.id == id) return t;

    for (Button b : buttons)
        if (b.id == id) return b;

    return null; // si rien trouvé
}


 public Object get(String name) {
    // ----- Horizontal slider Int -----
    for (HorizontalSliderInt s : hSlidersInt) {
      if (s.getName().equals(name))
        return s;
    }
    // ----- Vertical slider Int -----
    for (VerticalSliderInt s : vSlidersInt) {
      if (s.getName().equals(name))
        return s;
    }
    // ----- Horizontal slider Float -----
    for (HorizontalSliderFloat s : hSlidersFloat) {
      if (s.getName().equals(name))
        return s;
    }
    // ----- Vertical sider Float -----
    for (VerticalSliderFloat s : vSlidersFloat) {
      if (s.getName().equals(name))
      return s;
    }
    // ----- Horizontal radio int -----
    for (HorizontalRadioInt h : hRadioInt) {
      if (h.getName().equals(name))
    return h;
    }
    // ----- vertical radio int -----
    for (VerticalRadioInt v : vRadioInt) {
      if (v.getName().equals(name))
       return v;
    }
    // ----- Horizontal radio int -----
    for (HorizontalRadioFloat h : hRadioFloat) {
      if (h.getName().equals(name))
        return h;
    }
    // ----- vertical radio int -----
    for (VerticalRadioFloat v : vRadioFloat) {
      if (v.getName().equals(name))
        return v;
    }
    // ----- toggle -----
    for (Toggle t : toggles) {
      if (t.getName().equals(name))
        return t;
    }
    // ----- buttons -----
    for (Button b : buttons) {
      if (b.getName().equals(name))
        return b;
    }
    // si aucun slider ne correspond
    return null;
  }


  // ----- ADD HorizontalSliderInt with or without coordonates ----
  public HorizontalSliderInt addHorizontalSliderInt(int xx, int yy) {
    HorizontalSliderInt v = new HorizontalSliderInt(this, xx, yy);
    hSlidersInt.add(v);
    id++;
    return v;
  }

  public HorizontalSliderInt addHorizontalSliderInt() {
    HorizontalSliderInt v = new HorizontalSliderInt(this);
    hSlidersInt.add(v);
    id++;
    return v;
  }

  // ----- ADD HorizontalSliderFloat with or without coordonates ----
  public HorizontalSliderFloat addHorizontalSliderFloat(int xx, int yy) {
    HorizontalSliderFloat v = new HorizontalSliderFloat(this, xx, yy);
    hSlidersFloat.add(v);
    id++;
    return v;
  }

  public HorizontalSliderFloat addHorizontalSliderFloat() {
    HorizontalSliderFloat v = new HorizontalSliderFloat(this);
    hSlidersFloat.add(v);
    id++;
    return v;
  }

  // ----- ADD VerticalSliderInt with or without coordinates ----
  public VerticalSliderInt addVerticalSliderInt(int xx, int yy) {
    VerticalSliderInt v = new VerticalSliderInt(this, xx, yy);
    vSlidersInt.add(v);
    id++;
    return v;
  }

  public VerticalSliderInt addVerticalSliderInt() {
    VerticalSliderInt v = new VerticalSliderInt(this);
    vSlidersInt.add(v);
    id++;
    return v;
  }

  // ----- ADD VerticalSliderFloat with or without coordinates ----
  public VerticalSliderFloat addVerticalSliderFloat(int xx, int yy) {
    VerticalSliderFloat v = new VerticalSliderFloat(this, xx, yy);
    vSlidersFloat.add(v);
    id++;
    return v;
  }

  public VerticalSliderFloat addVerticalSliderFloat() {
    VerticalSliderFloat v = new VerticalSliderFloat(this);
    vSlidersFloat.add(v);
    id++;
    return v;
  }

  // ----- ADD Horizontal radio int with or without coordinates ----
  public HorizontalRadioInt addHorizontalRadioInt(int xx, int yy) {
    HorizontalRadioInt h = new HorizontalRadioInt(this, xx, yy);
    hRadioInt.add(h);
    id++;
    return h;
  }

  public HorizontalRadioInt addHorizontalRadioInt() {
    HorizontalRadioInt h = new HorizontalRadioInt(this);
    hRadioInt.add(h);
    id++;
    return h;
  }

  // ----- ADD Vertical radio int with or without coordinates ----
  public VerticalRadioInt addVerticalRadioInt(int xx, int yy) {
    VerticalRadioInt v = new VerticalRadioInt(this, xx, yy);
    vRadioInt.add(v);
    id++;
    return v;
  }

  public VerticalRadioInt addVerticalRadioInt() {
    VerticalRadioInt v = new VerticalRadioInt(this);
    vRadioInt.add(v);
    id++;
    return v;
  }

  // ----- ADD Horizontal radio float with or without coordinates ----
  public HorizontalRadioFloat addHorizontalRadioFloat(int xx, int yy) {
    HorizontalRadioFloat h = new HorizontalRadioFloat(this, xx, yy);
    hRadioFloat.add(h);
    id++;
    return h;
  }

  public HorizontalRadioFloat addHorizontalRadioFloat() {
    HorizontalRadioFloat h = new HorizontalRadioFloat(this);
    hRadioFloat.add(h);
    id++;
    return h;
  }

  // ----- ADD Vertical radio float with or without coordinates ----
  public VerticalRadioFloat addVerticalRadioFloat(int xx, int yy) {
    VerticalRadioFloat v = new VerticalRadioFloat(this, xx, yy);
    vRadioFloat.add(v);
    id++;
    return v;
  }

  public VerticalRadioFloat addVerticalRadioFloat() {
    VerticalRadioFloat v = new VerticalRadioFloat(this);
    vRadioFloat.add(v);
    id++;
    return v;
  }

  // ----- ADD toggle with or without coordinates ----
  public Toggle addToggle(int xx, int yy) {
    Toggle t = new Toggle(this, xx, yy);
    toggles.add(t);
    id++;
    return t;
  }

  public Toggle addToggle() {
    Toggle t = new Toggle(this);
    toggles.add(t);
    id++;
    return t;
  }

  // ----- ADD button with or without coordinates ----
  public Button addButton(int xx, int yy) {
    Button b = new Button(this, xx, yy);
    buttons.add(b);
    id++;
    return b;
  }

  public Button addButton() {
    Button b = new Button(this);
    buttons.add(b);
    id++;
    return b;
  }

  public float getValue(String name) {
    // ----- Horizontal slider Int -----
    for (HorizontalSliderInt s : hSlidersInt) {
      if (s.getName().equals(name))
        return (float) s.getValue();
    }
    // ----- Vertical slider Int -----
    for (VerticalSliderInt s : vSlidersInt) {
      if (s.getName().equals(name))
        return (float) s.getValue();
    }
    // ----- Horizontal slider Float -----
    for (HorizontalSliderFloat s : hSlidersFloat) {
      if (s.getName().equals(name))
        return s.getValue();
    }
    // ----- Vertical sider Float -----
    for (VerticalSliderFloat s : vSlidersFloat) {
      if (s.getName().equals(name))
        return s.getValue();
    }
    // ----- Horizontal radio int -----
    for (HorizontalRadioInt h : hRadioInt) {
      if (h.getName().equals(name))
        return h.getValue();
    }
    // ----- vertical radio int -----
    for (VerticalRadioInt v : vRadioInt) {
      if (v.getName().equals(name))
        return v.getValue();
    }
    // ----- Horizontal radio int -----
    for (HorizontalRadioFloat h : hRadioFloat) {
      if (h.getName().equals(name))
        return h.getValue();
    }
    // ----- vertical radio int -----
    for (VerticalRadioFloat v : vRadioFloat) {
      if (v.getName().equals(name))
        return v.getValue();
    }
    // ----- toggle -----
    for (Toggle t : toggles) {
      if (t.getName().equals(name))
        return t.getValue();
    }
    // ----- buttons -----
    for (Button b : buttons) {
      if (b.getName().equals(name))
        return b.getValue();
    }
    // si aucun slider ne correspond
    return 0f;
  }

  public float getValue(int id) {
    // ----- Horizontal Int -----
    for (HorizontalSliderInt s : hSlidersInt) {
      if (s.getId() == id)
        return (float) s.getValue();
    }
    // ----- Vertical Int -----
    for (VerticalSliderInt s : vSlidersInt) {
      if (s.getId() == id)
        return (float) s.getValue();
    }
    // ----- Horizontal Float -----
    for (HorizontalSliderFloat s : hSlidersFloat) {
      if (s.getId() == id)
        return s.getValue();
    }
    // ----- Vertical Float -----
    for (VerticalSliderFloat s : vSlidersFloat) {
      if (s.getId() == id)
        return s.getValue();
    }

    // ----- Horizontal Radio -----
    for (HorizontalRadioInt h : hRadioInt) {
      if (h.getId() == id)
        return h.getValue();
    }

    // ----- toggle -----
    for (Toggle t : toggles) {
      if (t.getId() == id)
        return t.getValue();
    }
    // ----- buttons -----
    for (Button b : buttons) {
      if (b.getId() == id)
        return b.getValue();
    }
    return 0f;
  }
}
