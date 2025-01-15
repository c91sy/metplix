repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm") version "1.9.24" // Kotlin 버전 설정 (이거 덕분에 디렉토리 src/main/kotlin 추천 가능)
//kotlin("dsl") // 2.0.0 부터 역따옴표 대신 kotlin() 함수 사용 가능하지만 버전을 명시하는게 좋다
// `kotlin-dsl` //1.0 옛날 버전 방식
}