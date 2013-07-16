#!C:\Ruby187\bin\ruby.exe

the_string = <<-HERE
                    This string has leading space and too    MANY tabs and sPaCes betweenX
   the indiVidual  Words in each Line.X
  each Line ends with a accidentally  aDDED  X.X
                in this lab you wilL WRITE code that "sAnITizES" this string by normalizingX
   ("normalizing" means   capitalizing sentences   and setting otherX
  characters to lower case)     and removes in       the extra spaces between WOrds.X
HERE

puts the_string

#####################################################
#puts "!Using Squeeze"

squeeze_string = the_string.squeeze(" ")
puts squeeze_string
#####################################################
#puts "!Using downcase"

downcase_string = squeeze_string.downcase
puts downcase_string
#####################################################
#puts "!Using upcase"

upcase_string = downcase_string.upcase
puts upcase_string
#####################################################
#puts "!! firstCapital"

#capital_string = the_string.capitalize
#puts capital_string
#the_string.split(” “).each{|word| word.capitalize!}.join(” “)  
#the_string = the_string.gsub("\n","\n")
#the_string = the_string.split(/\n+/).each{ |word| word.capitalize! }
#the_string = downcaseonly_string.gsub(/[a-z]/) { |a| a.capitalize! }

downcaseonly_string = the_string.downcase
firstcapital_string = downcaseonly_string.gsub(/^(\W*?[a-z])/) { |m| m.upcase }
puts firstcapital_string
#####################################################
#puts "!! last x removed"

lastxremoved_string = firstcapital_string.squeeze(" ").gsub(/([x])$/, "")
puts lastxremoved_string
#####################################################
#puts "!! each_byte"

puts "---------"
puts "C|Dec|Hex"
puts "---------"

#lastxremoved_string.downcase.each_byte {|c| printf "\n%s|%d|0x%s|" % [c.to_s, c, c.to_s.hex]}
#lastxremoved_string.downcase.each_char {|c| printf "\n%s|%d|0x%s|" % [c, ?c, c.to_s.hex]}

lastxremoved_string.downcase.each_byte {|c| printf "\n%s|%s|0x%s|" % [c.chr, c, c.to_s(16)]}

#####################################################
#puts "!!Using split"

splitArray = the_string.split
#the_string.split.class
puts  splitArray.inspect

#####################################################
#puts "!! Crypt"

crypt_string = the_string.crypt("12")
puts "\nString: %s" % the_string
puts "Encrypted: %s" % crypt_string
#####################################################
#puts "!! Using replace in-place"

printf "ObjectID Before %s\n", the_string.object_id 
first_hundred = the_string[1..100]

first_hundred.strip!
first_hundred.reverse!
first_hundred.squeeze!
first_hundred.upcase!

#puts first_hundred
the_string.sub!(the_string[1..100], first_hundred)
puts the_string

printf "ObjectID After %s\n", the_string.object_id 
#####################################################
#puts "!! Using inspect"

inspected_string = the_string.inspect
puts inspected_string
#####################################################
