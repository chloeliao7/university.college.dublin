require_relative './book'

# testing serface 
book = Book.new(name: 'name', author: 'author')
puts "Book!"
# error would be here 
puts book.inspect 