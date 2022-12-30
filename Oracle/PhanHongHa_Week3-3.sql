--Tên: Phan H?ng Hà


-- Bài 1:
--1)
CREATE OR REPLACE PROCEDURE "dept_info"
(
    dept_id IN departments.department_id%TYPE
)
AS
    dept_name       departments.department_name%TYPE;
    dept_manager    employees.first_name%TYPE;
    dept_city       locations.city%TYPE;
BEGIN
    SELECT department_name, (first_name||' '||last_name) , city
    INTO dept_name, dept_manager, dept_city
    FROM departments d
        LEFT JOIN employees e ON(d.manager_id = e.employee_id)
        JOIN locations l USING(location_id)
    WHERE d.department_id = dept_id;
    
    DBMS_OUTPUT.PUT_LINE('Department: ID= '||dept_id_param||
                        ', department name= '||dept_name_var||
                        ', manager= '||dept_manager_var||
                        ', city= '||dept_city_var);
EXCEPTION
    WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('No data found with department id: '||dept_id);
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('Unknown error has occured');
END;

--test1
BEGIN
 dept_info(96);
END;



--2)
CREATE OR REPLACE PROCEDURE "add_job"
(
    job_id IN jobs.job_id%TYPE,
    job_title IN  jobs.job_title%TYPE
)
IS
BEGIN
      INSERT INTO jobs VALUES (job_id_param, job_title_param, null, null);
    
END;

--test2
BEGIN
    add_job('TJ', 'Test JOB');
END;


--3)
CREATE OR REPLACE PROCEDURE "update_comm"
(
      emp_id IN employees.employee_id%TYPE
)
AS
BEGIN
    UPDATE employees
    SET commission_pct = commission_pct * 1.05
    WHERE employee_id = emp_id;
END;

-- test3
BEGIN 
    update_comm(560);
END;


--4)
CREATE OR REPLACE PROCEDURE "add_emp"
(
    first_name employees.first_name%TYPE,
    last_name employees.last_name%TYPE,
    email_param employees.email%TYPE,
    phone_number employees.phone_number%TYPE,
    hire_date_param employees.hire_date%TYPE,
    job_id employees.job_id%TYPE,
    salary employees.salary%TYPE,
    comission_pct employees.commission_pct%TYPE DEFAULT NULL,
    manager_id  employees.manager_id%TYPE DEFAULT NULL,
    department_id  employees.department_id%TYPE
)
AS
    emp_id employees.employee_id%TYPE;
BEGIN
    SELECT employees_seq.NEXTVAL INTO emp_id from dual;
    
    INSERT INTO employees
        VALUES (
            emp_id,
            first_name,
            last_name,
            email,
            phone_number,
            hire_date,
            job_id,
            salary,
            comission_pct,
            manager_id,
            department_id
            );
END;

-- test4
BEGIN
    add_emp('test',
            'ln test',
            'hah@gmail',
            '0955',
            TO_DATE('12-12-2022','dd-mm-yyyy'),
            'HR_REP',
            123,
            0.2,
            66,
            99);
END;


--5)
CREATE OR REPLACE PROCEDURE "delete_emp"
(
    emp_id employees.employee_id%TYPE
)
AS
    no_data_delete      EXCEPTION;
BEGIN
    DELETE FROM employees WHERE employee_id = emp_id; 
    IF SQL%ROWCOUNT = 0 THEN RAISE no_data_delete;
    END IF;
EXCEPTION
    WHEN no_data_delete THEN dbms_output.put_line('No such record');
END;


-- test5
BEGIN
   delete_emp(99); 
END;

--6)

CREATE OR REPLACE PROCEDURE "find_emp"

AS
    CURSOR find_emp_cusor IS
        SELECT employee_id, (first_name||' '||last_name) as Name,
                salary, job_title
        FROM employees e
            JOIN jobs j ON (e.job_id = j.job_id)
        WHERE e.salary > j.min_salary AND e.salary < j.max_salary
        ORDER BY 4, 3;
    found_emp_row        find_emp_cusor%ROWTYPE;
