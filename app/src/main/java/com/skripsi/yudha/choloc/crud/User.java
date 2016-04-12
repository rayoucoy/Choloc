package com.skripsi.yudha.choloc.crud;

/**
 * Created by yudha on 12/04/2016.
 */
public class User {

    private String id_user;
    private String username;
    private String password;
    private String no_hp;
    private String email;

    public void setUserId (String id_user)
    {
        this.id_user = id_user;
    }

    public String getMhsId()
    {
        return id_user;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public void setNoHp (String no_hp)
    {
        this.no_hp = no_hp;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }


    public String getUserame()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getNoHp()
    {
        return no_hp;
    }

    public String getEmail()
    {
        return email;
    }
}


