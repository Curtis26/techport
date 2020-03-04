--========= Get SID =========--
select sys_context('USERENV','SID') from dual;
select sid, serial# from v$session where username in 'C##CHINOOK_APP';

--========= Start Trace =========--
EXEC DBMS_SYSTEM.set_sql_trace_in_session(sid=>123, serial#=>1234, sql_trace=>TRUE);

--========= Get PID SID SERIAL# =========--
select spid, s.sid, s.serial# ,p.username, p.program from v$process p , v$session s
where p.addr= s.paddr
and s.sid = (select sid from v$mystat where rownum=1);

--========= Another Start Trace =========--
exec dbms_monitor.session_trace_enable(367,5637, TRUE, FALSE);
exec dbms_monitor.session_trace_disable(367,5637); 

--========= Privilege to V$ =========--
grant select on V_$process to C##CHINOOK_APP;
grant select on V_$session to C##CHINOOK_APP;

--========= Turn on and off SQL trace =========--
ALTER SESSION SET SQL_TRACE = TRUE;
ALTER SESSION SET SQL_TRACE = FALSE;

--========= Get trace directory =========--
select * from V$DIAG_INFO where name in 'Diag Trace';

--========= Explain plan =========--
EXPLAIN PLAN FOR
QUERY

--Example
explain plan for
SELECT prod_category, AVG(amount_sold)  
FROM   sh.sales s, sh.products p  
WHERE  p.prod_id = s.prod_id and amount_sold > 1
GROUP BY prod_category;

--========= Read Explain plan Content =========--
SELECT * FROM TABLE (DBMS_XPLAN.DISPLAY); 
SELECT * FROM TABLE (DBMS_XPLAN.DISPLAY(null, null, 'typical') ); 
SELECT * FROM TABLE (DBMS_XPLAN.DISPLAY(null, null, 'all') );

--========= Get one table's indexes =========--
SELECT  *
FROM    all_indexes
WHERE   table_name = '';

--========= tkprof Trace file =========--
tkprof orclcdb_ora_31939.trc chinook1.prf explain=system/oracle

--========= Gather index statistics =========--
exec dbms_stats.gather_index_stats ('SYSTEM','PRODUCTS_IDX', ESTIMATE_PERCENT => num);

--========= last DDL =========--
select uat.table_name 
    ,(select max(last_ddl_time)
        from user_objects
        where object_name = uat.table_name
        group by object_name) 
    as lastddltime 
    from user_all_tables uat
    order by lastddltime desc;