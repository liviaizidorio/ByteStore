# Usar a imagem oficial do OpenJDK 21
FROM eclipse-temurin:21-jdk

# Definir diretório de trabalho
WORKDIR /app

# Copiar o JAR do seu projeto para dentro do contêiner
COPY target/byteStore-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta da aplicação (mude se necessário)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
