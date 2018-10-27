require_relative "./family_member"
require_relative "./print_name_and_status"
require_relative "./print_info"

# my different objects
greg = FamilyMember.new(name: "Greg", sex: :male, status: :single, age: 27, children: ["SAM", "COLIN"], species: :human)
tim = FamilyMember.new(name: "String", sex: :male, status: :married, age: 30, children: ["FLEET", "FORCE"], species: :human)
umm = FamilyMember.new(name: "Craic", sex: :male, status: :married, age: 30, children: [], species: :human)
john = FamilyMember.new(name: "Tim", sex: :male, status: :single, age: 27, children: ["CALINE", "SWAT"], species: :human)

#array cycle
[greg, tim, john].each do |family_member| #  puts family_member
  puts family_member.inspect
end

print_info(greg)
puts umm.parent?
puts greg.parent?


# notes
# how you test in ruby`
# Block syntax with arguments
# .each { |argument| }
# .each do |argument|
# end



