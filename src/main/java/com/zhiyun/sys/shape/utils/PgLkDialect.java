package com.zhiyun.sys.shape.utils;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import java.sql.Types;

public class PgLkDialect extends PostgreSQL94Dialect {

    @Override
    public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor)
    {
        switch (sqlTypeDescriptor.getSqlType())
        {
            case Types.CLOB:
                return VarcharTypeDescriptor.INSTANCE;
            case Types.BLOB:
                return VarcharTypeDescriptor.INSTANCE;
            case 1111://1111是pgsql的json
                return VarcharTypeDescriptor.INSTANCE;
        }
        return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
    }
    public PgLkDialect() {
        super();
        registerHibernateType(1111, "string");
    }
}
