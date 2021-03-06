package services;

import databases.exception.NothingToTakeException;
import databases.mybatis.mapper.AdminMapper;
import databases.mybatis.mapper.CommMapper;
import org.apache.ibatis.session.SqlSession;
import server.comm.DataMap;

public class CommonSVC extends BaseService{

    public DataMap getAdminByNumber(int no) throws NothingToTakeException{
        try(SqlSession sqlSession = super.getSession()) {
            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            DataMap map = mapper.getAdmin(no);
            if(map == null) throw new NothingToTakeException();

            return map;
        }
    }

    public DataMap AdminLogin(String id, String pwd) throws NothingToTakeException{
        try(SqlSession sqlSession = super.getSession()) {
            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            DataMap map = mapper.AdminLogin(id, pwd);
            if(map == null) throw new NothingToTakeException();

            return map;
        }
    }

    public void saveAdmin(String adminID, String adminPwd, String adminName){
        try(SqlSession sqlSession = super.getSession()) {
            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            mapper.saveAdmin(adminID, adminPwd, adminName);
        }
    }

    public boolean validateAdminID(String id) throws NothingToTakeException{
        try(SqlSession sqlSession = super.getSession()) {
            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            DataMap map = mapper.validateAdminID(id);

            if(map.getInt("cnt") > 0)
                return false;
            else
                return true;
        }
    }
}
