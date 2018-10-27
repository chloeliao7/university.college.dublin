require_relative './Book'
require_relative './BookBorrowers'
require_relative './library'



# poodr = Book.new(name: 'POODR', author: 'Sandy Metz')
# library = Library.new(books: [poodr])
# user = User.new(name: "Greg", libary: library)
# user.borrow('poodr')

# "All Books in Library books: "
thesecretwindow = Book.new(title: 'thesecretwindow', author: 'shakespear', uid: 122, page: 500, markbook: 'markbook: and there was light')
cosmeticstories = Book.new(title: 'cosmeticstories', author: 'warlord 3rd', uid: 345, page: 233, markbook: 'markbook: put MAKEUP!')
artstil = Book.new(title: 'artstil', author: 'frankenstein', uid: 345, page: 233, markbook: 'markbook: put MAKEUP!')
constenstein = Book.new(title: 'constenstein', author: 'camelot', uid: 66, page: 111, markbook: 'markbook: hide in your whole!')
murdertales = Book.new(title: 'murdertales', author: 'weirdguy', uid: 2, page: 2315, markbook: 'markbook: plot twist')

allbooks = [thesecretwindow, cosmeticstories, artstil, constenstein, murdertales]; 
# "All book barrower objects"

theif = BookBorrowers.new(name: 'theif', address: 'kyle', bid: 43, allbooks)
police = BookBorrowers.new(name: 'police', address: 'steve', bid: 911)
rambo = BookBorrowers.new(name: 'rambo', address: 'out', bid: 33)
# allb = BookBorrowers.new(theif, police, rambo)
#  multi
# allstats = [theif, police, rambo]

# police.currentlibrarybooks(cosmeticstories); 

# allb.currentborrowers

# p "All Books in Library books: "

# p 'Updated Book: murdertales'
# murdertales.booksystem_arr = [title: 'savetales', author: 'coolguy', uid: 233.to_s, page: 3902.to_s, markbook: 'P: plot twist']
# [murdertales].each do |murd|
#   puts murd.printbookdetails
# end

# p "print all borrowers: "
# [theif, police, rambo].each do |borrowers_|
#     puts borrowers_.\
#   end
# puts "\n"
# takeout(police, )













################################################################################
################################################################################
################################################################################
################################################################################


# When thinking about how to model a situation using OOP you want to think
# first about the `messages` that are going to be passed between your classes;
# meaning that the `messages` are the most important part of your application.
#
# In this case you have a library, users and books. The key `messages` or 
# actions that need to be taken are:
#   - user borrows book *required in assignment
#   - user returns book *not required but makes sense in this context
#
# When you look at it this way it makes sense to have a User class that has a 
# `borrow` message.
#
# Also when you think about it conceptually, the Library is the one that owns 
# the book, therefore it should manage the state of the book. The user "goes" 
# to the library and borrows a book, so the user depends on the library to 
# alter the state of the book.
#
# The book itself should have two states that are important here, one is
#`borrowed`, and the other is `available`.

# So considering the above, you want your application to read like this:




# In the above, the user `borrows` the book using the name, just like in real 
# life. One way to model this in the user is like this:

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
    # ...
  end

  def borrowed_books
    @library.books_borrowed_by(@name) # The library knows what borrowed
  end
end

# What's happening here is that the user has a reference to the library with 
# @library (imagine a library card) and the library is responsible for knowing 
# the state of the book (available/borrowed), lending it to the user and 
# knowing which books are lent out to who.

# For convenience the book class can hold the state of who borrowed using `borrowed_by`
class Book
  attr_accessor :borrowed_by # state that shows if the book is borrowed and by whom

  def initalize(name:, author:)
    @name = name
    @author = author
  end
end

class Library
  @books # list of all books

  def initialize(books:)
    # ...
  end

  def lend(book_name, user)
    @book.borrowed_by = user # Let the book know who borrowed it
    # You could also store this information in the library itself but that 
    # would be a little more complicated and not necessary for a small app like 
    # this
  end

  def book_is_available?(book_name)
    @books.borrowed_by.nil? # not borrowed by someone
  end

  def books_borrowed_by(user)
    # go through the books and check which ones are borrowed_by this user
  end
end

# Remember that the key here is in how you think about the problem. Think about 
# the messages you need to send, in this case `borrow`, `lend`, `available?` 
# and the state you need to store like `Library.books`, `Book.borrowed_by`, 
# `User.library`.

# Hope that helps :)