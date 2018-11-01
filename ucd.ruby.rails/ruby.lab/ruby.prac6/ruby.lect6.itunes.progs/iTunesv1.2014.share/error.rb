
class MyErr
	attr_accessor :type, :holder, :method
	def initialize(type, holder, method)
		@type = type
		@holder = holder
		@method = method
	end
	
	def do_it
	  if @type == "multiple_answer_error"
			then puts "Error: Item #{@holder} raised #{@type} in #{@method}"
		elsif @type == "not_found_error"
			then puts "Error: #{@holder} was #{@type} in #{@method}"
		else 
			puts "Error: Have been given an unknown error type: #{@type}"
		end
	end
end