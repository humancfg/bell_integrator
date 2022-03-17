# Jenkins
```bash
curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo tee \
  /usr/share/keyrings/jenkins-keyring.asc > /dev/null
```
```bash
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
```
```bash
sudo apt-get update
sudo apt-get install jenkins
```

## Jenkins plugins
- Allure
- Maven Integration
- GitHub Branch

## Job Config
### Source Code Management
Select radiobutton "git" and specify repository URL
### Build
#### Goals and options
install -pl task_2_1 
(need specify module)

### Post Build Actions
#### Allure Report
Path: task_2_1/allure-results

