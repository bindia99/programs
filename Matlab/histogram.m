filename= 'C:\Users\bindi\Downloads\HistogramData.csv';
delimiter = ',';
data= importdata(filename, delimiter);
x=ones(100,1)
x=data.data(:,2)
nbins=20
h=histogram(x, nbins)
