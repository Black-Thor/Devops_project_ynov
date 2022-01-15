pipeline {
    agent any
       stages {
        stage('pass ssh file in chmod 600 for security') {
            steps { 
                sh "chmod 600  /var/terraform/ssh-files/project" 
          }
          stage('java app destroy') {
              steps{ 
                   sh "export ANSIBLE_CONFIG=/var/ansible/ansible.cfg "
                  sh "ansible-playbook  /var/ansible/playbook/vg_data_destroy.yml -i  /var/ansible/inventory/hosts" }
        }
        }
}