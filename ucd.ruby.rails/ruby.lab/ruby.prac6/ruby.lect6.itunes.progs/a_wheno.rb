
def sheep_spotter(test)
	case
	    when test == "sheep"
		   puts "Yup, its a sheep alright."
	    when test == "wolf"
	   	   puts "No, this is a wolf."
	    when test.instance_of?(String)
	   	   puts "I really don't know what this is?"
	    else "Are you trying to poison me, that's not a string !"
	 end
end

p sheep_spotter(nil)
p sheep_spotter("sheep")
p sheep_spotter("wolf")
puts sheep_spotter("elf with a ham")
