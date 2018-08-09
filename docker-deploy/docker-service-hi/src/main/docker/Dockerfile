# FROM
# 1   FROM <image>
# 2   FROM <image>:<tag>
# 3   FROM <image> <digest>
# FROM指令必须指定且需要在Dockerfile其他指令的前面，指定的基础image可以是官方远程仓库中的，也可以位于本地仓库。后续的指令都依赖于该指令指定的image。当在同一个Dockerfile中建立多个镜像时，可以使用多个FROM指令。
# VOLUME
# 格式为：
# 1   VOLUME ["/data"]
# 使容器中的一个目录具有持久化存储数据的功能，该目录可以被容器本身使用，也可以共享给其他容器。当容器中的应用有持久化数据的需求时可以在Dockerfile中使用该指令。
# ADD
# 从src目录复制文件到容器的dest。其中src可以是Dockerfile所在目录的相对路径，也可以是一个URL，还可以是一个压缩包
# ENTRYPOINT
# 指定Docker容器启动时执行的命令，可以多次设置，但是只有最后一个有效。
# EXPOSE
# 为Docker容器设置对外的端口号。在启动时，可以使用-p选项或者-P选项。

FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD docker-service-hi-0.0.1-SNAPSHOT.jar app.jar
#RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8763