
class Song
  attr_accessor :name, :album, :artist, :time, :owners, :id
  def initialize(name, album, artist, time, owners, id)
    @name = name
    @album = album
    @time = time
    @artist = artist
    @owners = owners
    @id = id
  end

  def to_s
    puts "<< #{@name} >> by #{@artist} in their album #{@album} is owed by #{@owners} .\n"
  end

  def isa?
    instance_of?(Song)
  end

  def play_song
    no = rand(10)``
    no.times { print "#{@name} do be do..." }
    puts "\n"
  end
end
