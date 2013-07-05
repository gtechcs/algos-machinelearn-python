#!/usr/local/bin/python

import random, copy, re
import sys
import threading

threading.stack_size(67108864) # 64MB stack
sys.setrecursionlimit(2 ** 20)

maxnumber = 875714

fin= open("./SCC.txt")

G = {}
Grev = {}

def loadGraphs():
	global G
	global Grev
	for line in fin: # load data, create adj lists

		splitter = re.compile(r'[\D]')
		l = splitter.split(line);	
	
		i = 0;
		empty = l.count('')
		while i < empty:
			l.remove('')
			i = i + 1;

		if(G.has_key(int(l[0]))):
			old = G[int(l[0])]
			old.append(int(l[1]))
			G[int(l[0])] = old
		else:
	#		print "Does not exist"
			n = []
			n.append(int(l[1]))
			G[int(l[0])] = n

		if(Grev.has_key(int(l[1]))):
			old = Grev[int(l[1])]
			old.append(int(l[0]))
			Grev[int(l[1])] = old
		else:
	#		print "Does not exist"
			n = []
			n.append(int(l[0]))
			Grev[int(l[1])] = n


t = 0	# for finishing time in 1st pass, anytime a node is last and we have to backtrack, we give it no 1, the 2
explored = []	# In 1st pass, I need to know which nodes I have passed
finishingtimeVsIndex = {}


explored = [0]*875715
print explored
def isExplored(i):
#	if(i in explored):
	if(explored[i] == 1): # Explored
		return 1
	else:
		return 0

firstloopexplored = 0
firstloopexplored222 = 0
stack = []
def dfsrev(G,i): # G is dict;
	global explored
	global t
	global finishingtimeVsIndex

	global queue
	global firstloopexplored
	global firstloopexplored222
	print 
	print ".....Explored: ", i

	explored[i] = 1 # marking i as explored	
	firstloopexplored = firstloopexplored +1
	if(G.has_key(i)):# Node has children in adjacency list 
		ini = len(stack)
		more = len(G[i])
		stack.extend(G[i]) #Put all children in stack, for dfs
		fin = len(stack)
		print fin , " = ", ini , " + ", more  , "    kids: " 
		while(len(stack) != 0):
			print "Stack length before popping ", len(stack)
			j = stack.pop();
			print "Stack length after popping ", len(stack)
			print "Popped ", j
			if(isExplored(j) == 0):
				dfsrev(G,j)
			else:
				print "Explored already", j	
	else: # This is a leaf
		print "Is leaf: ", i
		t = t + 1
		finishingtimeVsIndex[t] = i;	
		firstloopexplored222 = firstloopexplored222 + 1

		if(len(stack) != 0):
			print "Stack length before popping ", len(stack)
			j = stack.pop();
			print "Stack length after popping ", len(stack)
			print "Popped leaf ", j
			if(isExplored(j) == 0):
				dfsrev(G,j)



def dfslooprev(G): # G is dict; 
	global t	#for finishing times in first pass
	global maxnumber
	i = maxnumber 
	while (i >0):
		print "...............................", i
		if(isExplored(i) == 0):
			dfsrev(G,i)
		i = i-1


currentleaderfinishtime = 0
myleader = {}   # For leaders in second pass 

explored2 = [0]*875715
def isExplored2(i):	#real nodes? Yes
	if(explored2[i] == 1): # Explored
		return 1
	else:
		return 0

d_stack = []
totalnodesexplored = 0
def dfs(G,node): # G is dict; finishtime is key in finishvsindex; 
	global explored2
	global finishingtimeVsIndex

	global d_stack
	global totalnodesexplored

	explored2[node] = 1 # marking i as explored
	totalnodesexplored = totalnodesexplored + 1
	myleader[node] = currentleaderfinishtime
	print "My leader ", node , " is ", currentleaderfinishtime	
	if(G.has_key(node)):# Node has children in adjacency list 
		d_stack.extend(G[node]) #Put all children in stack, for dfs


	if(len(d_stack) != 0):
		j = d_stack.pop();
		if(isExplored2(j) == 0):
			dfs(G,j)



