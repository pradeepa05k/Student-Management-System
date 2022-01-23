-- Drop table if already exist
drop table if exists student;

-- Specified value for gender
create type gender_type AS enum ('m', 'f', 'o');

-- Blood group choices
create type blood_group_type AS enum ('a+', 'a-', 'b+', 'b-', 'o+', 'o-', 'ab+', 'ab-');

-- Student basic information table
create table student(
    student_id serial,
    first_name varchar(35) not null,
    last_name varchar(35) not null,
    gender gender_type not null,
    dob date not null,
    email_id varchar(320) not null,
    mobile_no varchar(15) not null,

    date_of_admission date,
    identification_mark varchar(50) not null,
    aadhar_no varchar(12) not null unique,
    blood_group blood_group_type not null,
    nationality varchar(30) not null,

    father_name varchar(70) not null,
    father_occupation varchar(50) not null,
    father_mobileNo varchar(15) not null,
    
    mother_name varchar(70) not null,
    mother_occupation varchar(50) not null,
    mother_mobileNo varchar(15) not null,
    annual_income numeric,
    
    address_line_1 varchar(50) not null,
    address_line_2 varchar(50),
    city varchar(50) not null,
    state varchar(50) not null,
    country varchar(50) not null,
    pin_code varchar(15) not null,
    
    constraint student_pk primary key(student_id),
    constraint annual_income_check check(annual_income > 0),
    constraint date_of_admission_check check(date_of_admission > dob)
);

-- Index for retrieval using Aadhar Number
create index ux_student_aadhar_no on student(aadhar_no);

-- Index for retrieval using first_name or last_name
create index ix_student_first_name_last_name on student(first_name, last_name);
