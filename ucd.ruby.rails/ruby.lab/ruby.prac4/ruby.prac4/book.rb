require_relative './library'

class Book
  attr_reader :title # we dont want others to change the names 
  attr_accessor :borrowed_by 
  def initialize(opts={})
    @title = opts[:title] 
    @author = opts[:author]
  end
end



