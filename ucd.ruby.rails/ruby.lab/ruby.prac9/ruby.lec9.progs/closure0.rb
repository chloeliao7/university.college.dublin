# From
#http://samdanielson.com/2007/9/6/an-introduction-to-closures-in-ruby

=begin
closures = []
(0..7).each { |n|  closures << lambda { n } }

#n => NameError: undefined local variable or method ...
p closures 
p closures.map { |c| c.call }
n = 3
p closures.map { |c| c.call }
=end


no = 0
closures = []
(0..12).each { |n|  closures << lambda { n + no } }
p closures # gives us the objects
#<Proc:0x00007f86d99800a0@closure0.rb:18 (lambda)>, 
#<Proc:0x00007f86d9980050@closure0.rb:18 (lambda)>, 
#<Proc:0x00007f86d997ffb0@closure0.rb:18 (lambda)>, 
#<Proc:0x00007f86d997ff60@closure0.rb:18 (lambda)>, 
#<Proc:0x00007f86d997fee8@closure0.rb:18 (lambda)>, 
#<Proc:0x00007f86d997fe98@closure0.rb:18 (lambda)>, 
#<Proc:0x00007f86d997fe20@closure0.rb:18(lambda)>, 
#<Proc:0x00007f86d997fda8@closure0.rb:18 (lambda)>, 
#<Proc:0x00007f86d997fd58@closure0.rb:18 (lambda)>, 
#<Proc:0x00007f86d997fd08@closure0.rb:18 (lambda)>, 
#<Proc:0x00007f86d997fc68@closure0.rb:18 (lambda)>, 
#<Proc:0x00007f86d997fbc8@closure0.rb:18 (lambda)>, 
#<Proc:0x00007f86d997fb50@closure0.rb:18 (lambda)>] 


p closures.map { |c| c.call } 
# [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]

no = 3
p closures.map { |c| c.call }