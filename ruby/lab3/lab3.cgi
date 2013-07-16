#!/usr/local/bin/ruby

class Student
	attr_accessor :username, :password, :uid, :gid, :gcos_field, :home_dir, :login_shell, :first_name, :last_name
	@number
		
	def number
		if defined?(@@count)
			@@count += 1
		else
			@@count = 1
		end
		@@count
	end
	
	def set_first_name(first_name)
		@first_name = first_name
	end
	
	def first_name
		@first_name
	end
	
	def set_last_name(last_name)
		@last_name = last_name
	end
	
	def last_name
		@last_name
	end
	
	def self.total
		@@count
	end	
end

puts "Content-type: text/html"
puts    # This blank line is mandatory

puts <<HTML
<!DOCTYPE html>
<html>
  <head>
    <title>Lab 3</title>
<style>
th {
	border: solid 2px cadetblue;
	color: gold;
	font-size: 14px;
}

table {
	border-collapse: collapse;
}
.round-corners {
   text-align:center;
   padding:0 4px;
/*   -moz-border-radius:6px;-webkit-border-radius:6px;z-index:1000;
*/
}
th a {
   color:white;
}
th a:selected {
   color:black;
}
th {
   background-color: black;
}
th:hover {
   background-color: gold;
}
td {
	border-collapse: collapse;
	border: solid 1px silver;
	padding: 6px;
	font-size: 12px;
}

body {
	font-family: Trebuchet MS;
	font-size: 12px;
	color: black;
  background-color: white;
}
a {
   color:blue;
}
.highlight {
	color: white;
  background-color: steelblue;
}
.hightlight a {
   color:black;
}
</style>
  </head>
  <body>
     <blockquote>
	<table style="border: solid 1px gray;" 2" cellspacing="2">
	<tr>
   <th style="background-color:black">Number</th>
   <th style="background-color:black">User Name</th>
   <th style="background-color:black">Password</th>
   <th style="background-color:black">Uid</th>
   <th style="background-color:black">Gid</th>
   <th style="background-color:black">Gcos Field</th>
   <th style="background-color:black">Home Directory</th>
   <th style="background-color:black">Login Shell</th>
   <th style="background-color:black">First Name</th>
   <th style="background-color:black">Last Name</th>
   </tr>
   <tr>
HTML

require 'cgi'
output = ''

	puts '<h1>Lab 3</h1>'

all_students = Array.new

lines = File.readlines('/etc/passwd')
	lines.each do |line|

	if(line.scan(/\/home\/students\/spr11/).length != 0)
		passwd_array = line.split(/\:/)
		s = Student.new
		s.username = passwd_array[0]
		s.password = passwd_array[1]
		s.uid = passwd_array[2]
		s.gid = passwd_array[3]
		if(passwd_array[4] != "")
			s.gcos_field = passwd_array[4]
		else
			s.gcos_field = "--"
		end	
		s.home_dir = passwd_array[5]
		s.login_shell = passwd_array[6]

		split_name = passwd_array[4].split();
		split_name.each {|name| name.capitalize!}

		if(split_name.length == 0)
			s.set_first_name("--")
			s.set_last_name("--no Data--")
		elsif(split_name.length == 1)
			s.set_first_name(split_name[0])
			s.set_last_name("--no Data--")
		else
			last_name = split_name[split_name.count - 1]
			split_name.delete_at(split_name.count - 1) 
			first_name = split_name.join(' ')
			s.set_first_name(first_name)
			s.set_last_name(last_name)
		end
		
		def s.first_name
			'<b style="color: blue;font-size:120%;">' + @first_name + '</b>'
		end
		
		def s.last_name
			'<b style="color: blue;font-size:120%;">' + @last_name + '</b>'
		end
		
		all_students.push(s)

	end
end

	all_students.sort! {|x,y| x.username <=> y.username }   
	
	all_students.each do |student|
		puts '<td>'
		puts student.number 
		puts '</td><td>'
		puts student.username 
		puts '</td><td>'
		puts student.password
		puts '</td><td>'
		puts student.uid
		puts '</td><td>'
		puts student.gid
		puts '</td><td>'
		puts student.gcos_field
		puts '</td><td>'
		puts student.home_dir
		puts '</td><td>'
		puts student.login_shell
		puts '</td><td>'
		puts student.first_name
		puts '</td><td>'
		puts student.last_name
		puts '</td>'
		puts '</tr>'
	end

	puts '</table></body></html>'

