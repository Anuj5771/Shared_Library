def call(String projectKey) {
    stage('SonarQube Scan') {
        withSonarQubeEnv('sonar') {
            withCredentials([string(credentialsId: 'attendance', variable: 'SONARQUBE_TOKEN')]) {
                sh """
                mvn sonar:sonar \
                -Dsonar.projectKey=${env.SONAR_PROJECT_KEY} \
                -Dsonar.host.url=${env.SONARQUBE_URL} \
                -Dsonar.login=${SONARQUBE_TOKEN}
                """
            }
        }
    }
}
