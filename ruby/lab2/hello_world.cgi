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
