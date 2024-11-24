plugins {
	java
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(22)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-amqp")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	implementation ("io.prometheus:prometheus-metrics-core:1.0.0")
	implementation ("io.prometheus:prometheus-metrics-instrumentation-jvm:1.0.0")
	implementation ("io.prometheus:prometheus-metrics-exporter-httpserver:1.0.0")
	implementation("org.mapstruct:mapstruct:1.6.2")
	// https://mvnrepository.com/artifact/io.micrometer/micrometer-core
	implementation("io.micrometer:micrometer-core")
	// https://mvnrepository.com/artifact/io.micrometer/micrometer-registry-prometheus
	implementation("io.micrometer:micrometer-registry-prometheus")
	// https://mvnrepository.com/artifact/io.prometheus/simpleclient_pushgateway
	implementation("io.prometheus:simpleclient_pushgateway")
	// https://mvnrepository.com/artifact/org.aspectj/aspectjweaver
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.6.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.amqp:spring-rabbit-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
