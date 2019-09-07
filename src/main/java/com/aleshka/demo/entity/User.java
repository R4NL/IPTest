package com.aleshka.demo.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "ip")
    private String ip;
    @Column(name = "host")
    private String host;

    public User() {
    }

    public User(String ip, String host) {
        this.ip = ip;
        this.host = host;
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ip, user.ip) &&
                Objects.equals(host, user.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, host);
    }

    @Override
    public String toString() {
        return "User{" +
                "ip='" + ip + '\'' +
                ", host='" + host + '\'' +
                '}';
    }
}
