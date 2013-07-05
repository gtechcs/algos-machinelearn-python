#!/usr/local/bin/python

import random, copy, re
import heapq

fin= open("./Median.txt")

#l = []

hlow = [] # Keep larger than median elements in this. Pop smallest
hhigh = [] #keep small elements than median. Pop highest from this. This is negative no 

mediansum = 0
median = 0
i = 1
for line in fin: # load data, create adj lists

	e = int(line[:-2])
#	l.append(e)
#	heapq.heappush(h, e)

	print "...", str(i)
	if(i % 2 == 0): #even-th element. Heaps must be odd
			a = heapq.heappop(hlow)
			a = abs(a)
			if(e < a): # Make heaps even
				heapq.heappush(hlow, -e)
				heapq.heappush(hhigh, a)
				temp = heapq.heappop(hlow)
				median = abs(temp)
				heapq.heappush(hlow, temp)
			else: # Make heaps even
				heapq.heappush(hlow, -a)
				heapq.heappush(hhigh, e)
				temp = heapq.heappop(hlow)
				median = abs(temp)
				heapq.heappush(hlow, temp)
	else: # odd-th element. Heaps must be even
		if(i == 1):
			heapq.heappush(hlow, -e)
			median = e
		else:
			a = heapq.heappop(hlow)
			a = abs(a)
			b = heapq.heappop(hhigh)
			if(e < a):
				heapq.heappush(hlow, -e)
				if(a < b):
					heapq.heappush(hlow, -a)
					heapq.heappush(hhigh, b)
					temp = heapq.heappop(hlow)
					median = abs(temp)
					heapq.heappush(hlow, temp)
				else:
					heapq.heappush(hlow, -b)
					heapq.heappush(hhigh, a)
					temp = heapq.heappop(hlow)
					median = abs(temp)
					heapq.heappush(hlow, temp)
			else:
				heapq.heappush(hlow, -a)
				if(e < b):
					heapq.heappush(hlow, -e)
					heapq.heappush(hhigh, b)
					temp = heapq.heappop(hlow)
					median = abs(temp)
					heapq.heappush(hlow, temp)
				else:
					heapq.heappush(hlow, -b)
					heapq.heappush(hhigh, e)
					temp = heapq.heappop(hlow)
					median = abs(temp)
					heapq.heappush(hlow, temp)


	i = i + 1
	mediansum = mediansum + median
	print "The element seen: ", e , "  Current median: ", median , "  mediansAdded: ", mediansum
	print "left: ",  hlow
	print "right: ",  hhigh

# Answer 41342392 is wrong,  46831213
print "mediansum: ", mediansum
print mediansum/10000
