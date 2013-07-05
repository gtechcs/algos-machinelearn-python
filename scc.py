#!/usr/local/bin/python

import random, copy, re

fin= open("./SCC.txt")

G = {}
Grev = {}
for line in fin: # load data, create adj lists

	splitter = re.compile(r'[\D]')
	l = splitter.split(line);	
	
	i = 0;
	empty = l.count('')
	while i < empty:
		l.remove('')
		i = i + 1;

#	print "Finalk: " + str(l[0]) + ' ' + str(l[1])
#	print G.keys()
	if(l[0] in G):
#		print "exists"
#		print G[l[0]] , ' ' , l[1]
		old = G[l[0]]
#		print "old:" , old
		old.append(l[1])
		G[l[0]] = old
	else:
#		print "Does not exist"
		n = []
		n.append(l[1])
		G[l[0]] = n

	if(l[1] in Grev):
		old = Grev[l[1]]
		old.append(l[0])
		Grev[l[1]] = old
	else:
#		print "Does not exist"
		n = []
		n.append(l[0])
		Grev[l[1]] = n

#	print "Final: " + str(G)

print "Adj List: "
print G

#k = G.keys()
#print k

#s = sorted(k)
#print s

print "Adj List reversed: "
print Grev

