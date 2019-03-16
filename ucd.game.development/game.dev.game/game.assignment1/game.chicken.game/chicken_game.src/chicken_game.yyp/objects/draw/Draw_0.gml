
 
draw_set_color(c_white)
switch (room) {
	
case room0:
if (counterEGG_m >= 100) {
	
with (all) {
		
motion_add(random(x), random(y))
speed = 0;
gravity = irandom_range(0,1)
	draw_set_color(c_red)
 draw_text(20,30, "MIKEY YOU WON TO : " + string(counterEGG_m));
if keyboard_check_pressed(vk_escape) room_goto(room1);

}
}

if (haycaught_m = counterEGG_m -5) {
	draw_set_color(c_white)
draw_text(20,700, "HEY MIKEY, YOU NEED MORE HEYYYY ");
}


if (counterEGG_d >= 100) {
with (all) {


motion_add(random(x), random(y))
speed = 0.5;
gravity = irandom_range(0,1)
	draw_set_color(c_red)
 draw_text(20,30, "DONALD YOU WON TO : " + string(counterEGG_d));
if keyboard_check_pressed(vk_escape) room_goto(room1);

}
}


if (spilledeggs = 10) {	 
	draw_set_color(c_red)
draw_text(20,30, "YOU ARE BOTH LOOSING EGGS : " + string(spilledeggs));
} 


if (spilledeggs >= 20) {	 
with (all) {

motion_add(random(x), random(y))

speed = 0;
gravity = irandom_range(0,1)
	draw_set_color(c_red)
 draw_text(20,30, "GAME OVER! TOO MANY EGGS DROPPED");
if keyboard_check_pressed(vk_escape) room_goto(room1);

} 

} 


if (haycaught_d <= counterEGG_d -5) {
	draw_set_color(c_white)
draw_text(800,700, "HEY DONALD, YOU NEED MORE HEYYYY");
} 

else {		
draw_set_color(c_white)
draw_text(20,10, "Mikey Score " + string(counterEGG_m));
draw_text(800,10, "Donalds Score " + string(counterEGG_d));
draw_text(400,10, "Spillage " + string(spilledeggs));
draw_text(20,740,  "Mikey Hay Caught " + string(haycaught_m));
draw_text(800,740,  "Donalds Hay Caught " + string(haycaught_d));
}   
break;


}
