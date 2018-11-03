class Mammal  
  def breathe  
    puts "animal: takes breath"  
  end  
end  
  
class Cat < Mammal  
  def speak  
    puts "Meow"  
  end  
end  
    
class Dog < Mammal  
  def speak  
    puts "Woff"  
  end  
end  

class KO < Dog  
  def finish_him  
    puts "crunch, Woof, Meow"  
  end  
end  
  
  

tony = Cat.new  
franz = Dog.new  
franz_KO = KO.new
franz.speak
franz.breathe  
tony.speak  
franz_KO.breathe
franz_KO.finish_him
