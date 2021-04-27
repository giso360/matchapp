create sequence match_seq;

alter sequence match_seq owner to postgres;

create sequence odd_seq;

alter sequence odd_seq owner to postgres;

create table if not exists matches
(
  match_id integer not null
    constraint matches_pk
      primary key,
  description varchar(100) not null,
  match_date date not null,
  team_a varchar(50) not null,
  team_b varchar(50) not null,
  match_time time not null,
  sport integer not null
);

alter table matches owner to postgres;

create table if not exists match_odds
(
  odd_id integer not null
    constraint table_name_pk
      primary key,
  match_id integer not null
    constraint match_odds_matches___fk
      references matches
      on update cascade on delete cascade,
  specifier varchar(50) not null,
  odd double precision not null
);

alter table match_odds owner to postgres;

