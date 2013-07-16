##################HELLO WORLD hello_world.cgi#########################################
#!/usr/local/bin/ruby
# SCRIPT: hello_world.cgi
# CREATOR: pkumar16


require 'open_uri'

names = ''

f = open('http:/csmcis2.smccd.edu/~coolj/olivertwist.txt')
f.each_line
do |line| names += line.chomp
end

puts "Names size coming up"
puts names.size

