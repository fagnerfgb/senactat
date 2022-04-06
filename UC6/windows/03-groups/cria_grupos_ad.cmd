:: CRIA GRUPOS BASEADO EM ARQUIVO
FOR /F "EOL=; TOKENS=1,2,* DELIMS=," %%I IN (grupos.txt) DO dsadd group "CN=%%I,OU=GROUPS,OU=BRAGA,DC=BRAGA,DC=INTRA" -samid %%I -secgrp yes -scope g

