for(var i=0; i<instance_number(obj_mikey); i++){
  var inst = instance_find(obj_mikey, i); 
    if inst.sprite_index == spr_mikey_take {
    inst.sprite_index = spr_mikey_still;
    }
}
