# FamilyMember encapsulates the attributes and behaviors of a Family member.
class FamilyMember
  # can do attr_read and write
  attr_accessor :name, :sex, :status, :age, :children, :species
  # like default constructor in java 
  def initialize(name:, sex:, status:, age:, children:, species:)
    @name = name
    @sex = sex
    @status = status
    @age = age
    @children = children
    @species = species || "human"
  end

  #methods to check 
  def parent?
    if @children.empty? == false # return false 
      return true
    end
    @species.to_s == 'human'
  end

  def child?
    @children.empty?
    @species.to_s == 'child'
  end

  def dad?
    # parent && male
    @age.to_i == 13
  end

  # functions as accessor 
  def mom?
    @children != "SAM"
    if my_string.to_s.empty?
      # It's nil or empty
    end
    
  end
  def son?
  end

  def daughter?
  end

  def dog?
  end
  
  def human?
  end
end

# notes
# # Initializing
# arthur = FamilyMember.new(name: 'arthur', sex: 'male', status: 'male', age: 27, children: [], species: 'human')
# puts arthur.inspect
# pp arthur
# puts arthur.age # 27
# ## Since Ruby is not statically typed in the future you'll want to test your 
# ## classes, making sure to test methods and attribtues
# # expect(arthur.age).to eq 27
# # expect(arthur.human?).to eq true
# # Inheritance
# class Parent < FamilyMember
#   attr_accessor :children
# end
# class Mother < Parent
# end
# class Father < Parent
# end
# mom = Mother.new
# mom.dog?
# mom.human?