package by.training.dao.impl;

import by.training.dao.SubscriptionDao;
import by.training.entity.Subscription;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDaoImpl extends BaseDaoImpl implements SubscriptionDao {
    private static final Logger LOGGER = LogManager.getLogger(SubscriptionDaoImpl.class);

    @Override
    public List<Integer> countSubscriptionsOrderByPopular() {
        String sql = "SELECT COUNT(`user_id`) AS user_ids FROM "
                + "`subscription` GROUP BY `user_id` ORDER BY "
                + "COUNT(`subscriber_id`) DESC";
        List<Integer> amounts = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer amount = resultSet.getInt("user_ids");
                amounts.add(amount);
            }
        } catch (SQLException e) {
            LOGGER.error("countSubscriptionsOrderByPopular error", e);
        }
        return amounts;
    }

    @Override
    public List<Integer> countSubscribersOrderByPopular() {
        String sql = "SELECT COUNT(`subscriber_id`) AS user_ids FROM "
                + "`subscription` GROUP BY `user_id` ORDER BY "
                + "COUNT(`subscriber_id`) DESC";
        List<Integer> amounts = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer amount = resultSet.getInt("user_ids");
                amounts.add(amount);
            }
        } catch (SQLException e) {
            LOGGER.error("countSubscriptionsOrderByPopular error", e);
        }
        return amounts;
    }

    @Override
    public int countSubscriptions(final long id) {
        String sql = "SELECT COUNT(user_id)  FROM `subscription` "
                + "WHERE subscriber_id = ?";
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
                + "FROM `subscription` WHERE user_id = ?";
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
