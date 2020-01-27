use manage_em_home;

#criar dois tipos de roles, pais e filhos
insert into Relationship_Role(id_role,name_role) values (1,"Parent");
insert into Relationship_Role(id_role,name_role) values (2,"Kid");

## create parent
 insert into User (role, username, name, age) values(1,'Fernando','fernando','2019-12-02');
 insert into Password(id_Password, password) values ((select id_User from User where username = 'fernando'), '123');

## create kid
insert into User(role, username, name, age) values(2,'Filho1','filho1','1995-09-22');
insert into Kid (id_Kid, pts_Kid, FirstTime) values ((select id_User from User where username = 'filho1'),0,true);
insert into Password(id_Password, password) values ((select id_User from User where username = 'filho1'), '123');

insert into User(role, username, name, age) values(2,'Filho2','filho2','1995-09-22');
insert into Kid (id_Kid, pts_Kid, FirstTime) values ((select id_User from User where username = 'filho2'),0,true);
insert into Password(id_Password, password) values ((select id_User from User where username = 'filho2'), '123');
## Create task
insert into Task (name, frequency_type, description, duration, pts_Task) values('lavar a loiça','One Time','bem lavada',3600,10);
## saber qual pai criou a task
Insert into Parents_Task (parent, Task) values (1,1);
## atribuir a task a um filho
Insert into Kids_Task (kid, Task,start_time ,completed) values (2,1,1000,false);
Insert into Kids_Task (kid, Task,start_time ,completed) values (3,1,1000,false);
select * from Kids_task;

## criar reward
insert into Reward (name, pts_required) values('PS4',50);
##saber de qual parent é esta reward
Insert into Parents_Reward (parent, reward) values (1,1);
## atribuir a reward a um kid(isto restringe que por exemplo uma criança de 10anos possa escolher como reward um carro caso os pais tenham
## criado tal reward.
Insert into Kids_Reward (kid, reward) values (3,1);
 
