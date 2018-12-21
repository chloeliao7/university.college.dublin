require_relative './book'
require_relative './library'

class User
  def initialize(opts={})
    @name = opts[:name] 
    @library = opts[:library]
    # puts opts = checking 
  end

  def borrow(title_param, library) # title of the book you want to pass 'thesecretwindow'
    if library.book_is_available?(title_param)

      library.lend(title_param, @name) # we pass the users's name to the library 
      puts "book #{title_param} has been borrowed"

    else
      puts "Sorry but #{title_param} is not available and was taken by #{library.borrowed_by(title_param)}"
      puts " "
    end
  end

  def return(title_param)
  end

  # def borrowed_books
  #   @library.books_borrowed_by(@name) # The library knows what borrowed
  # end
end
