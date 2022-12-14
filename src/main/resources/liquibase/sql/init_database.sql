create table if not exists academic_discipline
(
    id                bigint not null
        primary key,
    discipline_number varchar(255),
    name              varchar(255)
);
create sequence if not exists academic_discipline_seq
    increment by 50;
create table if not exists groups
(
    id         bigint not null
        primary key,
    group_name varchar(255)
);
create sequence if not exists group_seq
    increment by 50;
create table if not exists roles
(
    id        bigint not null
    primary key,
    role_name varchar(255)
    );
create sequence if not exists role_seq
    increment by 50;
create table if not exists specialization
(
    id                  bigint not null
    primary key,
    specialization      varchar(255),
    specialization_name varchar(255)
    );
create sequence if not exists specialization_seq
    increment by 50;
create table if not exists academic_methods
(
    id                     bigint not null
        primary key,
    activity_type          varchar(255),
    complete_info          varchar(255),
    dead_line              date,
    academic_discipline_id bigint not null
        constraint fkaqkuujflwbrksut4tdqrt5t5u
            references academic_discipline,
    specialization_id      bigint not null
        constraint fkfvfon5jaw36leq4n4th07i2ql
            references specialization
);
create sequence if not exists methods_work_seq
    increment by 50;
create table if not exists academic_work
(
    id                         bigint not null
        primary key,
    absolute_results           real,
    academic_year_semestr_fact varchar(255),
    academic_year_semestr_plan varchar(255),
    first_semestr_fact         varchar(255),
    first_semestr_plan         varchar(255),
    incomplete_reason          varchar(255),
    quality_results            real,
    second_semestr_fact        varchar(255),
    second_semestr_plan        varchar(255),
    academic_discipline_id     bigint not null
        constraint fkkkkpm2fh5am9x0ecnh5mmj91i
            references academic_discipline,
    group_id                   bigint not null
        constraint fklctm3keifp2bxjw26bo7riyj6
            references groups,
    specialization_id          bigint not null
        constraint fkr11j2dxpiqalwbtge4po5ei5x
            references specialization
);
create sequence if not exists academic_work_seq
    increment by 50;
create table if not exists academic_production
(
    id                                bigint not null
        primary key,
    academic_production_activity_form varchar(255),
    activity_type                     varchar(255),
    cabinet_name                      varchar(255),
    cabinet_type                      varchar(255),
    date                              date,
    result                            varchar(255),
    specialization_id                 bigint not null
        constraint fksn2cxxywymmauyosah8jqpwew
            references specialization
);
create sequence if not exists academic_production_seq
    increment by 50;
create table if not exists department
(
    id   bigint not null
        primary key,
    name varchar(255)
);
create sequence if not exists department_seq
    increment by 50;
create table if not exists educate
(
    id                  bigint not null
        primary key,
    activity_type       varchar(255),
    date                date,
    event_level         varchar(255),
    event_name          varchar(255),
    event_type          varchar(255),
    result              varchar(255),
    student_information varchar(255),
    work_vector         varchar(255)
);
create sequence if not exists educate_seq
    increment by 50;
create table if not exists organized_methods
(
    id                  bigint not null
        primary key,
    activity_type       varchar(255),
    date                date,
    event_level         varchar(255),
    event_name          varchar(255),
    event_type          varchar(255),
    result              varchar(255),
    student_information varchar(255)
);
create sequence if not exists organized_methods_seq
    increment by 50;
create table if not exists promotion_qualification_level
(
    id                 bigint not null
        primary key,
    date               date,
    document_or_result varchar(255),
    place              varchar(255),
    promotion_form     varchar(255),
    topic              varchar(255)
);
create sequence if not exists promotion_qualification_level_seq
    increment by 50;
create table if not exists scientific_methods
(
    id                  bigint not null
        primary key,
    activity_type       varchar(255),
    date                date,
    event_level         varchar(255),
    event_name          varchar(255),
    event_type          varchar(255),
    participation_type  varchar(255),
    place               varchar(255),
    result              varchar(255),
    student_information varchar(255)
);
create sequence if not exists scientific_methods_seq
    increment by 50;
create table if not exists teacher
(
    id                 bigint not null
        primary key,
    category           varchar(255),
    certification_date date,
    employment_type    varchar(255),
    firstname          varchar(255),
    lastname           varchar(255),
    middlename         varchar(255),
    position           varchar(255),
    department_id      bigint not null
        constraint fkd419q6obhj46eoye136y7rjyq
            references department
);
create sequence if not exists teacher_seq
    increment by 50;
create table if not exists users
(
    id       bigint not null
        primary key,
    login    varchar(255),
    password varchar(255)
);
create sequence if not exists user_seq
    increment by 50;
