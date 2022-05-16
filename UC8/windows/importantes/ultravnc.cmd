:::::::::::::::::::::::::::::::::::::::::::::::::::::::
:: CRIADO POR LEONARDO DUARTE						:::
:: ALTERADO POR FAGNER GERALDES BRAGA				:::
:: EMAIL: info@comoaprenderwindows.com.br		    :::
:: DATA DE CRIACAO: 22/07/17						:::
:: DATA DE ALTERACAO: 15/05/22						:::
:: OBJETIVO: INSTALAR ULTRAVNC NOS COMPUTADORES		:::
:::::::::::::::::::::::::::::::::::::::::::::::::::::::

@echo off

REM Nome do Servidor onde tem a instalação do ULTRAVNC
set DeployServer=\\core.intra\netlogon\core\softwares\ULTRAVNC\

REM VERIFICA SE ULTRAVNC ESTA INSTALADO

if exist "C:\Program Files\uvnc bvba\UltraVNC" GOTO SAIR

if not exist "C:\Program Files\uvnc bvba\UltraVNC" (
mkdir "C:\Program Files\uvnc bvba\UltraVNC"
)

REM *********************************************************************
REM VERIFICO SE O SO É 32BITS OU 64 BITS
IF NOT "%ProgramFiles(x86)%"=="" (goto X64) else (goto X86)

 
:X64

copy /Y "%DeployServer%SCHook.dll" "C:\Program Files\uvnc bvba\UltraVNC\SCHook.dll"
copy /Y "%DeployServer%SCHook64.dll" "C:\Program Files\uvnc bvba\UltraVNC\SCHook64.dll"
copy /Y "%DeployServer%acl.txt" "C:\Program Files\uvnc bvba\UltraVNC\acl.txt"

start /wait %DeployServer%UltraVNC_1_2_12_X64_Setup.exe /verysilent /loadinf=%DeployServer%vncserver.inf /norestart
copy /Y "%DeployServer%ultravnc.ini" "C:\Program Files\uvnc bvba\UltraVNC\ultravnc.ini"
"%ProgramFiles%\uvnc bvba\UltraVNC\MSLogonACL.exe" /i /o "C:\Program Files\uvnc bvba\UltraVNC\acl.txt"

net stop uvnc_service
net start uvnc_service
rd /s /q "C:\ProgramData\Microsoft\Windows\Start Menu\Programs\UltraVNC\"
exit

 
:X86

copy /Y "%DeployServer%SCHook.dll" "C:\Program Files\uvnc bvba\UltraVNC\SCHook.dll"
copy /Y "%DeployServer%SCHook64.dll" "C:\Program Files\uvnc bvba\UltraVNC\SCHook64.dll"
copy /Y "%DeployServer%acl.txt" "C:\Program Files\uvnc bvba\UltraVNC\acl.txt"

start /wait %DeployServer%UltraVNC_1_2_12_X86_Setup.exe /verysilent /loadinf=%DeployServer%vncserver.inf /norestart
copy /Y "%DeployServer%ultravnc.ini" "C:\Program Files\uvnc bvba\UltraVNC\ultravnc.ini"
"%ProgramFiles%\uvnc bvba\UltraVNC\MSLogonACL.exe" /i /o "C:\Program Files\uvnc bvba\UltraVNC\acl.txt"

net stop uvnc_service
net start uvnc_service
rd /s /q "C:\ProgramData\Microsoft\Windows\Start Menu\Programs\UltraVNC\"
exit 

:SAIR
exit 