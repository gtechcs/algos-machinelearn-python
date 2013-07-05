function [J, grad] = costFunctionReg(theta, X, y, lambda)
%COSTFUNCTIONREG Compute cost and gradient for logistic regression with regularization
%   J = COSTFUNCTIONREG(theta, X, y, lambda) computes the cost of using
%   theta as the parameter for regularized logistic regression and the
%   gradient of the cost w.r.t. to the parameters. 

% Initialize some useful values
m = length(y); % number of training examples

% You need to return the following variables correctly 
J = 0;
grad = zeros(size(theta));

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta.
%               You should set J to the cost.
%               Compute the partial derivatives and set grad to the partial
%               derivatives of the cost w.r.t. each parameter in theta


z = sigmoid(X*theta);

disp("sizetheta");
disp(size(theta));
%size(theta.^2)
%sum(theta.^2)

sumthetasquare = 0;
disp(sumthetasquare);
disp(size(theta(1)));
disp("lambda");
disp(lambda);
sztheta = size(theta);
disp("sztheta(1)");
disp(sztheta(1));
for i = 2:sztheta(1),
%        disp(i);
	sumthetasquare = sumthetasquare + theta(i,1).^2;
%	disp(sumthetasquare);
end;

%disp("Final");
%disp(sumthetasquare);

%J = (sum( (log(z) .*(-y)) +  (log(1-z) .* (y- 1)) ))/m  + (lambda/2*m)*sum(theta.^2) ;
J = (sum( (log(z) .*(-y)) +  (log(1-z) .* (y- 1)) ))/m  + (lambda/(2*m))*sumthetasquare ;

%disp("AAAAAAAAA");
%disp(sum( (z .- y).^2));
%disp("AAAAAAAAA");
%disp((1/m)*sum( (z .- y).^2));
%disp("BBBBBBBBB");
%disp((lambda/(2*m))*sumthetasquare);
%disp("BBBBBBBBB");
%disp((lambda/(2*m)));

%disp(z .-y);

%grad = (1/m)*sum( (z .- y).^2);

%for i = 2:sztheta(1),
%        disp(i);
%	grad() = sumthetasquare + theta(i,1).^2;
%	disp(sumthetasquare);
%end;

grad = (X'*(z .- y))/m;

for i = 2:sztheta(1),
        disp(i);
%        disp((theta(i,1)));
%        disp((theta(i,1)*lambda)/m);
%        disp(grad(i,1));
	grad(i,1) = grad(i,1) + (theta(i,1)*lambda)/m;
%        disp(grad(i,1));
end;



%disp("grad");
%disp(grad);

% =============================================================

end
