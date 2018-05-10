# Twittelum 

## Como esse projeto está estruturado até o momento 

### Modelos

 * Usuario 
 * Tweet
 * Curtida
 
### Controller

  * TweetController 
  
    - responsavel por todas as interações entre o device e o servidor para falar sobre tweets
 
  * CurtidaController
  
    - responsavel por curtir ou descurtir um tweet
    
        
  * UsuarioController
  
    - responsavel por criar e logar usuarios
        
    
### Task

   * AtualizadorTask
    
       - responsavel por ressucitar o servidor a cada 10 minutos no heroku
       - responsavel por limpar os tweets a cada mês
     
 ## Especificações do projeto
 
   * Spring Boot 
   * Spring Data
   * MySQL
   
    - Todas as configurações estão no application.properties