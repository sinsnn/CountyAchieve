/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.yunlin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author sinsnn
 */
public class AccountDAOJdbcImpl implements AccountDAO {

    private final DataSource dataSource;

    public AccountDAOJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean isUserExisted(Account account) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SQLException ex = null;
        boolean existed = false;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("SELECT COUNT(1) FROM t_account WHERE name = ?");
            stmt.setString(1, account.getName());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                existed = (rs.getInt(1) == 1);
            }
        } catch (SQLException e) {
            ex = e;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    if (ex == null) {
                        ex = e;
                    }
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    if (ex == null) {
                        ex = e;
                    }
                }
            }
        }
        if (ex != null) {
            throw new RuntimeException(ex);
        }

        return existed;
    }

    @Override
    public void addAccount(Account account) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SQLException ex = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("INSERT INTO t_account(name, password, email) VALUES(?, ?, ?)");
            stmt.setString(1, account.getName());
            stmt.setString(2, account.getPassword());
            stmt.setString(3, account.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            ex = e;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    if (ex == null) {
                        ex = e;
                    }
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    if (ex == null) {
                        ex = e;
                    }
                }
            }
        }
        if (ex != null) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Account getAccount(Account account) {
        Connection conn = null;
        PreparedStatement stmt = null;
        SQLException ex = null;
        Account acct = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("SELECT password, email FROM t_account WHERE name = ?");
            stmt.setString(1, account.getName());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                acct = new Account(account.getName(), rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            ex = e;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    if (ex == null) {
                        ex = e;
                    }
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    if (ex == null) {
                        ex = e;
                    }
                }
            }
        }
        if (ex != null) {
            throw new RuntimeException(ex);
        }

        return acct;
    }

}
