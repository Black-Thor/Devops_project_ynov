pipeline {
    agent any
    stages {
        stage('List ec2 inventory of Stephane Duboze') {
            steps { 
                dir("/var/ansible/inventory") { 
                sh "ansible-inventory -i aws_ec2.yaml --host tag_Owner_stephane_duboze_ynov_com" 
                }
          }
        }
    }
}