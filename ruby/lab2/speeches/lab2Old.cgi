##################LAB2 lab2.cgi#########################################
#!/usr/local/bin/ruby
# SCRIPT: lab2.cgi
# CREATOR: pkumar16
# c:\Ruby167\bin\ruby

puts 'Content-type: text/html'
puts
puts '<h1>Lab 2</h1>'
puts '<h2>Puneet Kumar, pkumar16</h2>'

# Text analyzer code follows 

#	stop_words = %w{a able about above abroad according accordingly across }

	stop_words = ''
	stop_file = File.open( 'stop_words.txt').each do |line|
		stop_words.concat(line.strip)
		stop_words.concat(' ')
	end
	puts stop_words
	
    Dir.glob('./speeches/*.txt').each do |speech|
# process speech
		puts "Processing #{speech}";
		line_count = 0;
		text = ''
		count_characters = 0
		total_characters_nonspaces = 0
		word_count = 0
		sentence_count = 0
		paragraph_count = 0
		words_per_sentence = 0
		non_fluff_words = ''
		keywords =''
		hash = Hash.new
		f = File.open( speech).each do |line|
			line_count += 1
			text << line
			count_characters += text.length
			total_characters_nonspaces += text.gsub(/\s+/, '').length # substitute
			word_count += text.split.length # split by default at spaces
			sentence_count = text.split(/\.|\?|!/).length # Breaks yp by ?, . or !
			paragraph_count = text.split(/\n\n/).length  # Paragraph boundary is two \n
			
		end

# Find the most common words, start		
			words = text.scan(/\w+/); # Gives array of alphanumeric words
			keywords = words.select{|word| !stop_words.include?(word)} # words without stop words
			keywords.uniq.each do |word_key| # for each unique keyword, put in hash Hash keyword and its count
				hash[word_key] = keywords.count(word_key) # unless word_key = ''
			end
			wmm = hash.keys.sort_by do |word| # sort these words based on value, returns array of most common words
				hash[word]
			end
			wmm.reverse # reverse the most common words 
			most_common = wmm.reverse.map do |word2| # returns array of  most common words vs their count
				"#{word2} #{hash[word2]}"
			end
			puts 'MOST COMMON WORDS #{s} ', most_common[0, 5]
# Find the most common words, end		
			
		words_per_sentence = word_count / sentence_count;

#Finding the ideal sentence		
		sentences = text.gsub(/\s+/, ' ').strip.split(/\.|\?|!/)
		sentences_sorted = sentences.sort_by { |sentence| sentence.length }
		one_third = sentences_sorted.length / 3
		ideal_sentence = sentences_sorted.slice ( one_third, one_third + 1 )
		ideal_sentence = ideal_sentence.select { |sentence| sentence =~ /is|are/}
		
#Finding the ideal sentence, end		
		
		puts "Total Lines are #{line_count}"
		puts "Total Charactrs are #{count_characters}"
		puts "Total Charactrs with no spaces are #{total_characters_nonspaces}"
		puts "Total Words are #{word_count}"
		puts "Total Sentences are #{sentence_count}"
		puts "Total paragraph are #{paragraph_count}"
		puts "Average words per sentence are #{words_per_sentence}"
		puts "Non fluff words are #{keywords.join(' ')}"
		puts "Non fluff words length is #{keywords.length}"
		puts "Ideal Sentence is: #{ideal_sentence.join(". ")}"
    end


#				hash[word] = keywords.count_of(word) unless word = ''
#			puts "hAsh"	
#			puts wmm.class
#			puts 'Hash size'
#			puts hash.size
#			puts hash
#				puts "stop words?"
#				puts word_key
#			non_fluff_words = non_fluff_words + keywords.join(' ')
#			puts "keywords"
#			puts keywords
#			puts "TEXT"
#			puts text
#			puts "WORDS"
#			puts words
	
#		puts 'hash size'
#		puts hash.size
#		inverted = hash.invert
#		puts 'inverted size'
#		puts inverted.size
#		valu= hash.values
#		puts 'valu size'
#		puts valu.size
#		sorted = valu.sort
#		puts 'sorted size'
#		puts sorted.size
#		reverse = sorted.reverse
#		reverse = hash.invert.values.sort.reverse
#		puts 'reverse size'
#		puts reverse.size
#		puts hash
#		puts reverse[0]
#		to_find = reverse[0]
#		puts = to_find
#		puts hash.key(to_find)
#		puts reverse[1]
#		puts hash[reverse[1]]
#		f.each { |line| line_count+= 1}
#		i = 0
#		until (i > 3) do
#			line_count++;
#			i = i+1;
#			print "count";
#		end
#		print f.readline()
#			puts keywords.class	
#			keywords.select do |word|
#				if hash[word] == NilClass
#					hash[word] = 1
#				else
#					old_value = hash[word]
#					hash[word] = old_value.to_i + 1 
#				end
#			end
	
	
	
	