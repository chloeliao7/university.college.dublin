module Pred # like an interface 
 	def isa?(target_class)
		instance_of?(target_class)
	end
end

# like a header in c 
# if you include pred then you can have everything in this class
# called a mixed in 