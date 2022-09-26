val kotlin_version = "1.7.0"
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("gradle.plugin.com.github.johnrengelman:shadow:7.1.2")
    }
}
plugins {

    kotlin("jvm") version "1.7.0"
    id("org.jetbrains.dokka") version "1.4.32"
    id("maven-publish")
    application
}
apply(plugin = "com.github.johnrengelman.shadow")
tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("${rootProject.name}.jar")
}

val projectMainClass = "AppKt"
tasks.withType<Jar> {
    manifest {
        attributes(mapOf(
            "Main-Class" to projectMainClass
        ))
    }
}

application {
    mainClass.set(projectMainClass)
}


repositories {
    mavenCentral()
}

dependencies {
    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api("org.jetbrains.kotlin:kotlin-stdlib:${kotlin_version}")
    api("org.jetbrains.kotlin:kotlin-reflect:${kotlin_version}")
    api("org.jetbrains.kotlin:kotlin-test:${kotlin_version}")
}

lateinit var sourcesArtifact: PublishArtifact
lateinit var javadocArtifact: PublishArtifact

typealias Shadowjar = com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

tasks {
    val sourcesJar by creating(Shadowjar::class) {
        archiveClassifier.set("sources")
        from(
            sourceSets["main"].java.srcDirs,
//            sourceSets["main"].kotlin.srcDirs
        )
    }
    val dokkaHtml by getting(org.jetbrains.dokka.gradle.DokkaTask::class)
    val javadocJar by creating(Shadowjar::class) {
        dependsOn(dokkaHtml)
        archiveClassifier.set("javadoc")
        from(dokkaHtml.outputDirectory)
    }
    artifacts {
        sourcesArtifact = archives(sourcesJar)
        javadocArtifact = archives(javadocJar)
    }
}

subprojects {
    apply(plugin = "maven-publish")


    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                val repo = findProperty("GITHUB_REPOSITORY")

                url = uri("https://maven.pkg.github.com/$repo")
                credentials {

                    username = findProperty("GITHUB_ACTOR") as? String
                    password = findProperty("GITHUB_TOKEN") as? String
                }
            }
        }
        publications {
            register<MavenPublication>(project.name) {
                groupId = this.groupId
                artifactId = project.name
                version = project.version.toString()
                artifact(sourcesArtifact)
                artifact(javadocArtifact)
            }
        }

    }


}