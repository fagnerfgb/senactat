import-module -name grouppolicy
Backup-GPO -all -Path "C:\GPO" | Export-Csv "C:\GPO\gpos.csv" 