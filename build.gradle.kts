import com.linecorp.support.project.multi.recipe.configureByLabels

plugins {
    id("java")
//버전 관리를 외부에서 관리하기 위해서 사용(모듈마다 서로다른 버전의 라이브러리를 사용할 경우 의존성 충돌이 발생), 하드코딩을 줄이기위해 사용
//여러모듈 or 하위 플젝에서 일관된 버전을 쉽게 유지 (한 곳에서 버전 정보를 수정하면 모든 관련 프로젝트에 일관성 있게 반영)
    /*	id("org.springframework.boot") version "3.3.3"
        id("io.spring.dependency-management") version "1.1.7"*/
    id("org.springframework.boot") version Versions.SPRING_BOOT apply false
    id("io.spring.dependency-management") version Versions.SPRING_DEPENDENCY_MANAGEMENT_PLUGIN apply false
    id("io.freefair.lombok") version Versions.LOMBOK_PLUGIN apply false
    id("com.coditory.integration-test") version Versions.INTEGRATION_TEST_PLUGIN apply false
    id("com.epages.restdocs-api-spec") version Versions.RESTDOCS_API_SPEC apply false
    id("org.asciidoctor.jvm.convert") version Versions.ASCIIDOCTOR_PLUGIN apply false
    id("com.linecorp.build-recipe-plugin") version Versions.LINE_RECIPE_PLUGIN
}
//Gradle 빌드 스크립트에서 사용되는 블록으로, 프로젝트의 모든 하위 모듈에 대해 공통 설정을 적용할 때 사용
// 이 블록 내에서 정의된 설정은 해당 프로젝트와 그 하위 프로젝트들에 모두 적용
allprojects {
    group = "com.metplix"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        maven { url = uri("https://maven.restlet.com") }
        maven { url = uri("https://jitpack.io") }
    }
}

subprojects {
    apply(plugin = "idea")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))  // JUnit BOM 버전 관리
    testImplementation("org.junit.jupiter:junit-jupiter")      // JUnit Jupiter 의존성
}

//Gradle의 configureByLabels를 사용하여 Java 기반 모듈에 필요한 플러그인과 의존성을 효율적으로 설정하고,
// Spring Boot 및 테스트 관련 의존성을 통합하여 일관된 개발 환경을 구축하기 위해 작성
// 디렉토리 생성시 해당 레이블에 맞는 추천 항목이 IDE에서 자동으로 제공
configureByLabels("java") {
    apply(plugin = "org.gradle.java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "io.freefair.lombok")
    apply(plugin = "com.coditory.integration-test")

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:${Versions.SPRING_BOOT}")
            mavenBom("com.google.guava:guava-bom:${Versions.GUAVA}")
        }

        dependencies {
            dependency("org.apache.commons:commons-lang3:${Versions.APACHE_COMMONS_LANG}")
            dependency("org.apache.commons:commons-collections4:${Versions.APACHE_COMMONS_COLLECTIONS}")
            dependency("com.navercorp.fixturemonkey:fixture-monkey-starter:${Versions.FIXTURE_MONKEY}")
            dependency("org.mapstruct:mapstruct:${Versions.MAPSTRUCT}")
            dependency("org.mapstruct:mapstruct-processor:${Versions.MAPSTRUCT}")
            dependency("com.fasterxml.jackson.core:jackson-databind:${Versions.JACKSON_CORE}")

            dependency("org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT}")
            dependency("org.junit.jupiter:junit-jupiter-params:${Versions.JUNIT}")
            dependency("org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT}")
            dependency("org.assertj:assertj-core:${Versions.ASSERTJ_CORE}")
            dependency("org.mockito:mockito-junit-jupiter:${Versions.MOCKITO_CORE}")

            dependency("com.epages:restdocs-api-spec:${Versions.RESTDOCS_API_SPEC}")
            dependency("com.epages:restdocs-api-spec-mockmvc:${Versions.RESTDOCS_API_SPEC}")
            dependency("com.epages:restdocs-api-spec-restassured:${Versions.RESTDOCS_API_SPEC}")

            dependencySet("io.jsonwebtoken:${Versions.JWT}") {
                entry("jjwt-api")
                entry("jjwt-impl")
                entry("jjwt-jackson")
            }
        }
    }

    dependencies {
        val implementation by configurations
        val annotationProcessor by configurations

        val testImplementation by configurations
        val testRuntimeOnly by configurations

        val integrationImplementation by configurations
        val integrationRuntimeOnly by configurations

        implementation("com.google.guava:guava")

        implementation("org.apache.commons:commons-lang3")
        implementation("org.apache.commons:commons-collections4")
        implementation("org.mapstruct:mapstruct")

        annotationProcessor("org.mapstruct:mapstruct-processor")

        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testImplementation("org.assertj:assertj-core")
        testImplementation("org.junit.jupiter:junit-jupiter-params")
        testImplementation("org.mockito:mockito-core")
        testImplementation("org.mockito:mockito-junit-jupiter")
        testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

        integrationImplementation("org.junit.jupiter:junit-jupiter-api")
        integrationImplementation("org.junit.jupiter:junit-jupiter-params")
        integrationImplementation("org.assertj:assertj-core")
        integrationRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }
}

configureByLabels("boot") {
    apply(plugin = "org.springframework.boot")

    tasks.getByName<Jar>("jar") {
        enabled = false
    }

    tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
        mainClass.set("com.metplix.MetplixApiApplication") // 명시적으로 main class 지정
        enabled = true
        archiveClassifier.set("boot")
    } // 부트는 해당 모듈을 어플리케이션으로 만들때 필요
}

configureByLabels("library") {
    apply(plugin = "java-library")

    tasks.getByName<Jar>("jar") {
        enabled = true
    }
}

configureByLabels("asciidoctor") {
    apply(plugin = "org.asciidoctor.jvm.convert")

    tasks.named<org.asciidoctor.gradle.jvm.AsciidoctorTask>("asciidoctor") {
        sourceDir(file("src/docs"))
        outputs.dir(file("build/docs"))
        attributes(
            mapOf(
                "snippets" to file("build/generated-snippets")
            )
        )
    }
}

configureByLabels("restdocs") {
    apply(plugin = "com.epages.restdocs-api-spec")
}
//퍼시스턴스 레이아웃에서만 사용 할 수 있도록 분류
configureByLabels("querydsl") {
    // QueryDSL 의존성 추가
    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            mavenBom("com.querydsl:querydsl-bom:${Versions.QUERYDSL}")
        }

        dependencies {
            dependency("com.querydsl:querydsl-core:${Versions.QUERYDSL}")
            dependency("com.querydsl:querydsl-jpa:${Versions.QUERYDSL}")
            dependency("com.querydsl:querydsl-apt:${Versions.QUERYDSL}")
        }
    }

    dependencies {
        val implementation by configurations
        val annotationProcessor by configurations

        // QueryDSL 의존성
        implementation("com.querydsl:querydsl-jpa:${Versions.QUERYDSL}:jakarta")
        implementation("com.querydsl:querydsl-core:${Versions.QUERYDSL}")

        // Annotation Processor 의존성
        annotationProcessor("com.querydsl:querydsl-apt:${Versions.QUERYDSL}:jakarta")
        annotationProcessor("jakarta.persistence:jakarta.persistence-api")
        annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    }
}