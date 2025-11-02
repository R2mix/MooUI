import R2mix.MooUI.*;



MooUI muu;

void setup() {
  size(800, 600);
  muu = new MooUI(this);

  // ----- Horizontal Slider Int -----
  muu.addHorizontalSliderInt()
    .setX(40)
    .setY(60)
    .setSliderWidth(200)
    .setSliderHeight(20)
    .setBackColor(100)
    .setFrontColor(200)
    .setName("VolumeInt")
    .setValue(64)
    .setMaxValue(127);

  // ----- Horizontal Slider Float -----
  muu.addHorizontalSliderFloat()
    .setX(40)
    .setY(120)
    .setSliderWidth(200)
    .setSliderHeight(35)
    .setBackColor(100)
    .setFrontColor(200)
    .setName("VolumeFloat")
    .setValue(64)
    .setMaxValue(127.0);

  // ----- Vertical Slider Int -----
  muu.addVerticalSliderInt()
    .setX(300)
    .setY(60)
    .setSliderWidth(20)
    .setSliderHeight(200)
    .setBackColor(100)
    .setFrontColor(200)
    .setName("PitchInt")
    .setValue(32)
    .setMaxValue(127);

  // ----- Vertical Slider Float -----
  muu.addVerticalSliderFloat()
    .setX(360)
    .setY(60)
    .setSliderWidth(20)
    .setSliderHeight(200)
    .setBackColor(100)
    .setFrontColor(200)
    .setName("PitchFloat")
    .setValue(32.5)
    .setMaxValue(127.0);

  // ----- button -----
  muu.addButton()
    .setX(40)
    .setY(200)
    .setButtonSize(25)
    .setBackColor(100)
    .setFrontColor(200)
    .setName("trigger");


  // ----- toggle -----
  muu.addToggle()
    .setX(100)
    .setY(200)
    .setToggleSize(25)
    .setBackColor(100)
    .setFrontColor(200)
    .setName("toggle");


  // ----- Horizontal Radion -----
  muu.addHorizontalRadioInt()
    .setX(40)
    .setY(300)
    .setRadioWidth(200)
    .setRadioHeight(40)
    .setBackColor(100)
    .setFrontColor(200)
    .setName("RadioOne")
    .setValue(50)
    .setJumpSteps(10)
    .setMinValue(22)
    .setMaxValue(127);

  // ----- Vertical Radion -----
  muu.addVerticalRadioInt()
    .setX(500)
    .setY(60)
    .setRadioWidth(35)
    .setRadioHeight(200)
    .setBackColor(100)
    .setFrontColor(200)
    .setName("RadioDown")
    .setValue(50)
    .setJumpSteps(10)
    .setMinValue(22)
    .setMaxValue(127);

  // ----- Horizontal Radio f-----
  muu.addHorizontalRadioFloat()
    .setX(40)
    .setY(400)
    .setRadioWidth(200)
    .setRadioHeight(40)
    .setBackColor(100)
    .setFrontColor(200)
    .setName("radiof")
    .setValue(50)
    .setJumpSteps(10)
    .setMinValue(2.5)
    .setMaxValue(127.0);

  // ----- Vertical Radio f -----
  muu.addVerticalRadioFloat()
    .setX(600)
    .setY(60)
    .setRadioWidth(35)
    .setRadioHeight(200)
    .setBackColor(100)
    .setFrontColor(200)
    .setName("radiovf")
    .setValue(50)
    .setJumpSteps(10)
    .setMinValue(22.3)
    .setMaxValue(127.5);
}

void draw() {


  background(#1C81EA);

  // Update all sliders
  muu.updateGUI();


  // Print values by ID
  println("ID 0:", muu.getValue(0), "ID 1:", muu.getValue(1), "ID 2:", muu.getValue(2), "ID 3:", muu.getValue(3),
    "ID 4:", muu.getValue(4), "ID 5:", muu.getValue(5), "ID 6:", muu.getValue(6), "ID 7:", muu.getValue(7),
    "ID 8:", muu.getValue(8), "ID 9:", muu.getValue(9)
    );

  // Print values by Name
  println("VolumeInt:", muu.getValue("VolumeInt"),
    "VolumeFloat:", muu.getValue("VolumeFloat"),
    "PitchInt:", muu.getValue("PitchInt"),
    "PitchFloat:", muu.getValue("PitchFloat"),
    "trigger:", muu.getValue("trigger"),
    "toggle:", muu.getValue("toggle"),
    "Radio H:", muu.getValue("RadioOne"),
    "Radio V:", muu.getValue("RadioDown"),
    "Radio HF:", muu.getValue("radiof"),
    "Radio VF:", muu.getValue("radiovf")
    );



  // accès to vertical trigger modification
  VerticalSliderInt vi = (VerticalSliderInt)muu.get("PitchInt");
  vi.setBackColor(color((int)muu.getValue("PitchInt"), 0, 0));


// hide show a ui element
  HorizontalRadioInt ho = (HorizontalRadioInt)muu.get("RadioOne");
  if (muu.getValue("toggle") == 1) {
    ho.setDisplay(false);
  } else {
    ho.setDisplay(true);
  }
}
