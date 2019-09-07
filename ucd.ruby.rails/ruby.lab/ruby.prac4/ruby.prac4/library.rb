require_relative './book'
require_relative './user'

class Library
  attr_accessor :books
  def initialize(opts={})
    @books = opts[:books] # array of books from top.rb
  end
  def lend(title_param, user) 
    # puts "book has been borrowed by #{user} BOOK: #{title_param}" 
    book = @books.find {|x| x.title == title_param }
    unless book.nil?
      book.borrowed_by = user # setting who borrowed the book
    else
      puts "Book couldn't be found"
    end
  end
  
  def borrowed_by(title_param)
    book = @books.find { |x| x.title == title_param }
    book.borrowed_by
  end
  
  def book_is_available?(title_param) # 'thesecretwindow'
    # check if there's a book with the title_param
    # if there isn't, .find will return nil # rails you can call .present? on nill objects directly
    book = @books.find {|x| x.title == title_param } # if empty
    book.borrowed_by.nil? 
    # the book is available if not borrowed
    
    # book . find array
    # puts "is the book #{title_param} in the library?"
  end
  def books_borrowed_by(user) 
  end
  
end
