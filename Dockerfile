FROM jboss/wildfly:10.0.0.Final

ADD analista-ear/target/analista-ear.ear /opt/jboss/wildfly/standalone/deployments/
ADD configuracao/standalone.xml /opt/jboss/wildfly/standalone/configuration
ADD configuracao/oracle/main /opt/jboss/wildfly/modules/system/layers/base/com/oracle/main

ENTRYPOINT ["bash","-c","/opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0"]

