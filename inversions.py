#!/usr/local/bin/python

#print "Hello World"

input = []
 
def readRandomArray():
	f = open('./IntegerArray.txt', 'r')
	for line in f:
		line = line.replace('\r\n','')
		input.append(line)
#		print line
	print 'All the input numbers'
#	print  input


readRandomArray();

#input = [1,2, 3,4, 5,22, 6, 7,9 ]


def merge(left, right,n ):
	
#	print "merge" + str(left) + str(right)
	inversioncount = 0
	merged = []
	k = 0	
	i = 0
	j = 0
	
	while k < n:
#		print "k: " + str(k)
#		print i;
#		print j;

		if(i < len(left) and j < len(right)):
			if( int(left[i]) < int(right[j])):
				merged.append(left[i])
				i = i + 1;
			elif (int(right[j]) < int(left[i])):
				merged.append(right[j])
				j = j + 1;
				inversioncount = inversioncount + len(left) - i;
		if (i < len(left) and j >= len(right)):
			merged.append(left[i])
			i = i+ 1
			
		if(i >= len(left) and j < len(right)):
			merged.append(right[j])
			j = j +1
			#inversioncount = inversioncount + len(left) - i

		k = k+1;
#		print "merged:" + str(merged)
#		print "inversioncount:" + str(inversioncount)

	return (inversioncount, merged);


def countInversions(arr, n):
	n = len(arr)
#	print "countInversions " + str(arr) +str(n)
	if n <=1:
		return (0,arr);

	left = arr[:n/2]
	right = arr[n/2:]

#	print "Start " + str(left) + str(right) + "broken at  "+ str(n/2);
	x, left  = countInversions(left, n/2)
#	print "Left is now: " + str(left)
	y, right = countInversions(right, n/2)
#	print "Right is now:" + str(right)
	z, merged = merge(left, right,n)
	return (x + y + z), merged; 

totalInversions = countInversions(input, len(input))
print totalInversions

#m, testmerged = merge([1,2,3,4,5,6],[7,8,9,10,11,12,13,14],14)
#print testmerged

#m, testmerged = merge([6,7,8,9,10,11,12,13,14], [1,2,3,4,5],14)
#print testmerged

#m, testmerged = merge([1,3,2,4,5,6],[7,8,9,10,11,12,13,14],14)
#print testmerged

#m, testmerged = countInversions([1,3,2,4,5,6,7,8,9,10,11,12,13,14],14)
#print testmerged
#print m

#m, testmerged = countInversions([1,3,2],3)
#print testmerged
#print m


