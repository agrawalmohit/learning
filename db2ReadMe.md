**How to get db2 statistics of table usage and index usage**
**Below command will get the statistics since last logon to the database.**

    db2pd -db <database> -tcbstats index

**How to backup db2 database**

 connect to db2 console as admin using db2cmd

    connect <database> user <username> using <password>

**backup**

    db2 backup db <database>

**restore**

    db2 restore db <database>

**adding db2 license file**

    run -> db2cmd
    db2licm -a <license_file>

**DUMP table specific**
**EXPORT**

    EXPORT TO "<dump_file>.IXF" OF IXF LOBS TO <path to lob file from current directory. eg: lbs/> <query. Eg: SELECT * FROM TABLESPACE.TABLE_NAME>;

**IMPORT**

    IMPORT FROM "<dump_file>.IXF" of IXF MESSAGES "<log_file>.log" INSERT INTO TABLESPACE.TABLE_NAME;

OR

    IMPORT FROM "<dump_file>.IXF" of IXF MESSAGES "<log_file>.log" REPLACE INTO TABLESPACE.TABLE_NAME;

OR

    LOAD FROM "<dump_file>.IXF" of IXF MESSAGES "<log_file>.log" REPLACE INTO TABLESPACE.TABLE_NAME;
