
-- Adding student information to table
insert into student values(1, 'John', 'adam', 'm', '1998-05-20', 'john@gmail.com', 
'9874561230', '12-06-2016', 'A mole in left hand thumb finger', '774188529963', 'o+', 
'Indian', 'James gosling', 'businessman', '9632145780','jessy', 
'employee', '7842136985', '1000000', '12,red street', 'vadapalani', 'Chennai', 'TamilNadu', 'India','641130');

insert into student values(2, 'Ravi', 'Kumar', 'm', '1999-06-10', 'ravi@gmail.com',
'8521479630', '2014-07-13', 'A mole in right hand knee', '998766543321', 'b+', 'Indian', 'Ramesh', 'businessman', '8745545780','radhika', 'employee',
 '8526136985', '5000000', '5, Raja street', 'Town hall', 'Coimbatore', 'TamilNadu', 'India', '654321');

-- Data without AddressLine 2
insert into student values(3, 'Anu', 'sri', 'f', '2000-07-15', 'anu@gmail.com',
'7532146890', '2018-07-18', 'A scar in right hand', '212344567789', 'ab+', 'Indian', 'suresh', 'businessman', 
'6399024581', 'saranya', 'employee', '7896136985', '9000000', '12, employees colony', '', 'Trichy', 'TamilNadu', 'India', '741258');

insert into student values(4, 'Anu', 'sri', 'f', '2001-08-15', 'anusri@gmail.com',
'5412346890', '2019-06-10', 'A mole in right hand', '996633225588', 'ab+', 'Indian', 'prakash', 'businessman', 
'8956024581', 'srinithi', 'employee', '9865236985', '8000000', '12, pk colony', '', 'madurai', 'TamilNadu', 'India', '784512');

-- View student table
select * from student;