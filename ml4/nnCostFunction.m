function [J grad] = nnCostFunction(nn_params, ...
                                   input_layer_size, ...
                                   hidden_layer_size, ...
                                   num_labels, ...
                                   X, y, lambda)
%NNCOSTFUNCTION Implements the neural network cost function for a two layer
%neural network which performs classification
%   [J grad] = NNCOSTFUNCTON(nn_params, hidden_layer_size, num_labels, ...
%   X, y, lambda) computes the cost and gradient of the neural network. The
%   parameters for the neural network are "unrolled" into the vector
%   nn_params and need to be converted back into the weight matrices. 
% 
%   The returned parameter grad should be a "unrolled" vector of the
%   partial derivatives of the neural network.
%

% Reshape nn_params back into the parameters Theta1 and Theta2, the weight matrices
% for our 2 layer neural network
Theta1 = reshape(nn_params(1:hidden_layer_size * (input_layer_size + 1)), ...
                 hidden_layer_size, (input_layer_size + 1));

Theta2 = reshape(nn_params((1 + (hidden_layer_size * (input_layer_size + 1))):end), ...
                 num_labels, (hidden_layer_size + 1));

% Setup some useful variables
m = size(X, 1);
         
% You need to return the following variables correctly 
J = 0;
Theta1_grad = zeros(size(Theta1));
Theta2_grad = zeros(size(Theta2));

% ====================== YOUR CODE HERE ======================
% Instructions: You should complete the code by working through the
%               following parts.
%
% Part 1: Feedforward the neural network and return the cost in the
%         variable J. After implementing Part 1, you can verify that your
%         cost function computation is correct by verifying the cost
%         computed in ex4.m
%
% Part 2: Implement the backpropagation algorithm to compute the gradients
%         Theta1_grad and Theta2_grad. You should return the partial derivatives of
%         the cost function with respect to Theta1 and Theta2 in Theta1_grad and
%         Theta2_grad, respectively. After implementing Part 2, you can check
%         that your implementation is correct by running checkNNGradients
%
%         Note: The vector y passed into the function is a vector of labels
%               containing values from 1..K. You need to map this vector into a 
%               binary vector of 1's and 0's to be used with the neural network
%               cost function.
%
%         Hint: We recommend implementing backpropagation using a for-loop
%               over the training examples if you are implementing it for the 
%               first time.
%
% Part 3: Implement regularization with the cost function and gradients.
%
%         Hint: You can implement this around the code for
%               backpropagation. That is, you can compute the gradients for
%               the regularization separately and then add them to Theta1_grad
%               and Theta2_grad from Part 2.
%


%% disp(size(X)); % is 5000 x 400; 5000 samples; each with 400 data points
%% Theta1 is 25 x 401
%% Theta2 is 10 x 26
%% 25 units in second layer
%% 10 units in output layer



