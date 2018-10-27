require_relative './book'
require_relative './user'
require_relative './library'

thesecretwindow = Book.new
cosmeticstories = Book.new(name: 'cosmeticstories', author: 'warlord 3rd')
artstil = Book.new(name: 'artstil', author: 'frankenstein')
constenstein = Book.new(name: 'constenstein', author: 'camelot')
murdertales = Book.new(name: 'murdertales', author: 'weirdguy')

library = Library.new(books: [thesecretwindow, cosmeticstories, artstil, constenstein, murdertales])
theif = User.new(name: 'theif', libary: library)
police = User.new(name: 'police', libary: library)
rambo = User.new(name: 'rambo', libary: library)

theif.borrow('thesecretwindow')
police.borrow('cosmeticstories') 
rambo.borrow('artstil') 
rambo.borrow('constenstein') 
rambo.borrow('murdertales')
