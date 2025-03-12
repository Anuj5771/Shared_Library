def call(String projectKey) {
    stage('SonarQube Scan') {
        withSonarQubeEnv('sonarQube-Server') {
            withCredentials([string(credentialsId: 'demo', variable: 'SONARQUBE_TOKEN')]) {
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
