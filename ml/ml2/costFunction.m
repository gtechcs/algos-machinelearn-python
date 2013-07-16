function [J, grad] = costFunction(theta, X, y)
%COSTFUNCTION Compute cost and gradient for logistic regression
%   J = COSTFUNCTION(theta, X, y) computes the cost of using theta as the
%   parameter for logistic regression and the gradient of the cost
%   w.r.t. to the parameters.

% Initialize some useful values
m = length(y); % number of training examples

% You need to return the following variables correctly 
J = 0;
%disp(theta);
grad = zeros(size(theta));

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta.
%               You should set J to the cost.
%               Compute the partial derivatives and set grad to the partial
%               derivatives of the cost w.r.t. each parameter in theta
%
% Note: grad should have the same dimensions as theta
%

%disp("size X")
%size(X)
%disp("size y")
%size(y)
%disp("size X*theta")
%size(X*theta)
%disp("AA")
%size(log(sigmoid(X*theta)))
%disp("AAAA should be 100x1")
%size(log(sigmoid(X*theta)) .*y +  log(-sigmoid(X*theta)) .* (1-y) )

z = sigmoid(X*theta);
%disp("size z")
%size(z)

J = (sum( (log(z) .*(-y)) +  (log(1-z) .* (y- 1)) ))/m;


%disp("BB");
%size( sigmoid(X*theta))
%disp("BBB");
%size( sigmoid(X*theta) .-y)
%disp("BBB");
%%%%%%size( (sigmoid(X*theta) .-y) .*X(:,i))
%%%%%%%disp(size(X(:,0)))
%disp("bbbb")
%disp(y); 
	grad = (X'*(z .- y))/m;

%disp("CC");
%disp(size(grad))

%%grad = sum( X' * ( sigmoid(X*theta)- y) )/m;


% =============================================================

end
