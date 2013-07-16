#!/usr/local/bin/ruby

require 'cgi'
require 'cgi_helper' 
include CGI_Helper

cgi = CGI.new
puts cgi.header

puts '<h1>Lab 4</h1>'

puts '<A HREF="view_all.png"><IMG SRC="view_all.png" ALT="ViewAll" WIDTH="100" HEIGHT="50">ViewAll</A>'
puts '<br>'
puts '<A HREF="list.png"><IMG SRC="list.png" ALT="List" WIDTH="100" HEIGHT="50">List</A>'
puts '<br>'
puts '<A HREF="entry1.png"><IMG SRC="entry1.png" ALT="Entry1" WIDTH="100" HEIGHT="50">Entry</A>'
puts '<br>'
puts '<A HREF="edit.png"><IMG SRC="edit.png" ALT="Edit" WIDTH="100" HEIGHT="50">Edit</A>'
puts '<br>'
puts '<A HREF="destroy.png"><IMG SRC="destroy.png" ALT="Delete" WIDTH="100" HEIGHT="50">Delete</A>'
puts '<br>'


#puts cgi.img("view_all.png", "ViewAll", 100, 50)

#cgi.out{
#   cgi.html{
#      cgi.head{ "\n"+cgi.title{"Show ROR images"} } +
#      cgi.body{ "\n"+
#		cgi.img("view_all.png", "ViewAll", 100, 50) + "\n"
#		cgi.img("list.png", "List", 100, 50) + "\n"
#		cgi.img("entry1.png", "Entry", 100, 50) + "\n"
#		cgi.img("edit.png", "Edit", 100, 50) + "\n"
#		cgi.img("delete.png", "Delete", 100, 50) 
#      }
#   }
#}
