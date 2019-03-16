if keyboard_check(ord("M")){
addithere_d_f = true;
if (keyboard_check(191)) {
motion_set(image_angle, 3) 
  with(obj_basket_d) {
  motion_set(image_angle, 3)
  }
}

if (keyboard_check(190)) {
  motion_set(image_angle, -3)
  with(obj_basket_d) {
  motion_set(image_angle, -3)
  }
  }
}

if keyboard_check(188){
  addithere_d_f = false;
  if (keyboard_check(191)) {
  motion_set(image_angle, 1)
  with(obj_basket_d) {
  motion_set(image_angle, 1)
  }
  }
  
if (keyboard_check(190)) {
motion_set(image_angle, -1)

with(obj_basket_d) {
  motion_set(image_angle, -1)
  }
  }
}
