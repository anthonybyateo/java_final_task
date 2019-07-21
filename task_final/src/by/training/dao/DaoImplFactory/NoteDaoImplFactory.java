package by.training.dao.DaoImplFactory;

import by.training.dao.impl.NoteDaoImpl;

public class NoteDaoImplFactory extends BaseDaoImplFactory<NoteDaoImpl> {
    @Override
    public NoteDaoImpl createDaoImpl() {
        return new NoteDaoImpl();
    }
}
