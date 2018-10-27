require_relative './book'
require_relative './user'
require_relative './library'

# other Books
thesecretwindow = Book.new(title: 'thesecretwindow', author:'string')
cosmeticstories = Book.new(title: 'cosmeticstories', author: 'warlord 3rd')
artstil = Book.new(title: 'artstil', author: 'frankenstein')
constenstein = Book.new(title: 'constenstein', author: 'camelot')
murdertales = Book.new(title: 'murdertales', author: 'weirdguy')

# try to take out one of the books here and it will tell you that the book cant be accessable
library = Library.new(books: [thesecretwindow, cosmeticstories, artstil, constenstein, murdertales])

theif = User.new(name: 'theif', library: library)
police = User.new(name: 'police', library: library)
rambo = User.new(name: 'rambo', library: library)

theif.borrow('thesecretwindow')
police.borrow('cosmeticstories')
rambo.borrow('artstil')
rambo.borrow('constenstein')
rambo.borrow('murdertales')