BEGIN
    OPEN find_emp_cusor;
    LOOP 
        FETCH find_emp_cusor INTO found_emp_row;
        EXIT WHEN find_emp_cusor%NOTFOUND;
        
        dbms_output.put_line('Employee infomation: '||
                            ', ID = '||found_emp_row.employee_id||
                            ', name = '||found_emp_row.name||
                            ', salary = '||found_emp_row.salary||
                            ', job title = '||found_emp_row.job_title);
    END LOOP;
    CLOSE find_emp_cusor;
END;

-- test6
BEGIN 
    find_emp;
END;

SELECT employee_id, (first_name||' '||last_name) as Name,
                salary, job_title
        FROM employees e
            JOIN jobs j ON (e.job_id = j.job_id)
        WHERE e.salary > j.min_salary AND e.salary < j.max_salary;


--7)
CREATE OR REPLACE PROCEDURE "update_comm"
(
    job_id IN NUMBER,
    job_title IN VARCHAR2
)
AS
   sql_var  VARCHAR2(400); 
BEGIN
    sql_var := 'UPDATE employees SET salary = CASE ' ||
        'WHEN MONTHS_BETWEEN(sysdate, hire_date) > 2 * 12 THEN salary + 200 '||
        'WHEN MONTHS_BETWEEN(sysdate, hire_date) > 1 * 12 AND  MONTHS_BETWEEN(sysdate, hire_date) < 2 * 12 THEN salary + 100 '||
        'WHEN CEIL(MONTHS_BETWEEN(sysdate, hire_date)) = 1 * 12 THEN salary + 50 END';
    EXECUTE IMMEDIATE sql_var;
END;
--test7
BEGIN
    update_comm;
END;

--8)
CREATE OR REPLACE PROCEDURE "job_his"
(
     emp_id_param  employees.employee_id%TYPE
)
AS
    CURSOR emp_cursor(emp_id_param   employees.employee_id%TYPE) IS
        SELECT (first_name||' '||last_name) as name,
                start_date,
                end_date,
                job_title
        FROM job_history jh
            JOIN employees e ON (jh.employee_id = e.employee_id)
            JOIN jobs j ON (j.job_id = jh.job_id)
        WHERE jh.employee_id = emp_id_param
        ORDER BY 2;
    
    job_his_row_var     emp_cursor%ROWTYPE;
    no_job_his_found    EXCEPTION;
BEGIN
    OPEN emp_cursor(emp_id_param);
    IF emp_cursor%ROWCOUNT = 0 
        THEN RAISE no_job_his_found;
    END IF;
    LOOP
        FETCH emp_cursor INTO job_his_row_var;
        EXIT WHEN emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Job history: '||
                                'ID = '||emp_id_param||
                                ', name = '||job_his_row_var.name||
                                ', job title = '||job_his_row_var.job_title||
                                ', start date = '||TO_CHAR(job_his_row_var.start_date)||
                                ', end date = '||TO_CHAR(job_his_row_var.end_date));
    END LOOP;
    CLOSE emp_cursor;
EXCEPTION 
    WHEN no_job_his_found THEN DBMS_OUTPUT.PUT_LINE('No job history found for employee id = '||emp_id_param);
    
END;

--test8
BEGIN
    job_his(89);
END;

SELECT (e.first_name||' '||e.last_name) AS name,
                jh.start_date,
                jh.end_date,
                j.job_title
        FROM job_history jh
            JOIN employees e ON (jh.employee_id = e.employee_id)
            JOIN jobs j ON (j.job_id = jh.job_id)
        WHERE jh.employee_id = 101
        ORDER BY 2;


--Bài 2
--1)
CREATE OR REPLACE FUNCTION sum_salary(v_department_id IN number)
RETURN number
IS 
    c_number number;
    CURSOR c1 IS
        SELECT sum(SALARY) "sum_salary" FROM employees
        WHERE employees.department_id = v_department_id;
BEGIN
    OPEN c1;
    FETCH c1 INTO c_number;
    CLOSE c1;
    RETURN c_number;
END;

