#!/usr/bin/ruby -w
class Album
  attr_accessor :name, :tracks, :length, :artist, :owners, :id
  def initialize(name, tracks, length, artist, owners)
    @name = name
    @tracks = tracks
    @length = length
    @artist = artist
    @owners = owners
    @id = name.object_id
  end

  def to_s
    puts "The album #{@name} by #{@artist}. \n"
  end

  def isa?
    instance_of?(Album)
  end

  def self.make_album(name, tracks, length, artist, owners)
    Album.new(name, tracks, length, artist, owners)
  end

  def self.build_all(albums = [])
    $songs.map { |song| build_an_album_called(song.album) } 
  end
  
  def self.build_an_album_called(album_name)
    tracks = $songs.select { |s| s.album == album_name }
    Album.new(album_name, tracks, tracks.map(&:time), tracks.map(&:artist).uniq, tracks.map(&:owners).uniq)
  end
end
