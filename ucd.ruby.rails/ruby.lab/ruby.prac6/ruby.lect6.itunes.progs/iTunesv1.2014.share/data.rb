class DataBit
	attr_accessor :songs, :albums, :actors, :hashes
	def initialize()
			@songs = [] # like globar variables
			@albums = []
			@actors = []
			@hashes = Hash.new
	end

		def songs=(x)
			@songs = x
		end
		
		def albums=(x)
			@albums = x
		end

		def actors=(x)
				@actors = x
		end
		
		def hashes=(x)
			@hashes = x
		end 

end
	