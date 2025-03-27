import org.ansible.*
def call(Map params) {
    pipeline {
        agent any
        tools {
            ansible 'ansible'
        }
        environment {
            Playbook_Path = "${params.Playbook_Path}"
            Inventory_path = "${params.Inventory_path}"
            key_path = "${params.key_path}"
            email_recipients = "${params.email_recipients}"
            channel_name = "${params.channel_name}"
            branch_name = "${params.branch_name}"
            repoUrl = "${params.repoUrl}"
            gitPassword = "${params.gitPassword}" 
            AWS_ACCESS_KEY_ID = credentials('AWS_ACCESS_KEY_ID')
            AWS_SECRET_ACCESS_KEY = credentials('AWS_SECRET_ACCESS_KEY')
        }
        
        stages {
            stage('Clean Workspace') {
                steps {
                    script {
                        new CleanWorkspace()
                    }
                }
            }

            stage('Clone Repository') {
               steps {
                   script {
                       def cloneRepo = new CloneRepo() // Create an instance
                       cloneRepo(params.branch_name, params.repoUrl, params.gitPassword) // Call method
                   }
               }
           }

            stage('Run Ansible Playbook') {
                steps {
                    script {
                        def RunAnsible = new RunAnsible()(env.Inventory_path, env.Playbook_Path, env.key_path)
                    }
                }
            }
        
        stage('Notifir') {
                steps {
                    script {
                        def Notifications = new Notifications()
                        Notifications(env.JOB_NAME, env.BUILD_NUMBER, env.BUILD_URL, env.email_recipients, env.channel_name, true)
                    }
                }
            }
        }
    }
}
