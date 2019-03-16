

var i = 0;
repeat(buttons) {
draw_set_font(font0)
draw_set_color(c_ltgray)
draw_text(20,20,"PRESS ESC TO EXIT")
if (men_index == i) {
	draw_set_color(c_red)
	
	  if (keyboard_check(vk_enter) and i ==0) {


with (all) {
room_restart()
game_restart()
global.counterEGG_d = 0 
global.counterEGG_m = 0
global.difmodechange = 0
global.haycaught_d = 0
global.haycaught_m = 0
global.spilledeggs = 0

}

		room_goto(room0);


			gamespeed = 1


		}
		
if (keyboard_check(vk_enter) and i == 1) {

	

room_restart();
with (all) {
room_restart()

global.counterEGG_d = 0 
global.counterEGG_m = 0
global.difmodechange = 0
global.haycaught_d = 0
global.haycaught_m = 0
global.spilledeggs = 0
}
	room_goto(room0);

	gamespeed = 2


}
  
if (keyboard_check(vk_enter) and i == 2) {
with (all) {
room_restart()
game_restart()
global.counterEGG_d = 0 
global.counterEGG_m = 0
global.difmodechange = 0
global.haycaught_d = 0
global.haycaught_m = 0
global.spilledeggs = 0
}

	room_goto(room0);


			gamespeed = 3

}
	
}
	draw_text(menu_x,menu_y + buttonh * i,button[i])
i++
}
