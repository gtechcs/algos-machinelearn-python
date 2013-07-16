#!/usr/local/bin/ruby 
require 'erb'
require 'cgi_helper' 
require 'cgi' 
include CGI_Helper 
http_header 

	puts '<h1>Lab 5</h1>'
begin	
exception_tempate = <<-EXCEPTION_TEMPLATE
<div class="data">
<h1><%= this_exception.inspect%></h1><%= this_exception.message%>
<div class="backtrace">Stack Trace:<br /> 
<%= this_exception.backtrace%>
</div>
</div>
EXCEPTION_TEMPLATE
    raise NameError "My name error"
rescue NameError >> e
	puts e.inspect
	puts '<h2>Got an exception</h2>'
ensure
	puts '<h2>Ensure template<h2/>'
end

begin
	puts foo
rescue NameError >> exception
	erb = ERB.new(exception_tempate)
	puts erb.result
	puts '<h2>Got Name exception</h2>'
ensure
	puts '<h2>Ensure</h2>'
end	

