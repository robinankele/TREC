package oad.trec;

import java.io.Serializable;


public class user implements Serializable
{
    private String accNum;
    private String accName;
    private String admin;

    public user()
    {
        accName = "";
        accNum = "";
        admin = "";
    }
    public String getAdmin()
    {
        return admin;
    }
    public void setAdmin(String admin)
    {
        this.admin = admin;
    }
    public String getAccNum()
    {
        return this.accNum;
    }
    public String getAccName()
    {
            return this.accName;
    }
    public void setAccNum(String accountNum)
    {
        this.accNum = accountNum;
    }
    public void setAccName(String accountName)
    {
        this.accName = accountName;
    }

}
