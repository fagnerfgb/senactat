Import-Module activedirectory
Import-CSV  C:\Scripts\03-groups\financeiro1.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-FINANCEIRO-R" -members $_.SamAccountName}
Import-CSV  C:\Scripts\03-groups\financeiro2.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-FINANCEIRO-W" -members $_.SamAccountName}
Import-CSV  C:\Scripts\03-groups\marketing1.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-MARKETING-R" -members $_.SamAccountName}
Import-CSV  C:\Scripts\03-groups\marketing2.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-MARKETING-W" -members $_.SamAccountName}
Import-CSV  C:\Scripts\03-groups\rh1.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-RH-R" -members $_.SamAccountName}
Import-CSV  C:\Scripts\03-groups\rh2.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-RH-W" -members $_.SamAccountName}
Import-CSV  C:\Scripts\03-groups\ti1.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-TI-R" -members $_.SamAccountName}
Import-CSV  C:\Scripts\03-groups\ti2.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-TI-W" -members $_.SamAccountName}
Import-CSV  C:\Scripts\03-groups\vendas1.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-VENDAS-R" -members $_.SamAccountName}
Import-CSV  C:\Scripts\03-groups\vendas2.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-VENDAS-W" -members $_.SamAccountName}
Import-CSV  C:\Scripts\03-groups\remote-desktop.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-TI-REMOTE-DESKTOP" -members $_.SamAccountName}
Import-CSV  C:\Scripts\03-groups\remote-desktop.csv -Header SamAccountName | ForEach-Object {Add-AdGroupMember -Identity "G-CORE-TI-VNC" -members $_.SamAccountName}