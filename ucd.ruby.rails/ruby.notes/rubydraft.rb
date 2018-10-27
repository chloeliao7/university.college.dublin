class Person
  attr_reader :fname

  def give_fname(name)
    @fname = name
  end

  attr_reader :lname

  def give_lname(name)
    @lname = name
  end
end

inst1 = Person.new
inst1.give_fname('Mark')
inst1.give_lname('KarenName')

p inst1
	