--test1
BEGIN    
    DBMS_OUTPUT.PUT_LINE(' sum_salary = ' || sum_salary(90));
END;

--2)

CREATE OR REPLACE FUNCTION name_con(v_country_id VARCHAR2)
RETURN VARCHAR2
IS
	c_result VARCHAR2(100);
	CURSOR c1 IS
	SELECT COUNTRY_NAME FROM COUNTRIES WHERE COUNTRIES.COUNTRY_ID = v_country_id;
BEGIN
	OPEN c1;
	FETCH c1 INTO c_result;
	CLOSE c1;
	RETURN c_result;
END;
--test2
BEGIN
    DBMS_OUTPUT.PUT_LINE(name_con('TEST'));
END;    
--3)

CREATE OR REPLACE FUNCTION annual_comp(v_month_sal number, v_commission number)
RETURN number
IS
	c_result number;
BEGIN
	c_result := v_month_sal*12 + (v_commission*v_month_sal*12);
	RETURN c_result;
END;
--test3
BEGIN
    DBMS_OUTPUT.PUT_LINE(annual_comp(56,0.2));
END; 

--4)
CREATE OR REPLACE FUNCTION avg_salary(v_department_id number)
RETURN number
IS
	c_result number;
	CURSOR c1 IS
	SELECT avg(SALARY) "Average_Salary" FROM EMPLOYEES  WHERE EMPLOYEES.DEPARTMENT_ID = v_department_id;
BEGIN
	OPEN c1;
	FETCH c1 INTO c_result;
	CLOSE c1;
	RETURN c_result;
END;

--test4
BEGIN
    DBMS_OUTPUT.PUT_LINE(avg_salary(90));
END;                 
          
--5)

CREATE OR REPLACE FUNCTION time_work(v_employee_id number)
RETURN number
IS
	c_result number;
	CURSOR c1 IS
	SELECT (TRUNC( sysdate ) - HIRE_DATE) * 12 "Months" FROM employees WHERE employees.employee_id = v_employee_id;
BEGIN
	OPEN c1;
	FETCH c1 INTO c_result;
	CLOSE c1;
	RETURN c_result;
END;
--test5
BEGIN
    DBMS_OUTPUT.PUT_LINE(time_work(10));
END;   

-- Bài 3
-- 1)

CREATE OR REPLACE TRIGGER trigger1
  BEFORE INSERT OR UPDATE ON employees
  FOR EACH ROW
BEGIN
  IF sysdate < :new.HIRE_DATE THEN
    RAISE_APPLICATION_ERROR(-20001, 'ERROR');
  END IF;
END;
ALTER TRIGGER trigger1 DISABLE;
ALTER TRIGGER trigger1 ENABLE;


--2)

CREATE OR REPLACE TRIGGER trigger2
  BEFORE INSERT OR UPDATE ON jobs
  FOR EACH ROW
BEGIN
  IF :new.MIN_SALARY > :new.MAX_SALARY THEN
    RAISE_APPLICATION_ERROR(-20001, 'ERROR');
  END IF;
END;
ALTER TRIGGER trigger2 DISABLE;
ALTER TRIGGER trigger2 ENABLE;


--3)

CREATE OR REPLACE TRIGGER trigger3
  BEFORE INSERT OR UPDATE ON job_history
  FOR EACH ROW
BEGIN
  IF :new.END_DATE > :new.START_DATE THEN
    RAISE_APPLICATION_ERROR(-20001, 'ERROR');
  END IF;
END;
ALTER TRIGGER trigger3 DISABLE;
ALTER TRIGGER trigger3 ENABLE;


--4)

CREATE OR REPLACE TRIGGER trigger4
  BEFORE UPDATE ON employees
  FOR EACH ROW
BEGIN
  IF :new.SALARY <= :old.SALARY and :new.COMMISSION_PCT <= :old.COMMISSION_PCT THEN
     RAISE_APPLICATION_ERROR(-20001, 'Wrong');
  END IF;
END;
ALTER TRIGGER trigger4 DISABLE;
ALTER TRIGGER trigger4 ENABLE;