package org.ansible

def call(String branch, String repoUrl, String credentialsId) {
    stage('CloneRepo') {
       checkout([$class: 'GitSCM',
            branches: [[name: "*/${branch}"]],
            userRemoteConfigs: [[url: repoUrl, credentialsId: credentialsId]]
        ])
        println "Repository cloned: ${repoUrl} (Branch: ${branch})"
    }
}
