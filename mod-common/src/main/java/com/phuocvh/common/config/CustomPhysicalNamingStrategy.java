package com.phuocvh.common.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {
  @Override
  public Identifier toPhysicalCatalogName(
      final Identifier identifier, final JdbcEnvironment jdbcEnv) {
    return convertToSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalColumnName(
      final Identifier identifier, final JdbcEnvironment jdbcEnv) {
    return convertToSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalSchemaName(
      final Identifier identifier, final JdbcEnvironment jdbcEnv) {
    return convertToSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalSequenceName(
      final Identifier identifier, final JdbcEnvironment jdbcEnv) {
    return convertToSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalTableName(
      final Identifier identifier, final JdbcEnvironment jdbcEnv) {
    return convertToSnakeCase(identifier);
  }

  private Identifier convertToSnakeCase(final Identifier identifier) {
    if (identifier == null) {
      return null;
    }
    StringBuilder builder = new StringBuilder(identifier.getText().replace('.', '_'));

    for (int i = 1; i < builder.length() - 1; i++) {
      if (this.isUnderscoreRequired(
          builder.charAt(i - 1), builder.charAt(i), builder.charAt(i + 1))) {
        builder.insert(i++, '_');
      }
    }

    return new Identifier(builder.toString().toLowerCase(), identifier.isQuoted());
  }

  private boolean isUnderscoreRequired(char before, char current, char after) {
    return Character.isLowerCase(before)
        && Character.isUpperCase(current)
        && Character.isLowerCase(after);
  }
}
