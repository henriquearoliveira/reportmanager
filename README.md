# Report Manager
Api rest desenvolvida para simplificar e minimizar o trabalho envolto da compilação de relatórios com JasperReport.

É possível gerar no formato PDF e HTML, com o Strategy com os Enums para futuros formatos se assim for necessário.

Opção para gerar relatórios com mais de um .jasper, os subreports.

Não é armazenado qualquer credencial necessária para baixar, gerar e exportar os relatórios.

Após o procedimento todos os arquivos são excluídos.

Exemplo do json:

{
    "database": {
        "urlConnection": "jdbc:mysql://localhost:3306/databasename",
        "username": "username",
        "password": "password"
    },
    "ftp": {
        "hostFTP": "urlFtp",
        "username": "username",
        "password": "password",
        "port": 21,
        "pathReports": ["reportRootPath.jasper", "subReportRootPath.jasper"]
    },
    "params": {
        "paramID": 345
    },
    "typeFormat": "PDF"
}
