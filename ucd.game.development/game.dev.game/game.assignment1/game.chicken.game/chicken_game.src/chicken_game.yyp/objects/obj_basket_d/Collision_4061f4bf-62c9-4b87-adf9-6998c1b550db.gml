

  with(other) {
    if(sprite_index == spr_hay_fall) {
    instance_destroy(); 
      sprite_index = spr_hay_still; 
effect_create_below(ef_ring, obj_basket_d.x,obj_basket_d.y,0,c_purple); 
      haycaught_d=  haycaught_d + 1; 
    }
  } 



