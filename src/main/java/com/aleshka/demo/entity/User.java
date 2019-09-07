package com.aleshka.demo.entity;



import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String ip;

    private int port;

    public User(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return port == user.port &&
                Objects.equals(ip, user.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
