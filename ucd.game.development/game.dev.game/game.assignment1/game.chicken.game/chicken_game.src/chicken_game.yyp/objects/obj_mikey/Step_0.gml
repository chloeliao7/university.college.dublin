if keyboard_check(ord("X")){
 
addithere_m_f = true;
if (keyboard_check(vk_right) || keyboard_check(ord("V"))) {
motion_set(image_angle, 3) 
  with(obj_basket_m) {
  motion_set(image_angle, 3)
  }
}
  if (keyboard_check(vk_left) || keyboard_check(ord("C"))) {
  motion_set(image_angle, -3)
  with(obj_basket_m) {
    motion_set(image_angle, -3)
  }
  }
}

if keyboard_check(ord("Z")) {
  addithere_m_f = false;
if (keyboard_check(vk_right) || keyboard_check(ord("V"))) {
motion_set(image_angle, 1)
  with(obj_basket_m) {
  motion_set(image_angle, 1)
  }
}

if (keyboard_check(vk_left) || keyboard_check(ord("C"))) {
motion_set(image_angle, -1)
with(obj_basket_m) {
  motion_set(image_angle, -1)
  }
}	
}
