require_relative './library'

class Book
  attr_reader :title # we dont want others to change the names 
  attr_accessor :borrowed_by 
  # @@number_of_books = 0
  def initialize(opts={})
    @title = opts[:title] 
    @author = opts[:author]
    # Book.number_of_books += 1
  end
end

# @@ means it can live all 
# Book.number_of_books
# Book.title would not work 
# to get any @ you need to do Book.new (needs to create a book, need to instanciate)
# sybol only has one instance author



