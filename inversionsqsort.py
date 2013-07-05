#!/usr/local/bin/python

input = []
 
def readRandomArray():
	f = open('./IntegerArray.txt', 'r')
	for line in f:
		line = line.replace('\r\n','')
		input.append(line)
#	print 'All the input numbers'
#	print  input



def partition(input, l, r):
	if(l < 0 or r <0 or r<=l or r>=len(input)  ):
		return 0;
	pivot = input[r]
	
	if pivot != input[l]:
		pivot, input[l] = input[l], pivot

	i = l+1
	j = l+1
	while j<=r:
		if int(input[j]) < int(pivot):
			input[i], input[j] = input[j], input[i]
			i = i+1
		j = j+1
	input[l], input[i-1] = input[i -1], input[l]
	return i-1



def qsort(input, l, r): # first element index, last element index
#	print "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
#	print "Starting qsort on " + "  " + str(l) + "  " + str(r)  
	global count

	if(l < 0 or r <0 or r<=l):
		return 0;
	i = partition(input, l, r)
	
	count = count + r - l -1 
	qsort(input, l, i-1)
	qsort(input, i+1, r)
	#print input

count=0
readRandomArray()
qsort(input, 0, len(input)-1)
print "??????????????? " + str(input) + "has inversions: " + str(count)


count=0
input=[7,6,5,4,3,2,1]
qsort(input, 0, len(input)-1)
inversions= count;
print "??????????????? " + str(input) + "has inversions: " + str(inversions)


count = 0
#input = [1,2,3,4,5,6,7]
#qsort(input, 0, len(input)-1)
#print "??????????????? "+ str(input) + "has inversions: " + str(count)

count = 0
#input = [7,6,5, 1,2,3,10]
#qsort(input, 0, len(input)-1)
#print "??????????????? "+ str(input) + "has inversions: " + str(count)

count=0
#input = [67,34,100,101,102,103,3,2,1,156,11,0,45]
#qsort(input, 0, len(input)-1)
#print "??????????????? "+ str(input) + "has inversions: " + str(count)
