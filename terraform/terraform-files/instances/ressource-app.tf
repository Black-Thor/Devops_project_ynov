resource "aws_instance" "app_instance" {
  ami                    = var.ec2_ami
  key_name = var.ssh_key_name
  instance_type          = var.ec2_instance
  vpc_security_group_ids = [aws_security_group.SD_devops.id]
  associate_public_ip_address = "true"
  user_data                   = data.template_file.user_data.rendered


  tags                        = {
    Name        = "${var.env}-Duboze-Stephane"
    Environment = var.env
    Groups      = "app"
    Owner       = "stephane.duboze@ynov.com"
  }
}

resource "aws_key_pair" "deployer" {

  tags = {
    Name = "Duboze-Stephane"
  }
  key_name               = var.ssh_key_name
  public_key             = file("../../ssh-files/project.pub")
}

data "template_file" "user_data" {
  template = file("../scripts/add-ssh-web-app.yaml")
}

#Attache the new Volume to the instance 
resource "aws_volume_attachment" "ebs_att" {
  device_name = "/dev/sdh"
  volume_id   = aws_ebs_volume.data-vol.id
  instance_id = aws_instance.app_instance.id
}
#Create The ebs Volume  
resource "aws_ebs_volume" "data-vol" {
  availability_zone = aws_instance.app_instance.availability_zone
  size  = 1
  tags = {
        Name = "data-volume"
  }
}
