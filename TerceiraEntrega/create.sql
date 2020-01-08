

create database ManageeMHome;
use ManageeMHome;



drop table Parents_Reward;
drop table Parents_Task;
drop table Kids_Reward;
drop table Kids_Task;
drop table Task;
drop table Reward;
drop table Family_Relation;
#drop table Parent;
drop table Kid;
drop table Password;
drop table User;
drop table Relationship_Role;

create table Relationship_Role(id_role int not null, name_role varchar(10),
			CONSTRAINT Relationship_RolePK PRIMARY KEY (id_role));

CREATE table User(id_User int not null AUTO_INCREMENT, username varchar(50) not null,  name varchar(50), age date not null,
					 role int not null,
				CONSTRAINT UserPK primary key(id_User, username),
                CONSTRAINT role foreign key (role)
                references Relationship_Role (id_role));
                
Create table Password(id_Password int not null, password varchar(30) not null,
	CONSTRAINT PasswordPk PRIMARY KEY (id_Password),
 CONSTRAINT PasswordInfo foreign key(id_Password)
	references User(id_User));
    


CREATE table Kid(id_Kid int not null, pts_Kid int, FirstTime Boolean,
 CONSTRAINT KidPk PRIMARY KEY (id_Kid),
 CONSTRAINT KidInfo foreign key(id_Kid)
	references User(id_User));

#CREATE table Parent(id_Parent int not null, name varchar(50), age date not null,
#CONSTRAINT ParentPk PRIMARY KEY (id_Parent),
#CONSTRAINT ParentInfo foreign key(id_Parent)
#	references User(id_User));




CREATE table Family_Relation(kid int not null, parent int not null,
Constraint FamilyRelationPk primary key (kid, parent),
CONSTRAINT KidFamilyRelation foreign key (kid)
	references Kid(id_Kid),
CONSTRAINT parentFamilyRelation foreign key (parent)
	references User(id_User));



CREATE table Reward(id_Reward int not null AUTO_INCREMENT, name varchar(30) not null, pts_required int not null, 
	CONSTRAINT rewardPk PRIMARY KEY (id_Reward));

CREATE table Task(id_Task int not null AUTO_INCREMENT, name varchar(30) not null, frequency_type varchar(20) not null,
	description varchar(50), duration INTEGER, pts_Task int, 
	CONSTRAINT TaskPk PRIMARY KEY (id_Task));
        
Create table Parents_Reward (parent int not null, reward int not null,
CONSTRAINT ParentsRewardPk primary key (parent, reward),
CONSTRAINT RewardMadeByParent foreign key (reward)
	references Reward(id_Reward),
CONSTRAINT ParentCreatedReward foreign key (parent)
	references User(id_User));
    
Create table Parents_Task (parent int not null, Task int not null,
CONSTRAINT ParentsTaskPk primary key (parent, task),
CONSTRAINT TaskMadeByParent foreign key (task)
	references Task(id_Task),
CONSTRAINT ParentCreatedTask foreign key (parent)
	references User(id_User));
    
    
Create table Kids_Reward (kid int not null, reward int not null,
CONSTRAINT KidsRewardPk primary key (kid, reward),
CONSTRAINT RewardMadeForKid foreign key (reward)
	references Reward(id_Reward),
CONSTRAINT KidThatViewReward foreign key (kid)
	references Kid(id_Kid));
    
Create table Kids_Task (kid int not null, Task int not null, start_time INTEGER, completed boolean,
CONSTRAINT KidsTaskPk primary key (kid, task),
CONSTRAINT TaskMadeForKid foreign key (task)
	references Task(id_Task),
CONSTRAINT KidThatViewTask foreign key (kid)
	references Kid(id_Kid));


 #CREATE table parent(id_parent int not null, name varchar(30) not null, 
# username varchar(50) not null,password varchar(50) not null,  age_parent date not null,
 #CONSTRAINT ParentPk PRIMARY KEY (id_parent)); 

