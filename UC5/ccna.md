#Autor: Fagner Geraldes Braga  
#Data de criação: 04/02/2022  
#Data de atualização: 04/02/2022  
#Versão: 0.01  
***
Aula 1 - 04/02/2021  

Memória Flash: IOS  
Switch# show flash:  

Running-config: RAM  
Switch#show running-config   

Startup-config: NVRAM  
Switch#show startup-config   

Modo Usuário  
Switch>  

Modo Exec (Privilegiado)  
enable  
Switch#  

Modo de Configuração Global  
configure terminal  
Switch(config)#  

Acesso a interface (Fast Ethernet)  
Switch(config)#interface fastEthernet 0/1  
Switch(config-if)#  

Sair  
Voltar um nível  
exit  

Voltar para o modo Exec  
end  

Criar VLAN  
Switch#show vlan  
Switch(config)#vlan 10  
Switch(config-vlan)#name RH  

Switch(config)#vlan 20  
Switch(config-vlan)#name Comercial  

Atribuir VLAN a Porta de acesso  
Switch(config)#interface fastEthernet 0/1  
Switch(config-if)#switchport mode access   
Switch(config-if)#switchport access vlan 10   


Switch(config)#interface fastEthernet 0/2  
Switch(config-if)#switchport mode access   
Switch(config-if)#switchport access vlan 20   

Configurar VLAN em Modo Trunk  
Switch(config)#interface gigabitEthernet 0/1  
Switch(config-if)#switchport mode trunk   

Native VLAN  
Switch(config)#vlan 99  
Switch(config-vlan)#name VLAN_NATIVA  
Switch(config)#interface gigabitEthernet 0/1  
Switch(config-if)#switchport trunk native vlan 99  

Lab1-VLAN1 - 04/02/2022  
## Criando VLANs  
S1(config)#vlan 10  
S1(config-vlan)#name Faculty/Staff  
S1(config)#vlan 20  
S1(config-vlan)#name Students  
S1(config)#vlan 30  
S1(config-vlan)#name Guest(Default)  
S1(config)#vlan 99  
S1(config-vlan)#name Management&Native  

S2(config)#vlan 10  
S2(config-vlan)#name Faculty/Staff  
S2(config)#vlan 20  
S2(config-vlan)#name Students  
S2(config)#vlan 30  
S2(config-vlan)#name Guest(Default)  
S2(config)#vlan 99  
S2(config-vlan)#name Management&Native  

## Atribuindo VLANs nas interfaces  
S2(config)#interface fastEthernet 0/11  
S2(config-if)#switchport mode access   
S2(config-if)#switchport access vlan 10  

S2(config)#interface fastEthernet 0/18  
S2(config-if)#switchport mode access   
S2(config-if)#switchport access vlan 20  

S2(config)#interface fastEthernet 0/6  
S2(config-if)#switchport mode access   
S2(config-if)#switchport access vlan 30  

S3(config)#interface fastEthernet 0/11  
S3(config-if)#switchport mode access   
S3(config-if)#switchport access vlan 10  

S3(config)#interface fastEthernet 0/18  
S3(config-if)#switchport mode access   
S3(config-if)#switchport access vlan 20  

S3(config)#interface fastEthernet 0/6  
S3(config-if)#switchport mode access   
S3(config-if)#switchport access vlan 30  

## Criando Trunk entre os switches  
S1(config)#interface range gigabitEthernet 0/1-2  
S1(config-if-range)#switchport mode trunk   

S2(config)#interface gigabitEthernet 0/1  
S2(config-if)#switchport mode trunk  

S3(config)#interface gigabitEthernet 0/2  
S3(config-if)#switchport mode trunk  

Lab1-VLAN2 - 04/02/20222  

Switch1  
S1(config)#vlan 99  
S1(config)#interface gigabitEthernet 0/1  
S1(config-if)#switchport mode trunk  
S1(config-if)#switchport trunk native vlan 99  

S1(config)#interface gigabitEthernet 0/2  
S1(config-if)#switchport mode trunk  
S1(config-if)#switchport trunk native vlan 99  

Switch2  
S2(config)#vlan 99  
S2(config)#interface gigabitEthernet 0/1  
S2(config-if)#switchport mode trunk  
S2(config-if)#switchport trunk native vlan 99  

Switch3  
S3(config)#vlan 99  
S3(config)#interface gigabitEthernet 0/2  
S3(config-if)#switchport mode trunk  
S3(config-if)#switchport trunk native vlan 99  


Lab1-VLAN1 - 04/02/2022  
S1(config)#vlan 10  
S1(config-vlan)#name Faculty/Staff  
S1(config)#vlan 20  
S1(config-vlan)#name Students  
S1(config)#vlan 30  
S1(config-vlan)#name Guest(Default)  
S1(config)#vlan 99  
S1(config-vlan)#name Management&Native  








