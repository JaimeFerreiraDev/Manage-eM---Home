##LOGIN
## para login o utilizador username:"fernando"  password:"123"
select username, Password from User A inner JOIN Password B ON A.id_User = B.id_Password and username = "fernando";

##conectar um filho a um parent
Insert into Family_Relation(kid, parent) values (3,1);
UPDATE Kid SET FirstTime = false WHERE id_Kid = (SELECT kid FROM
Family_Relation WHERE Family_Relation.parent = 1 and Family_Relation.kid = 3);

## mostrar kids deste parent
Select id_Kid, name from Family_Relation, Kid, User where parent = 1 and kid = id_Kid and id_Kid = id_User;

## mostrar tasks criadas por este pai
Select * from Parents_Task, Task where parent = 1 and id_Task = task;

## mostrar rewards criadas por este pai
Select * from Parents_Reward, Reward where parent = 1 and id_Reward = reward;

## saber quantos pontos tem um filho
select pts_Kid as points from Kid where id_Kid = 3;

## dar pontos a um filho
UPDATE Kid SET pts_Kid = pts_Kid + 10 WHERE id_Kid = 3;

## um certo filho ver tarefas que tem para fazer
Select * from Kids_Task, Task where kid = 3 and id_Task = task and completed = false;
## filho concluir uma tarefa
UPDATE Kids_Task, Task SET completed = true WHERE Kids_Task.kid =3 and Task.id_Task = Kids_Task.Task and Task.id_Task = 1;

## ver tarefas de um pai em especifico que estão completas
Select User.name as Filho, Task.name as Task_Name from User,
 Task, Kids_Task, Family_Relation where Family_Relation.kid = Kids_Task.kid 
 and Family_Relation.parent = 1 and Task.id_Task = Kids_Task.Task AND Kids_Task.completed =
 true and User.id_User = Kids_Task.kid;
 
 ## confirmaçao da parte do pai que a tarefa realmente foi concluida 
update Kid, Kids_Task, Task set pts_Kid = pts_Kid + pts_Task where Kid.id_Kid=Kids_Task.kid and Task.id_Task=Kids_Task.Task;
 DELETE FROM Kids_Task WHERE Kids_Task.Task= 1 and Kids_Task.kid= 3;
 
 ## filhos a gastar pontos em rewards
 UPDATE Kid, Reward set pts_Kid = pts_Kid - Reward.pts_required where Kid.id_Kid = 3 and Reward.id_Reward = 1 ;
 
 
 ####Indexes
 CREATE INDEX parent
ON family_relation (parent); 
CREATE INDEX kid
ON family_relation (kid); 
CREATE INDEX parent
ON parents_task (parent); 
CREATE INDEX parent
ON parents_reward (parent); 
CREATE INDEX kid
ON kids_task (kid); 
CREATE INDEX kid
ON kids_reward (kid); 
CREATE INDEX points
ON kid (pts_Kid); 
## stored procedure get parents porque nao existe tabela para os parents
USE `manage_em_home`;
DROP procedure IF EXISTS `getParents`;
DELIMITER $$
USE `manage_em_home`$$
CREATE PROCEDURE getParents ()
BEGIN
select * from user
where role =1;
END$$

DELIMITER ;

call getParents();
 
 

