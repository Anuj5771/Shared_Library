def call() {
    stage('Install Dependencies') {
        sh 'npm install'
    }
    
    stage('Build React App') {
        sh 'npm run build'
    }
}

