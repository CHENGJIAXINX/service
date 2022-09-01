pwd

echo off
echo 阿里发短信的
mvn install:install-file  -Dfile=./lib/aliyun-java-sdk-dysmsapi-1.0.0.jar  -DgroupId=tio-aliyun -DartifactId=aliyun-java-sdk-dysmsapi -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true
mvn install:install-file  -Dfile=./lib/alipay-sdk-java20180104135026.jar -Dsources=./lib/alipay-sdk-java20180104135026-source.jar  -DgroupId=tio-alipay -DartifactId=alipay-sdk-java -Dversion=20180104135026 -Dpackaging=jar -DgeneratePom=true

mvn install:install-file  -Dfile=./lib/Sdk4J-2.0.jar  -DgroupId=net.gplatform -DartifactId=Sdk4J -Dversion=2.0 -Dpackaging=jar -DgeneratePom=true



gid=org.aplus
basepath=./lib
tio_version=10.8.8

aid=aplus-captcha
mvn install:install-file  -Dfile=${basepath}/${aid}.jar  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=jar -DgeneratePom=true

cd ./WXPay-SDK-Java
mvn -Dmaven.test.skip=true clean install
cd ..


# 安装tio-ee
gid=org.t-io
basepath=./lib/tio-ee
tio_version=3.7.1.v20210106-RELEASE

aid=tio-core
mvn install:install-file  -Dfile=${basepath}/${aid}.jar  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=jar -DpomFile=${basepath}/${aid}.pom

aid=tio-flash-policy-server
mvn install:install-file  -Dfile=${basepath}/${aid}.jar  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=jar -DpomFile=${basepath}/${aid}.pom

aid=tio-http-common
mvn install:install-file  -Dfile=${basepath}/${aid}.jar  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=jar -DpomFile=${basepath}/${aid}.pom

aid=tio-http-parent
mvn install:install-file  -Dfile=${basepath}/${aid}.pom  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=pom 


aid=tio-http-server
mvn install:install-file  -Dfile=${basepath}/${aid}.jar  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=jar -DpomFile=${basepath}/${aid}.pom

aid=tio-parent
mvn install:install-file  -Dfile=${basepath}/${aid}.pom  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=pom 

aid=tio-utils
mvn install:install-file  -Dfile=${basepath}/${aid}.jar  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=jar -DpomFile=${basepath}/${aid}.pom

aid=tio-webpack-core
mvn install:install-file  -Dfile=${basepath}/${aid}.jar  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=jar -DpomFile=${basepath}/${aid}.pom

aid=tio-webpack-parent
mvn install:install-file  -Dfile=${basepath}/${aid}.pom  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=pom 


aid=tio-websocket-common
mvn install:install-file  -Dfile=${basepath}/${aid}.jar  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=jar -DpomFile=${basepath}/${aid}.pom

aid=tio-websocket-parent
mvn install:install-file  -Dfile=${basepath}/${aid}.pom  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=pom 


aid=tio-websocket-server
mvn install:install-file  -Dfile=${basepath}/${aid}.jar  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=jar -DpomFile=${basepath}/${aid}.pom

aid=tio-zoo-parent
mvn install:install-file  -Dfile=${basepath}/${aid}.pom  -DgroupId=${gid} -DartifactId=${aid} -Dversion=${tio_version} -Dpackaging=pom 

mvn install:install-file  -Dfile=./lib/5upay-sdk-java/5upay-sdk-core-1.0.0.jar  -DgroupId=tio-5upay -DartifactId=5upay-sdk-core -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true

