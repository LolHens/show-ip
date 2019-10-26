FROM oracle/graalvm-ce
MAINTAINER LolHens <pierrekisters@gmail.com>


ENV SHOW_IP_VERSION 0.1.0
ENV SHOW_IP_NAME show-ip
ENV SHOW_IP_FILE ${SHOW_IP_NAME}-${SHOW_IP_VERSION}.sh.bat
ENV SHOW_IP_URL https://github.com/LolHens/show-ip/releases/download/$SHOW_IP_VERSION/$SHOW_IP_FILE
ENV SHOW_IP_HOME /opt/$SHOW_IP_NAME

ENV CLEANIMAGE_VERSION 1.0
ENV CLEANIMAGE_URL https://raw.githubusercontent.com/LolHens/docker-cleanimage/$CLEANIMAGE_VERSION/cleanimage


ADD ["$CLEANIMAGE_URL", "/usr/local/bin/"]
RUN chmod +x "/usr/local/bin/cleanimage"

RUN mkdir -p $SHOW_IP_HOME \
 && cd $SHOW_IP_HOME \
 && curl -oL $SHOW_IP_URL


EXPOSE 8080
WORKDIR $SHOW_IP_HOME
CMD ./$SHOW_IP_FILE
