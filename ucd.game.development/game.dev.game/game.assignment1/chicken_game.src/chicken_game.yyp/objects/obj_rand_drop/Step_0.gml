
switch (room) {
case room0:


num = irandom_range(1,100);
r = irandom_range(1,10);

if counterEGG_m < 0 | keyboard_check_pressed(vk_escape)
   {
   room_goto(room1);
   } 
if counterEGG_m | counterEGG_d >= 10 and  counterEGG_m | counterEGG_d <= 19 {
  sprite_index = spr_egg_broke;
  gamespeed += 0.005; 
  hayspeed -= 0.1; 
  } 
  if  counterEGG_m | counterEGG_d >= 20 {
  sprite_index = spr_egg_broke_spill;
  gamespeed += 0.008;
   hayspeed -= 0.02; 
  }	
  if counterEGG_m | counterEGG_d >= 40 {
  sprite_index = spr_egg_broke_spill;
  gamespeed += 0.009;
   hayspeed -= 0.03; 
  } 
  if  counterEGG_m | counterEGG_d >= 80 {
  sprite_index = spr_egg_broke_spill;
  gamespeed += 0.01;
   hayspeed -= 0.5; 
  } 
  
if num<gamespeed{
  if r>=1 and r<=8{
    xp = irandom_range(40,1000)
    yp = 100;
    makedrop_e=obj_egg
    var chicken = instance_nearest(xp,yp, obj_chicken)
    dropegg = instance_create_layer(xp ,yp,"instances",makedrop_e);
    chicken.sprite_index = spr_chick_pound
    alarm[0] = 1*room_speed;  
    dropegg.speed=7; 
    dropegg.direction=270;
    dropegg.image_xscale =0.8; 
    dropegg.image_yscale=0.8; 
    dropegg.gravity = 0.1
  } else if r>=hayspeed {
    xp =  irandom_range(40,1000)
    yp = 100;
    makedrop_h=obj_golden_egg
    drophay = instance_create_layer(xp,yp,"instances",makedrop_h);
    drophay.speed=7;
    drophay.direction=270;
  }
}


	if keyboard_check_pressed(vk_escape) {  room_goto(room1); } 
	




break; 

}
