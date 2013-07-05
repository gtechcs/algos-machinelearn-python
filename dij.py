#!/usr/local/bin/python

import random, copy, re

fin= open("./dijkstraData.txt")

G = {} # node vs Dict_Of_node/weight

for line in fin: # load data, create adj lists

	splitter = re.compile('[^\S]')
	l = splitter.split(line);
	
	# This code block removes the "" elements
	empty = l.count('')
	i = 0
	while i < empty:
		l.remove('')
		i = i + 1;

#	print l
	key = int(l[0])
	l.remove(l[0])
#	print "key:", key , " l:", l
#	print "XXXXX", len(l)

	value = {}
	noEdges = len(l)
	j = 0
	while j < noEdges:
		splitter1 = re.compile('\,') 
		e = splitter1.split(l[j]);
		value[int(e[0])] = int(e[1]) 
		j = j + 1

	G[key] = value
#	print "YYYYY", len(value)
#	print value

print "Adj List: "
print G

shortesPaths = [0]*201
X = [] # Nodes on left hand side set of Dijkstra's algo

X.append(1)
print "X initial elements: ", X


minEdgeLength = 1000000
noOfIterations = len(G)
print "noOfIterations: ", noOfIterations 
iteration = 0
left = 1
while iteration < noOfIterations:
	minEdge = 0
	global minEdgeLength
	minEdgeLength = 10000

	global left
	if(left != len(X)):
		print "ERROR: left: ", left, " lenX:", len(X) 
	for x in X: #For each node in X
#		print "...........x: ", x
		nodeEdges = G[x] # All of my node/edges
#		print "nodeEdges: ", str(nodeEdges)
		for key in nodeEdges:
			if(X.count(key) == 0): # The key is not in left hand set
#				print "Weight: ", nodeEdges[key]
				if(minEdgeLength > nodeEdges[key]):
					minEdgeLength = nodeEdges[key]
					minEdge = key

	# We are done. We have the next node to include in pur left side set
	print "........The min edge wt: ", minEdgeLength, " for edge between :", x, " and ", minEdge
	chosenNode = minEdge # Chosen Node to be included in X, our left side set
	# We cannot delete this node from left hand side because we still might find shortest paths originating from this node
	#del(G[x]) # 1.Delete from right hand side set, the node whose endpoint is minEdge
	X.append(minEdge) #2. Append to Left hand side set
#	print "The left side set is: ", len(X)
	short = shortesPaths[x] + minEdgeLength
	shortesPaths[minEdge] = short # Add the shortest path in our final array

	iteration = iteration + 1
	left = left + 1

print shortesPaths
print len(shortesPaths)

#7,37,59,82,99,115,133,165,188,197
print "shortest paths:"
print shortesPaths[7]
print shortesPaths[37]
print shortesPaths[59]
print shortesPaths[82]
print shortesPaths[99]
print shortesPaths[115]
print shortesPaths[133]
print shortesPaths[165]
print shortesPaths[188]
print shortesPaths[197]




#print sorted(shortesPaths)
