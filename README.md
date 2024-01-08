# MailSystem

Este proyecto tiene como objetivo la generación de mails corporativos. Se podrá generar y restaurar contraseñas, determinar departamento correspondiente y visualizar nombre y mail.


Curls para usar en postman 

`
curl --location 'http://localhost:8080/user' \
--header 'Content-Type: application/json' \
--data-raw '{
"firstname": "EjemploNombre",
"lastname": "EjemploApellido",
"company": "EjemploEmpresa",
"department": "EjemploDepartamento",
"email": "ejemplo@email.com",
"smsNumber": "1234567890"
}'`
