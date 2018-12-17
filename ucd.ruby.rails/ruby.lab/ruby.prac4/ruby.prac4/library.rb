require_relative './book'
require_relative './user'

class Library
  attr_accessor :books

  def initialize(opts={})
    @books = opts[:books] # array of books from top.rb
  end

  def lend(title_param, user)
    puts "book has been borrowed by #{user} BOOK: #{title_param}" 

    book = @books.find {|x| x.title == title_param }

    unless book.nil?

      book.borrowed_by = user

    else
      puts "Book couldn't be found"
    end

  end

  def book_is_available?(title_param)
    # check if there's a book with the title_param
    # if there isn't, .find will return nil # rails you can call .present? on nill objects directly
    not @books.find {|x| x.title == title_param }.nil? 
    puts "is the book #{title_param} in the library?"
  end

  def books_borrowed_by(user) 
  end
end
