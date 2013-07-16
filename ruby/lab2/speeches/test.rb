

hash = Hash.new

hash['one'] = 1;
hash['two'] = 2; 
hash['three'] = 3; 
hash['four'] = 4; 
hash['five'] = 5; 

if hash['five'] > 0
   puts 'is gretaer than zero'
else
	puts 'IS NOT'
end 

if hash['six'].class == NilClass
   puts 'is gretaer than zero'
else
	puts 'IS NOT'
end 

puts hash['one']
puts hash['two']

puts 'Getting key for 1'
#puts hash.key(1)





puts hash
hash.invert
puts hash
array_values = hash.values

puts 'Unsorted'
puts array_values
sorted = array_values.sort
puts 'Sorted'
puts sorted

reverse = sorted.reverse

puts reverse[0]
puts reverse[1]
puts reverse[2]
puts reverse[3]
