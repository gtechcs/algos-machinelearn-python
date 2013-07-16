#!/usr/local/bin/ruby

require 'cgi'
require 'cgi_helper' 
include CGI_Helper


#Student class
class Student
	attr_accessor :username, :password, :uid, :gid, :gcos_field, :home_dir, :login_shell, :first_name, :last_name
	@number
	@@count = 0
		
	def initialize
		@@count += 1
		@number = @@count
	end


	def number
		@number
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

#Used for template
@fields = [ :number, :username, :password, :uid, :gid, :gcos_field, :home_dir, :login_shell, 
:first_name,:last_name] 

#Print Http header
http_header() # print the Content-type line and blank line
puts '<h1>Lab 4</h1>'

# Create/read template
  template = ''
  templateLines = File.readlines('lab4_template.html', "r") 
  templateLines.each do |line|
    template += line
  end

#Get value of sort_by  
@sort_by = CGI.new.params['sort_by'].to_s


#puts @sort_by  # works
 
#read and populat Students object  
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

	if(@sort_by != '')
		all_students = all_students.sort_by {|stu| stu.send(@sort_by.to_sym) }   
	end
	
	
	render_erb(template)
	

