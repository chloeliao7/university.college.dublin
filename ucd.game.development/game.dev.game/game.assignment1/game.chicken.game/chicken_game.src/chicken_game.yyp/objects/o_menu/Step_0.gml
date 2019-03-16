
menkey = keyboard_check_pressed(vk_down) - keyboard_check_pressed(vk_up);
men_index += menkey;
if (men_index < 0) men_index = buttons - 1;
if (men_index > buttons-1) men_index = 0;
if (men_index != last_sel) audio_play_sound(sound0, 1, false);
last_sel = men_index;
if keyboard_check_pressed(vk_escape) { game_end(); } 
