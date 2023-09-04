package org.pract;

public class UserService {

    UserRepository userRepository;
    UserService(){
        userRepository = new UserRepository();
    }

    public String getAlbert(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "albert einstein";
    }

    public boolean addUser( String name ){
        return userRepository.addUser( name );
    }

    public boolean removeUser( String name ){
        return userRepository.removeUser(name);
    }

}
