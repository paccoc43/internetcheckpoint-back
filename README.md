# MNTPA_SANIDAD_REGTUM_BACK

## Arranque para DEV

    $ mvn spring-boot:run -Pdev

[http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)

## Documentacion del API
La documentaciÃ³n en formato OpenAPI estÃ¡ disponible [aqui](http://localhost:8080/swagger-ui.html)

## Despliegue en JBoss EAP (local)

    $ vagrant up
    $ mvn clean wildfly:deploy

* Si despues de varios despliegues aparece un outofmemoryerror, hay que entrar en vagrant y reiniciar jboss

    $ vagrant ssh
    $ systemctl stop jboss-as
    $ systemctl start jboss-as

    
[https://localhost/regtum-back/actuator/health](https://localhost/regtum-back/actuator/health)     

## Despliegue en JBoss EAP (consolidacion)

    $ mvn wildfly:undeploy wildfly:deploy-only -Dwildfly.hostname=172.30.4.1 -Dwildfly.port=9999 -Djboss-as.username=jbadmin -Djboss-as.password=Password1$ -Dwildfly.serverGroups=desa2backc1s3
 
[https://desaapps1.sespa.es/regtum-back/actuator/health](https://desaapps1.sespa.es/regtum-back/actuator/health)

## Empaquetado para JBoss EAP

    $ mvn clean package