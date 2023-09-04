package org.pract;

public class UserService {
    public String getAlbert(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "albert einstein";
    }
}
