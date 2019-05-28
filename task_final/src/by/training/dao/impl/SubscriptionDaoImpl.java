package by.training.dao.impl;

import by.training.dao.SubscriptionDao;
import by.training.entity.Subscription;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionDaoImpl extends BaseDaoImpl implements SubscriptionDao {
    private static final Logger LOGGER = LogManager.getLogger(SubscriptionDaoImpl.class);

    @Override
    public int countSubscriptions(final long id) {
        String sql = "SELECT COUNT(user_id) AS user_ids FROM `users` WHERE "
                + "subscriber_id = ?";
        ResultSet result = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            result = statement.executeQuery();
            if (result.next()) {
                return result.getInt("user_ids");
            }
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        }
        return 0;
    }

    @Override
    public int countSubscribers(final long id) {
        String sql = "SELECT COUNT(subscriber_id) AS subscriber_ids "
                + "FROM `users` WHERE user_id = ?";
        ResultSet result = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            result = statement.executeQuery();
            if (result.next()) {
                return result.getInt("subscriber_ids");
            }
        } catch (SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        }
        return 0;
    }

    @Override
    public long create(Subscription subscription) {
        String sql = "INSERT INTO `subscription` (`subscriber_id`, `user_id`) "
                + "VALUES (?, ?)";
        ResultSet resultSet;
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, subscription.getSubscriber().getId());
            statement.setLong(2, subscription.getUser().getId());
            return statement.executeUpdate() != 0 ? -1 : 0;
        } catch(SQLException e) {
            LOGGER.error("PreparedStatement error", e);
        }
        return 0;
    }

    @Override
    public Subscription read(long id) {
        return null;
    }

    @Override
    public boolean update(Subscription subscription) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
