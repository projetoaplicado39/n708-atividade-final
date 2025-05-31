# Estágio de construção
FROM maven:3.9.9-amazoncorretto-24 AS build
WORKDIR /app
COPY pom.xml .
# Baixa todas as dependências primeiro para aproveitar o cache do Docker
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

# Estágio de execução
FROM amazoncorretto:24-alpine
WORKDIR /app

# Variáveis de ambiente para configuração do Java e MongoDB
ENV JAVA_OPTS="-Xms512m -Xmx1024m"
ENV SERVER_PORT=8080
ENV MONGODB_URI="mongodb+srv://admin:PH2iIiPDX8bwfeJb@cluster-multiplataforma.rscj0fx.mongodb.net/db-user"

# Criar um usuário não-root para executar a aplicação
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiar apenas o JAR gerado do estágio de construção
COPY --from=build /app/target/*.jar app.jar

# Porta que a aplicação expõe (configurada para 8080 conforme application.properties)
EXPOSE 8080

# Comando para iniciar a aplicação com as configurações de ambiente
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar \
  --server.port=$SERVER_PORT \
  --spring.data.mongodb.uri=$MONGODB_URI "]