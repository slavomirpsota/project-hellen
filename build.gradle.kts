plugins {
    java
    application
}

group = "sk.tuke.kpi.oop"
version = "1.0"

val gamelibVersion = "2.6.1"

repositories {
    mavenCentral()
    maven(url=uri("https://repo.kpi.fei.tuke.sk/repository/maven-public"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

application {
    mainClassName = "sk.tuke.kpi.oop.game.Main"
}

dependencies {
    implementation("sk.tuke.kpi.gamelib:gamelib-framework:$gamelibVersion")
}

tasks {
    withType<JavaCompile> {
        options.compilerArgs.plusAssign("-parameters")
    }
}
