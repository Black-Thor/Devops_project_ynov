#
# Jenkins customized image
#
# Usage:
#   Build -> docker build -t jenkins-cust .
#   Run -> docker run --name myjenkins -p 8080:8080 -p 50000:50000 jenkins-cust
#
FROM jenkins/jenkins:lts-jdk11
MAINTAINER Stephane Duboze

# Disable setup wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false -Dpermissive-script-security.enabled=true
#
#ENV JENKINS_USER admin
#ENV JENKINS_PASS ThisIs@StrongP@ssword

USER root
RUN apt-get update && \
    apt-get -y install apt-transport-https \
      ca-certificates \
      curl \
      gnupg2 \
      software-properties-common && \
    curl -fsSL https://download.docker.com/linux/$(. /etc/os-release; echo "$ID")/gpg > /tmp/dkey; apt-key add /tmp/dkey && \
    add-apt-repository \
      "deb [arch=amd64] https://download.docker.com/linux/$(. /etc/os-release; echo "$ID") \
      $(lsb_release -cs) \
      stable" && \
   apt-get update && \
   apt-get -y install docker-ce
#installation terraform
RUN curl -fsSL https://apt.releases.hashicorp.com/gpg | apt-key add - && apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main" && apt-get update && apt-get install terraform

#installation ansible
RUN apt-get install python3-pip -y && \
  pip3 install ansible 
#install boto3 for inventory dynamic
RUN pip3 install boto3
#Install LVM for lvol and lvg volumes
RUN ansible-galaxy collection install community.general
# Load plugins w jenkins-plugin-cli
COPY --chown=jenkins:jenkins jenkins/conf/plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt

USER jenkins
# Jenkins runs all grovy files from init.groovy.d dir
##COPY --chown=jenkins:jenkins conf/scripts/admin-user.groovy /usr/share/jenkins/ref/init.groovy.d/
##VOLUME /var/jenkins_home