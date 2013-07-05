#!/usr/local/bin/python

import random, copy, re

fin= open("./HashInt.txt")

l = []
G = {}
for line in fin: # load data, create adj lists
	e = int(line[:-1])
	l.append(e)
	G[e] = e

print l
print G

answers = [0]* 1505
t = 2500
answer = 0
while t <= 4000:
	for x in l:
		if(G.has_key(t-x)):
			if(x != (t-x)):
				print x, " + ", G[t-x] , " = ", t  
				answers[t-2500] = 1
				break;
	t = t + 1


print answers.count(1)

