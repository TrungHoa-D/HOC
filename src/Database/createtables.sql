CREATE TABLE ATTEND_CLASS (
  person_id int NOT NULL, 
  class_id  int NOT NULL, 
  PRIMARY KEY (person_id, 
  class_id));
CREATE TABLE CLASS (
  class_id      INT PRIMARY KEY, 
  class_name    nvarchar(255), 
  class_content nvarchar(255), 
  class_day     datetime, 
  class_place   nvarchar(255), 
  );
CREATE TABLE CONTEST (
  contest_id          INT PRIMARY KEY, 
  contest_name        nvarchar(255), 
  contest_target      nvarchar(255), 
  contest_type        nvarchar(255), 
  contest_day         datetime, 
  contest_place       nvarchar, 
  );
CREATE TABLE PERSON_DO_CONTEST (
  contest_id int NOT NULL, 
  person_id  int NOT NULL, 
  PRIMARY KEY (contest_id, 
  person_id)
  );
CREATE TABLE PERSONAL_INFOR (
  person_id             int NOT NULL, 
  person_name           nvarchar(255), 
  person_gen            nvarchar(255), 
  person_handle         nvarchar(255), 
  person_student_code   nvarchar(255), 
  person_phone          int, 
  person_group          int, 
  person_score          int, 
  person_avaiable_score int, 
  note                  nvarchar(255), 
  acc_id               int NOT NULL, 
  team_id               int NOT NULL, 
  PRIMARY KEY (person_id));
CREATE TABLE TEAM (
  team_id        INT PRIMARY KEY , 
  team_name      nvarchar(255), 
  team_member_id int, 
  team_create_at timestamp NULL, 
  );
CREATE TABLE TEAM_DO_CONTEST (
  contest_id int NOT NULL, 
  team_id    int NOT NULL, 
  PRIMARY KEY (contest_id, 
  team_id)
  );
CREATE TABLE ACC (
  acc_id           INT PRIMARY KEY , 
  acc_name         nvarchar(255), 
  acc_password     nvarchar(255), 
  acc_role         nvarchar(255), 
  account_create_at timestamp NULL, 
  );
ALTER TABLE PERSONAL_INFOR ADD CONSTRAINT FKPERSONAL_I121418 FOREIGN KEY (acc_id) REFERENCES ACC (acc_id);
ALTER TABLE ATTEND_CLASS ADD CONSTRAINT FKATTEND_CLA316865 FOREIGN KEY (person_id) REFERENCES PERSONAL_INFOR (person_id);
ALTER TABLE ATTEND_CLASS ADD CONSTRAINT FKATTEND_CLA148257 FOREIGN KEY (class_id) REFERENCES CLASS (class_id);
ALTER TABLE PERSONAL_INFOR ADD CONSTRAINT FKPERSONAL_I494546 FOREIGN KEY (team_id) REFERENCES TEAM (team_id);
ALTER TABLE PERSON_DO_CONTEST ADD CONSTRAINT FKPERSON_DO_433197 FOREIGN KEY (contest_id) REFERENCES CONTEST (contest_id);
ALTER TABLE PERSON_DO_CONTEST ADD CONSTRAINT FKPERSON_DO_484594 FOREIGN KEY (person_id) REFERENCES PERSONAL_INFOR (person_id);
ALTER TABLE TEAM_DO_CONTEST ADD CONSTRAINT FKTEAM_DO_CO428886 FOREIGN KEY (contest_id) REFERENCES CONTEST (contest_id);
ALTER TABLE TEAM_DO_CONTEST ADD CONSTRAINT FKTEAM_DO_CO651698 FOREIGN KEY (team_id) REFERENCES TEAM (team_id);
alter table PERSON_DO_CONTEST
add score int;
alter table TEAM_DO_CONTEST
add score int;