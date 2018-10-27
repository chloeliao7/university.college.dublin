# require_relative './Book'
require_relative './user'
require_relative './library'

# attr_accessor :name, :sex, :status, :age, :children, :species

class Book
  attr_accessor :borrowed_by # state that shows if the book is borrowed and by whom

  def initialize(name:, author:)
    @name = name
    @author = author
  end
  
end

# =========================================================================================

# class Book
  
#   attr_accessor :title, :author, :uid, :page, :markbook
#   def initialize(title:, author:, uid:, page:, markbook:)
#     @title = title
#     @author = author 
#     @uid = uid
#     @page = page
#     @markbook = markbook
#   end

#   def printbookdetails
# 		puts "#{@title}" + "#{@author}" + "#{@uid}" + "#{@page}" + "#{@markbook}"
#   end

#   # update book array system
#   def booksystem_arr
# 		"Book: " + @title + @author + @uid + @page + @markbook
#   end
  
#   # update the book (goes with the update book def below)
# 	def booksystem_arr=(book_array)
# 		@title = book_array[0]
# 		@author = book_array[1]
# 		@uid = book_array[2]
# 		@page = book_array[3]
# 		@markbook = book_array[4]
#   end

#   def updatebook
#     p 'Updated Book: murdertales'
#     murdertales.booksystem_arr = [title: 'savetales', author: 'coolguy', uid: 233.to_s, page: 3902.to_s, markbook: 'P: plot twist']
#     [murdertales].each do |murd|
#         puts murd.printbookdetails
#     end
#   end
# end
