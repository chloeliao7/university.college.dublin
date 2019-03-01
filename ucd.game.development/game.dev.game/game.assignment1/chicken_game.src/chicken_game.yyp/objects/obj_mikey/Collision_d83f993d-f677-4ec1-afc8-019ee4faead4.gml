 


sprite_index = spr_mikey_take
alarm[0]=1*room_speed;  
obj_mikey.direction = 0
obj_mikey.speed = 3
with(obj_basket_m) {
       motion_set(image_angle, 3)
}

if (counterEGG_m > 2) {
	if (addithere_m_f == false){
		counterEGG_m = counterEGG_m - 2; 
	}else if (addithere_m_f == true){
		if (counterEGG_d != 0) {
	counterEGG_m = counterEGG_m/counterEGG_m;
}
			
	}
}
	 
for (var i=0; i<2; i++){
	var new_egg = instance_create_layer(obj_basket_m.x ,obj_basket_m.y,"instances", spr_egg_broke); 
	new_egg.sprite_index = spr_egg_broke;
	new_egg.image_xscale =irandom_range(0.0,0.2)
	new_egg.image_yscale = irandom_range(0.0,0.2)
	new_egg.speed = 9
	new_egg.direction = irandom_range(1,100)
	new_egg.gravity = 	0.7
	new_egg.image_xscale = image_xscale - 0.050;
	new_egg.image_yscale =  image_xscale - 0.050; 
effect_create_below(ef_ring, obj_basket_m.x,obj_basket_m.y,0,c_red);

}





