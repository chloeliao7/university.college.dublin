for(var i=0; i<instance_number(obj_donald); i++){
  var inst = instance_find(obj_donald, i); 
    if inst.sprite_index == spr_donald_take {
    inst.sprite_index = spr_donald_still;
    }
}
