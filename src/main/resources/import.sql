-- Insert roles
insert into role (name) values ('ROLE_USER');
# insert into role (name) values ('MEMBER');


-- Insert two users (passwords are both 'password')
insert into user (confirmed, username, enabled, password, verify_password, email, role_id) values (1, 'user', true, 'password', 'password', 'landonwiedenman@gmail.com', 1);
insert into user (confirmed, username, enabled, password, verify_password, email, role_id) values (1, 'user2', true, 'password', 'password', 'someemail@what.com', 1);


-- Insert home page and contact page
insert into page (publish, name, author_id, writer_id, body, private_user_id) values (1, 'home', 1, 1, 'html content goes in here. ', 1);
insert into page (publish, name, author_id, writer_id, body, private_user_id) values (1, 'contact', 1, 1, 'This is a default contact page. ', 1);
