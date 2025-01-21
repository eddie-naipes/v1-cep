# Use a imagem base do OpenJDK slim para otimizar o tamanho
FROM openjdk:21-jdk-slim

# Atualize os pacotes e instale o cliente do PostgreSQL
RUN apt-get update && apt-get install -y --no-install-recommends \
    wget \
    gnupg \
    && echo "deb [signed-by=/usr/share/keyrings/postgres.gpg] http://apt.postgresql.org/pub/repos/apt bookworm-pgdg main" > /etc/apt/sources.list.d/pgdg.list \
    && wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | gpg --dearmor -o /usr/share/keyrings/postgres.gpg \
    && apt-get update \
    && apt-get install -y --no-install-recommends postgresql-client-17 \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR da aplicação para o contêiner
COPY build/libs/*.jar app.jar

# Exponha a porta da aplicação
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
