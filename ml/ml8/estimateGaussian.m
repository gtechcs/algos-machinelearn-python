function [mu sigma2] = estimateGaussian(X)
%ESTIMATEGAUSSIAN This function estimates the parameters of a 
%Gaussian distribution using the data in X
%   [mu sigma2] = estimateGaussian(X), 
%   The input X is the dataset with each n-dimensional data point in one row
%   The output is an n-dimensional vector mu, the mean of the data set
%   and the variances sigma^2, an n x 1 vector
% 

% Useful variables
[m, n] = size(X);

% You should return these values correctly
mu = zeros(n, 1);
sigma2 = zeros(n, 1);

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the mean of the data and the variances
%               In particular, mu(i) should contain the mean of
%               the data for the i-th feature and sigma2(i)
%               should contain variance of the i-th feature.
%

disp("size(X)");
disp(size(X));

%sum = size(mu);
%for i = 1:m 
%	sum = sum + X(i,:);
%end;
mu = sum(X);

mu = mu./m;

disp(mu);

%squareddiff = size(mu);

%for i = 1:m 
%	squareddiff = squareddiff .+ (X(i,:) - mu).^2;
%end;

%sigma2 = squareddiff/m; 

%sigma2 = var(X);
sigma2 = (var(X)*(m-1))/m;

disp(sigma2);
% =============================================================


end
