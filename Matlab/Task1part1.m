filename= 'C:\Users\bindi\Downloads\Lightbulb.csv';
delimiter = ',';
data= importdata(filename, delimiter);
A=zeros(20,1);
Volts =data.data(:,1);
Amps =data.data(:,2);
RHold=data.data(:,3);

for k = 1:20;
       c= (5.65*(data.data(k,1)/data.data(k,2)-data.data(k,3)))/0.93;
         A(k,1)=c;
end       

plot(Volts, A);
xlabel( 'Voltage');
ylabel( 'Restivity of Lightbulb');
title('Calibration Resistivity Curve')
grid on

B=[0.1 ;0.5 ;1.5 ;2.7 ;4.25];
D=zeros(5,1);


B(1,1)
for j=1:5
    F=B(j,1)
Y = interp1(Volts,A,F,'linear', 'extrap')
D(j,1)=Y
end

disp(D)