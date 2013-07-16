##################HELLO WORLD hello_world.cgi#########################################
#!/usr/local/bin/ruby
# SCRIPT: hello_world.cgi
# CREATOR: pkumar16

puts "Content-type: text/html"
puts # This blank line is mandatory
puts <<HTML
<!DOCTYPE html>
<html>
 <head>
 <title>A First Ruby CGI Script</title>
 <style type="text/css">
 body {background-color:#333;color:#fff;font-family:Helvetica,Arial,Verdana,sans-serif;font-size:18px;}
 h1 {color:#c00}
 </style>
 </head>
 <body>
 <h1>Hello, world!</h1>
 <p>
 This is an example of a Ruby CGI script. It has the following features.
 </p>
 <ol>
 <li>A shebang line</li>
 <li>A MIME type (<code>text/html</code>)</li>
 <li>A blank line after the Content-type line.</li>
 <li>Some HTML to format the text</li>
 </ol>
 </body>
</html>
HTML


###########################################################
###########################################################
#################OLIVER TWIST #############################
#!/usr/local/bin/ruby
# SCRIPT: oliver_twist.cgi
# CREATOR: pkumar16

puts "Content-type: text/html"
puts # This blank line is mandatory

puts "<html><head><title>A First Ruby Script</title><style type=\"text/css\">body {background-color:#333;color:#fff;font-family:Georgia, serif;font-size:13px;} h1 {color:#c00} </style></head><body><blockquote>"
aFile = File.new("oliver_twist.txt")

aFile.each_line {|line| puts "#{line}" }
puts "</blockquote></body></html>"

###########################################################
###########################################################
#################OLIVER TWIST##############################
#################oliver_twist.txt #########################
Although I am not disposed to maintain that the being born in a workhouse, is in itself the most fortunate and enviable
circumstance that can possibly befall a human being, I do mean to say that in this particular instance, it was the best
thing for Oliver Twist that could by possibility have occurred. The fact is, that there was considerable difficulty in
inducing Oliver to take upon himself the office of respiration,— a troublesome practice, but one which custom has rendered
necessary to our easy existence; and for some time he lay gasping on a little flock mattress, rather unequally poised
between this world and the next: the balance being decidedly in favour of the latter. Now, if, during this brief period,
Oliver had been surrounded by careful grandmothers, anxious aunts, experienced nurses, and doctors of profound wisdom, he
would most inevitably and indubitably have been killed in no time. There being nobody by, however, but a pauper old woman,
who was rendered rather misty by an unwonted allowance of beer; and a parish surgeon who did such matters by contract;
Oliver and Nature fought out the point between them. The result was, that, after a few struggles, Oliver breathed, sneezed,
and proceeded to advertise to the inmates of the workhouse the fact of a new burden having been imposed upon the parish, by
setting up as loud a cry as could reasonably have been expected from a male infant who had not been possessed of that very
useful appendage, a voice, for a much longer space of time than three minutes and a quarter.

(from Oliver Twist by Charles Dickens)

###########################################################
###########################################################
#################QUERY_STRING #############################
#!/usr/local/bin/ruby
# SCRIPT: query_string.cgi
# CREATOR: pkumar16

# The CGI class provide methods to handle CGI request, including
# the CGI::params, which contains all of the request data.
require 'cgi'
cgi = CGI.new

# Check to see if a link has been clicked
if cgi.params['color'].empty?
 background = 'blue'
 color = 'gold'
else
 color = cgi.params['color'].to_s
 background = cgi.params['background'].to_s
end

puts "Content-type: text/html"
puts # This blank line is mandatory

# Start printing the text
puts <<HTML
<!DOCTYPE html>
<html>
 <head>
 <title>A First Ruby CGI Script</title>
 <style type="text/css">
 body { background-color:#{background}; color:#{color}; width:800px; margin:2em auto;
 padding:2em; font-family:Helvetica,Arial,Verdana,sans-serif; font-size:18px;}
 h1 {color:#c00}
 a {color:cyan;}
 </style>
 </head>
 <body>
 <h1>QUERY_STRING EXAMPLE</h1>
 <p>
 This is an example of a Ruby CGI script that can process a request's QUERY_STRING. The links below each
have a QUERY_STRING encoded. When a user clicks on a link, the browser submits the QUERY_STRING.
 </p>
<p><a href="?color=red&background=orange">RED/ORANGE</a></p>
<p><a href="?color=blue&background=gray">BLUE/GRAY</a></p>
<p><a href="?color=lightgreen&background=black">GREEN/BLACK</a></p>
<p><a href="?color=gold&background=blue">GOLD/BLUE</a></p>
 </p>
 </body>
</html>
HTML

###########################################################
###########################################################
#################FORMS #############################
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
###########################################################
###########################################################
###########################################################
###########################################################


