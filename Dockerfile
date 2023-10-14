# Stage de build : construire le WAR de l'application
FROM gradle:jdk17-alpine as build

# Ne pas exécuter Gradle en tant que daemon
ENV GRADLE_OPTS="-Dorg.gradle.daemon=false"

# Copier les sources
COPY . /home/gradle/src
WORKDIR /home/gradle/src

# Construire le WAR
RUN gradle clean war --no-daemon

# Stage de déploiement : basé sur l'image WildFly
FROM quay.io/wildfly/wildfly:latest-jdk17

# Copier le WAR du stage de build précédent
COPY --from=build /home/gradle/src/build/libs/*.war /opt/jboss/wildfly/standalone/deployments/
