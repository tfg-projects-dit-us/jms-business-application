Este repositorio se corresponde con el ejemplo 6 del tutorial de jbpm para aplicaciones empresariales
https://docs.jbpm.org/7.74.1.Final/jbpm-docs/html_single/#_business_application_with_jms
Está actualizado con algunos cambios:
Versión de sprint más actual
Eliminada opción de configuración en la base de datos (application.properties), que ha quedado obsoleta
Cambio en la seguridad de sprint (clase de configuración de seguridad actualizada)

Comando para iniciar el proceso que captura el mensaje:

curl --location --request POST 'http://localhost:8090/rest/server/containers/business-application-kjar/processes/catchsignalprocess/instances' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic d2JhZG1pbjp3YmFkbWlu'

Comando para iniciar el proceso que envía el mensaje:

curl --location 'http://localhost:8090/rest/server/containers/business-application-kjar/processes/throwsignalprocess/instances' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic d2JhZG1pbjp3YmFkbWlu' \
--data '{
  "input":"hola caracola"
}'
