#!/usr/local/bin/ruby
# SCRIPT: oliver_twist.cgi
# CREATOR: pkumar16

puts "Content-type: text/html"
puts # This blank line is mandatory

puts "<html><head><title>A First Ruby Script</title><style type=\"text/css\">body {background-color:#333;color:#fff;font-family:Georgia, serif;font-size:13px;} h1 {color:#c00} </style></head><body><blockquote>"
aFile = File.new("oliver_twist.txt")

aFile.each_line {|line| puts "#{line}" }
puts "</blockquote></body></html>"
