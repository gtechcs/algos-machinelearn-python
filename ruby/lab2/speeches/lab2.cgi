#!/usr/local/bin/ruby
# SCRIPT: lab2.cgi
# CREATOR: pkumar16

puts "Content-type: text/html"
puts
puts "<html><head><title>Lab 2</title></head>"
puts "<h1>Lab 2</h1>"
puts "<h4>Puneet Kumar, pkumar16</h4>"

# Text analyzer code follows 

#	stop_words = %w{a able about above abroad according accordingly across }

	stop_words = ''
	stop_file = File.open( 'stop_words.txt').each do |line|
		stop_words.concat(line.strip)
		stop_words.concat(' ')
	end
#	puts stop_words
	
    Dir.glob('./speeches/*.txt').each do |speech|
# process speech
#		puts "Processing #{speech}";
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
		end
			count_characters += text.length
			total_characters_nonspaces += text.gsub(/\s+/, '').length # substitute
			word_count += text.split.length # split by default at spaces
			sentence_count = text.split(/\.|\?|!/).length # Breaks yp by ?, . or !
			paragraph_count = text.split(/\n\n/).length  # Paragraph boundary is two \n

			
		words = text.scan(/\w+/); # Gives array of alphanumeric words
# Find any averages
		words_per_sentence = word_count / sentence_count;
		
# Find the most common words, start		
			keywords = words.select{|word| (!stop_words.include?(word) && !stop_words.include?(word.downcase)) } # words without stop words
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
#			puts 'MOST COMMON WORDS #{s} ', most_common[0, 5]
# Find the most common words, end		
			

#Finding the ideal sentence		
		sentences = text.gsub(/\s+/, ' ').strip.split(/\.|\?|!/)
		sentences_sorted = sentences.sort_by { |sentence| sentence.length }
		one_third = sentences_sorted.length / 3
		ideal_sentence = sentences_sorted.slice( one_third, one_third + 1 )
		ideal_sentence = ideal_sentence.select { |sentence| sentence =~ /is|are/}
#Finding the ideal sentence, end		
		
		puts "<h2>#{speech.gsub!(/.txt/,'').gsub!(/speeches/,'').gsub!(/\.|\//,'').upcase} Inaugration Speech</h2>"
		puts
		puts "<h4>STATISTICS</h4>"
		puts "Lines  #{line_count}<br>"
		puts "Charactrs #{count_characters}<br>"
		puts "Charactrs (exc. spaces) #{total_characters_nonspaces}<br>"
		puts "Words count #{word_count}<br>"
		puts "Sentences #{sentence_count}<br>"
		puts "Paragraphs #{paragraph_count}<br>"
		sentences_per_paragraph = sentence_count / paragraph_count
		puts "Sentences/Paragraph #{sentences_per_paragraph}<br>"
		puts "Words per Sentence #{words_per_sentence}<br>"
		percent_non_fluff =(keywords.length * 100)/ words.length 
		puts "Non-fluff #{percent_non_fluff}%<br>" 
		puts
		puts "<h4>ABSTRACT</h4> \n #{ideal_sentence.join(". ")}"
		puts
		puts "<h4>THE TEN MOST COMMON WORDS</h4>"
		puts most_common[0, 10]
		puts "\n\n\n"
		
    end
puts "</html>"


	