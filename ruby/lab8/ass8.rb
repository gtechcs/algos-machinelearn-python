#!C:\Ruby187\bin\ruby.exe

@data = { 
 :student => {
 :id => '123477', 
 :first_name => 'Lazlo', 
 :last_name =>'Fortunatus', 
 :email=>'Lazlo@fortunatus.org' }, 
 :contact_info => { 
 :telephone=>'1 415 222-2222', 
 :address => '123 Main St', 
 :city =>'Beverly Hills', 
 :state=>'California', 
 :zip_code=>90210, 
 :social_security_number =>'111-11-1111'
 }
} 

class Student
end

s = Student.new

s.instance_eval("def id 
	'123477'
end") 

s.instance_eval("def first_name 
	'Lazio'
end") 

s.instance_eval("def last_name 
	'Fortunatus'
end") 

s.instance_eval("def email 
	'Lazlo@fortunatus.org'
end") 

s.instance_eval("def telephone 
	'1 415 222-2222'
end") 

s.instance_eval("def address 
	'123 Main St'
end") 

s.instance_eval("def city 
	'Beverly Hills'
end") 

s.instance_eval("def state 
	'California'
end") 

s.instance_eval("def zip_code 
	'90210'
end") 

s.instance_eval("def social_security_number 
	'111-11-1111'
end") 

@data.each_pair do |k,v|
	v.each_pair do |kk,vv|
	p s.send(kk)
	end
end

puts ''
puts s.telephone
puts s.id


#puts s.state

#p s.state

#s.instance_eval(
#  def hello_world
#    return "hello world"
#  end
#)

#s.instance_eval(
#	def telephone
#		puts @data[:student]
#	end
#)end

# Create the singletons here using the information in @data.
# Each key in the hash (except for :student and :contact_info)
# will become a method. You should be able to do:
#
#s.instance_eval("def telephone
#end") 

#@data.instance_eval("def each_pair
#	yield
#end") 

#@data.each_pair do |k,v|
#	 v.each_pair do |kk,vv|
#	 p s.send(kk)
#	 end
#end


#puts @data[:student]

#puts @data[:student][:zip_code]

#puts @data[:student][:state]

#puts @data[:student].class

#puts @data.class

#student = @data[:student]
#puts student.to_s

#puts student[:state].to_s

#puts student[:state]
#s.instance_eval("def send (arg)
#	arg
#	puts 'kjsdlksdncsldcksdcsd'
#	puts arg
#end") 
#a_name = "telephone"
#s.instance_eval("def #{a_name}
#	puts 'abc'
#end") 



