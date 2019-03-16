with(other) {
if(sprite_index == spr_egg_still) {
instance_destroy()
sprite_index = spr_egg_broke; 
effect_create_below(ef_ring, obj_basket_d.x,obj_basket_d.y,0,c_yellow);
image_xscale = image_xscale - 0.050;
image_yscale =  image_xscale - 0.050; 
if (haycaught_d <= counterEGG_d - 5 ) {
  instance_destroy()
  var new_egg = instance_create_layer(obj_basket_d.x ,obj_basket_d.y, "instances", spr_egg_broke); 
  new_egg.sprite_index = spr_egg_broke;
  new_egg.image_xscale = 0.4
  new_egg.image_yscale = 0.4
  new_egg.speed = 7
  new_egg.direction = irandom_range(1,100)
  new_egg.gravity = 0.08
  new_egg.image_xscale = image_xscale - 0.050;
  new_egg.image_yscale =  image_xscale - 0.050; 
} else {
      counterEGG_d =  counterEGG_d + 1
} 
}}
