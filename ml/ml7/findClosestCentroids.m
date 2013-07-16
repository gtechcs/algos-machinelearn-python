function idx = findClosestCentroids(X, centroids)
%FINDCLOSESTCENTROIDS computes the centroid memberships for every example
%   idx = FINDCLOSESTCENTROIDS (X, centroids) returns the closest centroids
%   in idx for a dataset X where each row is a single example. idx = m x 1 
%   vector of centroid assignments (i.e. each entry in range [1..K])
%

% Set K
K = size(centroids, 1);

% You need to return the following variables correctly.
idx = zeros(size(X,1), 1);

% ====================== YOUR CODE HERE ======================
% Instructions: Go over every example, find its closest centroid, and store
%               the index inside idx at the appropriate location.
%               Concretely, idx(i) should contain the index of the centroid
%               closest to example i. Hence, it should be a value in the 
%               range 1..K
%
% Note: You can use a for-loop over the examples to compute this.
%

%disp(size(X));
%disp(size(centroids));
%disp(centroids);


for i = 1: size(X,1)
	nearestC = 1;
	minDistance = -1;
	for c = 1: K
%		d = (sqrt((X(i,1) - centroids(c,1))^2 + (X(i,2) - centroids(c,2))^2))^2;
%		d = ((X(i) - centroids(c))^2);
%		d = (abs(X(i,1)*centroids(c,1) + X(i,2)*centroids(c,2))) ^2;
%		d = (X(i,:) .- centroids(c,:));
%		d = d.^2;

%		d = (X(i,1)*centroids(c,1)) + (X(i,2)*centroids(c,2))^2;
		d = 0;
		for b = 1: size(X,2)
			d = d + (X(i,b) - centroids(c,b))^2;
		end;

		if(minDistance == -1)
%			disp("First step");
			minDistance = d;
			nearestC = 1;
		end;
		if(d < minDistance)
%			disp("second step ");
%			disp( c);
			minDistance = d;
			nearestC = c;
		end;
	end;
	idx(i) = nearestC;
end;

%disp(idx');
% =============================================================

end

