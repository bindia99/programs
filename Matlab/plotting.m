filename= 'C:\Users\bindi\Downloads\PlottingGraphs.csv';
delimiter = ',';
data= importdata(filename, delimiter);
plot(data.data(:,2),data.data(:,1),'+','LineWidth',0.9,...
'Color',[0.24 0.60 0.92]);
err = data.data(:,3);
errorbar(data.data(:,2),data.data(:,1),err,'LineWidth',0.9,...
'Color',[0.24 0.60 0.92]);
title('Kinetic Energy vs Distance');
xlabel(data.textdata(1,2));
ylabel(data.textdata(1,1));
text(0,255,'Max Kinetic Energy');
axis([0,20,0,300]);
xticks([0,5,10,15,20]);
grid on; 
set(gca,'GridLineStyle','--');




