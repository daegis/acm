package red.sif.beans;

/**
 * Created by XIAN. Yingda on 2017/6/25 21:52.
 */
public class Action {
    private int aid;
    private String aname;
    private String adate;
    private int aday;
    private String abus;
    private int acount;
    private int aprice;
    private int acost;

    @Override
    public String toString() {
        return "Action{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", adate='" + adate + '\'' +
                ", aday=" + aday +
                ", abus='" + abus + '\'' +
                ", acount=" + acount +
                ", aprice=" + aprice +
                ", acost=" + acost +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public int getAday() {
        return aday;
    }

    public void setAday(int aday) {
        this.aday = aday;
    }

    public String getAbus() {
        return abus;
    }

    public void setAbus(String abus) {
        this.abus = abus;
    }

    public int getAcount() {
        return acount;
    }

    public void setAcount(int acount) {
        this.acount = acount;
    }

    public int getAprice() {
        return aprice;
    }

    public void setAprice(int aprice) {
        this.aprice = aprice;
    }

    public int getAcost() {
        return acost;
    }

    public void setAcost(int acost) {
        this.acost = acost;
    }
}
