filename= 'C:\Users\bindi\Downloads\Lightbulb.csv';
delimiter = ',';
data= importdata(filename, delimiter);

Volts =data.data(:,1);
Amps =data.data(:,2);
RHold=data.data(:,3);

= (5.65×(Volts*Amps-RHold))/0.93


ft = fittype( 'poly3' );

[fitresult, gof] = fit( xData, yData, ft );

h = plot( fitresult, xData, yData );

legend( h, 'data', 'fit', 'Location', 'NorthEast', 'Interpreter', 'none' );

xlabel( 'x', 'Interpreter', 'none' );
ylabel( 'f(x)', 'Interpreter', 'none' );
title('Curve Fitting')
