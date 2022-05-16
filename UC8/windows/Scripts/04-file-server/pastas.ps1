New-Item 'f:\Financeiro' -ItemType Directory
New-Item 'f:\Marketing' -ItemType Directory
New-Item 'f:\Publica' -ItemType Directory
New-Item 'f:\RH' -ItemType Directory
New-Item 'f:\Tecnologia' -ItemType Directory
New-Item 'f:\Vendas' -ItemType Directory
New-Item 'f:\Home' -ItemType Directory

New-SMBShare –Name Financeiro –Path "f:\Financeiro" -ChangeAccess "Domain Users"
New-SMBShare –Name Marketing –Path "f:\Marketing" -ChangeAccess "Domain Users"
New-SMBShare –Name Publica –Path "f:\Publica" -ChangeAccess "Domain Users"
New-SMBShare –Name RH –Path "f:\RH" -ChangeAccess "Domain Users"
New-SMBShare –Name Tecnologia –Path "f:\Tecnologia" -ChangeAccess "Domain Users"
New-SMBShare –Name Vendas –Path "f:\Vendas" -ChangeAccess "Domain Users"
New-SMBShare –Name Home$ –Path "f:\Home" -ChangeAccess "Domain Users"

(Get-ACL -Path "F:\Financeiro").Access | Format-Table IdentityReference, FileSystemRights, AccessControlType, IsInherited, InheritanceFlags -AutoSize

$ACL = Get-ACL -Path "F:\Financeiro"
$ACE = New-Object System.Security.AccessControl.FileSystemAccessRule("G-CORE-FINANCEIRO-R","ReadAndExecute","ContainerInherit, ObjectInherit","None","Allow")
$ACL.SetAccessRule($ACE)
Set-Acl -Path "F:\Financeiro" -AclObject $ACL

$ACL = Get-ACL -Path "F:\Financeiro"
$ACE = New-Object System.Security.AccessControl.FileSystemAccessRule("G-CORE-FINANCEIRO-W","Modify","ContainerInherit, ObjectInherit","None","Allow")
$ACL.SetAccessRule($ACE)
Set-Acl -Path "F:\Financeiro" -AclObject $ACL


(Get-ACL -Path "F:\Marketing").Access | Format-Table IdentityReference, FileSystemRights, AccessControlType, IsInherited, InheritanceFlags -AutoSize

$ACL = Get-ACL -Path "F:\Marketing"
$ACE = New-Object System.Security.AccessControl.FileSystemAccessRule("G-CORE-Marketing-R","ReadAndExecute","ContainerInherit, ObjectInherit","None","Allow")
$ACL.SetAccessRule($ACE)
Set-Acl -Path "F:\Marketing" -AclObject $ACL

$ACL = Get-ACL -Path "F:\Marketing"
$ACE = New-Object System.Security.AccessControl.FileSystemAccessRule("G-CORE-Marketing-W","Modify","ContainerInherit, ObjectInherit","None","Allow")
$ACL.SetAccessRule($ACE)
Set-Acl -Path "F:\Marketing" -AclObject $ACL

(Get-ACL -Path "F:\RH").Access | Format-Table IdentityReference, FileSystemRights, AccessControlType, IsInherited, InheritanceFlags -AutoSize

$ACL = Get-ACL -Path "F:\RH"
$ACE = New-Object System.Security.AccessControl.FileSystemAccessRule("G-CORE-RH-R","ReadAndExecute","ContainerInherit, ObjectInherit","None","Allow")
$ACL.SetAccessRule($ACE)
Set-Acl -Path "F:\RH" -AclObject $ACL

$ACL = Get-ACL -Path "F:\RH"
$ACE = New-Object System.Security.AccessControl.FileSystemAccessRule("G-CORE-RH-W","Modify","ContainerInherit, ObjectInherit","None","Allow")
$ACL.SetAccessRule($ACE)
Set-Acl -Path "F:\RH" -AclObject $ACL


(Get-ACL -Path "F:\Tecnologia").Access | Format-Table IdentityReference, FileSystemRights, AccessControlType, IsInherited, InheritanceFlags -AutoSize

$ACL = Get-ACL -Path "F:\Tecnologia"
$ACE = New-Object System.Security.AccessControl.FileSystemAccessRule("G-CORE-TI-R","ReadAndExecute","ContainerInherit, ObjectInherit","None","Allow")
$ACL.SetAccessRule($ACE)
Set-Acl -Path "F:\Tecnologia" -AclObject $ACL

$ACL = Get-ACL -Path "F:\Tecnologia"
$ACE = New-Object System.Security.AccessControl.FileSystemAccessRule("G-CORE-TI-W","Modify","ContainerInherit, ObjectInherit","None","Allow")
$ACL.SetAccessRule($ACE)
Set-Acl -Path "F:\Tecnologia" -AclObject $ACL


(Get-ACL -Path "F:\Vendas").Access | Format-Table IdentityReference, FileSystemRights, AccessControlType, IsInherited, InheritanceFlags -AutoSize

$ACL = Get-ACL -Path "F:\Vendas"
$ACE = New-Object System.Security.AccessControl.FileSystemAccessRule("G-CORE-Vendas-R","ReadAndExecute","ContainerInherit, ObjectInherit","None","Allow")
$ACL.SetAccessRule($ACE)
Set-Acl -Path "F:\Vendas" -AclObject $ACL

$ACL = Get-ACL -Path "F:\Vendas"
$ACE = New-Object System.Security.AccessControl.FileSystemAccessRule("G-CORE-Vendas-W","Modify","ContainerInherit, ObjectInherit","None","Allow")
$ACL.SetAccessRule($ACE)
Set-Acl -Path "F:\Vendas" -AclObject $ACL


(Get-ACL -Path "F:\Publica").Access | Format-Table IdentityReference, FileSystemRights, AccessControlType, IsInherited, InheritanceFlags -AutoSize

$ACL = Get-ACL -Path "F:\Publica"
$ACE = New-Object System.Security.AccessControl.FileSystemAccessRule("Domain Users","Modify","ContainerInherit, ObjectInherit","None","Allow")
$ACL.SetAccessRule($ACE)
Set-Acl -Path "F:\Publica" -AclObject $ACL

