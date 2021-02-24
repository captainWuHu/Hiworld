package dao;

import entity.Config;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigDao {

    public int getTotal() {
        int total = 0;
        try (Connection conn = DBUtil.getConnection(); Statement state = conn.createStatement()) {
            String sql = "select count(*) from config";
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("total:" + total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void add(Config config) {
        String sql = "insert into config values(null,?,?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement prepare_state = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            prepare_state.setString(1, config.getKey());
            prepare_state.setString(2, config.getValue());
            prepare_state.execute();
            ResultSet rs = prepare_state.getGeneratedKeys();
            if (rs.next()) {
                config.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Config config) {
        String sql = "update config set key_ = ?,value = ? where id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement prepare_state = conn.prepareStatement(sql)) {
            prepare_state.setString(1, config.getKey());
            prepare_state.setString(2, config.getValue());
            prepare_state.setInt(3, config.getId());
            prepare_state.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "delete from config where id = " + id;
        try (Connection conn = DBUtil.getConnection(); Statement state = conn.createStatement()) {
            state.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Config get(int id) {
        Config config = null;
        String sql = "select * from config where id = " + id;
        try (Connection conn = DBUtil.getConnection(); Statement state = conn.createStatement()) {
            state.execute(sql);
            ResultSet rs = state.getResultSet();
            if (rs.next()) {
                config.setId(rs.getInt("id"));
                config.setKey(rs.getString("key_"));
                config.setValue(rs.getString("value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }

    public List<Config> list(int start, int count) {
        List<Config> configs = new ArrayList<>();
        String sql = "select * from config order by id desc lim ?,?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement state = conn.prepareStatement(sql)) {
            state.setInt(1, start);
            state.setInt(2, count);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                Config config = new Config();
                config.setId(rs.getInt("id"));
                config.setKey(rs.getString("key_"));
                config.setValue(rs.getString("value"));
                configs.add(config);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return configs;
    }

    public List<Config> list() {
        return list(0, Short.MAX_VALUE);
    }

    public Config getByKey(String key) {
        Config config = null;
        String sql = "select * from config where key_ = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {

            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                config = new Config();
                config.setKey(key);
                config.setValue(rs.getString("value"));
                config.setId(rs.getInt("id"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return config;
    }


}
