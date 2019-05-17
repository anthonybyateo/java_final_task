package by.training.dao.DaoImplFactory;

import by.training.dao.mysql.InfouserImpl;

public class InfouserDaoImplImplFactory extends BaseDaoImplFactory<InfouserImpl> {
    @Override
    public InfouserImpl createDaoImpl() {
        return new InfouserImpl();
    }
}
