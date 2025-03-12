def call() {

    node {
        stage('Install Dependencies') {
            sh 'npm install'   
        }

        stage('Build') {
            sh 'npm run build' 
        }
    }

}
