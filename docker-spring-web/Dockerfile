
FROM openjdk:8

#作者
MAINTAINER wangjiankai <18616537606@163.com>

#系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

#应用构建成功后的jar文件被复制到镜像内，名字也改成了app.jar
ADD target/docker-spring-web-0.0.1-SNAPSHOT.jar app.jar

#启动容器时的进程
ENTRYPOINT ["java","-jar","/app.jar"]

#暴露8080端口
EXPOSE 7777
