# f = File.new('./out.txt', 'a') # a means for append # w writes over it
# f.write
# f.close
def check_how_many(an_array, letter)
  numArray = []
  counterNumTimes = 0
  counterNumTimesAtStart = 0 # the letter to check will be passed here

  # select iterates though all of them
  # item will be the item at that one time
  # checking for letter in general in the word

  an_array.select do |item|
    if item =~ /#{letter}/ # to start the regex
      puts item.to_s
      counterNumTimes += 1
      File.open('./out.txt', 'a') do |line|
        line.print "#{item} "
      end
    end # Checking if the letter is at the start if the word
    next unless item =~ /^#{letter}/ # ^ if its at the start
    puts item.to_s
    counterNumTimesAtStart += 1
  end # end of do
  numArray[0] = counterNumTimes
  numArray[1] = counterNumTimesAtStart
  numArray
end

arr = [] # each string
whole_string = ''
puts 'What letter to check for: ...'
letter = gets.chomp
# Reading from a text file

File.open('info.txt', 'r') do |inFile| # line means that every time you get a new line
  while (line = inFile.gets) # puts "#{line}"
    whole_string += line
  end
  arr = whole_string.split(' ')
  numberOfOverall = []
  numberOfOverall = check_how_many(arr, letter)
  puts arr.inspect # print a
  # print off method
  p "The number of the words that contain the letter somewhere are #{numberOfOverall[0]}" # numStartWith = check_how_many_start_with(a, letter)
  p "The number of words where the letter is at the start is #{numberOfOverall[1]}" # p does not need to put a new line
  
  # ISssue
  # File.open('./out.txt', 'w') { |f|
  #   f.puts "the text is "
  #   # f.close
  #   }
  # File.close
  # File.open('./out.txt', 'w') do |f|
  #   f.write 'the text is'
  # end

  File.open('./out.txt', 'a') do |line|
    arr.select do |element|
      line.print "#{element} "
    end
  end
end
