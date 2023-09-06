package org.pract.loadbalancer.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Request {
    String path;
    String data;
    Pair<String, String> pair;

    public Request(String path) {
        this.path = path;
    }

    public Request(String path, Pair<String, String> pair) {
        this.path = path;
        this.pair = pair;
    }
}
