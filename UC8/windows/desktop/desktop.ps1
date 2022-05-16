# Abrir o PowerShell como Administrador
# Executar comando abaixo para instalação do Chocolatey
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))

#Instalação dos aplicativos padrão da System Core
choco install -Y firefox adobereader -params '" /UpdateMode:3"' 7zip.install git vcredist-all notepadplusplus.install putty vlc vscode googlechrome microsoft-edge

#Remoção de Bloatware
iex ((New-Object System.Net.WebClient).DownloadString('https://git.io/JJ8R4'))