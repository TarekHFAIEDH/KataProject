Les services 

Add User et authenticate : deux services pour générer un token 

* Add User : 

  -http://localhost:8080/register
  -Post
  -Body   : {"username":"tarek" ,"password":"password"}
 ===> User ajouté 

* Authenticate : 

  -http://localhost:8080/register
  -Post
  -Body   : {"username":"tarek" ,"password":"password"}
 ===> token genéré

Deposit : 

  -URL : http://localhost:8080/KataServices/deposit
  -PUT
  -Body   : {"amount":1000}
  -ajouter token dans le header.
 ===> opération de type diposit est ajoutée


Withdrawal: 

  -URL : http://localhost:8080/KataServices/withdrawal
  -PUT
  -Body   : {"amount":1000}
  -ajouter token dans le header.
 ===> opération de type Withdrawal: est ajoutée.

Operations : 
  -URL : http://localhost:8080/services/operations
  -PUT
  -ajouter token dans le header.
