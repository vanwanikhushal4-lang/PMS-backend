package com.velox.itsm.mobileauth;

import java.sql.SQLException;
import org.hibernate.metadata.ClassMetadata;

final class LegacyRecord {
    private LegacyRecord() {}

    static Object create(ClassMetadata mapping) throws SQLException {
        if (mapping == null) throw new SQLException("SCM record mapping is unavailable");
        try {
            Class<?> type = mapping.getMappedClass();
            return type.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException failure) {
            throw new SQLException("SCM record mapping is unavailable", failure);
        }
    }
}
