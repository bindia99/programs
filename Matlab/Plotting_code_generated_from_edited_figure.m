%this is code generated from the figure made by my original code
%when editing, I shifted the axis and changed the line style and marker style to only
% show error bars as in the figure in provided material
% however figure generated had shifted axises and did not corresspond to
% edited figure
%code is as follows:
figure('OuterPosition',[722.6 213 574.4 509.6]);
axes1 = axes;
hold(axes1,'on');
errorbar(data.data(:,2),data.data(:,1),data.data(:,3),'LineWidth',0.9,...
'Color',[0.243137254901961 0.607843137254902 0.929411764705882]);
text('FontSize',12,'String','Max Kinetic Energy',...
'Position',[-0.046040515653778 262.710280373832 1.4210854715202e-14]);
ylabel({'KineticEnergy(J)  '});
xlabel({'Distance(m) '});
title('Kinetic Energy vs Distance');
box(axes1,'on');
grid(axes1,'on');
hold(axes1,'off');
set(axes1,'GridColor',[0 0 0],'GridLineStyle','--','LineStyleOrder',{'+'},...
'XTick',[0 5 10 15 20]);
