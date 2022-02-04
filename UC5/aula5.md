#Autor: Fagner Geraldes Braga  
#Data de criação: 03/02/2022  
#Data de atualização: 03/02/2022  
#Versão: 0.01  
***

! Primeiros comandos no Packet Tracer
modo exec
switch>
! Modo Privilegiado
enable
switch#

! Modo de Configuração Global
configure terminal
switch(config)#

! Sair do Modo de Configuração Global
exit

! Sair do Modo Privilegiado
exit
disable

!Alterar nome do Switch
enable 
    configure terminal
        hostname sw-senac-01

! Gravar alterações realizadas
end
copy running-config startup-config        
! write


![Markdown][image]

[image]: aula5_1.PNG

![Markdown][image2]

[image2]: aula5_2.PNG    