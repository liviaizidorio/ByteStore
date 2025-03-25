# Usa uma imagem do OpenJDK 21 como base
FROM eclipse-temurin:21-jdk-alpine

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR gerado para o contêiner
COPY target/*.jar app.jar

# Expõe a porta usada pelo Spring Boot (padrão 8080)
EXPOSE 8080

# Define o comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
