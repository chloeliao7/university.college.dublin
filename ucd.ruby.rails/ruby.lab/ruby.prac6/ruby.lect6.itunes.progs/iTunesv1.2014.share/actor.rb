#!/usr/bin/ruby -w
class Actor
	attr_accessor :name, :id
	def initialize(name)
		@name = name
		@id = name.object_id
	end

	def to_s
		puts "Actor #{@name} has ID: #{@id}.\n"
	end	

	def isa?
			instance_of?(Actor)
		end

		def self.build_all(actors = [])
			actor_names = $hash_owners.values.clean_up
			actor_names.each {|name| actors << Actor.new(name)}
			actors
		end

		def buys_song(song)
			song.owners <<  (" " + @name)
		end
		
		def what_songs_does_he_own()
				$songs.select{|song| song.owners.include?(@name)}
		end
end
