for(var i=0; i<instance_number(obj_chicken); i++){
  var inst = instance_find(obj_chicken, i); 
    if inst.sprite_index == spr_chick_pound {
    inst.sprite_index = spr_chick_calm;
    }
}
