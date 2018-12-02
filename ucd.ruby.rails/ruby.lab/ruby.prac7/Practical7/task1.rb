#     1) Get  5  regular  emailspams  and  5  advance-fee  fraud  emailspams  (aka  spam).    Save  them  as
#     text  and  change  them  so  they  are  a    single,  long  string.      Then  turn  each  into  an
#     array  of  words  (split may  help  here).    Then  use  a  bunch  of  regular  expressions  to
#     search  the  array  of  words  looking  for  keywords  to  classify  which  files  are spam
#     or  not.    If  you  want  to  get  fancy  you  could  give  each  array  a  spam-score  out  of  10.
#     rescue => exception
# Take in five spam emailspams
# try read from emailspam file


'./regemail.txt'
'./spamemail.txt'

def checkForMoney(emailspam)
  if emailspam.match(/money/) 
    puts emailspam.match(/^(.*?)money^(.*?)/)
  end
end

def checkForWords(emailspam)
  p 'Enter word to search for: '
  word = gets
  return emailspam.match(/#{word}/) 
  end
def checkFile(fileName)
  p fileName 
  line_counter = 0
  File.open("./#{fileName}", 'r') do |inFile|
  while (emailspam = inFile.gets) do
     line_counter += 1
     if !emailspam.match(/^#/) 
      if checkForMoney(emailspam)
        p "Money was mentioned in this emailspam, could be spam #{emailspam} at new line #{line_counter}"
      end
      checkForWords(emailspam)
    end
      p "num lines are #{line_counter}"
    end
end
end 

num = 0
fileName = ''
p 'Enter number of files to check: '
num = gets.to_i
for i in 1..num # 1 all the way to the file name
  p 'Enter file name '
  fileName = gets.to_s.chomp
checkFile(fileName)  
end