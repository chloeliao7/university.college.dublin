require_relative './book'
require_relative './library'

# theif = User.new(name: 'theif', libary: library)
# attr_accessor :library

class User
  def initialize(name, library)
    @name = name
    @library = library
  end

  def borrow(book_name)
    if @library.book_is_available?(book_name)
      @library.lend(book_name, @name) # we pass the User's name to the library 
    else
      puts "Sorry but #{book_name} is not available"
    end
  end

  def return(book_name)
  end

  def borrowed_books
    @library.books_borrowed_by(@name) # The library knows what borrowed
  end
end

# =========================================================================================

# class BookBorrowers
#   attr_accessor :name, :address, :bid
#   def initialize(name:, address:, bid:)
#     @name = name
#     @address = address
#     @bid = bid
#    end
   
#   def printborrowersdetails
#     puts '-----------------------'
#     p 'borrowers details: '
#     p "#{@name}, #{@address}, #{@bid}"
#     puts ''
#     p theif.printborrowersdetails
#     p police.printborrowersdetails
# 		p rambo.printborrowersdetails
# 		puts "\n"
#   end
  
#   def currentborrowers(fam)
#     puts '-----------------------'
#     puts ''
#     p 'Current Library Borrowers: '
#     fam.each do |borr|
#       puts "the User : #{borr.name}"
#     end
#     puts puts "\n"
#     puts '-----------------------'
#     puts ''
#   end

# end
