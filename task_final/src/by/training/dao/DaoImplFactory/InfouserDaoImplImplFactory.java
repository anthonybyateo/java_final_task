package by.training.dao.DaoImplFactory;

import by.training.dao.mysql.InfouserImpl;

public class InfouserDaoImplFactory extends BaseDaoFactory<InfouserImpl>{
    @Override
    public InfouserImpl createDaoImpl() {
        return new InfouserImpl();
    }
}
