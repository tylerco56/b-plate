-- Insert roles
insert into role (name) values ('ADMIN');
insert into role (name) values ('MEMBER');


-- Insert two users (passwords are both 'password')
insert into user (username,enabled,password,verify_password,email,role_id) values ('user',true,'$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u','$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u','landonwiedenman@gmail.com',1);
insert into user (username,enabled,password,verify_password,email,role_id) values ('user2',true,'$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u','$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u','someemail@what.com',1);