%disp(size(X)); % display the output X size
%disp(size(y)); % display the output y size
%disp(m); % display the output m size
%disp(num_labels); 
%disp(size(sigmoid(XplusOne(1,:) * Theta1')));


XplusOne = [ ones(size(X,1),1),X]; % add one element to each X array
for i= 1:m, % 5000 samples
	a2 = sigmoid(XplusOne(i,:) * Theta1');
	a2plusOne = [ ones(1,1),a2];
	a3 = sigmoid(a2plusOne * Theta2');

	for k= 1 :num_labels, %
		a3k = a3(1, k); 

		mu = zeros(num_labels, 1);
		mu(y(i,1),1) = 1;
	
		J = J + ((log(a3k) .* (-mu(k,1))) + ( log(1 -a3k) .* ( (mu(k,1)) - 1)    ) );	
	end;
end; 
J = J/m;
%disp("J");
%disp(J);

Theta1Squared = 0;
for j= 1:size(Theta1,1),
	for k= 2:size(Theta1,2),
		Theta1Squared = Theta1Squared + (Theta1(j,k).^2);
	end;
end;

Theta2Squared = 0;
for j= 1:size(Theta2,1),
	for k= 2:size(Theta2,2),
		Theta2Squared = Theta2Squared + (Theta2(j,k).^2);
	end;
end;

regTerm = ((Theta1Squared + Theta2Squared)*lambda)/(2*m);

J = J + regTerm;





%	J = (sum( (log(z) .*(-y)) +  (log(1-z) .* (y- 1)) ))/m  + (lambda/(2*m))*sumthetasquare;
%	z = sigmoid(X*Theta1');
%	J = sum( (log(z) .*(-y)) +  (log(1-z) .* (y- 1)) ))/m ;
%		J = J + ((log(a3k) .* (-y(i,1))) + ( log(1 -a3k) .* ( (y(i,1)) - 1)    ) );	
%		J = J + sum((log(a3) .*(-(mu) )) + (log(1-a3) .* ((mu)- 1))  );
%		if(y(i,1)=k)		
%			mu(k) = 1;
%		end;
%%		disp("a3 size");
%%		disp(size(a3));


% -------------------------------------------------------------

% =========================================================================

delta3 = zeros(size(a3));
delta2 = zeros(1, size(a2, 2) + 1);
triangle1 = zeros(size(Theta1_grad));
triangle2 = zeros(size(Theta2_grad));


a1 = X;
for t = 1:m, % for loop over samples
	%Step2
	for k= 1 :num_labels, 
		a3k = a3(1, k);

		mu = zeros(num_labels, 1);
		mu(y(t,1),1) = 1;

		delta3(1,k) = a3k - mu(k,1); %Step2 Looks ok
%		disp(k);
%		disp(a3k);
%		disp(delta3(1,k));
	end;

	%Step3
%	disp("All the suspects");
%	disp(size(delta2));  % delta2 is 1 x 26
%	disp(size(a1));  % a1 is 5000 x 400
%	disp(size(XplusOne));  % XPlusOne is 5000 x 401
%	disp(size(Theta1));  % Theta1 = 25 x 401
%	disp(size(Theta2));  % Theta2 is 10 x 26
%	disp(size(delta3));  % delta3 is 1 x 10

%	delta2(1,1) = 0;
	xrow = XplusOne(t,:); % 1 x 401
	
	delta2 =  (delta3 *Theta2) .* [1, sigmoidGradient(xrow*Theta1')] ;
%	sigZ2 = sigmoidGradient(xrow*Theta1');
%	sigZ2 = [1, sigZ2];
%	disp(size(sigZ2));
%	for delta2index= 2: size(delta2, 2),
%		delta2(1, delta2index) = delta2(1, delta2index) * sigZ2(delta2index-1);
%	end;


%	for delta2index= 2: size(delta2, 2),
%		sigZ2 = sigmoidGradient((xrow * Theta1'(:,delta2index -1)));
%		Theta2Delta3 = (Theta2'(delta2index, :)) * (delta3'(:,1));
%
%		delta2(1, delta2index) = sigZ2 .* Theta2Delta3; % Looks ok?
%		disp(delta2index);
%		disp(delta2(1, delta2index));
%	end;

	%Step4:
%	disp(size(triangle1));  % triangle1 is 25 x 401
%	disp(size(triangle2));  % triangle2 is 10 x 26
%	disp(size(a1));  % a1 is 5000 x 400
%	disp(size(a2));  % a2 is 1 x 25
%	disp(size(delta2));  % delta2 is 1 x 26
%	disp(size(delta3));  % delta3 is 1 x 10
%	disp(size(delta2'(2:end,:)));  % This is 25 x 1
%	disp(xrow(:, 1:10));  % This is xrow
	triangle1 = triangle1 + (delta2'(2:end,:) * xrow); % no problem
	a2_1 = [1 , a2];
	triangle2 = triangle2 + ( delta3' * a2_1);  % No problem




%	delta2 = delta2(2:end);
%	for m = 1:,
%		for n = 

	

end;

%	for mm = 2: size(triangle1,1),
%		for nn = 2: size(triangle1,2),
%			triangle1(mm,nn) = triangle1(mm,nn) + (lambda*Theta1(mm,nn));
%		end;
%	end;
%	for mm = 2: size(triangle2,1),
%		for nn = 2: size(triangle2,2),
%			triangle2(mm,nn) = triangle2(mm,nn) + (lambda*Theta2(mm,nn));
%		end;
%	end;




Theta1_grad = triangle1/m;  %No problem
Theta2_grad = triangle2/m;

% Unroll gradients
grad = [Theta1_grad(:) ; Theta2_grad(:)];


end;
