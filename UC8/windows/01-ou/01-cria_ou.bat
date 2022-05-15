:: CRIA OU PRINCIPAL
dsadd ou "OU=CORE, DC=core, DC=intra" -desc "System Core"

:: CRIA SUB-OU
FOR /F "EOL=; TOKENS=1,* DELIMS=," %%I IN (02-SUB-OUs.TXT) DO dsadd ou "OU=%%I, OU=core,DC=core, DC=intra"
FOR /F "EOL=; TOKENS=1,* DELIMS=," %%I IN (deptos.TXT) DO dsadd ou "OU=%%I, OU=USERS, OU=core,DC=core, DC=intra"








