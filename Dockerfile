FROM toolsnexus.marchex.com:5000/azul/zulu-openjdk:8

ENV JAVA_HOME=/usr/lib/jvm/zulu-8-amd64
ENV WORKING_DIRECTORY=/opt/swagner-demo

WORKDIR ${WORKING_DIRECTORY}
ADD target/swagner-demo*.jar swagner-demo.jar

CMD  java \
      -Droot=${WORKING_DIRECTORY} \
      -Duser.timezone=UTC \
      -Dfile.encoding=UTF8 \
      -Xmx2g \
      -jar swagner-demo.jar
