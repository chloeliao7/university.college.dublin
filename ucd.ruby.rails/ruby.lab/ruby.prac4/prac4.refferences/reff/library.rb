require_relative './book'
require_relative './user'
# require_relative './library'

class Library
  @books # list of all books 

  def initialize(books:)
  end

  def lend(book_name, user)
    @book.borrowed_by = user # Let the book know who borrowed it
  end

  def book_is_available?(book_name)
    @books.borrowed_by.nil? # book not borrowed by someone
  end

  def books_borrowed_by(user) # go through the books and check which ones are borrowed_by this 
  end
end

#========================================================================================

# class Library
#   # Should define a library class that has attributes that record
#   # the books in the library, those books that have been borrowed,
#   #  and those books available for borrowing.
#   attr_accessor :allbooks, :borrowedbooks, :availablebooks

#   def initialize(allbooks:, borrowedbooks:, availablebooks:)
#     @allbooks = allbooks
#     @borrowedbooks = borrowedbooks
#     @availablebooks = availablebooks
#   end

#   # call for current library books
#   def currentlibrarybooks(bookspass)
#     puts '---------------------------------------------------'
#     puts "\n"
#     p 'Current Library Books: '
#     bookspass.each do |book|
#     # [thesecretwindow, cosmeticstories, artstil, constenstein, murdertales].each do |book|
#       puts "the book : #{book.title}"
#       puts "the author : #{book.author}"
#       puts "the uid : #{book.uid}"
#       puts "the page : #{book.page}"
#       puts "the markbook : #{book.markbook}"
#       puts ''
#       puts '###############################'
#       puts ''
#     end
#     puts '---------------------------------------------------'
#     puts "\n"
#   end

#   def printbookdetails
#     puts "#{@allbooks}, #{@borrowedbooks}, #{@availablebooks}"
#   end
# end
