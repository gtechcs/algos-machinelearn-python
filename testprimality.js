var fs = require('fs');

function isPrime(operand){
	if(operand < 2)
		return 

	var isPrime = true
	for (var i =2; i < operand; i++){
		if(operand % i == 0){
			isPrime = false
		}
	}
	if(isPrime == true)
		primes.push(operand)
} 

var primes = []
var contestant = 2;
while(primes.length != 10000){
	isPrime(contestant)
	contestant++
}

//console.log(primes.toString())

fs.writeFile("./primes1.txt", primes.toString())
