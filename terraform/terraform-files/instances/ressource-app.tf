resource "aws_instance" "app_instance" {
  count                  = var.instance_count
  ami                    = var.ec2_ami
  key_name = var.ssh_key_name
  instance_type          = var.ec2_instance
  vpc_security_group_ids = [aws_security_group.moustache.id]
  associate_public_ip_address = "true"
  user_data                   = data.template_file.user_data.rendered


  tags                        = {
    Name        = "${var.env}-Duboze-Stephane-${count.index}"
    Environment = var.env
    Groups      = "app"
    Owner       = "stephane.duboze@ynov.com"
  }
}

resource "aws_key_pair" "deployer" {

  tags                        = {
    Name = "Duboze-Stephane"
  }
  key_name               = var.ssh_key_name
  public_key             = file("../../ssh-files/project.pub")
}

data "template_file" "user_data" {
  template = file("../scripts/add-ssh-web-app.yaml")
}