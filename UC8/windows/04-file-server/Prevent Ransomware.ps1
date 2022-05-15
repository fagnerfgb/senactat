## Script Powershell 
## Objetivo: Criar File Groups para Proteger Servidores de File Server
## 


## Verifica se o FS-Resource-Manager esta instalado
Get-WindowsFeature -Name FS-Resource-Manager

###
###

Install-WindowsFeature FS-Resource-Manager -IncludeManagementTools

###
new-FsrmFileGroup -name "Anti-Ransomware File Groups" -IncludePattern @((Invoke-WebRequest -Uri "https://fsrm.experiant.ca/api/v1/combined").content | convertfrom-json | % {$_.filters})

