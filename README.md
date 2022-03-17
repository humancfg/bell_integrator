# [Jenkins](https://www.jenkins.io/doc/book/installing/linux/)


## Jenkins plugins
- Allure
- Maven Integration
- GitHub Branch

# Job Config

## Source Code Management:
Select radiobutton "git" and specify repository URL 

## Build:
### Goals and options (need specify module)
`install -pl task_2_1` 

## Post Build Actions:
### Allure Report (need specify module path)
Path: `task_2_1/allure-results`

