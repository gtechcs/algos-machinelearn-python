function centroids = computeCentroids(X, idx, K)
%COMPUTECENTROIDS returs the new centroids by computing the means of the 
%data points assigned to each centroid.
%   centroids = COMPUTECENTROIDS(X, idx, K) returns the new centroids by 
%   computing the means of the data points assigned to each centroid. It is
%   given a dataset X where each row is a single data point, a vector
%   idx of centroid assignments (i.e. each entry in range [1..K]) for each
%   example, and K, the number of centroids. You should return a matrix
%   centroids, where each row of centroids is the mean of the data points
%   assigned to it.
%

% Useful variables
[m n] = size(X);

% You need to return the following variables correctly.
centroids = zeros(K, n);


% ====================== YOUR CODE HERE ======================
% Instructions: Go over every centroid and compute mean of all points that
%               belong to it. Concretely, the row vector centroids(i, :)
%               should contain the mean of the data points assigned to
%               centroid i.
%
% Note: You can use a for-loop over the centroids to compute this.
%
disp(m);
disp(n);
disp(K);
disp(size(centroids));

totalsum = zeros(1,n);
disp(size(totalsum));

for i = 1:K  
	noOfsamples = 0;
	totalsum = zeros(1,n);
	for sam = 1 : m	% all the samples
		if(idx(sam) == i)
%			disp(X(sam,:));
			totalsum = totalsum + X(sam,:);
			noOfsamples = noOfsamples + 1;
		end;
	end;
	disp(totalsum);
	disp(noOfsamples);
	centroids(i,:) = totalsum/noOfsamples;
end;


% =============================================================


end

