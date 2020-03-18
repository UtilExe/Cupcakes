package FunctionLayer;

import DBAccess.UserMapper;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    }


    public static User createUser(String username, String email, String password, int mobilNr) throws LoginSampleException {
        User user = new User(username, email, password, mobilNr);
        UserMapper.createUser( user );
        return user;
    }

}
