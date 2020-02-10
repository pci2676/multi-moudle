# multi-moudle
gradle 멀티 모듈 예제

## 설정
 - settings.gradle

    - rootProject.name = 'multi-module'  
    rootProject.name : 루트 프로젝트의 이름을 적는다.
    - include 'module-api'  
    include : 자식 모듈의 이름을 적어주자.
    
 - subprojects

    - settings.gradle 에 속한 모든 프로젝트에게 공통적으로 적용되는 옵션 예시 
        ```groovy
        	group 'com.example'
        	version '1.0'
        
        	apply plugin: 'java'
        	apply plugin: 'org.springframework.boot'
        	apply plugin: 'io.spring.dependency-management'
        
        	sourceCompatibility = 1.8
        
        	repositories {
        		mavenCentral()
        	}
        
        	dependencies {
        		implementation('org.projectlombok:lombok')
        		annotationProcessor ('org.projectlombok:lombok')
        
        		implementation 'org.junit.jupiter:junit-jupiter'
        		testCompile group: 'org.assertj', name: 'assertj-core', version: '3.14.0'
        	}
        
        	test {
        		useJUnitPlatform()
        	}
        ```
    
- 각 모듈은 dependencies 만 가지고 있는다.

- Main 메소드가 존재하지 않는 모듈은 아래 두줄을 추가해 두자

    ```groovy
    bootJar { enabled = false }
    jar { enabled = true }
    ```

- 루트 모듈에서 하위 모듈에 대한 의존성관리를 따로 할수 있다.

    ```groovy
    //하위 프로젝트간의 의존성 관리
    project(':module-api') {
    	dependencies {
    		compile project(":module-core")
    	}
    }
    ```

    

