#!/usr/bin/ruby -w

require 'csv'
require_relative 'data'
require_relative 'actor'
require_relative 'album'
require_relative 'song'
require_relative 'reader'
require_relative 'utilities'
require_relative 'error'

reader = Reader.new           
data = DataBit.new() # sends all the songs to the array inn the dara rb
songs_file = 'songs.csv'
owners_file = 'owners.csv'

puts "\nProcessing Songs from file: #{songs_file}"
data.songs = reader.read_in_songs(songs_file)

puts "Processing Ownership from file: #{owners_file}"
data.hashes = reader.read_in_ownership(owners_file)
puts "Building all owners..."
data.actors = Actor.build_all(data)
puts "Updating songs with ownership details..."
data.songs.each{|song| song.owners = data.hashes[song.id]} 
puts "Building All Albums..."
data.albums = Album.build_all(data)
puts data.albums 

puts "\n Mark buys The Cure..."
song1 = Util.fetch(data, "The Cure")
mark = Util.fetch(data, "markk")
mark.to_s
song1.to_s
mark.buys_song(song1)
song1.to_s

puts "\nHow many songs does Markk own..."
p mark.what_songs_does_he_own(data).size
puts "\nPlay The Cure..."
song1.play_song
puts "\nPrinting full details of all songs..."
data.songs.each{|song| p song}
