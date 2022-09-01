echo off
echo 阿里发短信的
call mvn install:install-file  -Dfile=./lib/aliyun-java-sdk-dysmsapi-1.0.0.jar  -DgroupId=tio-aliyun -DartifactId=aliyun-java-sdk-dysmsapi -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true
call mvn install:install-file  -Dfile=./lib/alipay-sdk-java20180104135026.jar -Dsources=./lib/alipay-sdk-java20180104135026-source.jar  -DgroupId=tio-alipay -DartifactId=alipay-sdk-java -Dversion=20180104135026 -Dpackaging=jar -DgeneratePom=true

call mvn install:install-file  -Dfile=./lib/Sdk4J-2.0.jar  -DgroupId=net.gplatform -DartifactId=Sdk4J -Dversion=2.0 -Dpackaging=jar -DgeneratePom=true



set gid=org.aplus
set basepath=./lib
set tio_version=10.8.8

set aid=aplus-captcha
call mvn install:install-file  -Dfile=%basepath%/%aid%.jar  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=jar -DgeneratePom=true


cd .\WXPay-SDK-Java
call mvn -Dmaven.test.skip=true clean install
cd ..



rem 安装tio-ee
set gid=org.t-io
set basepath=./lib/tio-ee
set tio_version=3.7.1.v20210106-RELEASE


set aid=tio-core
call mvn install:install-file  -Dfile=%basepath%/%aid%.jar  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=jar -DpomFile=%basepath%/%aid%.pom

set aid=tio-flash-policy-server
call mvn install:install-file  -Dfile=%basepath%/%aid%.jar  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=jar -DpomFile=%basepath%/%aid%.pom

set aid=tio-http-common
call mvn install:install-file  -Dfile=%basepath%/%aid%.jar  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=jar -DpomFile=%basepath%/%aid%.pom

set aid=tio-http-parent
call mvn install:install-file  -Dfile=%basepath%/%aid%.pom  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=pom 


set aid=tio-http-server
call mvn install:install-file  -Dfile=%basepath%/%aid%.jar  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=jar -DpomFile=%basepath%/%aid%.pom

set aid=tio-parent
call mvn install:install-file  -Dfile=%basepath%/%aid%.pom  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=pom 

set aid=tio-utils
call mvn install:install-file  -Dfile=%basepath%/%aid%.jar  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=jar -DpomFile=%basepath%/%aid%.pom

set aid=tio-webpack-core
call mvn install:install-file  -Dfile=%basepath%/%aid%.jar  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=jar -DpomFile=%basepath%/%aid%.pom

set aid=tio-webpack-parent
call mvn install:install-file  -Dfile=%basepath%/%aid%.pom  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=pom 


set aid=tio-websocket-common
call mvn install:install-file  -Dfile=%basepath%/%aid%.jar  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=jar -DpomFile=%basepath%/%aid%.pom

set aid=tio-websocket-parent
call mvn install:install-file  -Dfile=%basepath%/%aid%.pom  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=pom 


set aid=tio-websocket-server
call mvn install:install-file  -Dfile=%basepath%/%aid%.jar  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=jar -DpomFile=%basepath%/%aid%.pom

set aid=tio-zoo-parent
call mvn install:install-file  -Dfile=%basepath%/%aid%.pom  -DgroupId=%gid% -DartifactId=%aid% -Dversion=%tio_version% -Dpackaging=pom 


call mvn install:install-file  -Dfile=./lib/5upay-sdk-java/5upay-sdk-core-1.0.0.jar  -DgroupId=tio-5upay -DartifactId=5upay-sdk-core -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true



call dir





call pause
