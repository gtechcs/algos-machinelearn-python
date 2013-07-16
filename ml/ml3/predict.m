function p = predict(Theta1, Theta2, X)
%PREDICT Predict the label of an input given a trained neural network
%   p = PREDICT(Theta1, Theta2, X) outputs the predicted label of X given the
%   trained weights of a neural network (Theta1, Theta2)

% Useful values
m = size(X, 1);
num_labels = size(Theta2, 1);

% You need to return the following variables correctly 
p = zeros(size(X, 1), 1);

% ====================== YOUR CODE HERE ======================
% Instructions: Complete the following code to make predictions using
%               your learned neural network. You should set p to a 
%               vector containing labels between 1 to num_labels.
%
% Hint: The max function might come in useful. In particular, the max
%       function can also return the index of the max element, for more
%       information see 'help max'. If your examples are in rows, then, you
%       can use max(A, [], 2) to obtain the max for each row.
%
%disp("Size of X");
%disp(size(X));

%disp("Size of theta1");
%disp(size(Theta1));

%disp("Size of theta2");
%disp(size(Theta2));

%disp("num_labels");
%disp(num_labels);

%disp("Size of p");
%disp(size(p));

%a1 = ones(size(X,1), size(X,2) + 1);
%disp("a1");
%disp(size(a1));

%a1(:,end) = X(:,size(X,2));

%disp("First 10 digits of a1");
%v = a1(1:10, size(X,2) + 1);
%disp(v);

X = [ones(m, 1) X];
%disp("New Size of X");
%disp(size(X));

z2= sigmoid(X*Theta1');
%disp("z2 size");
%disp(size(z2));

z2 = [ones(m, 1) z2];
%disp("New Size of z2");
%disp(size(z2));

z3= sigmoid(z2*Theta2');
%disp("z3 size");
%disp(size(z3));

%p = max(z3', [], 2);

%maxvalues = zeros(size(X, 1), 1);
%disp("size(maxvalues)");
%disp(size(maxvalues));
%disp(size(maxvalues'));
%disp(size(p));

%disp("a b");

%disp(z3(1,:));
%disp(z3(2,:));
%disp(z3(3,:));
%disp(z3(4,:));
%disp(z3(5,:));

[ a, b] = max(z3, [], 2);
p = b;

%disp("a b");
%[ p', maxvalues'] = max(z3');
%disp(size(a));
%disp(size(b));

%disp(b(1,:));


%disp(b);

%disp("doing max");
%disp(size(max(z3')));

%p' = max(z3');

%disp(p);

%disp(z3(1,:));

% why does not work? [maxvalue, p] = max(z3, [], 2);
%disp(max(z3(1,:)));

%for i=1:size(z3, 1),
%	disp("    ");
%	disp(i);
%	disp(p(i,1));
%	[maxvalue, p(i,1)] = max(z3(i,:));
%	disp(maxvalue);
%	disp(p(i,1));
%	disp(p(i+1,1));
%end;


%disp("displaying p");
%disp(p);
%disp(num_labels);

% =========================================================================


end
