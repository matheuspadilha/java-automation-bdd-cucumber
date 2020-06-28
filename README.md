## Projeto simples de automação com BDD

Neste projeto, execute a _**RunnerTest**_, um teste automatizado que interage com o site do srbarriga e possui o cenário inserir uma conta, adicionar uma conta sem nome e adicionar outra com o mesmo nome.  
**URL**: https://srbarriga.herokuapp.com  
Neste projeto foi utilizado algumas tecnicas de TDD, onde com base nas features, foram desenvolvidos as funcionalidade e depois foi feito um pequeno refactor.  
 
Apresentado no durante o curso: https://www.udemy.com/course/cucumber-java/

#### :sparkles: Tecnologias  
:heavy_check_mark: **Java**    
:heavy_check_mark: **JUnit**  
:heavy_check_mark: **Cucumber**    
:heavy_check_mark: **Selenium WebDriver** com driver do **chrome** e **firefox** ja implementado.  

|-Por default o driver do chrome já esta setado.  

Na feature, possui um exemplo de cenário tradicional, cenário imperativo e cenŕio declarativo.  
O mesmo se encontram em:   
|- src/test/resources/Features

Pelas configurações no _**RunnerTest**_, é possivel gerar um relatório em HTML com as informações dos testes, além da criação de um JSON com as informações dos testes.    
Os mesmo se encontram em:   
|- **HTML** -> target/report-html/index.html    
|- **JSON** -> target/report.json  

#### :vertical_traffic_light: Requisitos 
Idea: **Eclipse** ou **IntelliJ**  
Versão: **Java 8**
