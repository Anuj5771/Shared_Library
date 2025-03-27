package org.ansible
class DeployPostgres {
    def deploy(pipeline) {
        pipeline.sh "ansible-playbook -i aws_ec2.yml deploy_postgres.yml"
    }
}
