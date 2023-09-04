package org.pract;

import org.pract.exception.UserAlreadyExistsException;
import org.pract.exception.UserNotExistException;

import java.util.HashSet;
import java.util.Set;

public class UserRepository {
    Set<String> users = new HashSet<>();
    public boolean addUser( String name ){
        if( users.contains(name) )
            throw new UserAlreadyExistsException();

        return users.add( name );
    }

    public boolean removeUser( String name ){
        if( !users.contains(name) )
            throw new UserNotExistException();

        return users.remove( name );
    }

}
