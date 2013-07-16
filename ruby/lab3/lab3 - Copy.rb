#!C:\Ruby187\bin\ruby.exe

#include CGI

class Student
	def initialize(username, password, uid, gid, gcos_field, home_dir, login_shell)
		set_username(username)
		set_password(password)
		set_uid(uid)
		set_gid(gid)
		set_gcos_field(gcos_field)
		set_home_dir(home_dir)
		set_login_shell(login_shell)
		first_name, last_name = gcos_field.split(/\s+/);
		set_firstname(first_name)
		set_lastname(last_name)
	end
	
	def set_username(username)
		@username = username
	end
	
	def username
		@username
	end
	
	def set_password(password)
		@password = password
	end
	
	def password
		@password
	end
	
	def set_firstname(firstname)
		@firstname = firstname
	end
	
	def firstname
		@firstname
	end
	
	def set_lastname(lastname)
		@lastname = lastname
	end
	
	def lastname
		@lastname
	end

	def set_uid(uid)
		@uid = uid
	end
	
	def uid
		@uid
	end
	def set_gid(gid)
		@gid = gid
	end
	
	def gid
		@gid
	end
	
	def set_gcos_field(gcos_field)
		@gcos_field = gcos_field
	end
	
	def gcos_field
		@gcos_field
	end
	
	def set_home_dir(home_dir)
		@home_dir = home_dir
	end
	
	def home_dir
		@home_dir
	end

	def set_login_shell(login_shell)
		@login_shell = login_shell
	end
	
	def login_shell
		@login_shell
	end
	
end

#	cgi = CGI.new
#	cgi.

#puts "Content-type: text/html"
#puts
#puts "<html><head><title>Lab 3</title></head>"
#puts "<h1>Lab 3</h1>"
#puts "<h4>Puneet Kumar, pkumar16</h4>"
#puts "<table style="border: solid 1px gray;" 2" cellspacing="2">"

#passwd_file = File.new("passwd.txt") 	
#passwd_file.each_line do |line| 
lines = File.readlines('passwd.txt')
	lines.each do |line|
	puts "#{line}" 
	passwd_array = line.split(/\:/)
	puts passwd_array
	s = Student.new(passwd_array[0], passwd_array[1], passwd_array[2], passwd_array[3], passwd_array[4], passwd_array[5], passwd_array[6])
	puts "Student's first instance variable"
	puts s.username
	puts s.password
	puts s.gid
	puts s.uid
	puts s.gcos_field
	puts s.home_dir
	puts s.login_shell
	puts s.firstname
	puts s.lastname
end



