#!/usr/local/bin/ruby
# SCRIPT: form.cgi
# CREATOR: pkumar16

require "cgi"
cgi = CGI.new("html3")  

username = cgi['user_name']
emailaddress = cgi['email']

puts "Content-type: text/html"
puts # This blank line is mandatory
 
puts "<html><head><title>A First Ruby Script</title></head><body><blockquote>"

puts "<form action=\"form.cgi\" method=\"post\" accept-charset=\"utf-8\">"
puts "<p>"
puts "<label for=\"User Name\" style=\"width:100px;float:left\">User Name</label>"
puts "<input type=\"text\" name=\"user_name\" value=\"\" id=\"user_name\">"
puts "</p>"
puts "<p>"
puts "<label for=\"email\" style=\"width:100px;float:left\">Email</label>"
puts "<input type=\"text\" name=\"email\" value=\"\" id=\"email\">"
puts "<p>"
puts "<p><input type=\"submit\" value=\"Continue &rarr;\"></p>"
puts "</form>"

if username.length != 0
	puts "Welcome #{username}. It's good to see you again."
	puts "<br>"
	puts "May I send many emails to you at your email address: #{emailaddress}?"
end

username = ""
emailaddress = ""

puts "</blockquote></body></html>"