def dfsloop(G): # G is dict;
#	print G
	global myleader	#for leaders in 2nd pass
	global currentleader
	global finishingtimeVsIndex
	global currentleaderfinishtime

#	print "Total Elements ", len(G)	

	i = 161167 # The max finish time I saw 
	while (i >0):
		if(finishingtimeVsIndex[i] != None):
			print "finishTime ", i , "  has Node:" , finishingtimeVsIndex[i]
			node = finishingtimeVsIndex[i]
			if(isExplored2(node) == 0): # not explored
				currentleaderfinishtime = i # I am current leader
				print "I am current finish leader: ", currentleaderfinishtime
				dfs(G,node)
			else:
				print "Already explored node: ", node
		i = i - 1





scc = {}
def sccs(myleader):
	global scc
	keys = myleader.keys()
	for key in keys:
#		print key
		leader = myleader[key]
		if(scc.get(leader, 'NONE') != 'NONE'):
#			print ""
#			print scc
			value = scc[leader]
#			print value
			value.append(key)
			scc[leader] = value
		else:
			n = list()
			n.append(key)
			scc[leader] = n
#			print scc


maxvalue = 0
def count(scc):
	global maxvalue
	counts = []
	keys = scc.keys()
	for key in keys:
		listofvalues = scc[key]
		l = len(listofvalues)
		if(l > maxvalue):
			maxvalue = l;
		counts.append(l)
	print "MAX value : ", maxvalue
	counts.sort()
	return counts


#foutG= open("./G.txt", 'w')
#foutGrev= open("./Grev.txt", 'w')
#foutGfinish= open("./Gfinish.txt", 'w')
#foutGfinishsorted= open("./Gfinishsorted.txt", 'w')
#foutleader= open("./Gleader.txt", 'w')

loadGraphs()
#foutG.write(str(G))
#foutGrev.write(str(Grev))

print G
#print
print Grev
dfslooprev(Grev)
#print "	FinishingtimeVsIndex: " , finishingtimeVsIndex

print "	FinishingtimeVsIndex keys: " , finishingtimeVsIndex.keys()

print "	FinishingtimeVsIndex keys length: " , len(finishingtimeVsIndex.keys())

#ss = finishingtimeVsIndex.keys().sort()
#foutGfinishsorted.write(str(finishingtimeVsIndex))

#print "2nd Loop  ............................... "

#del stack[:]
#del explored[:]
#dfsloop(G)

#print "Done finding leaders"
#print myleader

#sccs(myleader)
#c = count(scc)
#print "This should be the answer: "
#print c

print "Total nodes explored in 1st dfs loop: ", firstloopexplored
print "Total nodes explored in 1st dfs loop: ", firstloopexplored222
print "Total nodes explored in 1st dfs loop t: ", t
print "Total nodes explored in 1st dfs loop stack: ", len(stack)

print "Total nodes explored in 2nd dfs loop: ", totalnodesexplored
#print "Total G nodes: ", len(G.keys())
#print "Total Grev nodes: ", len(Grev.keys())

#print scc


#Grev = {1:[7], 2:[5], 3:[9], 4:[1], 5: [8], 6: [3,8], 7: [4,9], 8: [2], 9: [6]}
#dfslooprev(Grev)
#print "		FinishingtimeVsIndex: " , finishingtimeVsIndex
#print 
#G = {1:[4], 2:[8], 3:[6], 4:[7], 5: [2], 6: [9], 7: [1], 8: [5,6], 9: [3,7]}
#dfsloop(G)
#print "myleader: " , myleader
#sccs(myleader)
#print "scc: ", str(scc)
#print type(scc)
#c = count(scc)
#print c





def testisExplored():
	ex = isExplored(1)
	print "Should be None ", ex
	if(ex == -100):
		explored.append(1)
	ex = isExplored(1)
	print "Should be sth ", ex
	ex = isExplored(1)
	print "Should be sth ", ex
	ex = isExplored(2)
	print "Should be None ", ex
	ex = isExplored(2)
	print "Should be sth ", ex
	ex = isExplored(1)
	print "Should be sth ", ex
#testisExplored()
