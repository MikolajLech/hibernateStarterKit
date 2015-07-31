insert into library (id, name) values (1, 'Pierwsza biblioteka');
insert into library (id, name) values (2, 'Biblioteka Mikołaj');
insert into library (id, name) values (3, 'Trzecia biblioteka');

insert into book (id, title, library_id) values (1, 'Pierwsza książka', 1);
insert into book (id, title, library_id) values (2, 'Druga książka', 2);
insert into book (id, title, library_id) values (3, 'Trzecia książka', 3);
insert into book (id, title, library_id) values (4, 'Czwarta ksiazka', 3);
insert into book (id, title, library_id) values (5, 'Piata ksiazka', 2);
insert into book (id, title, library_id) values (6, 'Szosta ksiazka', 1);

insert into author (id, first_name, last_name) values (1, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (2, 'Zbigniew', 'Nowak');
insert into author (id, first_name, last_name) values (3, 'Janusz', 'Szczecina');
insert into author (id, first_name, last_name) values (4, 'Adam', 'Jankowski');
insert into author (id, first_name, last_name) values (5, 'Mikołaj', 'Dragon');


insert into book_author(book_id, author_id) values (1, 1);
insert into book_author(book_id, author_id) values (2, 2);
insert into book_author(book_id, author_id) values (3, 3);
insert into book_author(book_id, author_id) values (3, 4);
insert into book_author(book_id, author_id) values (4, 4);
insert into book_author(book_id, author_id) values (5, 5);
insert into book_author(book_id, author_id) values (6, 5);

